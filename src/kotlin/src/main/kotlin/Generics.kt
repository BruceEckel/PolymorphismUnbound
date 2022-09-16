//: src/kotlin/src/main/kotlin/Generics.kt
package generics
import disjoint.*

fun <T> nourish(subject: T) : T {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
    return subject
}

fun nourish2(subject: Any) : Any {
    when (subject) {
        is Person -> subject.consume()
        is Robot -> subject.charge()
    }
    return subject
}

fun main() {
    listOf(Person(), Robot())
        .map { nourish(it) }.forEach{ println(it) }
    val r: Robot = nourish(Robot())
    println(r)
    // val p: Person = nourish2(Person()) // Nope
    val o: Any = nourish2(Person())
}
