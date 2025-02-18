package bikeshowroom;

public class BikeShowroom {
    private int quantity;

    public BikeShowroom(int quantity) {
        this.quantity = quantity;
    }
    public void order(int quantity) throws InventoryNotExistForBikesException {
        if(quantity > this.quantity)
            throw new InventoryNotExistForBikesException("Inventory does not exist for " + quantity + " bikes.");
        this.quantity -= quantity;
        System.out.println("Order placed for " + quantity + " bikes. Remaining quantity: " + this.quantity);
    }
    public void purchase(int quantity) {
        this.quantity += quantity;
        System.out.println("Purchase of " + quantity + " bikes. Total Invenory: " + this.quantity);
    }

}
