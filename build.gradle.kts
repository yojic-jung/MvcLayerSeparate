import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.5"
    // id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("plugin.jpa") version "1.9.20"
    kotlin("kapt") version "1.9.20"
}

group = "com.hmcnetworks"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.5")
    // jpa, querydsl
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.5")
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    // security
    implementation("org.springframework.security:spring-security-core:6.1.2")
    implementation("org.springframework.security:spring-security-web:6.1.2")

    // thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.1.5")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0")

    // mysql-connector
    implementation("com.mysql:mysql-connector-j:8.0.31")

    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // valid
    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.5")

    developmentOnly("org.springframework.boot:spring-boot-devtools:3.1.5")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.5")
    testImplementation("org.springframework.security:spring-security-test:6.1.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
