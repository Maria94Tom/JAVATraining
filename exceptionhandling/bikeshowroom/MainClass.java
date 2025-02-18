package bikeshowroom;

public class MainClass {

    public static void main(String[] args) throws InventoryNotExistForBikesException {
        BikeShowroom bikeShowroom = new BikeShowroom(150);
        bikeShowroom.order(20);
        bikeShowroom.purchase(30);
    }
}
