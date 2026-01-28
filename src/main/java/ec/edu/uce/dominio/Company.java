package ec.edu.uce.dominio;

import ec.edu.uce.util.FileHelper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private static Company instance;
    private String name;
    private List<Product> products;

    public static boolean flag = false;

    private Company(String name) {
        this.name = name;
        this.products = new ArrayList<>();
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

    public List<Product> getProducts() {
        return products;
    }

    public void createProduct(Product product){
        if(product == null) return;
        products.add(product);
    }

    public boolean loginValidator (String user, String password){
        if (user.length() < 3) return false;
        if ((FileHelper.dataUsers[0].equals(user) && FileHelper.dataUsers[1].equals(password)) || (FileHelper.dataUsers[2].equals(user) && FileHelper.dataUsers[3].equals(password))) {
            //JOptionPane.showMessageDialog(null, "ingresaste","Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }

}
