/**
 * Created with IntelliJ IDEA.
 * User: Sabertooth SSD
 * Date: 5/18/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
object chap12 {
    val tableSize = 7 //> tableSize  : Int = 7

    def qhash(n: Int)(i: Int): Int = (n.hashCode + (i * i)) % tableSize

    //> qhash: (n: Int)(i: Int)Int

    var ary = new Array[Int](tableSize) //> ary  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0)

    import scala.util.control.Breaks._

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(23)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 23
                break
            }
        }
    } //> qhash(23)(t) = 2
    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(13)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 13
                break
            }
        }
    } //> qhash(23)(t) = 2

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(21)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 21
                break
            }
        }
    } //> qhash(23)(t) = 2

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(14)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 14
                break
            }
        }
    } //> qhash(23)(t) = 2




    //| qhash(23)(t) = 3

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(7)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 7
                break
            }
        }
    } //> qhash(23)(t) = 2






    //| qhash(23)(t) = 3
    //| qhash(23)(t) = 6

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(8)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 8
                break
            }
        }
    } //> qhash(23)(t) = 2






    //| qhash(23)(t) = 3
    //| qhash(23)(t) = 6

    breakable {
        for (t <- 0 until tableSize) {
            val d = qhash(15)(t)
            println("qhash(23)(t) = " + qhash(23)(t))
            if (ary(d) == 0) {
                ary(d) = 15
                break
            }
        }
    } //> qhash(23)(t) = 2








    //| qhash(23)(t) = 3
    //| qhash(23)(t) = 6
    //| qhash(23)(t) = 4


    for (a <- ary) {
        println(a) //> 21
        //| 14
        //| 23
        //| 15
        //| 7
        //| 8
        //| 13
    }
























    for (a <- 0 until tableSize) {
        println("a = " + a)
        if (ary(qhash(7)(a)) == 7) {
            println("Found 7 at round " + a)
        }
    }



























    // Chapter 13
    // ************ zip
    List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1)

    "Scala".zipWithIndex



    "Scala".zipWithIndex.max
    "Scala".zipWithIndex.max._2
    List('a', 'b', 'c', 'd').view.zipWithIndex

    val xs = List.tabulate(5)(_ + 1)
    val ys = xs.view map {
        x => println(x); x * x
    }

    // This is the same
    val freq = scala.collection.mutable.Map[Char, Int]()
    for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
    // as
    (Map[Char, Int]() /: "Mississippi") {
        (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
    }



    val y = List(0,0,0,0,1, 2, 3, 4, 5, 6, 7)
    y.grouped(3) foreach {
        e => println(e)
    }






    y.dropRight(2)
    y.drop(2)
    y.dropWhile(_ < 5)
    y.find( _ < 6)
    y.dropWhile(_ == 0)
    y.filter(_ % 3 == 0)
}