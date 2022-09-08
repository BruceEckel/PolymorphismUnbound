package main

type Dog struct{}

func (_ Dog) Eat()     { println("eating dog food") }
func (_ Dog) Bark() { println("woof") }

type Person struct{}

func (_ Person) Eat()     { println("eating pizza") }
func (_ Person) Greet() { println("hello") }

type Robot struct{}

func (_ Robot) Eat()     { println("charging") }
func (_ Robot) Initiate() { println("operational") }

type Slug struct{}

func (_ Slug) Eat()     { println("eating grass") }

// Does not compile
//func Nourish[T Dog | Person | Robot | Slug](subject T) {
//	subject.Eat()
//}

func Speak[T Dog | Person | Robot | Slug](subject T) {
	switch subjectTyped := any(subject).(type) {
	case Dog:
		subjectTyped.Bark()
	case Person:
		subjectTyped.Greet()
	case Robot:
		subjectTyped.Initiate()
	}
}

func Poly[T Dog | Person | Robot | Slug](subject T) {
	switch subjectTyped := any(subject).(type) {
	case Dog:
		subjectTyped.Eat()
	case Person:
		subjectTyped.Eat()
	case Robot:
		subjectTyped.Eat()
	case Slug:
		subjectTyped.Eat()
	}
	Speak(subject)
}

type Eater interface {
	Eat()
}
func Poly2[T Dog | Person | Robot | Slug](subject T) {
	switch subjectTyped := any(subject).(type) {
	case Eater:
		subjectTyped.Eat()
	}
	Speak(subject)
}

func main() {
	Poly(Dog{})
	Poly(Person{})
	Poly(Robot{})
	Poly(Slug{})
	Poly2(Dog{})
	Poly2(Person{})
	Poly2(Robot{})
	Poly2(Slug{})
}
