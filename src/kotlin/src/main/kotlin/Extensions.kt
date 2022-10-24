//: src/kotlin/src/main/kotlin/Extensions.kt
package extensions

interface Base {
    fun eat()
}

fun Base.smile() = println("Base.smile()")

fun f(b: Base) {
    b.eat()
    b.smile()
}

class Derived : Base {
    override fun eat() = println("Derived.eat()")
    // Cannot override smile() this way:
    // override fun smile() = Unit
}

// Doesn't override Base.smile():
fun Derived.smile() = println("Derived.smile()")

fun main() = f(Derived())
/*
Derived.eat()
Base.smile()
 */