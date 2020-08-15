buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = com.example.buildSrc.Versions.kotlin))
        classpath(com.example.buildSrc.BuildPlugins.androidPlugin)
        classpath(com.example.buildSrc.BuildPlugins.koinPlugin)
        classpath(com.example.buildSrc.BuildPlugins.navSafeArg)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

apply(plugin = "koin")
