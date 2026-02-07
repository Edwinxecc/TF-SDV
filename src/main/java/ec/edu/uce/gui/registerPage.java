package ec.edu.uce.gui;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.dominio.User;
import ec.edu.uce.util.FileHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class registerPage {
    public JPanel registerPanel;
    private JTextField userTextField;
    private JTextField passwordTextFiel;
    private JButton registrarButton;


    public registerPage() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!userTextField.getText().isEmpty() || !passwordTextFiel.getText().isEmpty()){
                    Company.users.add(new User(userTextField.getText().trim(), passwordTextFiel.getText().trim()));
                    JOptionPane.showMessageDialog(null, "Usuario registrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        FileHelper.writeDataUsers(Company.users);
                    } catch (IOException ex) {
                        System.err.println("No se pudo escribir los usuarios: " + ex.getMessage());
                    }
                    SwingUtilities.getWindowAncestor(registerPanel).dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Ingresa datos en los campos", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
