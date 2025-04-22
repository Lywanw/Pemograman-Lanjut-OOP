import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScanStat {
    public static void main(String[] args) {
        String namafile = "pokemon.csv";
        Special[] sp = new Special[1100];
        try {
            BufferedReader br = FileReaderUtil.getFileReader(namafile);
            if (br == null) {
                return;
            }
            String line = "";
            br.readLine();
            int idx = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

               Special pokemon = new Special();

                pokemon.setNumber(Integer.parseInt(data[0]));
                pokemon.setName(data[1]);
                pokemon.setType1(data[2]);
                pokemon.setType2(data[3]);
                pokemon.setTotal(Integer.parseInt(data[4]));
                pokemon.setHp(Integer.parseInt(data[5]));
                pokemon.setAttack(Integer.parseInt(data[6]));
                pokemon.setDefense(Integer.parseInt(data[7]));
                pokemon.setSp_attack(Integer.parseInt(data[8]));
                pokemon.setSp_defense(Integer.parseInt(data[9]));
                pokemon.setSpeed(Integer.parseInt(data[10]));
                pokemon.setGeneration(Integer.parseInt(data[11]));
                pokemon.setLegendary(data[12]);
                pokemon.setMythical(data[13]);
                pokemon.setMega(data[14]);
                pokemon.setGigantamax(data[15]);

                sp[idx] = pokemon;
                pokemon.print();
                idx++;
            }
            System.out.println("================================================================================================");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Special pokemon : sp) {
            if (pokemon != null ) {
                pokemon.print("Gyarados");
            }
        }
        System.out.println("================================================================================================");
    }
}
class FileReaderUtil {
    public static BufferedReader getFileReader(String filename) {
        try {
            return new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            System.out.println("Kesalahan saat membuka file masukkan file yang benar>>>" + e.getMessage());
            return null;
        }
    }
}