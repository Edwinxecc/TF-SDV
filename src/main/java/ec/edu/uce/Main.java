package ec.edu.uce;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.gui.Login;
import ec.edu.uce.gui.LoginListener;
import ec.edu.uce.gui.MainPage;
import ec.edu.uce.util.FileHelper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String miUrl = "https://raw.githubusercontent.com/Edwinxecc/TF-SDV/main/logo_sv.png";
        String nombreLocal = "logo_sv.png";
        Path ruta = Paths.get(nombreLocal);
        if (!Files.isRegularFile(ruta)) {
            FileHelper.descargarLogo(miUrl, nombreLocal);
        }

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
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            // Cargamos la imagen
            Image image = Toolkit.getDefaultToolkit().getImage("logo_sv.png");

            // Cambiamos el icono en el Dock de macOS
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println("El sistema no soporta cambiar el icono del taskbar.");
        } catch (final SecurityException e) {
            System.out.println("No hay permisos para cambiar el icono.");
        }
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
        Image icono = new ImageIcon("logo_sv.png").getImage();
        mainFrame.setIconImage(icono);
        mainFrame.setContentPane(new MainPage().mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setSize(950, 600);
        mainFrame.setVisible(true);
    }

}