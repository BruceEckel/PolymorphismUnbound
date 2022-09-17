//: src/scala/UnionTypes.scala
// Union types aka sum types
package uniontypes
import disjointtypes.*

def nourish(x: Person | Robot) = x match
    case p: Person => p.consume()
    case r: Robot  => r.charge()

@main def main() =
    val list: List[Person | Robot] = List(Person(), Robot())
    list.foreach(nourish)
