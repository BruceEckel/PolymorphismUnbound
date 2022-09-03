use std::ops::Add;

pub trait FromString {
    fn from_string(s: String) -> Self;
}

impl FromString for i32 {
    fn from_string(s: String) -> i32 {
        s.parse::<i32>().unwrap()
    }
}

impl FromString for f32 {
    fn from_string(s: String) -> f32 {
        s.parse::<f32>().unwrap()
    }
}

pub fn add<B>(a: String, b: String) -> B where B: Add<Output=B> + FromString {
    B::from_string(a) + B::from_string(b)
}

fn main() {
    println!("Hello, world!");
}
