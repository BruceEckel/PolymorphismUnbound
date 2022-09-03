from base import Base
from nourish import Dog, Person, Robot, Slug

class Dog2(Dog, Base):
    def eat(self) -> None: super().eat()
    def speak(self) -> None: self.bark()

class Person2(Person, Base):
    def eat(self) -> None: super().eat()
    def speak(self) -> None: self.greet()

class Robot2(Robot, Base):
    def eat(self) -> None: super().eat()
    def speak(self) -> None: self.initiate()

class Slug2(Slug, Base):
    def eat(self) -> None: super().eat()
    def speak(self) -> None: pass  # Required by ABC

def nourish_mi(base: Base):
    base.eat()
    base.speak()

if __name__ == '__main__':
    for subject in [Dog2(), Person2(), Robot2(), Slug2()]:
        nourish_mi(subject)
