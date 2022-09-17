---
marp: true
theme: gaia
class: invert
footer: 'MindviewLLC.com'
---

<style scoped>
h1, h2, h3, h4, h5, h6 {
  color: black;
}
a {
  color: black;
  text-decoration: none;
}
</style>
![bg](TitleImage.jpg)

# Polymorphism<br/>Unbound

## Bruce Eckel

###### Github:<br/> BruceEckel/PolymorphismUnbound

---

## `cfront`, `virtual`, and dynamic binding

![bg right](tape.jpg)

---

# How did we get here?

## Simula

- A simulation needs a common interface for all simulation elements.
- So you can tell them all to update themselves.

---

# Smalltalk

- Takes Simula concept and applies it to all elements
- Code Reuse via Inheritance
* BUT Smalltalk is inherently dynamic
* _Message-Oriented Programming_ (like Actors)

---

# C++

  - Encapsulation for data control
  - Inheritance and dynamic binding
  - Objects are completely optional
  - Everything statically typed for safety

---

# Java

  - Not optional: Everything is an Object, like Smalltalk
  - BUT static typing makes it quite different
  - The concept of dynamic messages is lost, not really like Smalltalk
  - Reusing code through inheritance didn't really work out
  - Post-Java languages have learned from its mistakes

---
<style scoped>
h2 {
  color: orange;
}
</style>
# Polymorphism

## &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; _A type represents multiple types_

* Usually appears in the form of a function parameter
* Achieving polymorphism
  * Modifying types vs.
  * Modifying functions

---

# Examples

- Different forms of polymorphism
- Implemented in different languages:

---

# Kotlin

www.AtomicKotlin.com
![bg fit right](AtomicKotlinCover.png)

---

# Java

(_without reflection_)
www.OnJava8.com
![bg fit left](TIJava4cover.jpg)
![bg fit left](OnJava8Cover.jpg)

---

# C++

![bg fit right](eckel-c-front-cover-only.jpg)

---

<style scoped>
h1, h2, h3, h4, h5, h6 {
  color: black;
}
</style>
### www.AtomicScala.com
![bg](Scala.jpg)
![bg fit](AtomicScala.jpg)

---

## Python: 25 years
## Rust, Go: Hours

---

# Ad-Hoc Polymorphism (Overloading)

```
f("hello")
f(42.24)
```

---

|==> //: src/kotlin/src/main/kotlin/disjoint/DisjointTypes.kt
|==> //: src/kotlin/src/main/kotlin/AdHoc.kt

- Java overloading: `src/java/src/AdHoc.java`
- C++ overloading: `src/cpp/AdHoc.cpp`
- Python overloading: `src/python/single_dispatch.py`

---

# Classic Inheritance following Liskov Substitution

---

|==> //: src/kotlin/src/main/kotlin/Inheritance.kt

  - `src/scala/Inheritance.scala`
  - `src/java/src/Inheritance.java`
  - `src/cpp/Inheritance.cpp`
  <!-- - `src/python/base.py` -->
  - `src/python/inheritance.py`

---

# Multiple Inheritance

---

|==> //: src/kotlin/src/main/kotlin/MultipleInheritance.kt
|==> //: src/kotlin/src/main/kotlin/Composition.kt
<!-- |==> //: src/kotlin/src/main/kotlin/Delegation.kt -->
|==> //: src/cpp/MultipleInheritance.cpp
<!-- |==> #: src/python/multiple_inheritance.py -->

# Parametric Polymorphism (Generics)

```
Holder<Car>(car)
Holder<Robot>(robot)
Holder<List<Car>>(listOf(car))
---

|==> //: src/kotlin/src/main/kotlin/Holder.kt
|==> //: src/kotlin/src/main/kotlin/GenericFunctions.kt

- Java: `src/java/src/Generics.java`
- Kotlin has reified generics

---

# Structural Typing <br/>(Duck Typing)

---

|==> #: src/python/duck_typing.py
|==> //: src/cpp/StructuralTyping.cpp

# Union Types aka Sum Types

---

|==> #: src/python/disjoint_types.py
|==> #: src/python/union_types.py
|==> //: src/scala/DisjointTypes.scala
|==> //: src/scala/UnionTypes.scala
|==> //: src/golang/uniontypes/uniontypes.go
|==> //: src/cpp/UnionTypes.cpp

# Protocols

---

|==> #: src/python/protocols.py
|==> //: src/golang/structural/structural.go

# Algebraic Data Types (ADTs)

---

|==> //: src/scala/EnumeratedDataTypes.scala
|==> //: src/scala/EnumeratedDataTypes2.scala
|==> //: src/scala/AlgebraicDataTypes.scala
|==> //: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt

# Type Classes

---

|==> //: src/scala/TypeClasses.scala
|==> //: src/rust/typeclasses/src/main.rs

# Multiple Dispatching

- Some versions of Lisp
- Julia

---

# Moving Away from Code-Reuse Inheritance

---

|==> //: src/rust/inheritance/src/main.rs

# Takeaways

* Why do we want to treat multiple types as the same type?
  * Separate things that change from things that stay the same?
  * Reduce code duplication?
  * Capturing & reusing common concepts
  * Don't do it without question

---

# What can we do with the aggregate?

* If there's no intersection of either syntax or semantics, does it make sense?
* Yes: erasure in Java allows no behavior, only preserves exact return type

---

# Code Reuse with Inheritance

* Maybe conflating these should have been left to Smalltalk
  * Have I used more than one level of inheritance? (except examples)
  * Some newer languages (Rust, Go) explicitly disallow it
  * Code reuse means embedding an object rather than inheriting
  * Luciano Ramalho: implement interfaces only for "frameworks"

---

# Was OO a Mistake?

* No: Sometimes it's quite useful
* Just not everywhere all the time
  * Forcing inheritance into every design seems like a bad idea
* Ad-hoc polymorphism is heavily used in FP: map, fold, etc.

---

# I'll Get By With a Little Help...

- Bill Frasure
- James Ward
- Luciano Ramalho
- Jack Leow
- Marshall Pierce
- Bill Venners

---

# Questions

... In the hall

![bg fit right](workwithcare.jpg)
