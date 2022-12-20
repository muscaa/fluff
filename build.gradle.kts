import com.github.gradle.node.npm.task.NpmTask

val frontendDir ="${project.projectDir}/src/main/ui"

plugins {
    java
    id("com.github.node-gradle.node") version "3.4.0"
}

repositories {
    mavenCentral()
    maven(url = "https://dl.equo.dev/sdk/mvn/release")
}

dependencies {
    implementation("com.equo:com.equo.starter.bom:+")
}

node {
    nodeProjectDir.set(file(frontendDir))
}

tasks.register<NpmTask>("npmBuild") {
    dependsOn("npmInstall")
    npmCommand.set(listOf("run", "build"))
}

tasks.named("processResources") {
    dependsOn("npmBuild")
}

group = "sample-name"
version = property("version").toString()
