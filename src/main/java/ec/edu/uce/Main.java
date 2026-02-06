package ec.edu.uce;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.gui.Login;
import ec.edu.uce.gui.LoginListener;
import ec.edu.uce.gui.MainPage;
import ec.edu.uce.util.FileHelper;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FileHelper.createFile();
        Company com = Company.getInstance();

        // creacion del archivo
        //FileHelper.createFile();

        JFrame frame = new JFrame("Login");
        Login loginUI = new Login(new LoginListener() {
            @Override
            public void onLoginSuccess() {
                frame.dispose();
                //JOptionPane.showMessageDialog(null, "Login Correcto. Abriendo sistema...", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                mainPanel();
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
    }

    public static void mainPanel(){
        JFrame mainFrame = new JFrame("Sistema de Ventas");
        mainFrame.setContentPane(new MainPage().mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setSize(950, 600);
        mainFrame.setVisible(true);
    }

}