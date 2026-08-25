plugins {
    `maven-publish`
}

val heheSdkGroup = providers.gradleProperty("HEHESDK_GROUP").get()
val heheSdkArtifact = providers.gradleProperty("HEHESDK_ARTIFACT").get()
val heheAdapterArtifact = providers.gradleProperty("HEHESDK_ADAPTER_ARTIFACT").get()
val heheSdkVersion = providers.gradleProperty("HEHESDK_VERSION").get()
val heheAdapterVersion = providers.gradleProperty("HEHESDK_ADAPTER_VERSION").get()

// Keep the publication aligned with this standalone repository's JitPack artifact.
group = heheSdkGroup
version = heheAdapterVersion

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = heheSdkGroup
            artifactId = heheAdapterArtifact
            version = heheAdapterVersion

            artifact("../libs/adaptermax-release.aar") {
                extension = "aar"
            }

            pom {
                name.set("HeheSDK MAX Adapter")
                description.set("HeheSDK adapter for MAX")
                packaging = "aar"

                withXml {
                    val dependenciesNode = asNode().appendNode("dependencies")

                    fun addDependency(
                        groupId: String,
                        artifactId: String,
                        version: String,
                        scope: String = "runtime",
                    ) {
                        val dependencyNode = dependenciesNode.appendNode("dependency")
                        dependencyNode.appendNode("groupId", groupId)
                        dependencyNode.appendNode("artifactId", artifactId)
                        dependencyNode.appendNode("version", version)
                        dependencyNode.appendNode("scope", scope)
                    }

                    addDependency("androidx.annotation", "annotation", "1.9.1", "compile")
                    addDependency("org.jetbrains.kotlin", "kotlin-stdlib", "2.2.10", "compile")
                }
            }
        }
    }
}
