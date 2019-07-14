package br.com.casadocodigo.nf.model;

public class NF {

    private String client;
    private String book;
    private double amount;

    public NF(String client, String book, double amount) {
        this.setClient(client);
        this.setBook(book);
        this.amount = amount;
    }

    public boolean hasValidAmount() {
        return amount > 0;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}