package ec.edu.uce.util;

import ec.edu.uce.dominio.Company;
import ec.edu.uce.dominio.Product;
import ec.edu.uce.dominio.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Map;
import java.awt.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FileHelper {
    public static String[] dataUsers = {"edwin", "edwin4313", "user", "user123"};
    private static String ruteOfUsers = "noCopyUsers.pft";
    private static String ruteOfProducts = "copyItProducts.pft";
    // esta funcion es para crear el archivo tengo que completarlo con el Mensaje
    // el mensaje solo es visible cuando no se crea caso contrario no muestra nada, ni en consola

    // datos del producto
    private static final Map<String, Double> products = Map.ofEntries(
            Map.entry("Pan", 0.25),
            Map.entry("Leche", 1.10),
            Map.entry("Arroz", 1.20),
            Map.entry("Azúcar", 1.10),
            Map.entry("Aceite", 2.80),
            Map.entry("Huevos", 3.50),
            Map.entry("Pollo", 2.30),
            Map.entry("Carne de res", 4.50),
            Map.entry("Atún en lata", 1.50),
            Map.entry("Fideos", 0.90),
            Map.entry("Sal", 0.60),
            Map.entry("Café", 4.20),
            Map.entry("Arveja", 1.00),
            Map.entry("Lenteja", 1.20),
            Map.entry("Queso", 3.00),
            Map.entry("Mantequilla", 2.10),
            Map.entry("Yogur", 1.80),
            Map.entry("Galletas", 1.25),
            Map.entry("Papel higiénico", 3.80),
            Map.entry("Jabón", 1.00),
            Map.entry("Detergente", 2.90),
            Map.entry("Cloro", 1.40),
            Map.entry("Cebolla", 0.80),
            Map.entry("Papa", 0.70),
            Map.entry("Plátano", 0.30)
    );


    public static boolean createFile() {
        try {
            File copyProducts = new File(ruteOfProducts);
            File noCopyUsers = new File(ruteOfUsers);

            if (!copyProducts.exists()) {
                copyProducts.createNewFile();
            }

            if (!noCopyUsers.exists()){
                noCopyUsers.createNewFile();
            }

            writeDataProducts();

            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo crear el archivo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    private static void writeDataProducts() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruteOfProducts, false))) {

            for (Map.Entry<String, Double> entry : products.entrySet()) {
                String producto = entry.getKey();
                Double precio = entry.getValue();

                writer.write(producto + " | " + precio);
                writer.newLine();
            }

            System.out.println("[OK] Productos");
        }
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

    public static void writeDataUsers(List<User> usuarios) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruteOfUsers, false))) {

            for (User usr: Company.users){
                writer.write(usr.getName() + " | " + usr.getPassword());
                writer.newLine();
            }

            System.out.println("[OK] Write Users");
        }
    }

    public static List<User> reedUsers() {
        List<User> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruteOfUsers))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                String nombre = partes[0].trim();
                String password = partes[1].trim();
                usuarios.add(new User(nombre, password));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return usuarios;
    }

    public static void descargarLogo(String urlGithub, String nombreArchivoLocal) {
        try {
            URL url = new URL(urlGithub);
            Path destino = Paths.get(nombreArchivoLocal);

            // Verificamos si no es un archivo regular (si no existe o es carpeta)
            if (!Files.isRegularFile(destino)) {
                // Abrimos el flujo de datos y copiamos al destino
                try (InputStream in = url.openStream()) {
                    Files.copy(in, destino, StandardCopyOption.REPLACE_EXISTING);
                }

                //System.out.println("Archivo guardado correctamente en: " + destino.toAbsolutePath());
                System.out.println("[OK] Img");
            }

        } catch (IOException e) {
            System.err.println("Error crítico durante la descarga: " + e.getMessage());
        }
    }

}
