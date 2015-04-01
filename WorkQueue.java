//Name:Rizwan Ahmad
//Class:BSCS-2B
//Registration:00073
package lab6;
import java.util.LinkedList;
import java.io.*;

public class WorkQueue {

//
  private LinkedList<String> working_que;
 private boolean done;  // all directoriess added till here
 private int length;  // how many directories in queue
 
 public WorkQueue() {
  working_que = new LinkedList<String>();
  done = false;
  length = 0;
 }
 
 public synchronized void add(String s) {
  working_que.add(s);
  length++;
  notifyAll();
 }
 
 public synchronized String remove() {
  String s;
  while (!done && length == 0) {
   try {
    wait();
   } catch (Exception e) {};
  }
  if (length > 0) {
   s = working_que.remove();
   length--;
   notifyAll();
  } else
   s = null;
  return s;
 }
 
 public synchronized void finish() {
  done = true;
  notifyAll();
 }
}