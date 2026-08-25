# HeheSDK MAX adapter project

This standalone project publishes `libs/adaptermax-release.aar` as:

```text
com.github.hehesdk:android-adapter-max-release:0.2.3
```

JitPack exposes this standalone repository using its GitHub repository name as the artifact. Its generated POM intentionally does not depend on HeheSDK core SDK.

## Usage

In the consuming Android project, add JitPack to `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the core SDK and this adapter:

```kotlin
dependencies {
    implementation("com.github.hehesdk:android-sdk-release:0.2.2")
    implementation("com.github.hehesdk:android-adapter-max-release:0.2.3")
}
```

Validate locally with:

```text
./gradlew clean publishToMavenLocal
```
