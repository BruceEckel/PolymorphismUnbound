fun f(s: String) {
    println("f(String): $s")
}

fun f(i: Int) {
    println("f(Int): $i")
}

fun main() {
    f("hi")
    f(12)
}