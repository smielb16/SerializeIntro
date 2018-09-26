
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class SchuelerBL {

    private ArrayList<Schueler> klasse = new ArrayList<>();

    public void add(Schueler s) {
        klasse.add(s);
    }

    public void save(File f) throws Exception {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(f));
        for (Schueler s : klasse) {
            bw.write(s.getName());
            bw.write(";");
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
    }

    public void load(File f) throws Exception {
        BufferedReader br = new BufferedReader(
                new FileReader(f));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            try {
                add(new Schueler(parts[0],
                        LocalDate.parse(parts[1])));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

    }

}
