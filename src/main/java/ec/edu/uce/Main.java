package ec.edu.uce;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.dominio.Product;
import ec.edu.uce.dominio.User;
import ec.edu.uce.gui.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Company com = Company.getInstance();

        // para el login no cambiar por favor jaja
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);

        // pagina pricipal


        if () {
            JOptionPane.showMessageDialog(null, "Ingresaste al Sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}