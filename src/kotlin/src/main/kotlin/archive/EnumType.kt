//: src/kotlin/src/main/kotlin/EnumType.kt
// Doesn't work so well (Not used in presentation)
package enumtype
import enumtype.EnumType.*

enum class EnumType {
    Person {
        fun consume() = println("${this.name} eating pizza")
    },
    Robot {
        fun charge() = println("${this.name} charging")
    };
}

fun nourish(subject: EnumType) {
    when (subject) {
        // Person -> subject.consume()  // Error: No smart cast happens
        Robot -> println("Robot")
        else -> {}
    }
}

fun main() = listOf(Person, Robot).forEach { nourish(it) }
