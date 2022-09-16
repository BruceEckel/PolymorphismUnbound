//: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt
package algebraic
import algebraic.ADT.*

sealed class ADT(val eats: String) {
    class Person(food: String) : ADT(food) {
        fun consume() = println("eating pizza")
    }
    class Robot : ADT("electricity") {
        fun charge() = println("charging")
    }
}

fun nourish(subject: ADT) {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
}

fun main() = listOf(Person("pizza"), Robot()).forEach { nourish(it) }
