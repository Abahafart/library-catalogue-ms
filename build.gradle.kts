plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.arch"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
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
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.liquibase:liquibase-core")
    implementation("com.github.javafaker:javafaker:0.12")
    implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub")
    implementation("com.google.cloud:spring-cloud-gcp-pubsub-stream-binder")
//    implementation("com.mysql:mysql-connector-j")
//    implementation("com.google.cloud:spring-cloud-gcp-starter-sql-mysql")
    runtimeOnly("org.postgresql:postgresql")
    implementation("com.google.cloud:spring-cloud-gcp-starter-sql-postgresql")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api")
    implementation("javax.cache:cache-api")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-binder")
    compileOnly("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.6.3")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${property("gcpSpringCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("docker.io/paketobuildpacks/builder-jammy-base")
    imageName = "${project.name}"
    environment = mapOf("BP_JVM_VERSION" to "21")
    docker {
        publishRegistry {
            username = project.findProperty("registryUsername").toString()
            password = project.findProperty("registryToken").toString()
            url = project.findProperty("registryUrl").toString()
        }
    }
}
