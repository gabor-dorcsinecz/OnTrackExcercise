package ontrack

import cats.FlatMap
import cats.implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers._

class Excercise6 extends AnyFlatSpec with should.Matchers {

  trait MyAlg[F[_]] {
    def insertItSomewhere(someInt: Int): F[Unit]
    def doSomething(someInt: Int): F[Int]
  }

  class MyProg[F[_] : FlatMap](myAlg:MyAlg[F]) {
    def checkThenAddIt(someInt: Int):F[Int]  = {
      for {
        res <- myAlg.doSomething(someInt)
        _ <- myAlg.insertItSomewhere(res)
      } yield res
    }
  }

  object MyProg {
    def apply[F[_]](implicit ev: FlatMap[F]):FlatMap[F] = ev
  }

  it should "work" in {
    val myAlg = new MyAlg[Option] {
      def insertItSomewhere(someInt: Int): Option[Unit] = Some(())
      def doSomething(someInt: Int): Option[Int] = Some(someInt)
    }
    val myProg = new MyProg[Option](myAlg)
    myProg.checkThenAddIt(1) shouldBe Some(1)
  }

}
