//: src/kotlin/src/main/kotlin/Generics.kt

fun <T> nourish(subject: T) : T {
    when (subject) {
        is Dog -> {
            subject.gulp()
            subject.bark()
        }
        is Person -> {
            subject.scarf()
            subject.greet()
        }
        is Robot -> {
            subject.charge()
            subject.initiate()
        }
        is Slug -> {
            subject.absorb()
        }
    }
    return subject
}
//---
fun main() {
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).map { nourish(it) }.forEach{ println(it) }
    val d: Dog = nourish(Dog())
    println(d)
}
