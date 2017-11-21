object CaseClasses extends App {
  //  Case classes are good for modeling immutable data.

  // Defining a case class
  // 'case class' + identifier(class명을 말하는듯) + parameter list(비어도 됨)
  case class Book(isbn: String)
  // Book의 instance를 만들기 위해 'new'를 쓰지 않음.
  // case class는 default로 apply method를 가지기 때문
  val frankenstein = Book("978-0486282114")

  case class Message(sender: String, recipient: String, body: String)
  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

  println(message1.sender)  // prints guillaume@quebec.ca
  // reassign 불가(immutable하니까)
  message1.sender = "travis@washington.us"  // this line does not compile

  // Comparison
  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  // compared by structure(not by reference)
  val messagesAreTheSame = message2 == message3  // true

  // Copying
  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  message5.sender  // travis@washington.us
  message5.recipient // claire@bourgogne.fr
  message5.body  // "Me zo o komz gant ma amezeg"
}
