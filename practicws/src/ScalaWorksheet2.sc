/**
 * Created with IntelliJ IDEA.
 * User: Sabertooth SSD
 * Date: 4/24/13
 * Time: 7:49 AM
 * To change this template use File | Settings | File Templates.
 */

object Outer {

    object Accounts {
        private var lastNumber = 0

        def apply = {
            println("-----------------")
            val b = new Accounts()
            println("========== " + b.balance)
            lastNumber = 1
        }

        def newUniqueNumber() = {
            println("================")
            lastNumber += 1
            lastNumber
        }
    }


    class Accounts {
        def apply(n: Int) = {
            println("^^^^^^^^^^^^^^^ ")
            Accounts.lastNumber
        }

        val id = Accounts.newUniqueNumber()
        private var balance = 0.0

        def deposit(amount: Double) {
            balance += amount
        }
    }
}


val v = new Outer.Accounts()






v(23)



//v.apply
//println(v.newUniqueNumber)


class Foo(x: Int) {
    def apply(y: Int) = {
        x * x + y * y
    }
}


object Foo {
    def apply(y: Int) = {
        y + y
    }
}



val f = new Foo(3)
f(4)


f.apply(4)

