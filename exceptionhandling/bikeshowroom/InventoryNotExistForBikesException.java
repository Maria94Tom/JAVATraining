package bikeshowroom;

public class InventoryNotExistForBikesException extends Exception{
    public InventoryNotExistForBikesException(String message) {
        super(message);
    }
}
