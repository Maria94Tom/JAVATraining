package labassignment;

public class Inventory implements Comparable<Inventory> {
    @Override
    public int compareTo(Inventory o) {
        return Double.compare(o.getPrice(), this.getPrice());
    }


    private String itemID;
    private int Qty;
    private double price;

    public Inventory(String itemID, int Qty, double price) {
        this.itemID = itemID;
        this.Qty = Qty;
        this.price = price;
    }
    public double getUnitPrice() {
        return 0;
    }
    public String getItemID() {
        return itemID;
    }

    public int getQty() {
        return Qty;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "inventory{" +
                "itemID='" + itemID + '\'' +
                ", Qty=" + Qty +
                ", price=" + price +
                '}';
    }


}
