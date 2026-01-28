package ec.edu.uce.dominio;
import java.util.Random;

public class Product {
    private String name;
    private String code;
    private double price;

    public Product(String name, double price){
        this.code = genCode();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return code + " | " + name;
    }

    private String genCode() {
        String randomCode = "";
        Random random = new Random();

        while (randomCode.length() < 6) {
            int number = random.nextInt(10); // generar cada vez
            randomCode += number;
        }

        return randomCode;
    }

}
