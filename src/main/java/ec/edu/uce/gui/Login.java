package ec.edu.uce.gui;

import javax.swing.*;
import ec.edu.uce.dominio.Company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private int contador = 0;
    private JTextField textName;
    public JPanel loginPanel;
    private JButton goButton;
    private JTextField passwordText;


    Company com = Company.getInstance();

    public Login(){
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String password = passwordText.getText();
                //System.out.println(name + ": " + password); // solo para verificar la funcionalidad del boton
                contador += 1;
                 com.loginValidator(name, password);
                //System.out.println(contador);
                if (contador >= 3) System.exit(0);
            }
        });
    }

}
