package com.bloidonia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceUtils {

    private ResourceUtils() {
    }

    public static Stream<String> readResource(String resourceName) {
        return new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                ResourceUtils.class.getClassLoader().getResourceAsStream(resourceName)
                        )
                )
        ).lines();
    }

    public static String readResourceText(String resourceName) {
        return readResource(resourceName).collect(Collectors.joining("\n"));
    }
}
