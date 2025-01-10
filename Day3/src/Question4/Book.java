package Question4;

public class Book {
    private int id;
    private String ISBN;
    private String Title;
    private int price;

    public Book(int id, String ISBN, String title, int price) {
        this.id = id;
        this.ISBN = ISBN;
        Title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", Title='" + Title + '\'' +
                ", price=" + price +
                '}';
    }
}
