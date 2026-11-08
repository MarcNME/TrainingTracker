plugins {
    val springVersion = "2.4.21"
    val springBootVersion = "4.1.2"

    kotlin("jvm") version springVersion
    kotlin("plugin.spring") version springVersion
    id("org.jetbrains.kotlin.plugin.jpa") version springVersion
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.1.7"
}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-noarg:2.4.21")
    }
}


group = "dev.enzmann"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
