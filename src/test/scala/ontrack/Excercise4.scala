package ontrack

import scala.concurrent.Future
import scala.util.Try
import cats.implicits._
import scala.concurrent.ExecutionContext.Implicits.global

object Excercise4Spec {

  def f[A](a: A): Future[A] = ???

  def g[A](a: A): Future[Either[Throwable, A]] = {
    f(a).transformWith(_.fold(
      err => Future(Either.left[Throwable, A](err)),
      success => Future(Either.right[Exception, A](success))
    ))
  }

}
