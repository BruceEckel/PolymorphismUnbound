struct Dog;
impl Dog {
  fn bark(&self) { println!("woof"); }
}

struct Person;
impl Person {
  fn greet(&self) { println!("hello"); }
}

pub trait Communicate<T> {
  fn speak(t:T);
}

impl Communicate<Dog> for Dog {
  fn speak(t: Dog) { t.bark(); }
}

impl Communicate<Person> for Person {
  fn speak(t: Person) { t.greet(); }
}

pub fn poly<T>(x: T) {
    Communicate::<T>::speak(x);
}

fn main() {
    poly(&Dog{});
    poly(&Person{});
}
