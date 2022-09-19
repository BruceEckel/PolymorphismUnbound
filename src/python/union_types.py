#: src/python/union_types.py
from disjoint_types import Person, Robot

def nourish(x: Person | Robot):
    match x:  # No exhaustiveness checking (yet)
        case Person(): x.consume()
        case Robot(): x.charge()

if __name__ == '__main__':
    for subject in [Person(), Robot()]:
        nourish(subject)
    # nourish("")  # Type-check error
