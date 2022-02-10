enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "ToDometerMultiplatform"

include(":android")
include(":desktop")
include(":ios")
include(":common-compose-ui")
include(":common")
include(":backend")
include(":wearos")
