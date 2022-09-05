package inheritancepolymorphism

abstract class Base {
    abstract fun eat()
    abstract fun speak()
}

class Dog: Base() {
    override fun eat() { println("eating dog food") }
    override fun speak() { println("woof") }
}

class Person: Base()  {
    override fun eat() { println("eating pizza") }
    override fun speak() { println("hello") }
}

class Robot: Base()  {
    override fun eat() { println("charging") }
    override fun speak() { println("operational") }
}

class Slug: Base()  {
    override fun eat() { println("eating grass") }
    override fun speak() { }
}

fun nourish(subject: Base) {
    subject.eat()
    subject.speak()
}

fun main() {
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).forEach { nourish(it) }
}
