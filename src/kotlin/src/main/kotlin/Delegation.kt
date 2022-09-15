//: src/kotlin/src/main/kotlin/Delegation.kt

class Delegate(b: Base) : Base by b {
    fun consume() = eat()
    fun report() = speak()
}

fun nourish2(d: Delegate) {
    d.consume()
    d.report()
}

fun main() = listOf(
    Delegate(Dog3()), Delegate(Person3()), Delegate(Robot3()), Delegate(Slug3())
).forEach { nourish2(it) }
