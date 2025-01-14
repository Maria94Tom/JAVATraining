package Question5;

public class StudentPortal {
    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration();
        try {
            userRegistration.userRegister("Raj", "INDIA");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}