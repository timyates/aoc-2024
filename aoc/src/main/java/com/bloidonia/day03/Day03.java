package com.bloidonia.day03;

import com.bloidonia.ResourceUtils;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Day03 {

    static long part1(String input) {
        return Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)")
                .matcher(input)
                .results()
                .mapToLong(r -> Long.parseLong(r.group(1)) * Long.parseLong(r.group(2)))
                .sum();
    }

    static long part2(String input) {
        List<MatchResult> groups = Pattern.compile("((do\\(\\))|(don't\\(\\))|mul\\((\\d{1,3}),(\\d{1,3})\\))")
                .matcher(input)
                .results()
                .toList();
        boolean process = true;
        long total = 0L;
        for (int i = 0; i < groups.size(); i++) {
            if ("do()".equals(groups.get(i).group(2))) {
                process = true;
            } else if ("don't()".equals(groups.get(i).group(3))) {
                process = false;
            } else if (process) {
                total += Long.parseLong(groups.get(i).group(4)) * Long.parseLong(groups.get(i).group(5));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Part 1: " + part1(ResourceUtils.readResourceText("day03.txt")));
        System.out.println("Part 2: " + part2(ResourceUtils.readResourceText("day03.txt")));
    }
}
