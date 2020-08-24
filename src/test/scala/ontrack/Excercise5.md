```scala
  trait MyAlg[F[_]] {
  def insertItSomewhere(someInt: Int): F[Unit]
  def doSomething(someInt: Int): F[Int]
}
```

We are generalizing the F effect type (tagless final style)
This way our algebra can be used with any effect type like 
Option, Either, Future, Monix Task, Cats IO, ZIO 
