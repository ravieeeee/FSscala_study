object UnifiedTypes extends App {
  // Type Hierarchy
  // Any가 최상위노드
  // AnyVal과 AnyRef가 그 하위노드
  // AnyVal(non-nullable) : Double, Float, Long, Int, Short, Byte, Char, Unit, Boolean
  // AnyRef(non-value 포함) : reference type, 새롭게 정의한 타입 모두 AnyRef의 subtype
  // java.lang.Object랑 같은 의미

  val list: List[Any] = List(
    "a string",
    732,
    'c',
    true,
    () => "an anonymous function returning a string"
  )
  list.foreach(element => println(element))
  // 여러 타입이어도 모두 scala.Any의 instance기 때문에 저렇게 다 때려넣을 수 있다

  // Type Casting
  // Byte -> Short -> Int(<-Char) -> Long -> Float -> Double
  // 이 방향들로만 casting 가능
  val x: Long = 987654321
  val y: Float = x
  // 오 이모티콘도 올라간다
  val face: Char = '☺'
  val number: Int = face

  // Nothing and Null
  // Nothing은 모든 타입이 다 가지고 있음 새로 만들 타입까지도(최하위노드)
  // 하지만 Nothing이 value일 수는 없다.(Nothing type의 instance 생성 불가)
  val nlist: List[Nothing] = List[Nothing]();
  val list1: List[Int] = nlist;
  val list2: List[Float] = nlist;
  val list3: List[Double] = nlist;
  // 이런식으로 비어있지만 서로 다른 타입인 애들을 만들때 사용할 수 있다.
  // 최하위노드니까 가능한 것
  val list4: List[Int] = Nil
  // 많이써서그런가 List[Nothing]()을 Nil로 만들어둔듯
  // 예외 처리, 프로그램 종료, 무한루프같이 리턴값이 나올 수 없는 경우에도 사용됨

  // Null은 모든 reference type의 하위노드(Nothing은 Null의 하위노드기도 하다)
  // 스칼라에서는 null 사용을 지양하는듯
  // null의 대안이 있다
}
