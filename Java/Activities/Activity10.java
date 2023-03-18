package activities;

import java.util.HashSet;
import java.util.Iterator;

public class Activity10 {
    public static void main(String args[]) {

        HashSet<String> hs=new HashSet();
        hs.add("One");
        hs.add("Two");
        hs.add("Three");
        hs.add("Four");
        hs.add("Five");
        hs.add("Six");

        System.out.println("Size bofore Removing "+hs.size());

        //remove element
        hs.remove(1);
        //remove element which is not present
        hs.remove(9);

        //contains
        hs.contains(2);

        //set after removing
        Iterator<String> i=hs.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }







    }
}
