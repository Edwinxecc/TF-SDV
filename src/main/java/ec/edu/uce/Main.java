package ec.edu.uce;

import ec.edu.uce.dominio.Company;

public class Main {
    public static void main(String[] args) {

        Company company1 = Company.getInstance();
        System.out.println(company1.getCompanyName());
        
    }
}