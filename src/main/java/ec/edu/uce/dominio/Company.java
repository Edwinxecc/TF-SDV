package ec.edu.uce.dominio;

import ec.edu.uce.gui.Login;
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
    public static List<User> users;

    public static String userAcces;

    public static boolean flag = false;

    private Company(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        users = FileHelper.reedUsers();
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
        if (Company.users.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ningun usurio registrado", "Registro necesario", JOptionPane.INFORMATION_MESSAGE);
        }else {
            for (User usr: Company.users){
                if (user.equals(usr.getName()) && password.equals(usr.getPassword())){
                    userAcces = usr.getName();
                    return true;
                }else {
                    User lastUser = Company.users.getLast();
                    if (lastUser.getName().equals(usr.getName())){
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        return false;
    }

}
