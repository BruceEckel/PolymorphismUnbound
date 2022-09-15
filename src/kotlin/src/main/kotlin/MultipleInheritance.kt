//: src/kotlin/src/main/kotlin/MultipleInheritance.kt
// Can also do this in Java

interface Base {
    fun eat()
    fun speak() {}
}

class Dog2 : Base, Dog() {
    override fun eat() = gulp()
    override fun speak() = bark()
}
//---
class Person2 : Base, Person() {
    override fun eat() = scarf()
    override fun speak() = greet()
}

class Robot2 : Base, Robot() {
    override fun eat() = charge()
    override fun speak() = initiate()
}
//---
class Slug2 : Base, Slug() {
    override fun eat() = absorb()
}

fun nourish(subject: Base) {
    subject.eat()
    subject.speak()
}

fun main() = listOf(
    Dog2(), Person2(), Robot2(), Slug2()
).forEach { nourish(it) }
