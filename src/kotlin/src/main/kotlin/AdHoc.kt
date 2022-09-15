//: src/kotlin/src/main/kotlin/AdHoc.kt

fun f(s: String) = println("f(String): $s")

fun f(f: Float) = println("f(Float): $f")

fun main() {
    f("hi")
    f(42.24f)
}