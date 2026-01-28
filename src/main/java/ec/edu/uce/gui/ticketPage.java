package ec.edu.uce.gui;

import ec.edu.uce.dominio.Product;

import javax.swing.*;
import java.util.List;

public class ticketPage {
    public JPanel ticketPanel;
    private JTextArea textDescripsion;
    private JTextArea textPrecio;
    private JTextField totalTextField;
    private JTextField efectivoTextField;
    private JTextField cambioTextField;
    private JTextField numTargetaTextField;

    List<Product> buyProduct;
    double efectivo;

    public ticketPage(List<Product> buyProduct,  double efectivo){
        this.buyProduct = buyProduct;
        this.efectivo = efectivo;

        double total = 0.0;

        llenarDescripsionAndPrice(buyProduct);

        for (Product prd: buyProduct){
            total += prd.getPrice();
        }
        totalTextField.setText(String.format("%.2f$", total));


        if (cardPage.buyWithCard){
            efectivoTextField.setText("Tarjeta");
            cambioTextField.setText("Tarjeta");
            String cardPrivate = cardPage.cardNumberShare.substring(cardPage.cardNumberShare.length() - 5);
            numTargetaTextField.setText("*********"+ cardPrivate);
        }else {
            efectivoTextField.setText(efectivo + "$");
            double retValue = efectivo - total;
            if (retValue >= 0) cambioTextField.setText(String.format("%.2f$", retValue));
            numTargetaTextField.setText("*****************");
        }
    }

    public void llenarDescripsionAndPrice (List<Product> buyProduct){
        String descriptions = "";
        String price = "";
        for (Product prd: buyProduct){
            descriptions += prd.getName() + "\r\n";
            price += prd.getPrice() + "\r\n";
        }
        textDescripsion.setText(descriptions);
        textPrecio.setText(price);
    }
}
