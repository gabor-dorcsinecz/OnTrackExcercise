package ontrack

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers._

class Excercise3 extends AnyFlatSpec with should.Matchers {


  def addToSeq(seq:Seq[Int]): Seq[Int] = {
    def addToInternal(seq: Seq[Int]): Seq[Int] = {
      seq match {
        case Nil => Seq(1)
        case head :: tail if head < 9 => Seq(head + 1) ++ tail
        case _ :: tail => Seq(0) ++ addToInternal(tail)
      }
    }

    seq match {
      case Nil => Nil
      case _ => addToInternal(seq.reverse).reverse
    }
  }

  it should "Not add to empty list" in {
    addToSeq(Nil) shouldBe Nil
  }

  it should "Add to a single element" in {
    addToSeq(Seq(0)) shouldBe Seq(1)
  }

  it should "Add to a 3 element list" in {
    addToSeq(Seq(1, 2, 3)) shouldBe Seq(1, 2, 4)
  }

  it should "Add increase number of elements in the list" in {
    addToSeq(Seq(9, 9, 9)) shouldBe Seq(1, 0, 0, 0)
  }

}
