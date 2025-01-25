package tostring;


// getClass() method returns the metadata of the class.

public class Person
{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) {
        Person person = new Person("John", 30);
        //when we call getClass() method it returns a Class object
        Class personClass = person.getClass();

        //Few useful methods of Class Object

        System.out.println(personClass.getName());    // This will printpackage.ClassName


        System.out.println(personClass.getSimpleName());      //This will print only class name


        System.out.println(personClass.getSuperclass().getName());    //SuperClass name

    }
}
