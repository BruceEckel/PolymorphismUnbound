//: src/golang/generic/generics.go
package main

type Dog struct{}

func (dog Dog) Eat()  { println("eating dog food") }
func (dog Dog) Bark() { println("woof") }

type Person struct{}

func (person Person) Eat()   { println("eating pizza") }
func (person Person) Greet() { println("hello") }
//---
type Robot struct{}

func (robot Robot) Eat()      { println("charging") }
func (robot Robot) Initiate() { println("operational") }

type Slug struct{}

func (slug Slug) Eat() { println("eating grass") }
//---
type Eater interface {
	Eat()
}

func Poly[T Dog | Person | Robot | Slug](subject T) {
	switch subjectTyped := any(subject).(type) {
	case Eater:
		subjectTyped.Eat()
	}
	switch subjectTyped := any(subject).(type) {
	case Dog:
		subjectTyped.Bark()
	case Person:
		subjectTyped.Greet()
	case Robot:
		subjectTyped.Initiate()
	}
}
//---
func main() {
	Poly(Dog{})
	Poly(Person{})
	Poly(Robot{})
	Poly(Slug{})
}
