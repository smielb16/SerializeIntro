
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class SchuelerBL {

    private ArrayList<Schueler> klasse = new ArrayList<>();

    public void add(Schueler s) {
        klasse.add(s);
    }

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(f));
        for (Schueler s : klasse) {
            oos.writeObject(s);
        }
        oos.flush();
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f));
        Object s = null;
        while ((s = ois.readObject()) != null) {
            add((Schueler) s);
        }
    }

    public static void main(String[] args) {
        Schueler s1
                = new Schueler("Hans",
                        LocalDate.of(2000, Month.MARCH, 3));
        Schueler s2
                = new Schueler("Grete",
                        LocalDate.of(2000, Month.OCTOBER, 10));

        SchuelerBL bl = new SchuelerBL();
        bl.add(s1);
        bl.add(s2);

        File f = new File("./data.bin");
        try {
            bl.save(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
