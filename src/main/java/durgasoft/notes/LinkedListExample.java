package durgasoft.notes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.stream.IntStream;

public class LinkedListExample {
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<Integer>();

        //Add Elements
        IntStream.range(1,11).forEach(ll::add);
        System.out.println(ll);

        //Add null
        ll.add(null);
        ll.add(null);
        System.out.println(ll);

        //Remove 3rd index
        ll.remove(3);
        System.out.println(ll);

        //Add First
        ll.addFirst(0);
        //Add Last
        ll.addLast(4);
        System.out.println(ll);

        //Remove First
        ll.removeFirst();
        //Remove Last
        ll.removeLast();
        System.out.println(ll);

        //Remove Null
        ll.remove(null);
        System.out.println(ll);

        //Get First Element
        System.out.println(ll.getFirst());
        //Get Last Element
        System.out.println(ll.getLast());

        //Print each element using iterator
        Iterator<Integer> itr = ll.iterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            System.out.println(i);
        }

        //Print each element using enhanced for loop
        for(Integer a: ll){
            System.out.println(a);
        }

        //Using Lambda function
        ll.forEach(System.out::println);

        //Linked List doesn't follow RandomAccess so (ll instanceof RandomAccess) -> False
        System.out.println(ll instanceof Serializable); //true
        System.out.println(ll instanceof Cloneable); //true
        System.out.println(ll instanceof RandomAccess); //false
    }
}
