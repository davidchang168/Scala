
import scala.collection.immutable
import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

// java List, this is not a Scala List
var js: java.util.List[String] = new java.util.ArrayList[String]()
js.add("david")
js.add("michelle")
js.add("aaron")
js.add("keith")
val ss: Seq[String] = js.asScala
// Scala List
val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
val fruit2 = "apples" :: "oranges" :: "pears" :: Nil
val fruit3 = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val ary = new Array[Array[Int]](10)






for (i <- 0 until ary.length) ary(i) = new Array[Int](i+1)
val matrix = Array.ofDim[Int](3,4)





var a = ArrayBuffer(2,3,5,-5,19,-8,12,-1,7)




// copy the non-negative values to the front.
var first = true
val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
    if (a(i) < 0) first = false; i
}





// move the elements where they belong and then trim the end.
for (j <- 0 until indexes.length) a(j) = a(indexes(j))
a.trimEnd(a.length - indexes.length)
val sortedA = a.sortWith(_ < _)



println(a.mkString(","))
println(sortedA.mkString(","))
val c = Array(1,7,2,4)
scala.util.Sorting.quickSort(c)
println(c.mkString(","))

// a is not changed.
val d = a.toArray
scala.util.Sorting.quickSort(d)
println(d.mkString(","))

abstract class IntSet {
    def contains(x: Int): Boolean
    def incl(x: Int): IntSet
    def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean =
        if (x < elem) left contains x
        else if (x > elem) right contains x
        else true
    def incl(x: Int): IntSet =
        if (x < elem) new NonEmpty(elem, left incl x, right)
        else if (x > elem) new NonEmpty(elem, left, right incl x)
        else this

    def union(other: IntSet): IntSet =
        ((left union right) union other) incl elem
}

object Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
    def union(other: IntSet): IntSet = other
}

(new NonEmpty(7, Empty, Empty)) contains 7

object scratch {
    def main(args: Array[String]) {

        new Rational(1,2)
        // error is a Nothing type.
        def error(msg: String) = throw new Error("error")
        error("test")
    }
}
//scratch.main(Array("test","ggyy"))
val x = null
val y: String = x
// Null is a subtype of AnyRef type but AnyVal type.
val z: Int = null



















// class with a type parameter '[T]'
trait MList[T] {
    def isEmpty: Boolean
    def head: T
    def tail: MList[T]
}
class Cons[T](val head: T, val tail: MList[T]) extends MList[T] {
    def isEmpty: Boolean = false
}
class Nil[T] extends MList[T] {
    def isEmpty: Boolean = true

    // 'Nothing' is a subtype of any other type T
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
val intList: MList[Int] = new Cons(3, new Cons(4, new Nil))
val intList2 = 1 :: 2 :: 3 :: Nil
// function with type parameter
def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
singleton[Int](1)
singleton[Boolean](true)
// 'type erasure' is applied because type [Int] and [Boolean] are redundant here.
singleton(1)
singleton(true)


object nth {
    def nth[T](n: Int, xs: MList[T]): T =
        if (xs.isEmpty) throw new IndexOutOfBoundsException
        else if (n == 0) xs.head
        else nth(n - 1, xs.tail)
}

val lst = new Cons(1, new Cons(2, new Cons(3, new Nil)))
//val lst: immutable.List[Int] = 1 :: 2 :: 3 :: Nil
nth.nth(2, lst)
nth.nth(-1, lst)



























































































