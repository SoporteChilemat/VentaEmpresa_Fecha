/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.Comparator;

public class IntComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        String replace = o1.toString().replace("$", "").replace(".", "").trim();
        int priority1 = Integer.valueOf(replace);

        String replace2 = o2.toString().replace("$", "").replace(".", "").trim();
        int priority2 = Integer.valueOf(replace2);
        
        if (priority1 > priority2) {
            return -1;
        } else if (priority1 < priority2) {
            return +1;
        } else {
            return 0;
        }
    }
}
