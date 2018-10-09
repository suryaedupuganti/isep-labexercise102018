## Questions

### Q1. What shows up? Why is the method toString() called without being named?

java.lang.Object is a super class of any class by default which results the string representation of an object. In our case, the Circle class overrides the toString() implementation of java.lang.Object class.

### Q2. If you rename the method toString(), what happens?

It calls the default toString() method from java.lang.Object