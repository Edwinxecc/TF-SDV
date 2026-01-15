package ec.edu.uce;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.dominio.Product;
import ec.edu.uce.dominio.User;

public class Main {
    public static void main(String[] args) {

        Company company1 = Company.getInstance();
        System.out.println(company1.getCompanyName());
        //System.out.println(company1.createUser("Edwin", "edcc4313", 29));


        company1.createProduct(new Product("Papas fritas", 16));
        company1.createUser(new User("Edwin", 29, "edcc4313"));

        System.out.println(company1.getUsers());
        System.out.println(company1.getProducts());

    }
}