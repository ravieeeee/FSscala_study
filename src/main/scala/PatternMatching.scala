object PatternMatching extends App {
  // Syntax
  import scala.util.Random

  val x: Int = Random.nextInt(10)
  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    // case _ : "catch all" case (2개 이상의 case)
    case _ => "many"
  }
  // 스칼라에서는 case가 alternative라고 불림

  def matchTest(x: Int): String = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(x))

  // Matching on case classes
  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      // body는 return값에서 안쓰여서 _
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?
  println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

  // Pattern guards
  // boolean expression
  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(email, _, _) if importantPeopleInfo.contains(email) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val someSms2 = SMS("867-5309", "Are you there?")
  val someVoiceRecording2 = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms, importantPeopleInfo))
  println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
  println(showImportantNotification(importantEmail, importantPeopleInfo))
  println(showImportantNotification(importantSms, importantPeopleInfo))

  // Matching on type only
  abstract class Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }
  def goIdle(device: Device) = device match {
    // 첫글자를 identifier로 쓰는 것이 convention
    case p : Phone => p.screenOff
    case c : Computer => c.screenSaverOn
  }

  // Sealed classes
  // sealed : 서브타입을 같은 파일 내에서만 선언할 수 있음
  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a : Couch => "Lie on the couch"
    case b : Chair => "Sit on the chair"
  }
}
