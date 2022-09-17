//: src/golang/uniontypes/uniontypes.go
package main

type Person struct{}

func (person Person) Consume() { println("eating pizza") }

type Robot struct{}

func (robot Robot) Charge() { println("charging") }

// ---
func Nourish[T Person | Robot](subject T) {
	switch subjectTyped := any(subject).(type) {
	case Person:
		subjectTyped.Consume()
// 	case Robot:
// 		subjectTyped.Charge()
	} // Not exhaustive
}

func main() {
	Nourish(Person{})
	Nourish(Robot{})
	// Nourish("")  // Error
}
