package Question2;

public class AnnotatedClass {
    @Author(name = "Author1")
    @Version(number = 2.0f)
    public void annotatedMethod1() {
        System.out.println("Annotated Method 1");
    }
    @Author(name = "Author2")
    @Version(number = 4.0)
    public void annotatedMethod2() {
        System.out.println("Annotated method 2");
    }
}