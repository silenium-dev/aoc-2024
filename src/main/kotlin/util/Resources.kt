package util

object Resources {
    fun load(fileName: String): String {
        return Thread.currentThread().contextClassLoader.getResource(fileName).readText()
    }
}
