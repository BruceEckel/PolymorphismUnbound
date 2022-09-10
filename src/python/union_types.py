#: src/python/union_types.py
from disjoint_types import Dog, Person, Robot, Slug

def nourish(sumtype_obj: Dog | Person | Robot | Slug):
    sumtype_obj.eat()
    match sumtype_obj:  # No exhaustiveness checking
        case Dog(): sumtype_obj.bark()
        case Person(): sumtype_obj.greet()
        case Robot(): sumtype_obj.initiate()

if __name__ == '__main__':
    for subject in [Dog(), Person(), Robot(), Slug()]:
        nourish(subject)
    # nourish("")  # Type-check error
