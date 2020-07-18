package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionVal = if (aCondition) 42 else 65
  // instructions vs expressions (scala build expressions on top of other expressions)

  //compiler infers types for us

  // Unit - only for side effects = void in other languages
  val theUnit = println("hello, Scala")

  //functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  @tailrec
  def factorial(n: Int, accum: Int): Int = {
    if (n <= 0) accum
    else factorial(n - 1, n * accum)
  }

  // object-orientation programming
  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog //subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("crunch!")
  }

  // method notations
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // natural language

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("roar!")
  }

  // generics
  abstract class MyList[+A] //variance and variance problems in this course

  // singletons and companions
  object MyList

  // case classes
  case class Person(name: String, age: Int)

  // exceptions and try/catch/finally
  val throwsException: Nothing = throw new RuntimeException // Nothing type
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("Some logs")
  }

  //packaging and imports

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)

  val anonymousIncrememter = (x: Int) => x + 1
  List(1,2,3).map(anonymousIncrememter) // HOF

  // map, flatMap, filter
  // for-comprehension
  // Scala collections: Seqs, Arrays, Lists, Vectors, Maps, Tuples

  // "collections": Options, Try
  // pattern matching

}

