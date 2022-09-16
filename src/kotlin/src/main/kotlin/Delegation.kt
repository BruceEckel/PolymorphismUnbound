//: src/kotlin/src/main/kotlin/Delegation.kt
package delegation
import inheritance.*

class Delegate(b: Base) : Base by b {
    fun consume() = eat()
}

fun nourish(d: Delegate) = d.consume()

fun main() = listOf(Delegate(Person()), Delegate(Robot()))
    .forEach { nourish(it) }
