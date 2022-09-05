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

pub fn poly<T>(x: T)(using Communicate[T]) {
    x.speak();
}

fn main() {
    poly(Dog());
    poly(Person());
}
