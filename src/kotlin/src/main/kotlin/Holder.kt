class Holder<T>(private val value: T) {
    fun get(): T = value
}

fun main() {
    class Car
    val garage = Holder(Car())
    val car: Car = garage.get()

    val carList = Holder(listOf(Car()))
    val cars: List<Car> = carList.get()
}