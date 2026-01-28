package ec.edu.uce.util;

import ec.edu.uce.dominio.Product;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FileHelper {
    public static String[] dataUsers = {"edwin", "edwin4313", "user", "user123"};
    private static String ruteOfProducts = "copyItProducts.pft";
    // esta funcion es para crear el archivo tengo que completarlo con el Mensaje
    // el mensaje solo es visible cuando no se crea caso contrario no muestra nada, ni en consola

    public static boolean createFile(){

        try {
            File copyProducts = new File(ruteOfProducts);
            return copyProducts.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Archivo ya existe o no se puedo crar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }


    public static List<Product> leerProductos() {
        List<Product> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruteOfProducts))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                String nombre = partes[0].trim();
                double precio = Double.parseDouble(partes[1].trim());

                productos.add(new Product(nombre, precio));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }

}
