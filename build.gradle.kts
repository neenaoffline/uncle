plugins {
    kotlin("jvm") version "2.0.10"

    id("com.google.devtools.ksp") version "2.0.10-1.0.24"
    application
}

group = "com.dulllife"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val exposedVersion: String by project
val ktorVersion: String by project
val daggerVersion: String by project

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("com.google.dagger:dagger:$daggerVersion")
    ksp("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-money:$exposedVersion")

    implementation("org.flywaydb:flyway-core:10.17.2")
    implementation("org.xerial:sqlite-jdbc:3.46.1.0")
    implementation("ch.qos.logback:logback-classic:1.5.7")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "com.dulllife.MainKt"
}