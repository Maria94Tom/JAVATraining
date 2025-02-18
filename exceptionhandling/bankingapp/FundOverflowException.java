package bankingapp;

public class FundOverflowException extends RuntimeException{
    public FundOverflowException(String message) {
        super(message);
    }
}
