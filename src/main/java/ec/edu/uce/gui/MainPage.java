package ec.edu.uce.gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage {

    public JPanel mainPanel;
    private JTable table1;
    private JButton buttonRandomCode;
    private JTextField textCodigoBarra;
    private JButton PAGOTARJETAButton;
    private JTextField EFECTIVOTextField;
    private JButton button2;
    private JTextField VUELTATextField;
    private JButton eliminarButton;
    private JTextField TOT00$TextField;
    private JButton TICKETDECOMPRAButton;

    public MainPage() {

        buttonRandomCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt){
                textCodigoBarra.setText("12983u19823");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                System.out.println("Ya salio el code");
            }

        });
    }
}
