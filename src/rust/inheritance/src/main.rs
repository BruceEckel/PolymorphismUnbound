//: src/rust/inheritance/src/main.rs

trait Base {
  fn eat(&self);
  fn speak(&self);
}

struct Dog;
struct Person;
struct Robot;
struct Slug;

impl Base for Dog {
  fn eat(&self) { println!("eating dog food"); }
  fn speak(&self) { println!("woof"); }
}

impl Base for Person {
  fn eat(&self) { println!("eating pizza"); }
  fn speak(&self) { println!("hello"); }
}
//---
impl Base for Robot {
  fn eat(&self) { println!("charging"); }
  fn speak(&self) { println!("operational"); }
}

impl Base for Slug {
  fn eat(&self) { println!("eating grass"); }
  fn speak(&self) {}
}

fn main() {
  let v: Vec<&dyn Base> = vec![&Dog{}, &Person{}, &Robot{}, &Slug{}];
  for d in v.iter() {
    d.eat();
    d.speak();
  }
}
