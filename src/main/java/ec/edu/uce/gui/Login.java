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

    private LoginListener listener;


    Company com = Company.getInstance();

    public Login(LoginListener listener){
        this.listener = listener;

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String password = passwordText.getText();

                Company.flag = com.loginValidator(name, password);

                if (Company.flag) {
                    // Avisamos al Main que el login fue exitoso
                    if (listener != null) listener.onLoginSuccess();
                } else {
                    contador += 1;
                    if (contador >= 3) System.exit(0);
                }
            }
        });
    }

}
