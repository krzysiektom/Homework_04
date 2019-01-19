package pl.coderslab;

public class GuestBook {
    private int id;
    private String name;
    private String text;


    public GuestBook(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public GuestBook(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
