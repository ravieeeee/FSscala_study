object Basics extends App {
  println("Hello world")

  // value
  // 변하지 않는 값
  val x1 = 1 + 1
  // x1 = 3 불가능
  val x2: Int = 1 + 1

  // variables
  var y1 = 1 + 1
  y1 = 3
  println(y1 * y1)
  var y2: Int = 1 + 1

  // Blocks
  println({
    val z = 1 + 1
    // 마지막 줄이 리턴값이 됨
    z + 1
  })

  // Functions
  // 익명 함수 가능, arrow function 가능
  val addOne = (x: Int) => x + 1
  println(addOne(1))

  val add = (x: Int, y: Int) => x + y
  println(add(1, 2))

  val getTheAnswer = () => 42
  println(getTheAnswer());

  // Methods
  // 'def' - name - param - return type - body 구조
  def add2(x: Int, y: Int): Int = x + y
  println(add(1, 2))
  // 여러개의 parameter list를 받을 수 있음
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3))

  def name: String = System.getProperty("name")
  println("Hello, " + name);

  // 스칼라에도 return 예약어가 있지만 거의 사용되지 않음
  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }

  // Classes
  // 클래스명(constructor parameters)
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }
  // Unit을 return하는 건 void와 비슷한 의미
  // 다른점 : 스칼라 코드는 항상 value를 가져야 해서 실제로는 Unit type의 singleton value가 리턴된다는 것
  // () 이렇게 비어있는 value가 return되나봄.

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer")

  // Case Classes
  // immutable, compared by value
  case class Point(x: Int, y: Int)
  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)

  // 같음(compared by value)
  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  }
  // 당연히 다름
  if (point == yetAnotherPoint) {
    println(point + " and " + yetAnotherPoint + " are the same.")
  } else {
    println(point + " and " + yetAnotherPoint + " are different.")
  }

  // Objects
  // single instance(singleton 패턴같이 하나만 만들어 쓰는걸 따로 예약어로 뺀듯)
  object IDFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }
  val newId: Int = IDFactory.create()
  println(newId)
  val newerId: Int = IDFactory.create()
  println(newerId)
  // 2가 출력됨
  // newId랑 같은 애를 참조하니까

  // Traits
  // interface와 비슷하다고 한다
  // 여러개의 trait 결합가능
  trait Greeter2 {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }

  // trait 다중 상속도 가능하다.
  class DefaultGreeter extends Greeter2 {
    class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2 {
      override def greet(name: String): Unit = {
        println(prefix + name + postfix)
      }
    }
    val greeter = new DefaultGreeter()
    greeter.greet("Scala developer")
    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
  }

  // Main Method
  object Main {
    def main(args: Array[String]) : Unit =
      println("hello, Scala developer!")
  }
}


