/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the
collection. Stream API will allow sequential as well as parallel execution. This is one of the best 
feature for me because I work a lot with Collections and usually with Big Data, we need to filter out
them based on some conditions.

Collection interface has been extended with stream() and parallelStream() default methods to get the 
Stream for sequential and parallel execution. Let’s see their usage with simple example.
*/
package java1.pkg8_feature_java_stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Vaibhav.Chugh
 */
public class Java18_feature_Java_Stream {
   static List<Integer> lv;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herevai
      firstaddingsomevalues();
      int i =  sumIterator(lv);
        int j = sumStream(lv);
        System.out.println("java1.pkg8_feature_java_stream.Java18_feature_Java_Stream.main() for iterator value " + i);
        System.out.println("java1.pkg8_feature_java_stream.Java18_feature_Java_Stream.main() for stream value " + j);
// you will get same output form both..
    }
    
    //this method is just for adding some data to make a list.
    private static void firstaddingsomevalues(){
      lv = new ArrayList<Integer>();

     for(int i = 0; i<20; i++){
     lv.add(i);}
    }

    
    
/*    Before we look into Java Stream API Examples, let’s see why it was required. Suppose we want to
    iterate over a list of integers and find out sum of all the integers greater than 10.*/
    private static int sumIterator(List<Integer> list) {
	Iterator<Integer> it = list.iterator();
	int sum = 0;
	while (it.hasNext()) {
		int num = it.next();
		if (num > 10) {
			sum += num;
		}
	}
	return sum;
}
   /* 
    There are three major problems with the above approach:
We just want to know the sum of integers but we would also have to provide how the iteration will take
place, this is also called external iteration because client program is handling the algorithm to iterate 
over the list.
The program is sequential in nature, there is no way we can do this in parallel easily.
There is a lot of code to do even a simple task.
To overcome all the above shortcomings, Java 8 Stream API was introduced. We can use Java Stream API to
implement internal iteration, that is better because java framework is in control of the iteration.

Internal iteration provides several features such as sequential and parallel execution, filtering based
on the given criteria, mapping etc.

Most of the Java 8 Stream API method arguments are functional interfaces, so lambda expressions work very
well with them.
Let’s see how can we write above logic in a single line statement using Java Streams.
    */
    private static int sumStream(List<Integer> list) {
	return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
}
    /*Notice that above program utilizes java framework iteration strategy,
filtering and mapping methods and would increase efficiency.
A map contains values on the basis of key i.e. key and value pair.
    Each key and value pair is known as an entry. Map contains only unique keys.
*/}
