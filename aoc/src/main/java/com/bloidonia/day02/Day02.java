package com.bloidonia.day02;

import com.bloidonia.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class Day02 {

    static List<Report> parseReports(Stream<String> input) {
        return input.map(Report::of).toList();
    }

    public static void main(String[] args) {
        System.out.println("Part 1: " + parseReports(ResourceUtils.readResource("day02.txt")).stream()
                .filter(Report::isSafe)
                .count());
        System.out.println("Part 2: " + parseReports(ResourceUtils.readResource("day02.txt")).stream()
                .filter(r -> r.isSafe(true))
                .count());
    }

    record Report(List<Long> levels) {

        static Report of(String line) {
            return new Report(Stream.of(line.split("\\s+")).map(Long::parseLong).toList());
        }

        boolean isSafe() {
            return isSafe(false);
        }

        boolean isSafe(boolean isPart2) {
            return isSafe(levels, isPart2);
        }

        private boolean isSafe(List<Long> levels, boolean recurse) {
            boolean increasing = levels.get(0) < levels.get(1);
            for (int i = 0; i < levels.size() - 1; i++) {
                if (invalid(levels.get(i), levels.get(i + 1), increasing)) {
                    if (recurse) {
                        for (int j = 0; j < levels.size(); j++) {
                            List<Long> trimmed = new ArrayList<>(levels);
                            trimmed.remove(j);
                            if (isSafe(trimmed, false)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean invalid(long curr, long next, boolean increasing) {
            long diff = next - curr;
            if (abs(diff) > 3 || diff == 0) {
                return true;
            } else if (increasing && diff < 0) {
                return true;
            } else if (!increasing && diff > 0) {
                return true;
            }
            return false;
        }
    }
}
