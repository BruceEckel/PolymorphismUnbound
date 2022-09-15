#: src/python/multiple_inheritance.py
from base import Base
from disjoint_types import Dog, Person, Robot, Slug

class Dog2(Dog, Base): # Order of base classes is important
    def eat(self): super().eat()
    def speak(self): self.bark()

class Person2(Person, Base):
    def eat(self): super().eat()
    def speak(self): self.greet()

class Robot2(Robot, Base):
    def eat(self): super().eat()
    def speak(self): self.initiate()

class Slug2(Slug, Base):
    def eat(self): super().eat()
    def speak(self): pass  # Required by ABC
#---
def nourish(base: Base):
    base.eat()
    base.speak()

if __name__ == '__main__':
    for subject in [Dog2(), Person2(), Robot2(), Slug2()]:
        nourish(subject)
