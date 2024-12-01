package com.bloidonia.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.bloidonia.ResourceUtils.readResourceText;

public class Day01 {

    private final List<Long> left = new ArrayList<>();
    private final List<Long> right = new ArrayList<>();

    Day01(String input) {
        input.lines().forEach(line -> {
            left.add(Long.parseLong(line.split("\\s+")[0]));
            right.add(Long.parseLong(line.split("\\s+")[1]));
        });
        left.sort(Long::compareTo);
        right.sort(Long::compareTo);
    }

    public static void main(String[] args) {
        Day01 day01Part1 = new Day01(readResourceText("day01.txt"));
        System.out.printf("Part 1: %d\n", day01Part1.part1());
        System.out.printf("Part 1: %d\n", day01Part1.part2());
    }

    static Map<Long, Long> frequency(List<Long> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    long part1() {
        return IntStream.iterate(0, i -> i < left.size(), i -> i + 1)
                .mapToLong(i -> Math.abs(left.get(i) - right.get(i)))
                .sum();
    }

    long part2() {
        Map<Long, Long> frequency = frequency(right);
        return left.stream().mapToLong(l -> l * frequency.getOrDefault(l, 0L)).sum();
    }
}
