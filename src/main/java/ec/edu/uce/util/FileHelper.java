package ec.edu.uce.util;

import java.io.File;
import java.io.IOException;
import java.io.*;

public class FileHelper {
    public static String[] dataUsers = {"edwin", "edwin4313", "user", "user123"};
    // esta funcion es para crear el archivo tengo que completarlo con el Mensaje
    // el mensaje solo es visible cuando no se crea caso contrario no muestra nada, ni en consola
    public static boolean createFile(){
        String ruteOfProducts = "copyItProducts.pft";
        try {
            File copyProducts = new File(ruteOfProducts);
            return copyProducts.createNewFile();
        } catch (IOException e) {
            // TASK: completar esto con un cuadro de mensaje se llamaba algo como JOptinShowMessaje algo asi
            System.out.println("Completa esto con un ShowMessaje o algo asi jajaj" + e.getMessage());
        }
        return false;
    }


    public static void writeDataUsers(String users, String products){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(users))){
            writer.write("xd");
            writer.newLine();
        }catch (IOException e){
            System.out.println("completar como el anterior");
        }
    }

    public static void writeDataProducts(){

    }

}
