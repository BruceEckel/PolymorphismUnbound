#: src/python/duck_typing.py
from disjoint_types import Dog, Person, Robot, Slug

def nourish(subject):
    subject.eat()  # Duck typing
    if type(subject) is Dog: subject.bark()
    if type(subject) is Person: subject.greet()
    if type(subject) is Robot: subject.initiate()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug()]:
        nourish(subject)
        # nourish("")  # Runtime error
