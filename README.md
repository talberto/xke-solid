# SOLID : Open Closed Principle

# Why?
```java
switch(mower.getNextCommand()) {
  case(Command.goForward) :
    mower.goForward();
    break;
  case(Command.turnRight) :
    mower.turnLeft();
    break;
  [...]
  default :
    throw new IllegalArgumentException(“Unknown command”);	
}
```
When adding a new command changes multiple classes like adding one new `Command` and updating the already created class `Mower`, the class which runs the program, you should stop and think.

# Definition :
> Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification

Which means: keep as much as possible existing code unchanged when adding new functionality.

# How?
Most of the use cases involves inheritance and polymorphism but you can also use patterns like Decorator, Factory or Observer.
