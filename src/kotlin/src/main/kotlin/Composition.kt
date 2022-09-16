//: src/kotlin/src/main/kotlin/Composition.kt
// Can use this approach in most languages
import disjoint.*

class Person3 : Base {
    private val person = Person()
    override fun eat() = person.consume()
}

class Robot3 : Base {
    private val robot = Robot()
    override fun eat() = robot.charge()
}

fun main() = listOf(Person3(), Robot3()).forEach { nourish(it) }
