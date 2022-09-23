//: src/golang/structural/structural.go
package main

type Person struct{}

func (person Person) Eat() { println("eating pizza") }

type Robot struct{}

func (robot Robot) Eat() { println("charging") }

//---
type Eater interface {
	Eat()
}

func Nourish(x Eater) {
	x.Eat()
}

func main() {
	subjects := []Eater{Person{}, Robot{}}
	for _, subject := range subjects {
		Nourish(subject)
	}
}
