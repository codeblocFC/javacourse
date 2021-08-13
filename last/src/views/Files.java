package views;

/*import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
*/

import model.Client;

public class Files {

    public static void main(String[] args) {
        
            Client customer1 = new Client("Marco");           
            System.out.println(customer1.getWallet().saveMoney(30000));
            System.out.println(customer1.getWallet().breakLimit());
            System.out.println(customer1.getWallet().saveMoney(15000));
            System.out.println(customer1.getWallet().takeMoney(20000));
            customer1.getWallet().displayMovimientos();
            System.out.println(customer1.getWallet());
            customer1.getWallet().generarRegistro();
            
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