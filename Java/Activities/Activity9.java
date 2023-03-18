package activities;

import java.util.ArrayList;
import java.util.Collections;

public class Activity9 {

    public static void main(String args[]) {
        ArrayList<String> mylist = new ArrayList<String>();//Creating arraylist
        mylist.add("Tom");//Adding object in arraylist
        mylist.add("Jerry");
        mylist.add("peppa");
        mylist.add("mickey");
        mylist.add("disney");
        Collections.sort(mylist);
        for (var i : mylist
        )
            System.out.println(i);

        ///print 3rd name
        String name = mylist.get(3);
        System.out.println("3rd name -> " + name);
        ////check if name is present
        if (mylist.contains(name)) {
            System.out.println("Present!");
        } else {
            System.out.println("NOTPresent!");
        }
      ///size method
       System.out.println( "Size/_beforeRemoving" + mylist.size());

        ///remove method
        mylist.remove(1);

        System.out.println("Size/_afterRemoving"+ mylist.size());

        //updated list
        for (var i : mylist
        )
            System.out.println(i);


    }


}

