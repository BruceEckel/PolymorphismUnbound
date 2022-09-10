//: src/rust/typeclasses/src/main.rs

struct Dog;
impl Dog {
    fn bark(&self) {
        println!("woof");
    }
}

struct Person;
impl Person {
    fn greet(&self) {
        println!("hello");
    }
}
//---
pub trait Communicate {
    fn speak(&self);
}

impl Communicate for Dog {
    fn speak(&self) {
        self.bark();
    }
}

impl Communicate for Person {
    fn speak(&self) {
        self.greet();
    }
}
//---
pub fn poly<T: Communicate>(x: &T) {
    x.speak();
}

fn main() {
    poly(&Dog {});
    poly(&Person {});
}
