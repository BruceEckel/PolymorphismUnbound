//: src/main/kotlin/MultipleInheritance.kt
// You can also do this in Java

interface Base {
    fun eat()
    fun speak() {}
}

class Dog2 : Dog(), Base {
    override fun eat() = super.gulp()
    override fun speak() = super.bark()
}
//---
class Person2 : Person(), Base {
    override fun eat() = super.scarf()
    override fun speak() = super.greet()
}

class Robot2 : Robot(), Base {
    override fun eat() = super.charge()
    override fun speak() = super.initiate()
}
//---
class Slug2 : Slug(), Base {
    override fun eat() = super.absorb()
}

fun nourish(subject: Base) {
    subject.eat()
    subject.speak()
}

fun main() = listOf(
    Dog2(), Person2(), Robot2(), Slug2()
).forEach { nourish(it) }
