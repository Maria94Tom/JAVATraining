package AssignmentQ5;

class Invoice implements Payable {
    private String invoiceNumber;
    private String customerName;
    private double totalAmount;

    public Invoice(String invoiceNumber, String customerName, double totalAmount) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    // Implementing getPayment() for Invoice
    @Override
    public void getPayment() {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + totalAmount);
    }
}
