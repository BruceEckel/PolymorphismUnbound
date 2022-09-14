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

  - No option: Everything is an Object, like Smalltalk
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
<br/><br/>
## _A type represents multiple types_
<br/><br/>
Usually appears in the form of a function parameter

---

# C++

![bg fit right](eckel-c-front-cover-only.jpg)

---

|==> //: src/cpp/AdHoc.cpp
|==> //: src/cpp/Inheritance.cpp
|==> //: src/cpp/MultipleInheritance.cpp
|==> //: src/cpp/StructuralTyping.cpp

# Java

(_without reflection_)
![bg fit left](TIJava4cover.jpg)
![bg fit left](OnJava8Cover.jpg)

---

|==> //: src/java/src/Inheritance.java
|==> //: src/java/src/DisjointTypes.java
|==> //: src/java/src/Generics.java

# Python

---

|==> #: src/python/base.py
|==> #: src/python/inheritance.py
|==> #: src/python/disjoint_types.py
|==> #: src/python/multiple_inheritance.py
|==> #: src/python/duck_typing.py
|==> #: src/python/union_types.py
|==> #: src/python/protocols.py
|==> #: src/python/single_dispatch.py

# Kotlin

![bg fit right](AtomicKotlinCover.png)

---

|==> //: src/kotlin/src/main/kotlin/AdHoc.kt
|==> //: src/kotlin/src/main/kotlin/Inheritance.kt
|==> //: src/kotlin/src/main/kotlin/ReifiedGenerics.kt
|==> //: src/kotlin/src/main/kotlin/AlgebraicDataTypes.kt

![bg](Scala.jpg)
![bg fit](AtomicScala.jpg)

---

|==> //: src/scala/Inheritance.scala
|==> //: src/scala/EnumeratedDataTypes.scala
|==> //: src/scala/EnumeratedDataTypes2.scala
|==> //: src/scala/AlgebraicDataTypes.scala
|==> //: src/scala/DisjointTypes.scala
|==> //: src/scala/UnionTypes.scala
|==> //: src/scala/TypeClasses.scala

# Rust

---

|==> //: src/rust/inheritance/src/main.rs
|==> //: src/rust/typeclasses/src/main.rs

# Go

---

|==> //: src/golang/structural/structural.go
|==> //: src/golang/generic/generics.go

# Takeaways

* Why do we want to treat multiple types as the same type?
  * Separate things that change from things that stay the same?
  * Reduce code duplication?
  * Code understanding & maintenance?
  * Don't do it without question

---

# What can we do with the aggregate?

* If there's no intersection of either syntax or semantics, does it make sense?
* Yes: erasure in Java allows no behavior, only preserves exact return type

---

# Code Reuse with Inheritance

* Maybe conflating these should have been left to Smalltalk
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

- James Ward
- Luciano Ramalho
- Bill Frasure
- Jack Leow
- Marshall Pierce
- Bill Venners

---

# Questions

![bg fit right](workwithcare.jpg)
