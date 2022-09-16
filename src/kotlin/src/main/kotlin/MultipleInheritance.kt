//: src/kotlin/src/main/kotlin/MultipleInheritance.kt
// Can also do this in Java
import disjoint.*

interface Base {
    fun eat()
}

class Person2 : Base, Person() {
    override fun eat() = consume()
}

class Robot2 : Base, Robot() {
    override fun eat() = charge()
}

fun nourish(subject: Base) = subject.eat()

fun main() = listOf(Person2(), Robot2()).forEach { nourish(it) }
