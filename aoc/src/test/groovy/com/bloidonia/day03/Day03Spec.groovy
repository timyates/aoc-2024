package com.bloidonia.day03

import spock.lang.Specification

class Day03Spec extends Specification {

    def "example 1"() {
        when:
        def result = Day03.part1("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")

        then:
        result == 161
    }

    def "example 2"() {
        when:
        def result = Day03.part2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")

        then:
        result == 48
    }
}
