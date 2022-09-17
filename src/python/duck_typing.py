#: src/python/duck_typing.py
from inheritance import Person, Robot

def nourish(subject: object):
    subject.eat()  # Duck typing

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
    # nourish("")  # Runtime error
