package durgasoft.notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class ArrayListExample {
    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<Integer>();

        //Method to add elements in an ArrayList
        IntStream.range(1,10).forEach(al::add);
        System.out.println(al);

        //Adding null
        al.add(null);
        al.add(null);
        System.out.println("After adding null:");
        System.out.println(al);

        //Remove element in 3rd Index
        al.remove(3);
        System.out.println("Remove element in 3rd Index:");
        System.out.println(al);


        //Print each element using Iterator
        System.out.println("Iterator:");
        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext()){
            Integer i = (Integer) itr.next();
            System.out.println(i);
        }

        //Print each element using ListIterator
        System.out.println("ListIterator:");
        ListIterator<Integer> litr = al.listIterator();
        while(litr.hasNext()){
            Integer i = (Integer) litr.next();
            System.out.println(i);
        }

        //Print each element using Enhanced for loop
        System.out.println("Enhanced For Loop:");
        for (Integer a : al) {
            System.out.println(a);
        }


    }
}
