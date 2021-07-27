package views;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Files {

    public static void main(String[] args) {
        
        try {
            InputStream ins = new FileInputStream("./data/data.properties");

            Properties prop = new Properties();

            prop.load(ins);

            //System.out.println(prop.getProperty("8"));

            //por cada elemento de prop mostrar key y value
            prop.forEach((key, value) -> System.out.println(key + " " + value));            

            // System.out.println(prop.getProperty("58numero"));

        } catch (Exception e) {
            // TODO: handle exception
        }
        /*
        try {

            OutputStream ous = new FileOutputStream("./last/data/data.properties");
            Properties prop = new Properties();
            // prop.setProperty("nombre", "Marco");
            // prop.setProperty("edad", "31");

            //guarda llave unica y valor de 3 en 3
            for (int i = 1; i <= 10; i++) {
                prop.setProperty(i + "", (i * 3) + "");
            }
            prop.store(ous, null);
            System.out.println(prop);
        } catch (Exception e) {
            // TODO: handle exception
        }
*/
    }

}