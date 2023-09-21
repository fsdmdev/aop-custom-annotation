# Spring Boot AOP (Aspect-Oriented Programming)

AOP is a powerful feature in the Spring ecosystem that allows you to modularize cross-cutting concerns in your
application, such as logging, security, and transaction management

# AOP Terminologies

## Aspect

In AOP, an aspect is a module that encapsulates a concern. A concern is a behavior or functionality that you want to
apply to your application independently, like logging or security.

## Advice

Advice is the actual action taken by an aspect at a particular join point. It defines what should be done and when it
should be done. Types of advice include "before," "after," "around," and more.

## Join Point

A join point is a specific point in your application where an aspect's advice can be applied. For example, method
executions, method calls, or object instantiations can be join points.

## Pointcut

A pointcut is an expression that specifies a set of join points where advice should be applied. It allows you to
define conditions for when your aspect should take action.

## Weaving
Weaving is the process of integrating aspects into your application at the appropriate join points. Spring AOP
supports both compile-time and runtime weaving.

### You can use Spring Boot AOP to:
- Log method invocations for debugging or auditing purposes.
- Add security checks before executing certain methods.
- Implement transaction management.
- Measure the execution time of methods.
- Handle exceptions in a centralized manner.