package pl.coderslab.beans;

public class HelloWorld {
    private String message;

    public HelloWorld() {
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
