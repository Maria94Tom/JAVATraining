package labAssign1;


import labassignment.Inventory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
Code a MerchandiseInventoryTest program which will accept 11 merchandises from a redirected input text file.
Copy and paste the following data to a text editor and save it as input.dat file. ItemId Qty price

KLM6666 22 49.50
GHI3330 30 20.00
WXX9000 11 15.00
JKL4440 40 35.00
YZZ9990 30 25.00
PQR6660 7 76.00
DEF2220 8 63.44
STU7770 15 55.00
ABC1110 10 50.50
TVV8880 18 43.50
MNO5550 50 12.00
Store each merchandise (one per input line) in an ArrayList object. (Merchandise class consist of itemCode, quantity, unitPrice)
Sort the merchandise elements in the ArrayList in an ascending order by names. Display the sorted merchandise elements (one per line).
Sort the merchandises in a descending order by price.
Display the sorted merchandise elements again in the new order (one per line).

 */
public class InventoryTestPgm {
    // create an arraylist
    static java.util.ArrayList<Inventory> llb = new java.util.ArrayList<Inventory>();
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] invDetails = line.split(" ");
                // llb.add(new Book(Integer.parseInt(bookDetails[0]), bookDetails[1], bookDetails[2], Integer.parseInt(bookDetails[3])));
                llb.add(new Inventory(invDetails[0], Integer.parseInt(invDetails[1]), Double.parseDouble(invDetails[2])));
            }
            System.out.println("Merchandise elements");
            Iterator<Inventory> iterator = llb.iterator();
            while (iterator.hasNext()) {
                // Print the next merchandise item
                System.out.println(iterator.next());
            }

            Collections.sort(llb, new Comparator<Inventory>() {
                @Override
                public int compare(Inventory o1, Inventory o2) {
                    return o1.getItemID().compareTo(o2.getItemID());

                }
            });




// print the sorted arraylist
            System.out.println("Sorted Array based on ID");
            for (Inventory i:llb)
            {
                System.out.println(i);
            }

            Collections.sort(llb, new Comparator<Inventory>() {
                @Override
                public int compare(Inventory m1, Inventory m2) {
                    return Double.compare(m2.getUnitPrice(), m1.getUnitPrice()); // Descending order by price
                }
            });


            System.out.println("Sorted Array based on price");
            for (Inventory i:llb)
            {
                System.out.println(i);
            }
       }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
