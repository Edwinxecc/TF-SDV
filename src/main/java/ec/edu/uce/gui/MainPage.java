package ec.edu.uce.gui;

import ec.edu.uce.Main;
import ec.edu.uce.dominio.Product;
import ec.edu.uce.util.FileHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPage {

    public JPanel mainPanel;
    private JTable productsTable;
    private JButton buttonRandomCode;
    private JTextField textCodigoBarra;
    private JButton PAGOTARJETAButton;
    private JTextField efectivoTextField;
    private JButton calVueltaButton;
    private JTextField vueltaTextField;
    private JButton eliminarButton;
    private JTextField totalTextField;
    private JButton ticketCompraButton;
    private JButton lectorButton;

    private double totalAux = 0.0;

    public MainPage() {

        List<Product> buyProducts = new ArrayList<>();
        List<Product> allProducts = FileHelper.leerProductos();

        Random random = new Random();

        // esto necesito que se defina una sola vez
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Codigo", "Nombre", "P. Unit"});
        productsTable.setModel(model);
        // System.out.println("Hola xd");

        buttonRandomCode.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseEntered(MouseEvent evt){
                int numRandom = random.nextInt(allProducts.size());
                Product randomProduct = allProducts.get(numRandom);
                buyProducts.add(randomProduct);
                textCodigoBarra.setText(randomProduct.getCode());
            }

            @Override
            public void mouseExited(MouseEvent evt) {

                model.setRowCount(0); // limpiamos antes de agregar para evitar el bug del index

                for (Product producto: buyProducts){
                    model.addRow(new Object[]{
                            producto.getCode(),
                            producto.getName(),
                            producto.getPrice()
                    });
                }
                actualizarTotal(buyProducts);
            }

        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) productsTable.getModel();
                if (productsTable.getSelectedRowCount() == 1){
                    // aca va el metodo de Products para eliminar el Producto
                    buyProducts.remove(productsTable.getSelectedRow()); // se elimina por indice de la lista de compras
                    tableModel.removeRow(productsTable.getSelectedRow());// esto solo es para la visibilidad de la tabla
                    actualizarTotal(buyProducts);
//                    for (Product prd: buyProducts){
//                        System.out.println(prd.getCode() + " | " + prd.getName() + " | " + prd.getPrice());
//                    }
//                    System.out.println("_________________________________________________");
                }
            }
        });

        // para borrar el texto al momento de ingresar el efectivo
        efectivoTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                efectivoTextField.setText("");
            }
        });
        calVueltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPage.buyWithCard = false;
                String texto = efectivoTextField.getText();
                double efectivo = Double.parseDouble(texto);

                double buyCoste = 0.0;
                for (Product prd: buyProducts){
                    buyCoste += prd.getPrice();
                }

                double retValue = efectivo - buyCoste;
                if (retValue <= 0) {
                    JOptionPane.showMessageDialog(null, "Efectivo Insuficiente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    vueltaTextField.setText(String.format("%.2f$", retValue));
                }
            }
        });
        ticketCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cardPage.buyWithCard){
                    efectivoTextField.setText("Tarjeta");
                    ticketPanel(buyProducts, 0.0);
                    //vueltaTextField.setText("Tarjeta");
                }else {
                    String texto = efectivoTextField.getText().trim();
                    double efectivo = Double.parseDouble(texto);
                    ticketPanel(buyProducts, efectivo);
                }

            }
        });
        PAGOTARJETAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPageInicializer(totalAux);
            }
        });
    }

    public void actualizarTotal(List<Product> buyProducts){
        double total = 0.0;
        for (Product prd: buyProducts){
            total += prd.getPrice();
        }
        totalTextField.setText("TOT: " + String.format("%.2f$", total));
        totalAux = total;
    }

    public static void ticketPanel(List<Product> products, double efectivo){
        JFrame ticketFrame = new JFrame("Ticket de Compra");
        ticketFrame.setContentPane(new ticketPage(products, efectivo).ticketPanel);
        ticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ticketFrame.pack();
        ticketFrame.setLocationRelativeTo(null);
        ticketFrame.setResizable(false);
        ticketFrame.setSize(425, 605);
        ticketFrame.setVisible(true);
    }

    public static void cardPageInicializer(double total){
        JFrame cardPage = new JFrame();
        cardPage.setContentPane(new cardPage(total).cardPanel);
        cardPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cardPage.pack();
        cardPage.setLocationRelativeTo(null);
        cardPage.setResizable(false);
        cardPage.setSize(450, 400);
        cardPage.setVisible(true);
    }

}
