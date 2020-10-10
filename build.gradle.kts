plugins {
    id("java-library")

    id("idea")
    id("com.diffplug.spotless") version "5.6.1"
    id("com.github.spotbugs") version "4.5.1"
}

group = "com.github.evansb"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    // These are defined in gradle.properties
    val lombokVersion: String by project
    val junitVersion: String by project
    val googleTruthVersion: String by project

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))

    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

    implementation("org.projectlombok:lombok:$lombokVersion")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.google.truth:truth:$googleTruthVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

spotless {
    format("misc") {
        target("build.gradle.kts", "settings.gradle.kts")

        trimTrailingWhitespace()
        indentWithSpaces(4)
        endWithNewline()
    }

    java {
        importOrder()
        removeUnusedImports()

        googleJavaFormat()
    }
}
