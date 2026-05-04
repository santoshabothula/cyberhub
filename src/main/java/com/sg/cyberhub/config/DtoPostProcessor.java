package com.sg.cyberhub.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public class DtoPostProcessor {

    private static final String EXCLUSION_FILE = "src/main/resources/openapi/exclusions.json";

    public static void main(String[] args) throws Exception {

        Map<String, Set<String>> rules = loadRules();

        Path root = Paths.get("target/generated-sources");

        Files.walk(root)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(file -> processFile(file, rules));
    }

    private static Map<String, Set<String>> loadRules() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(EXCLUSION_FILE), new TypeReference<>() {});
    }

    private static void processFile(Path file,
                                    Map<String, Set<String>> rules) {

        try {
            String content = Files.readString(file);

            String className = extractClassName(content);

            if (!rules.containsKey(className)) return;

            for (String field : rules.get(className)) {
                // remove field line
                String regex = "\\s*(?:@\\S+(?:\\([^)]*\\))?\\s*)*private\\s+\\S+\\s+" + field + "\\s*;";
                content = content.replaceAll(regex, "");
            }

            Files.writeString(file, content);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String extractClassName(String content) {

        // simple match: public class XYZ
        for (String line : content.split("\n")) {
            line = line.trim();

            if (line.startsWith("public class")) {
                return line.split(" ")[2];
            }
        }

        return null;
    }
}
