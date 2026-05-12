package com.sg.cyberhub.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Slf4j
public class OpenApiEmptyClassProcessor {

    private static final String MODEL_PATH = "target/generated-sources/src/main/java";

    public static void main(String[] args) throws Exception {
        Path root = Paths.get(MODEL_PATH);
        Set<String> emptyClasses = findEmptyClasses(root);
        log.info("Empty classes found: " + emptyClasses);
        replaceFieldTypes(root, emptyClasses);
    }

    private static Set<String> findEmptyClasses(Path root) throws IOException {
        Set<String> emptyClasses = new HashSet<>();
        Pattern classPattern = Pattern.compile("public class (\\w+)\\s*\\{\\s*}");

        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(p -> p.toString().endsWith(".java"))
                    .forEach(path -> {
                        try {
                            String content = Files.readString(path);
                            Matcher matcher = classPattern.matcher(content);
                            if (matcher.find()) {
                                emptyClasses.add(matcher.group(1));
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
        return emptyClasses;
    }

    private static void replaceFieldTypes(Path root, Set<String> emptyClasses) throws IOException {

        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(p -> p.toString().endsWith(".java")).forEach(path -> {
                try {
                    String content = Files.readString(path);
                    for (String className : emptyClasses) {
                        // replace field declarations
                        content = content.replaceAll(
                                "\\bprivate\\s+" + className + "\\s+",
                                "private Object "
                        );

                        // optional: replace getter/setter types
                        content = content.replaceAll(
                                "\\b" + className + "\\s+get",
                                "Object get"
                        );

                        content = content.replaceAll(
                                "\\bset\\w+\\(" + className + "\\s+",
                                "set$0".replace(className, "Object")
                        );
                    }
                    Files.writeString(path, content);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
