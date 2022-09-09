//: src/kotlin/src/main/kotlin/UnionType.kt

sealed class SumType {
    abstract fun eat()

    class Dog : SumType() {
        override fun eat() { println("eating dog food") }
        fun bark() { println("woof") }
    }
    class Person : SumType() {
        override fun eat() { println("eating pizza") }
        fun greet() { println("hello") }
    }
    class Robot : SumType() {
        override fun eat() { println("charging") }
        fun initiate() { println("operational") }
    }
    class Slug : SumType() {
        override fun eat() { println("eating grass") }
    }
}

fun nourish(subject: SumType) {
    subject.eat()
    when (subject) {
        is SumType.Dog -> subject.bark()
        is SumType.Person -> subject.greet()
        is SumType.Robot -> subject.initiate()
        else -> {}
    }
}

fun main() {
    listOf(
        SumType.Dog(), SumType.Person(),
        SumType.Robot(), SumType.Slug()
    ).forEach { nourish(it) }
}
