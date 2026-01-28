package ec.edu.uce.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cardPage {
    public JPanel cardPanel;
    private JTextField cardTextField;
    private JTextField monthTextField;
    private JTextField secureCodeTextField;
    private JTextField totalTextField;
    private JButton completarCompraButton;
    private JTextField yearTextField;
    int currentYear = java.time.LocalDate.now().getYear();
    int currentMonth = java.time.LocalDate.now().getMonthValue();
    private double total;

    public static boolean buyWithCard;

    public cardPage(double total){
        this.total = total;

        totalTextField.setText(String.format("%.2f$", total) + " USD");
        completarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    byte month = Byte.parseByte(monthTextField.getText().trim());
                    int yearProvide = Integer.parseInt(yearTextField.getText().trim());

                    int lengthOfCode = secureCodeTextField.getText().trim().length();

                    if ((month >= 1 && month <= 12) && (yearProvide >= currentYear) && lengthOfCode == 3){
                        buyWithCard = validarTarjeta(cardTextField.getText().trim());
                        JOptionPane.showMessageDialog(null, "Compra Exitosa!", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        SwingUtilities.getWindowAncestor(cardPanel).dispose(); // con esto cierro mi ventanita
                    }else if(yearProvide < currentYear || (yearProvide == currentYear && month < currentMonth)){
                        JOptionPane.showMessageDialog(null, "¡Tarjeta Invalida!", "Tarjeta Invalida", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(
                            null,
                            "¡Ingrese solo números!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

    }

    // Algoritmo de Luhn | creo
    public static boolean validarTarjeta(String numero) {
        int suma = 0;
        boolean alternar = false;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numero.substring(i, i + 1));
            if (alternar) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            suma += n;
            alternar = !alternar;
        }
        return (suma % 10 == 0);
    }

}
