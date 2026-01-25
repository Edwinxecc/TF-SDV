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
    private List<User> users;

    public static boolean flag = false;

    private Company(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
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

    public List<User> getUsers() {
        return users;
    }

    public Boolean createProduct(String name, int stock){
        if (name.length() >= 2 && stock > 0){
            new Product(name, stock);
            return true;
        }
        return false;
    }

    public void createProduct(Product product){
        if(product == null) return;
        products.add(product);
    }

    public Boolean createUser(String name, String password, int age) {
        if (name.length() >= 3 && password.length() >= 8 && age >= 5){
            new User(name, age, password);
            return true;
        }
        return false;
    }

    public void createUser(User user){
        if (user == null) return;
        users.add(user);
    }


    public boolean loginValidator (String user, String password){
        if (user.length() < 3) return false;
        if ((FileHelper.dataUsers[0].equals(user) && FileHelper.dataUsers[1].equals(password)) || (FileHelper.dataUsers[2].equals(user) && FileHelper.dataUsers[3].equals(password))) {
            //JOptionPane.showMessageDialog(null, "ingresaste","Información", JOptionPane.INFORMATION_MESSAGE);
            flag = true;
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }

}
