class Dog() {
  fn bark() { println!("woof"); }
}

class Person() {
  fn greet() { println!("hello"); }
}

pub trait Communicate[T] {
  fn speak(t:T) -> Unit
}

impl Communicate for Dog {
  fn speak(t: Dog) -> Unit { t.bark(); }
}

impl Communicate for Person {
  fn speak(t: Person) -> Unit { t.greet(); }
}

pub fn demo<T>(instance: T)(using Communicate[T]) {
    instance.speak();
}

fn main() {
    demo(Dog());
    demo(Person());
}