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
    //write method searchBook(book id)
    public void searchBook(int id) {
        ClassValue<T> llb;
        if(id.equals(llb.get(0))){ {
            System.out.println("Book found");
        }
        else{
            System.out.println("Book not found");
        }

    }
    //write method sellBook(String isbn, int noOfCopies)
    public void sellBook(String ISBN, int noOfCopies) throws NotSufficientBookException{
        if(noOfCopies<0) {
            throw new NotSufficientBookException("Not sufficient book");
        }
        else {
            System.out.println("Book sold");
        }
    }
}

