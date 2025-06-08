import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class NewFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama file csv : ");
        String namaFile = sc.nextLine();

        System.out.print("Masukkan generasi pokemon yang di inginkan: ");
        int gen = sc.nextInt();

        Special[] listPoke = new Special[1100];

        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
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

                listPoke[idx] = pokemon;
                idx++;
            }
            Special[] filterPoke = carigen(listPoke, gen);

            Arrays.sort(filterPoke, 0, filterPoke.length, new Comparator<Special>() {
                @Override
                public int compare(Special p1, Special p2) {
                    if (p1 == null || p2 == null) return 0;
                    return p1.getName().compareToIgnoreCase(p2.getName());
                }
            });
            for (Special p : filterPoke) {
                if (p != null) {
                    System.out.println(p.getName());
                }
            }
            System.out.println("Pokemon gen " + gen + " = " + filterPoke.length);
            saveToFile("./data/pokemon_gen" + gen + ".csv", filterPoke);

        } catch (Exception e) {
            System.out.println("Gagal membaca file: " + namaFile);
            System.out.println("Detail error: " + e.getMessage());
        }
    }

    public static Special[] loadPoke(String daftarNamaFile[]) {
        Special[] temp_listPoke = new Special[1100];
        try (BufferedReader br = new BufferedReader(new FileReader(daftarNamaFile[0]))) {
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
                temp_listPoke[idx] = pokemon;
                idx++;
            }
        } catch (IOException e) {
            System.out.println("Error loading file in loadPoke: " + e.getMessage());
        }
        return temp_listPoke;
    }


    public static Special[] carigen(Special[] listPoke, int Generation) {
        List<Special> filteredPoke = new ArrayList<>();
        for (Special pokemon : listPoke) {
            if (pokemon != null && pokemon.getGeneration() == Generation ) {
                filteredPoke.add(pokemon);
            }
        }
        return filteredPoke.toArray(new Special[0]);
    }

    public static void saveToFile(String fileName, Special[] data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("number,name,type1,type2,total,hp,attack,defense,sp_attack,sp_defense,speed,generation,legendary,mythical,mega,gigantamax\n");
            for (Special row : data) {
                writer.append(row.number + ",");
                writer.append(row.name + ",");
                writer.append(row.type1 + ",");
                writer.append(row.type2 + ",");
                writer.append(row.total + ",");
                writer.append(row.hp + ",");
                writer.append(row.attack + ",");
                writer.append(row.defense + ",");
                writer.append(row.sp_attack + ",");
                writer.append(row.sp_defense + ",");
                writer.append(row.speed + ",");
                writer.append(row.generation + ",");
                writer.append(row.legendary + ",");
                writer.append(row.mythical + ",");
                writer.append(row.mega + ",");
                writer.append(row.gigantamax + "\n");
            }
            System.out.println("Data berhasil ditulis ke " + fileName);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }
    }
}