package bankingapp;

public class NotSufficientFundException extends Exception {
    public NotSufficientFundException(String message) {
        super(message);
    }
}
