package ec.edu.uce.gui;

import javax.swing.*;

public class cardPage {
    public JPanel cardPanel;
    private JTextField cardTextField;
    private JTextField endDateTextFIeld;
    private JTextField secureCodeTextField;
    private JTextField totalTextField;
    private JButton completarCompraButton;
    private JTextField AAAATextField;

    private double total;

    public cardPage(double total){
        this.total = total;

        totalTextField.setText(total + " USD");
    }

}
