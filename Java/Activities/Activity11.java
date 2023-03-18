package activities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Activity11 {
    public static void main(String args[]) {
        Map map = new HashMap();
        //Adding elements to map
        map.put(1, "orange");
        map.put(5, "Red");
        map.put(2, "purple");
        map.put(4, "Grey");
        map.put(3, "green");

        //Remove 1 color
        map.remove(2);
        //check if green colour is present
        if (map.containsValue("green"))
            System.out.println("Green present");

        else{
            System.out.println("Green not present");
        }

//size
        System.out.println("Size "+ map.size());


}
}
