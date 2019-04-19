// !LANGUAGE: +GenerateNullChecksForGenericTypeReturningFunctions
// TARGET_BACKEND: JVM
// IGNORE_BACKEND: JVM_IR
// WITH_RUNTIME

class Foo<K> {
    fun <T : K> foo(): T = null as T
}

fun box(): String {
    try {
        Foo<Number>().foo<Int>()
    } catch (e: KotlinNullPointerException) {
        return "OK"
    }
    return "Fail: KotlinNullPointerException should have been thrown"
}
