// TODO

import akka.actor._
//
// Make this an actor and write a message handler for at least the
// set method.
//


  
case class set(x: Int, y: Int, c: Colour)
case class init(im: Image, of: String)
case class print()


object Coordinator extends Actor {
  
  import Coordinator ._

  // Number of pixels we're waiting for to be set.
  var waiting = 0
  var outfile: String = null
  var image: Image = null

  // TODO
  def receive = {
    case set(x: Int, y: Int, c: Colour) => image(x,y) = c
                         waiting -= 1
    case init(im, of) => image = im
                         outfile = of
                         waiting = im.width * im.height
  }
  
  def init(im: Image, of: String) = {
    image = im
    outfile = of
    waiting = im.width * im.height
  }
  
  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
}


/*
 * 
 *   
  }
 * 
 *   // TODO: make set a message
  def set(x: Int, y: Int, c: Colour) = {
    image(x, y) = c
    waiting -= 1
  }

  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
 * 
 * 
 */
