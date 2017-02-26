# 1 Class Design (20 points)

Design a class hierarchy (classes and/or interfaces) to support a program dealing with geographic
objects. Support the following classes (at least):
- Countries
- States/Provinces
- Cities
- Boundary Segments
- Rivers
Support the following operations, where applicable, plus any others that seem useful (arguments
have been omitted, but you will have to include them):
- area()
- capital()
- getCities()
- getCountry()
- distance() { between cities
- boundaryLength() { total length of boundary
- neighbors() { objects sharing boundaries
- borderOf() { the countries/states this separates

Write out the class definitions, instance variables and method definitions. Some of the instance
variables should probably be various kinds of Collections. 

You do not need to implement the methods, but you should include comments inside each method that describe the approach you would
take (alternately, you can actually implement them  (that might be simpler for some methods). 

Use interfaces and superclasses where appropriate. 

Supply javadoc comments for all classes, interfaces,
and methods.
The system you write should compile, even if it doesn't actually work (because the
methods are just stubs with comments). 

Identify all of the classes as belonging to the package "geography", and put the .java files in a directory called geography,
so that javadoc functions properly. 

Note that this means that the compiler must be run from outside the geography directory,
and you should type `javac geography/*.java`, say, to compile your code. 
This is annoying, and one of the reasons I dislike Java's package system. 
(You would do the same thing to run a program in a package, but in this particular case you are not writing a program, so the issue won't come
up.)

Note: This problem is deliberately openended. Don't panic! Be creative!
Extra credit: Be especially creative!
