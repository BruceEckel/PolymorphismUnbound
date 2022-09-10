//: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt
package algebraic
import algebraic.ADT.*

sealed class ADT(val eats: String) {
    fun eat() = println("eating $eats")

    class Dog(food: String = "dog food") : ADT(food) {
        fun bark() { println("woof") }
    }
    class Person(food: String) : ADT(food) {
        fun greet() { println("hello") }
    }
    class Robot : ADT("electricity") {
        fun initiate() { println("operational") }
    }
    class Slug(food: String) : ADT(food)
}
//---
fun nourish(subject: ADT) {
    subject.eat()
    when (subject) {
        is Dog -> subject.bark()
        is Person -> subject.greet()
        is Robot -> subject.initiate()
        is Slug -> {}
    }
}

fun main() = listOf(
    Dog(), Person("pizza"),
    Robot(), Slug("grass")
).forEach { nourish(it) }
