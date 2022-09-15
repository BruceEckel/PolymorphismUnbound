#: src/python/single_dispatch.py
# (Not included in presentation)
from functools import singledispatch
from disjoint_types import Dog, Person, Robot, Slug

@singledispatch
def nourish(subject):
    print("default nourish")

@nourish.register
def _(subject: Dog):
    print("Dog")
    subject.eat()
    subject.bark()

@nourish.register
def _(subject: Person):
    print("Person")
    subject.eat()
    subject.greet()
#---
@nourish.register
def _(subject: Robot):
    print("Robot")
    subject.eat()
    subject.initiate()

@nourish.register
def _(subject: Slug):
    print("Slug")
    subject.eat()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug(), ""]:
        nourish(subject)
