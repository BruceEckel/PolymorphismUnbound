//: src/kotlin/src/main/kotlin/Inheritance.kt
package inheritance

interface Base {
    fun eat()
}

class Person: Base {
    override fun eat() = println("eating pizza")
}

class Robot: Base {
    override fun eat() = println("charging")
}

fun nourish(subject: Base) = subject.eat()

fun main() = listOf(Person(), Robot()).forEach { nourish(it) }
