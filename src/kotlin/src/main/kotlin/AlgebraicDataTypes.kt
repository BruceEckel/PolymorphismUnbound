//: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt
package algebraic
import algebraic.ADT.*

sealed class ADT {
    class Person(val eats: String) : ADT()
    class Robot(val chargesWith: String): ADT()
}

fun nourish(subject: ADT) {
    when (subject) {  // Exhaustive
        is Person -> println("eating ${subject.eats}")
        is Robot -> println("charging with ${subject.chargesWith}")
    }
}

fun main() = listOf(Person("pizza"), Robot("electricity")).forEach { nourish(it) }
