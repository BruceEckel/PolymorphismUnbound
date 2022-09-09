package main

type Dog struct{}

func (_ Dog) Eat()  { println("eating dog food") }
func (_ Dog) Bark() { println("woof") }

type Person struct{}

func (_ Person) Eat()   { println("eating pizza") }
func (_ Person) Greet() { println("hello") }

type Robot struct{}

func (_ Robot) Eat()      { println("charging") }
func (_ Robot) Initiate() { println("operational") }

type Slug struct{}

func (_ Slug) Eat() { println("eating grass") }

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

func main() {
	Poly(Dog{})
	Poly(Person{})
	Poly(Robot{})
	Poly(Slug{})
}
