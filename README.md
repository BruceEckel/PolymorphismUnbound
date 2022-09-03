# Polymorphism Unbound

This repository contains the code examples for the presentation I gave
at StrangeLoop 2022, along with the article (in this README.md) that
I wrote in the process of creating the presentation.

## Notes

- Liskov because of static languages vs Smalltalk and Python
- Duck typing in Python and C++ (Go with help from Jack)
- No duck typing with erasure, unless you do it by hand
- Better Duck Typing: Sum Types + Pattern Matching
- Type classes? (See bookmarked article)

- Polymorphism -> "many forms." I assumed this meant "many forms of
  objects" but it really meant that a function argument could take on multiple
  forms.


## The Inheritance Bias

My first encounter with polymorphism was in the very early days of C++. I was
working at the University of Washington in the School of Oceanography for a
researcher named Tom Keffer, and we were trying to make programming easier for
scientists.

At that time C++ was implemented as a program called `cfront` and distributed by
mailing a reel of magnetic tape. The brilliance of `cfront` was that it took
your C++ program and translated it into C. One of the few things you could
expect for most machines at the time was that they had a C compiler, so this
meant that C++ could be immediately targeted to any platform.

Note that this explains C++'s rigid conformance to C source-code compatibility,
which later resulted in folks unfamiliar with C++'s origins to claim that it was
"badly designed." The design was actually very considered and careful---the
"bad" parts came from the uncompromising C-compatibility constraint.

In those early days there was very little in the way of documentation for the
language, and it was not clear that C++ would become the behemoth that it did
(arguably primarily because of C source compatibility). When I first encountered
the `virtual` keyword, there were no clear explanations of why it existed. I floundered for awhile, but eventually realized I could look at the C output of `cfront` to discover what was going on.

To even create a compiling program containing the `virtual` keyword required a
lot of scaffolding: you needed a base class and a derived class, and a member
function in the base class that was marked `virtual`. Once this was done,
`cfront` generated a jump table that called different versions of the `virtual`
function based on type. You know the drill.

It required days of poring over the generated C code for me to figure this out.
Once I did, the *mechanism* of inheritance polymorphism became clear---but not
the "why"---that would take many years to begin creating a useful mental model.
The one thing that *was* clear, however, was there were a lot of special gears
added to C++ just to support this one idea. It was clearly a vital concept and
we programmers should start looking for all the places where we could use it and
improve our lives.

Later, Java came along and confirmed this idea that objects, inheritance and
polymorphism were essential to our programming future. In Java, *everything* is
an object because it was modeled after Smalltalk. (Note that there's a huge
difference: Smalltalk is a dynamic language while Java is statically typed.
Smalltalk's essential nature is dynamic and what you write in Smalltalk or
another dynamic language is often fundamentally different than what you can do
with a static language).

Then we got Design Patterns, which showed how to solve all kinds of problems by
shoehorning them into object hierarchies. I found patterns to be a very useful
mental exercise, but sometimes the resulting designs could seem ... overwrought?

The point of all this is that I made what now seems like an obvious mistake:
Thinking that polymorphism is only about inheritance, because that was my entry
point and that was what was emphasized by OOP. I've done a lot of writing and
speaking over the years, teaching the inheritance view of polymorphism.

The problem for me arose when people would use the word "polymorphism" together with an unfamiliar paradigm. The simplest example is probably *ad-hoc polymorphism*, which just means function overloading:

```C++
// Function overloading
// Tested on https://cpp.sh
#include <iostream>
#include <string>

void f(std::string s) {
    std::cout << "f(std::string s)" << std::endl;
}

void f(float f) {
    std::cout << "f(float f)" << std::endl;
}

int main() {
    f("");
    f(1.0);
}
```

The function names are the same, but they have different parameter lists. The
compiler is able to call the appropriate function based on the argument list.

From my narrow-keyhole-view of polymorphism, this is just some convenience trick
by the compiler. The name `f` is used for more than one function, but the
compiler does some pattern matching to figure out which version to call. Big
deal! There's no inheritance and no dynamic binding so how can it be
polymorphic? And why give it a fancy name like "ad-hoc polymorphism?" You're
trying to confuse me. I will just call it "overloading" and give it no more
thought.

It turns out that overloading contains the essence of what polymorphism is: *a
function that can accept different types of arguments*. Calling it "ad-hoc"
unfortunately de-emphasized the meaning of the word "polymorphism" (at least, to
me). In hindsight, I can see why "ad-hoc" might have been chosen, because
overloading only makes it *look* like the same function when you call it,
whereas when you look at the definition it's clearly two distinct functions. The
idea that it's *the same function with different argument types* gets lost in
the process.

What I want to accomplish in this article is to re-frame your thinking about
polymorphism. In particular, to get you unstuck from my initial impression that
it was all about inheritance and dynamic binding, and to broaden your view so
that terms like "ad-hoc," "parametric," etc. make sense to you. I will also ask
the question, "Objects: Have we Made a Huge Mistake?"

## Changing Our Thinking About Polymorphism

- It's about functions with different parameter types (Decouple from inheritance)
- What problem are we solving by creating a polymorphic function?
- What mechanism are we using (ad hoc, parameterized, inheritance, sum types)?
- How are the different parameters distinguished within the function?
- When is it helping vs simply adding complication?
- Revisit inheritance polymorphism from a function perspective
