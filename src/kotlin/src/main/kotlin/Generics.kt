//: src/kotlin/src/main/kotlin/Generics.kt

fun <T> nourish(subject: T) : T =
    when (subject) {
        is Dog -> {
            subject.gulp()
            subject.bark()
            subject
        }
        is Person -> {
            subject.scarf()
            subject.greet()
            subject
        }
        is Robot -> {
            subject.charge()
            subject.initiate()
            subject
        }
        is Slug -> {
            subject.absorb()
            subject
        }
        else -> subject
    }

fun main() {
    listOf(
        Dog(), Person(), Robot(), Slug()
    ).map { nourish(it) }.forEach{ println(it) }
    val d: Dog = nourish(Dog())
    println(d)
}
