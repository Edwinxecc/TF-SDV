package ec.edu.uce.dominio;
import java.util.Random;

public class Product {
    private String name;
    private String code;
    private int stock;

    public Product(String name, int stock){
        this.name = name;
        this.code = "17PE";
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | " + stock;
    }
}
