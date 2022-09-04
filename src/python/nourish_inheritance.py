from base import Base

class Dog(Base):
    def eat(self): print("eating dog food")
    def speak(self): print("woof")

class Person(Base):
    def eat(self): print("eating pizza")
    def speak(self): print("hello")

class Robot(Base):
    def eat(self): print("recharging")
    def speak(self): print("operational")

class Slug(Base):
    def eat(self): print("eating grass")
    def speak(self): pass

def nourish_inheritance(subject: Base):
    subject.eat()
    subject.speak()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug()]:
        nourish_inheritance(subject)