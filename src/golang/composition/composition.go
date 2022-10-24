// From jackbot:
// Here’s some Go composition example. Interesting that it does have “overriding” behavior:
package main

type Generic struct{}

func (_ Generic) doWork() {
	println("Generic work")
}

type Specific1 struct {
	Generic
}

type Specific2 struct {
	Generic
}

func (_ Specific2) doWork() {
	println("Specific2 work")
}

func main() {
	g := Generic{}
	s1 := Specific1{}
	s2 := Specific2{}

	g.doWork()          // Prints "Generic work"
	s1.doWork()         // Prints "Generic work"
	s2.doWork()         // Prints "Specific2 work"
	s2.Generic.doWork() // Prints "Generic work"
}

/*
This got me wondering what would happen if multiple components provide the same behavior, and the answer it, “it does not compile”, which is IMO, a good thing:
package main

type Generic1 struct{}

func (_ Generic1) doWork() {
	println("Generic1 work")
}

type Generic2 struct{}

func (_ Generic2) doWork() {
	println("Generic2 work")
}

type Specific struct {
	Generic1
	Generic2
}


func main() {
	s := Specific{}

	s.doWork() // Does not compile: Ambiguous reference 'doWork'
}
*/