package com.bloidonia.day01

import spock.lang.Specification

class Day01Spec extends Specification {

    def "lists are sorted"() {
        when:
        def day01 = new Day01("3 8\n1 2\n4 5")

        then:
        day01.left == [1L, 3L, 4L]
        day01.right == [2L, 5L, 8L]
    }

    def "part1 example is as expected"() {
        when:
        def day01 = new Day01("""3   4
                |4   3
                |2   5
                |1   3
                |3   9
                |3   3""".stripMargin())

        then:
        day01.part1() == 11L
    }

    def "frequency can be calculated"() {
        expect:
        Day01.frequency([1L, 2L, 1L, 4L]) == [1L: 2L, 2L: 1L, 4L: 1L]
    }

    def "part2 example is as expected"() {
        when:
        def day01 = new Day01("""3   4
                |4   3
                |2   5
                |1   3
                |3   9
                |3   3""".stripMargin())

        then:
        day01.part2() == 31L
    }
}
