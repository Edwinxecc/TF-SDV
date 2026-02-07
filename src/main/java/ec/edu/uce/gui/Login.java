package ec.edu.uce.gui;

import javax.swing.*;
import ec.edu.uce.dominio.Company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    private int contador = 0;
    private JTextField textName;
    public JPanel loginPanel;
    private JButton goButton;
    private JTextField passwordText;
    private JLabel registrarLabel;

    private LoginListener listener;

    Company com = Company.getInstance();

    public Login(LoginListener listener){
        this.listener = listener;

        registrarLabel.setText("<html><u>Registrar</u></html>");
        registrarLabel.setForeground(Color.BLUE.darker());
        registrarLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String name = textName.getText();
                String password = passwordText.getText();

                Company.flag = com.loginValidator(name, password);

                // limpiador
                textName.setText("");
                passwordText.setText("");

                if (Company.flag) {
                    // Avisamos al Main que el login fue exitoso
                    if (listener != null) listener.onLoginSuccess();
                } else {
                    if (Company.users.isEmpty()){
                        if (contador >= 4) System.exit(0);
                    }else {
                        if (contador >= 3) System.exit(0);
                    }
                    contador += 1;
                }
            }
        });
        registrarLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerPage();
            }
        });
    }

    public void registerPage(){
        JFrame registerPage = new JFrame();
        registerPage.setContentPane(new registerPage().registerPanel);
        registerPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerPage.pack();
        registerPage.setLocationRelativeTo(null);
        registerPage.setResizable(false);
        registerPage.setSize(425, 425);
        registerPage.setVisible(true);
    }

}
