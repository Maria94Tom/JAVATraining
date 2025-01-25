package tostring;

import java.lang.reflect.Field;

// getClass() method returns the metadata of the class.
public class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) throws NoSuchFieldException {
        Person2 person = new Person2("John", 30);
    //when we call getClass() method it returns a Class object
        Class personClass = person.getClass();
    //Array of Feild object the represents the fields of a class including private
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
        }


    }
}
