package tostring;



import java.lang.reflect.Field;

// getClass() method returns the metadata of the class.
public class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) throws NoSuchFieldException {
        Person1 person = new Person1("John", 30);
        //when we call getClass() method it returns a Class object
        Class personClass = person.getClass();

        try {
            //Field is a class in java.lang.reflect that represents a field(member variable) of a class
            Field field = personClass.getDeclaredField("name");   //Accessing Name field of the class Person
            field.setAccessible(true);  //allows to access private
            Object value = field.get(person);  //Value is assigned to a variable of type Object
            String name = (String) value; //Typecasting to String, as name is a String
            System.out.println(name);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
