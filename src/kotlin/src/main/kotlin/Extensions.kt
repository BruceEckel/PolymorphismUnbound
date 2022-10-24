//: src/kotlin/src/main/kotlin/Extensions.kt
package extensions

interface Base {
    fun eat()
}

fun f(b: Base) {
    b.eat()
    b.smile()
}

fun Base.smile() = println("Base.smile()")

class Derived : Base {
    override fun eat() = println("Derived.eat()")
    // Cannot override smile() this way:
    // override fun smile() = Unit
}

// Doesn't override Base.smile():
fun Derived.smile() = println("Derived.smile()")

fun g(d: Derived) {
    d.eat()
    d.smile()
}

fun main() {
    f(Derived())
    g(Derived())
}
/*
Derived.eat()
Base.smile()
Derived.eat()
Derived.smile()
 */