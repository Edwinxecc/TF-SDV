package ec.edu.uce;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.dominio.Product;
import ec.edu.uce.dominio.User;
import ec.edu.uce.gui.Login;
import ec.edu.uce.gui.LoginListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Company com = Company.getInstance();

        JFrame frame = new JFrame("Login");

        Login loginUI = new Login(new LoginListener() {
            @Override
            public void onLoginSuccess() {
                frame.dispose();

                JOptionPane.showMessageDialog(null, "Login Correcto. Abriendo sistema...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // configuraciones del login
        frame.setContentPane(loginUI.loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);

        // pagina pricipal

        System.out.println("In Main" + Company.flag);
        if (Company.flag) {
            JOptionPane.showMessageDialog(null, "new Window", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}