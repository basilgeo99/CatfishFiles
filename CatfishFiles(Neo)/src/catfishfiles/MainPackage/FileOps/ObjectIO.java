package catfishfiles.MainPackage.FileOps;

import catfishfiles.MainPackage.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author trainee_3
 */
public class ObjectIO {

    public void writeObject(Player P, String file) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream O = new ObjectOutputStream(f);
        O.writeObject(P);
        O.close();
    }

    public Player readObject(String file ) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream O = new ObjectInputStream(f);
        Player P = (Player) O.readObject();
        O.close();
         return P;       
    }

}
