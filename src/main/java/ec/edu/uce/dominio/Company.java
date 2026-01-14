package ec.edu.uce.dominio;

import java.util.List;

public class Company {
    private static Company instance;
    private String name;
    private List<Product> products;

    private Company(String name) {
        this.name = name;
    }

    public static Company getInstance(){
        if(instance == null){
            instance = new Company("WIMP APP");
        }
        return instance;
    }

    public String getCompanyName(){
        return this.name;
    }

    public Boolean createProduct(String name, int stock){
        if (name.length() >= 2 && stock > 0){
            new Product(name, stock);
            return true;
        }else {
            return false;
        }
    }



}
