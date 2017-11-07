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
  // def - name - param - return type - body 구조
  def add2(x: Int, y: Int): Int = x + y
  println(add(1, 2))
}
