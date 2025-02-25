import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScanStat {
    public static void main(String[] args) {
        String namafile = "pokemon.csv";
        MethodStat[] ms = new MethodStat[1100];
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

                MethodStat pokemon = new MethodStat();

                if (data[3] == null){
                    pokemon.type2 = "";
                }
                else {
                    pokemon.type2 = data[3];
                }

                pokemon.number = Integer.parseInt(data[0]);
                pokemon.name = data[1];
                pokemon.type1 = data[2];
                pokemon.type2 = data[3];
                pokemon.total = Integer.parseInt(data[4]);
                pokemon.hp = Integer.parseInt(data[5]);
                pokemon.attack = Integer.parseInt(data[6]);
                pokemon.defense = Integer.parseInt(data[7]);
                pokemon.sp_attack = Integer.parseInt(data[8]);
                pokemon.sp_defense = Integer.parseInt(data[9]);
                pokemon.speed = Integer.parseInt(data[10]);
                pokemon.generation = Integer.parseInt(data[11]);
                pokemon.legendary = data[12];

                ms[idx] = pokemon;
                pokemon.print();
                idx++;
            }
            System.out.println("================================================================================================");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (MethodStat pokemon : ms) {
            if (pokemon != null && pokemon.total == 1125) {
                System.out.println("Nama pokemon yang dipilih: "+pokemon.name+" type: "+pokemon.type1+"/"+pokemon.type2+" & stat: "+pokemon.total);
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
