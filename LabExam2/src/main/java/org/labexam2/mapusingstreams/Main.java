package org.labexam2.mapusingstreams;
/*

Q1. consider Map and data as given below:

Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("raj", 95);
		map.put("ekta", 75);
		map.put("rajiv", 85);
		map.put("sunita", 66);
		map.put("gunika", 99);
		System.out.println("------printing map------");


1. print map using stream
2. print only that recrods that contain key contains raj
3. print map sorted by key
4. print map sorted by values
5. print map reverse sorted by the key
5. consider key as user define key:


 */
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<MapsWithStream, Integer> map = new HashMap<>();
        map.put(new MapsWithStream("raj"), 95);
        map.put(new MapsWithStream("ekta"), 75);
        map.put(new MapsWithStream("rajiv"), 85);
        map.put(new MapsWithStream("sunita"), 66);
        map.put(new MapsWithStream("gunika"), 99);

        System.out.println("------printing map with user-defined keys------");
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("------printing map using Streams------");
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("------printing records where key contains 'raj'------)");
        map.entrySet().stream()
                .filter(entry -> entry.getKey().name.contains("raj"))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("------printing map sorted by key------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("------printing map sorted by value------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("------printing map reverse sorted by key------");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));



    }
}


