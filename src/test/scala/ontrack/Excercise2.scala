package ontrack

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers._

class Excercise2 extends AnyFlatSpec with should.Matchers {

  val f1: (Int, Int) => Int = (a, b) => a + b
  val f2: Int => String = _.toString

  //Faster, but have to be read backwards
  val f31: (Int, Int) => String = (a,b) => f2(f1(a,b))

  //Creates more objects and slower, but reads sequentially
  val f32: (Int, Int) => String = (f1.tupled.andThen(f2))(_,_)

  it should "work" in {
    f31(1,2) shouldBe "3"
    f32(1,2) shouldBe "3"
  }
}
