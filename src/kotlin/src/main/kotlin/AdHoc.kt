//: src/kotlin/src/main/kotlin/AdHoc.kt
import disjoint.*

fun nourish(p: Person) = p.consume()

fun nourish(r: Robot) = r.charge()

fun main() {
    nourish(Person())
    nourish(Robot())
}