//: src/rust/typeclasses/src/main.rs
struct Person;
struct Robot;

impl Person {
  fn consume(&self) { println!("eating pizza"); }
}

impl Robot {
  fn charge(&self) { println!("charging"); }
}
//---
pub trait Eater {
    fn eat(&self);
}

impl Eater for Person {
    fn eat(&self) {
        self.consume();
    }
}

impl Eater for Robot {
    fn eat(&self) {
        self.charge();
    }
}
//---
pub fn nourish<T: Eater>(x: &T) {
    x.eat();
}

fn main() {
    nourish(&Person {});
    nourish(&Robot {});
}
