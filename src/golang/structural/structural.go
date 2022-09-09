// : src/golang/structural/structural.go
package main

type Dog struct{}

func (dog Dog) Consume()     { println("eating dog food") }
func (dog Dog) Communicate() { println("woof") }

type Person struct{}

func (person Person) Consume()     { println("eating pizza") }
func (person Person) Communicate() { println("hello") }

type Robot struct{}

func (robot Robot) Consume()     { println("charging") }
func (robot Robot) Communicate() { println("operational") }

type Slug struct{}

func (slug Slug) Consume()     { println("eating grass") }
func (slug Slug) Communicate() {}

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
