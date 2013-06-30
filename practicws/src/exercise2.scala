object rationals {
    def main(args: Array[String]) {
        val x = new Rational(1, 3)
        val y = new Rational(5, 7)
        val z = new Rational(3, 2)

        x.numer
        x.denumer
//        x.add(y)
        x + y
        println(y + y)
//        println(y.less(x))
        println(y < x)
        println(x.max(y))

        println("x * y + y * y = " + (x * y + y * y))


//        Use the 'new' keyword when you want to refer to a class's own constructor:
//
//        class Foo { }
//
//        val f = new Foo
//        Omit 'new' if you are referring to the companion object's apply method:
//
//        class Foo { }
//        object Foo {
//            def apply() = new Foo
//        }
//
//        // Both of these are legal
//        val f = Foo()
//        val f2 = new Foo
//
        println("new Rational(1, 2).numer = " + new Rational(1, 2).numer)
        println("Rational(1, 2).numer = " + Rational(1, 2).numer)

//        println("new Rational(1,2).less(new Rational(2,3)) = " + new Rational(1, 2).less(new Rational(2, 3)))
        println("new Rational(1,2).less(new Rational(2,3)) = " + (new Rational(1, 2) < new Rational(2, 3)))
//        println("Rational(1,2).less(Rational(2,3)) = " + Rational(1, 2).less(Rational(2, 3)))
        println("Rational(1,2).less(Rational(2,3)) = " + (Rational(1, 2) < Rational(2, 3)))
    }
}

// 'case class' in Scala
//======================
// If you've made a case class:
//
//    case class Foo()
//    Scala secretly creates a companion object for you, turning it into this:
//
// class Foo { }
// object Foo {
//    def apply() = new Foo
// }

case class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
//    def numer = x / gcd(x,y)
//    def denumer = y /gcd(x,y)

    val numer = x / gcd(x,y)
    val denumer = y /gcd(x,y)

//    def add(that: Rational) = new Rational(that.denumer * numer + denumer * that.numer, that.denumer * denumer)
    def + (that: Rational) = new Rational(that.denumer * numer + denumer * that.numer, that.denumer * denumer)
//    def sub(that: Rational) = add(that.neg)
//    def sub(that: Rational) = this + (that.neg)
    def - (that: Rational) = this + -that
//    def neg: Rational = new Rational(-numer, denumer)
    def unary_- : Rational = new Rational(-numer, denumer)
//    def less(that: Rational) = numer * that.denumer < that.numer * denumer
    def < (that: Rational) = numer * that.denumer < that.numer * denumer
//    def max(that: Rational) = if (this.less(that)) that else this
    def max(that: Rational) = if (this < that) that else this

    def * (that: Rational) = new Rational(numer * that.numer, denumer * that.denumer)

    override def toString: String = numer + "/" + denumer
}

object exercise2 {
    def main(args: Array[String]) {
        def sum(f: Int => Int, a: Int, b: Int) = {
//        def sum(f: Int => Int): (Int, Int) => Int = {
            def loop(a: Int, acc: Int): Int =
                if (a > b) acc
                else loop(a + 1, f(a) + acc)

            loop(a, 0)
        }

        println("sum = " + sum((x: Int) => x * x, 1, 5))
        println("sum = " + sum(x => x * x, 1, 5))

        //-----------------------------------------------------
        def sum2(f: Int => Int): (Int, Int) => Int = {
            def sumF(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumF(a + 1, b)
            sumF
        }

        def sumInts = sum2(x => x)
        def sumCubes = sum2(x => x * x * x)

        println(sumCubes(1, 10) + sumInts(2, 8))

        println(sumCubes(1, 10))
        println(sumInts(2, 8))

        //---------------------------------
        // remove middleman
        def cube(x: Int): Int = x * x * x
        println( sum2(cube)(1, 10) )


        //----------------------------
        // multiple parameters list
        def foo(as: Int*)(bs: Int*)(cs: Int*) = as.sum * bs.sum * cs.sum
        println( foo(1, 2, 3)(4, 5, 6, 7, 8, 9)(10, 11) )
        println( (1+2+3) * (4+5+6+7+8+9) * (10+11) )

        // ---------------------------
//        println(rationals.toString)

        val ary = new Array[Array[Int]](10)

        for (i <- 0 until ary.length) ary(i) = new Array[Int](i+1)

    }
}
