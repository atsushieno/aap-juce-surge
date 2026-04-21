package org.androidaudioplugin.ports.juce.surge_xt

import android.content.Context
import androidx.startup.Initializer
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class SurgeSetupInitializer : Initializer<Any?> {

    private fun ensureDirectoryExists(dir: File) {
        if (dir.exists()) {
            require(dir.isDirectory) { "${dir.absolutePath} exists but is not a directory" }
            return
        }

        check(dir.mkdirs()) { "Failed to create directory: ${dir.absolutePath}" }
    }

    private fun xcopyFromAssetsToLocalStorage(context: Context, dst: File, src: String): Boolean {
        val list = context.assets.list(src).orEmpty()
        if (list.isNotEmpty()) {
            ensureDirectoryExists(dst)
            for (sub in list)
                xcopyFromAssetsToLocalStorage(context, File(dst, sub), "$src/$sub")
            return true
        } else {
            dst.parentFile?.let(::ensureDirectoryExists)
            return try {
                FileOutputStream(dst).use { w ->
                    context.assets.open(src).use { r -> r.copyTo(w) }
                }
                true
            } catch (_: FileNotFoundException) {
                false
            }
        }
    }

    override fun create(context: Context): Any {
        val documentsDir = File(context.filesDir, "Documents")
        ensureDirectoryExists(documentsDir)

        val surgeDataDir = File(documentsDir, "Surge XT")
        if (!surgeDataDir.exists())
            xcopyFromAssetsToLocalStorage(context, surgeDataDir, "Surge XT")
        return ""
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}
