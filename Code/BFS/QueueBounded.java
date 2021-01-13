import java.lang.RuntimeException ;
import java.util.Scanner ;
public class QueueBounded<E> {
  private E[] element ;
  private int input ;
  private int count ;
  @SuppressWarnings("unchecked")
  public QueueBounded (int n) {
    element = (E[]) new Object[n] ;
    input = 0 ;
    count = 0 ;
  }
  public void add(E e) {
    if (count == this.element.length)
      throw new RuntimeException ("Overflow") ;
    this.element[this.input] = e ;
    this.input = (this.input + 1) % this.element.length ;
    this.count ++ ;
  }
    // @SuppressWarnings("unchecked")
  public E head () {
    if (count == 0)
      throw new RuntimeException ("Underflow") ;
    return this.element[(input-count) % this.element.length] ;
  }
    // @SuppressWarnings("unchecked")
  public E extract () {
    if (count == 0)
      throw new RuntimeException ("Underflow") ;
    int index = (input + (this.element.length - count)) % this.element.length ;
    // Je [PN] suis preneur d'une autre solution pour avoir un reste >= 0
    E value = this.element[index] ;
    this.doDrop() ;
    return value ;
  }
  public void drop () {
    if (count == 0)
      throw new RuntimeException ("Underflow") ;
    this.doDrop() ;
  }
  private void doDrop() {
    this.count -- ;
  }
  public boolean isEmpty() {
    return this.count == 0 ;
  }
  public boolean isFull() {
    return this.count == this.element.length ;
  }
  public int length () {
    return this.count ;
  }
  public int size () {
    return this.element.length ;
  }
  public static void main (String[] arg) {
    int size = Integer.parseInt(arg[0]) ;
    QueueBounded<Integer> queue = new QueueBounded<Integer>(size) ;
    Scanner scanner = new Scanner (System.in) ;
    int action = scanner.nextInt() ;
    boolean error ;
    int x ;
    while (action >= 0) {
      error = false ;
      if (action == 0) {
        x = scanner.nextInt() ;
        try {
          queue.add(x) ;
          System.out.print ("    ** Added " + x + " to queue. ") ;
        }
        catch (RuntimeException re) {
          System.out.println ("    ** Queue is already full, cannot add value") ;
          error = true ;
        }
      }
      else if (action == 1) {
        try {
          x = queue.extract() ;
          System.out.print ("    ** Extracted " + x + " from queue. ") ;
        }
        catch (RuntimeException re) {
          System.out.println ("    ** Queue is empty, cannot fetch head") ;
          error = true ;
        }
      }
      if (! error) 
        System.out.println ("Length of queue now is " + queue.length()) ;
      action = scanner.nextInt() ;
    }
  }
}
