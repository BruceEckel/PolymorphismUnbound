//: src/kotlin/src/main/kotlin/Composition.kt
// Can use this approach in most languages

class Dog3 : Base {
    private val dog = Dog()
    override fun eat() = dog.gulp()
    override fun speak() = dog.bark()
}

class Person3 : Base {
    private val person = Person()
    override fun eat() = person.scarf()
    override fun speak() = person.greet()
}
//---
class Robot3 : Base {
    private val robot = Robot()
    override fun eat() = robot.charge()
    override fun speak() = robot.initiate()
}

class Slug3 : Base {
    private val slug = Slug()
    override fun eat() = slug.absorb()
}

fun main() = listOf(
    Dog3(), Person3(), Robot3(), Slug3()
).forEach { nourish(it) }
