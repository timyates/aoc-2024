package com.bloidonia.day02

import spock.lang.Specification

class Day02Spec extends Specification {

    def input = '''7 6 4 2 1
                  |1 2 7 8 9
                  |9 7 6 2 1
                  |1 3 2 4 5
                  |8 6 4 4 1
                  |1 3 6 7 9'''.stripMargin()

    def "can read reports"() {
        when:
        def reports = Day02.parseReports(input.lines())

        then:
        reports.size() == 6
        reports*.levels()*.size().unique() == [5]
    }

    def "can validate reports"() {
        when:
        def reports = Day02.parseReports(input.lines())

        then:
        reports*.isSafe() == [true, false, false, false, false, true]
    }

    def "can validate reports for part 2"() {
        when:
        def reports = Day02.parseReports(input.lines())

        then:
        reports*.isSafe(true) == [true, false, false, true, true, true]
    }
}
