//: src/rust/inheritance/src/main.rs
struct Person;
struct Robot;

trait Base {
  fn eat(&self);
}

impl Base for Person {
  fn eat(&self) { println!("eating pizza"); }
}
//---
impl Base for Robot {
  fn eat(&self) { println!("charging"); }
}

fn main() {
  let v: Vec<&dyn Base> = vec![&Person{}, &Robot{}];
  for d in v.iter() {
    d.eat();
  }
}
