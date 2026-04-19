package com.sg.cyberhub.util;

import java.util.UUID;

public interface CommonUtil {
    String CORRELATION_ID_HEADER = "X-Correlation-Id";
    String CORRELATION_ID_MDC_KEY = "correlationId";

    static String generateUUIDAsString() {
        return UUID.randomUUID().toString();
    }
}
