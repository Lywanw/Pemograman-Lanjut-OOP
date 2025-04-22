import java.util.Scanner;

public class Special extends Stat {
    Scanner sc = new Scanner(System.in);
    private String legendary;
    private String mythical;
    private String mega;
    private String gigantamax;


    public String getLegendary() {
        return legendary;
    }

    public void setLegendary(String legendary) {
        this.legendary = legendary;
    }

    public String getMythical() {
        return mythical;
    }

    public void setMythical(String mythical) {
        this.mythical = mythical;
    }

    public String getMega() {
        return mega;
    }

    public void setMega(String mega) {
        this.mega = mega;
    }

    public String getGigantamax() {
        return gigantamax;
    }

    public void setGigantamax(String gigantamax) {
        this.gigantamax = gigantamax;
    }

    public void print() {
        System.out.println("Nama pokemon: " + name + " & type " + type1 + "-" + type2 + " & Stat total: " + total);
    }

    public void print(boolean showType) {
        System.out.println(showType);
        if (showType) {
            System.out.println("Pokedex: "+number+"Nama pokemon: " + name );
        } else {
            System.out.println("Nama pokemon: " + name);
        }
    }
        public void print ( int totalStat) {
            if (this.total == totalStat) {
                System.out.println("Pokemon yang punya Total Stat = " + totalStat);
                print();
            }
        }
            public void print(String category, String value) {
                if (category.equalsIgnoreCase("legendary") && value.equalsIgnoreCase(legendary)) {
                    print();
                } else if (category.equalsIgnoreCase("mythical") && value.equalsIgnoreCase(mythical)) {
                    print();
                } else if (category.equalsIgnoreCase("mega") && value.equalsIgnoreCase(mega)) {
                    print();
                } else if (category.equalsIgnoreCase("gigantamax") && value.equalsIgnoreCase(gigantamax)) {
                    print();
                }
            }

            public void print(String nick){
                    if (this.name.equalsIgnoreCase(nick)){
                        System.out.println("===== DATA LENGKAP POKÉMON =====");
                        System.out.println("Nama        : " + name);
                        System.out.println("Nomor       : " + number);
                        System.out.println("Type        : " + type1 + (type2.isEmpty() ? "" : " - " + type2));
                        System.out.println("HP          : " + hp);
                        System.out.println("Attack      : " + attack);
                        System.out.println("Defense     : " + getDefense());
                        System.out.println("Sp.Attack   : " + getSp_attack());
                        System.out.println("Sp.Defense  : " + getSp_defense());
                        System.out.println("Speed       : " + speed);
                        System.out.println("Total Stat  : " + total);
                        System.out.println("Legendary   : " + ("True".equalsIgnoreCase(legendary) ? "Iya" : "Tidak"));
                        System.out.println("Mythical    : " + ("True".equalsIgnoreCase(mythical) ? "Iya" : "Tidak"));
                        System.out.println("Mega        : " + ("True".equalsIgnoreCase(mega) ? "Iya" : "Tidak"));
                    }
                }
        }


