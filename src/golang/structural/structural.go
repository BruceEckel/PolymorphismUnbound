//: src/golang/structural/structural.go
package main

type Person struct{}

func (person Person) Consume() { println("eating pizza") }

type Robot struct{}

func (robot Robot) Consume() { println("charging") }

//---
type Consumer interface {
	Consume()
}

func Nourish(x Consumer) {
	x.Consume()
}

func main() {
	subjects := []Consumer{Person{}, Robot{}}
	for _, subject := range subjects {
		Nourish(subject)
	}
}
