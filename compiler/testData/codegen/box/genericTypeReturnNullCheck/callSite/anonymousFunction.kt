// !LANGUAGE: +GenerateNullChecksForGenericTypeReturningFunctions
// TARGET_BACKEND: JVM
// IGNORE_BACKEND: JVM_IR
// WITH_RUNTIME

fun <T> bar() = fun(): T = null as T

fun box(): String {
    try {
        bar<String>()()
    } catch (e: KotlinNullPointerException) {
        return "OK"
    }
    return "Fail: KotlinNullPointerException should have been thrown"
}
