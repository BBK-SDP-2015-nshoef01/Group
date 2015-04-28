import akka.actor.{Actor, ActorSystem, Props, ActorRef, ActorContext}


object Tracer extends Actor {
  
  def receive = {
    case set(x, y, c) => sender ! set(x, y, c)
  }
  def act = ???
}