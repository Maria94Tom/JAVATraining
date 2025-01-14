package Question5;
/*
A student portal provides user to register their profile.
During registration the system needs to validate the user should be located in India.
If not the system should throw an exception.
Step 1: Create a user defined exception class named “InvalidCountryException”.
Step 2: Overload the respective constructors.
Step 3: Create a main class “UserRegistration”, add the following method,
registerUser– The parameter are String username,String userCountry and add the following logic,
• if userCountry is not equal to “India” throw a InvalidCountryException
with the message “User Outside India cannot be registered”
• if userCountry is equal to “India”, print the message “User registration done successfully”
 Invoke the method registerUser from the main method with the data specified and see how the program
behave
 */

public class UserRegistration {
    public void userRegister(String userName,String userCountry) throws InvalidCountryException{
        userCountry = userCountry.toLowerCase();
        if(userCountry.equals("india")) {
            System.out.println("User registration done successfully");
        }else {
            throw new InvalidCountryException("User Outside India cannot be registered");
        }

    }
    }


