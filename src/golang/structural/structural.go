//: src/golang/structural/structural.go
package main

type Dog struct{}

func (_ Dog) Consume()     { println("eating dog food") }
func (_ Dog) Communicate() { println("woof") }

type Person struct{}

func (_ Person) Consume()     { println("eating pizza") }
func (_ Person) Communicate() { println("hello") }

type Robot struct{}

func (_ Robot) Consume()     { println("charging") }
func (_ Robot) Communicate() { println("operational") }

type Slug struct{}

func (_ Slug) Consume()     { println("eating grass") }
func (_ Slug) Communicate() {}

type ConsumerCommunicator interface {
	Consume()
	Communicate()
}

func Poly(x ConsumerCommunicator) {
	x.Consume()
	x.Communicate()
}

func main() {
	subjects := []ConsumerCommunicator{
		Dog{}, Person{}, Robot{}, Slug{},
	}
	for _, subject := range subjects {
		Poly(subject)
	}
}
