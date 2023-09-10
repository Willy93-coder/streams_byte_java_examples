import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String pathFile = "./images/santiago_bernabeu_stadium.jpeg";
        ArrayList<Integer> myImageArrByte = new ArrayList<>();
        try {
            FileInputStream lectura_archivo = new FileInputStream(pathFile);
            boolean final_archivo = false;

            while (!final_archivo) {
                int byteImagenEntrada = lectura_archivo.read();
                myImageArrByte.add(byteImagenEntrada);
                if (byteImagenEntrada == -1) final_archivo = true;
            }
            lectura_archivo.close();
            CreaFichero(myImageArrByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void CreaFichero(ArrayList<Integer> arrayExterno) throws IOException {

        FileOutputStream ficheroExterno = new FileOutputStream("./escritura/santiago_bernabeu_stadium_clone.jpeg");
        for (Integer integer : arrayExterno) {
            ficheroExterno.write(integer);
            System.out.println(integer);
        }
        ficheroExterno.close();
    }
}