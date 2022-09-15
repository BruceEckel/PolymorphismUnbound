//: src/golang/structural/structural.go
package main

type Dog struct{}

func (dog Dog) Eat()     { println("eating dog food") }
func (dog Dog) Speak() { println("woof") }

type Person struct{}

func (person Person) Eat()     { println("eating pizza") }
func (person Person) Speak() { println("hello") }
//---
type Robot struct{}

func (robot Robot) Eat()     { println("charging") }
func (robot Robot) Speak() { println("operational") }

type Slug struct{}

func (slug Slug) Eat()     { println("eating grass") }
func (slug Slug) Speak() {}
//---
type EaterSpeaker interface {
	Eat()
	Speak()
}

func Nourish(x EaterSpeaker) {
	x.Eat()
	x.Speak()
}

func main() {
	subjects := []EaterSpeaker{
		Dog{}, Person{}, Robot{}, Slug{},
	}
	for _, subject := range subjects {
		Nourish(subject)
	}
}
