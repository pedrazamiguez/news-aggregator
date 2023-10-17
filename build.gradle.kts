import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val springBootVersion = "3.1.4"
    val springDependencyManagementVersion = "1.1.3"
    val kotlinVersion = "1.8.22"

    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyManagementVersion
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

group = "eu.pedrazamiguez"
version = "0.0.1-SNAPSHOT"
description = "Back-office for RSS XML feeds from multiple sources."
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

val romeVersion = "2.1.0"
val jsoupVersion = "1.16.1"

dependencies {
    // Standard dependencies
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Web MVC / Rest
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    // Data sources
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

    // Scraping
    implementation("com.rometools:rome:$romeVersion")
    implementation("org.jsoup:jsoup:$jsoupVersion")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
