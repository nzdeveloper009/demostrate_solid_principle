package nzcoding.android.solideprinciple

import java.util.Vector


// S - Single Responsibility Principle
// Mastering the art of delegation and specialization.
// here is the square responsibility is calculation
// and UI based responsibility of square is only SquareUI Responsible
class Square {
    fun calculateArea(side: Int): Int = side * side

    fun calculatePerimeter(side: Int): Int = 4 * side

}

class SquareUI {
    fun renderSquare() = print("Render Square")
    fun renderLargeSquare() = print("Render Large Square")
}


/*
* O - Open Closed Principle
*   -	Software component is opened for extension, but closed for modification
*   -	Learning how to be adaptable to change while maintaining stability.*/

interface Customer {
    fun isLoyalCustomer(): Boolean
}

class VehicleInsuranceCustomer : Customer {
    override fun isLoyalCustomer(): Boolean = true
}

class HomeInsuranceCustomer : Customer {
    override fun isLoyalCustomer(): Boolean = true
}

class LifeInsuranceCustomer : Customer {
    override fun isLoyalCustomer(): Boolean = true
}

class InsuranceCompany {

    fun discountRate(customer: Customer): Int = if (customer.isLoyalCustomer()) 38 else 30
}


/*
fun main() {
    /*val lifeInsuranceCustomer = LifeInsuranceCustomer()
    val homeInsuranceCustomer = HomeInsuranceCustomer()
    val vehicleInsuranceCustomer = VehicleInsuranceCustomer()

    val insuranceCompany = InsuranceCompany()
    insuranceCompany.discountRate(lifeInsuranceCustomer)
    insuranceCompany.discountRate(homeInsuranceCustomer)
    insuranceCompany.discountRate(vehicleInsuranceCustomer)
}
*/

 */
/*
*Liskov Substitution
**  - objects of a superclass should be replaceable with objects of its subclasses without breaking the application
*   - Understanding the value of trust in relationships (between classes, of course!)
*   - In other words, what we want is to have the objects of our subclasses behaving the same way as the objects of our superclass.
*/

open class Vehicle {
    open fun getInteriorWidth(): Int = 0
}

open class Car : Vehicle() {
    fun getCabinWidth(): Int = 39
    override fun getInteriorWidth(): Int = this.getCabinWidth()
}
// Car and Racingcar is between interconvertible ; capable of being exchanged equivalently, the one for the other
class RacingCar : Vehicle() {
    fun cockpitWidth(): Int = 12
    override fun getInteriorWidth(): Int = this.cockpitWidth()
}
/*
fun main() {
    val list = mutableListOf(RacingCar(), Car())

    list.forEach {
        println(it.getInteriorWidth())
    }
/*    list.forEach {
        when(it) {
            is RacingCar -> {
                println(it.cockpitWidth())
            }
            is Car -> {
                println(it.getCabinWidth())
            }
        }
    }*/
}
*/



/*
* Interface Segregation
* - Clients should not be forced to depend upon interfaces that they do not use
* - The goal of this principle is to reduce the side effects of using larger interfaces by breaking application interfaces into smaller ones.
* -	Discovering the joy of simplicity and specificity
** - Instead of creating a big interface you can create a small interfaces
* */


/*
// Printer Functionality interface
interface IMultiFunctional {
    fun print()
    fun printSpoonDetails()
    fun scan()
    fun scanPhoto()
    fun fax()
    fun internetFax()
}


// CanonPrinter have not Fax Functionality but interface have
// but interfaces have then how to fix it?
// here Interface Segregation is used.
class CanonPrinter: IMultiFunctional {
    override fun print() {

    }

    override fun printSpoonDetails() {

    }

    override fun scan() {

    }

    override fun scanPhoto() {

    }

    override fun fax() {

    }

    override fun internetFax() {

    }
}
*/


interface IPrint {
    fun print()
    fun printSpoonDetails()
}

interface IScan {
    fun scan()
    fun scanPhoto()
}

interface IFax {
    fun fax()
    fun internetFax()
}

class CanonPrinter: IPrint,IScan{
    override fun print() {
    }

    override fun printSpoonDetails() {
    }

    override fun scan() {
    }

    override fun scanPhoto() {
    }

}

/*
* Dependency Inversion Principle
* states that high-level modules should depend on abstractions rather than concrete implementations.
* helps decouple the high-level and low-level modules, making it easier to change the low-level ones without affecting the high-level ones
* - Grasping the concept of depending on abstractions over details
* - Upper Model not depend on the Lower Model, both could depend on the abstraction
* */


/*
// High level Module
class ProductCatalog {
    fun listAllProducts() {
        val sql = SQLProductRepo()
        sql.getAllProducts().forEach {
            println(it)
        }
    }
}

// Low Level Module
class SQLProductRepo {
    fun getAllProducts(): MutableList<String>  = mutableListOf("Apple","Banana")
}
*/

// here upper level and lower level is depended
// but Dependency Inversion Principle is not said that
// here we apply the rule of Dependency Inversion Principle


interface ProductRepo {
    fun getAllProducts(): MutableList<String>
}


// Low Level Module
class SQLProductRepo: ProductRepo {
    override fun getAllProducts(): MutableList<String>  = mutableListOf("Apple","Banana")
}

// Upper Module
class ProductCatalog {
    fun listAllProducts() {
        val sql:ProductRepo = SQLProductRepo() // abstraction ProductRepo
        sql.getAllProducts().forEach {
            println(it)
        }

        val sql1:ProductRepo = MongoProductRepo()
        sql1.getAllProducts().forEach {
            println(it)
        }
    }
}

class MongoProductRepo:ProductRepo {
    override fun getAllProducts(): MutableList<String> = mutableListOf("Cherry")

}

fun main() {
    val productCatalog = ProductCatalog()
    productCatalog.listAllProducts()
}