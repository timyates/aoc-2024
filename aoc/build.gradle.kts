plugins {
    groovy
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.commons.math3)
    implementation(libs.guava)
    testImplementation(libs.groovy)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useSpock(libs.versions.spock)
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}
