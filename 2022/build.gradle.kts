import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins{
    kotlin("jvm") version "1.7.21"
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories{
    mavenCentral()
}

dependencies{
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.7.21")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.withType<Test>{
    useJUnitPlatform()
}

application {
    mainClass.set("joaomneto.RunnerKt")
}

tasks.withType<ShadowJar> {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("shadow")
    isZip64 = true

    exclude("META-INF/*.RSA")
    exclude("META-INF/*.SF")
    exclude("META-INF/*.DSA")
}
