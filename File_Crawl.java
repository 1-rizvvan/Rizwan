package lab6;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
//Name:Rizwan Ahmad
//Class:BSCS-2B
//Registration:00073
public class File_Crawl {
 
  private WorkQueue Working_que;
  static int i = 0;
 
 private class Worker implements Runnable {
 
  private WorkQueue que;
 
  public Worker(WorkQueue q) {
   que = q;
  }
 

 
  public void run() {
   String Namee;
   while ((Namee = que.remove()) != null) {
    File File_pointer = new File(Namee);
    String entries[] = File_pointer.list();
    if (entries == null)
     continue;
    for (String entry : entries) {
     if (entry.compareTo(".") == 0)
      continue;
     if (entry.compareTo("..") == 0)
      continue;
     String fn = Namee + "\\" + entry;
     System.out.println(fn);
    }
   }
  }
 }
 
 public File_Crawl() {
  Working_que = new WorkQueue();
 }
 
 public Worker createWorker() {
  return new Worker(Working_que);
 }
 
 
// need try ... catch below in case the directory is not legal
 
 public void processDirectory(String dir) {
   try{
   File File_pointer = new File(dir);
   if (File_pointer.isDirectory()) {
    String entries[] = File_pointer.list();
    if (entries != null)
     Working_que.add(dir);
 
    for (String entry : entries) {
     String subdir;
     if (entry.compareTo(".") == 0)
      continue;
     if (entry.compareTo("..") == 0)
      continue;
     if (dir.endsWith("\\"))
      subdir = dir+entry;
     else
      subdir = dir+"\\"+entry;
     processDirectory(subdir);
    }
   }}catch(Exception e){}
 }
 
 public static void main(String Args[]) {
 
  File_Crawl fc = new File_Crawl();
 
//  Here are all the threads
 
  int N = 5;
  ArrayList<Thread> thread = new ArrayList<Thread>(N);
  for (int ai = 0; ai < N; ai++) {
   Thread tt = new Thread(fc.createWorker());
   thread.add(tt);
   tt.start();
  }
 

 
  fc.processDirectory(Args[0]);
 
//  indicating ther are 0 directoriez to ad
 
  fc.Working_que.finish();
 
  for (int ii = 0; ii < N; ii++){
   try {
    thread.get(ii).join();
   } catch (Exception e) {};
  }
 }
}