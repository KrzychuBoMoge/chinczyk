import java.util.Locale;
import java.util.Scanner;

public
    class S18962 {
    public static void main(String[] args) {
        Chinczyk.start(4, new int[ ][ ]{
                                        {'a', 3},
                                        {'b', 9,},
                                        {'c', 22},
                                        {'d', 31, 33},
                                    } ,new int[ ]{6}, new int[ ]{3});
    }

    static class Chinczyk {
        static int iloscGraczy;
        static int liczbaOczek;
        static int decyzje;
        static char[] gracze = {'a','b','c','d'};
        // Gracz, ile pionów w bazie, ile pionów w domku
        static int[][] punktacja = new int[][]{{'a',4,0},{'b',4,0},{'c',4,0},{'d',4,0}};
        static int[] plansza = new int[40];
        static {
            for (int i = 0; i < plansza.length; i++)
                plansza[i]='x';
        }
        char zwyciezca = ' ';
        static Scanner scanner = new Scanner(System.in);
        static void start(int iloscGraczy, int[][] piony, int[] losowania, int[] decyzje){
            Chinczyk.iloscGraczy = iloscGraczy;
            for (int[] tab : piony) {
                for (int i = 1; i < tab.length; i++)
                    plansza[tab[i]] = tab[0];
                punktacja[tab[0]-97][1] -= tab.length-1;
            }
            Chinczyk.liczbaOczek = losowania[0];
            Chinczyk.decyzje = decyzje[0];
            new Chinczyk();
        }

        static void start(){
            System.out.println("Ile graczy?");
            Chinczyk.iloscGraczy = scanner.nextInt();
            Chinczyk.liczbaOczek = losuj();
            Chinczyk.decyzje = (int) (Math.random()*10%iloscGraczy+1);
        }

        static int losuj(){
            return (int) (Math.random()*10%6+1);
        }

        private Chinczyk() {
            while (zwyciezca == ' ') {
                wypisz();
                System.out.println("> porusza się gracz: " + gracze[decyzje]);
                if (liczbaOczek == 6)
                    baza();
                ruch();
                liczbaOczek = losuj();
            }
            System.out.println("> Tą grę wygrał gracz " + zwyciezca);
        }

        void baza(){
            System.out.println("> Wylosowano 6! Chcesz dodać nowy pion z domku? T / N");
            if (scanner.next().toUpperCase(Locale.ROOT).equals("T"))
                if (plansza[10*(gracze[decyzje]-97)+1] != gracze[decyzje]) {
                    plansza[10 * (gracze[decyzje] - 97) + 1] = gracze[decyzje];
                    punktacja[decyzje][1]--;
                } else
                    System.out.println("> Dodanie piona jest niemożliwe");
        }
        void ruch(){
            boolean wykonanoRuch = false;
            while (!wykonanoRuch) {
                wypisz();
                System.out.println("> wylosowano: " + liczbaOczek);
                System.out.print("> podaj numer pola na ktorym stoi pionek ktory nalezy przesunac: ");
                int ruch = scanner.nextInt();
                int doceloweMiejsce = (ruch + liczbaOczek)%40;
                if (plansza[ruch] == 'x' || plansza[ruch] != gracze[decyzje] || plansza[ruch] == plansza[doceloweMiejsce]) {
                    System.out.println("> Niepoprawny ruch");
                    continue;
                }
                if (plansza[doceloweMiejsce] <= 100 && plansza[doceloweMiejsce] >= 97)
                    punktacja[plansza[doceloweMiejsce]-97][1]++;
                if (plansza[ruch] < (gracze[decyzje]-97)*10 && plansza[doceloweMiejsce] > (gracze[decyzje]-97)*10) {
                    plansza[ruch] = 'x';
                    if (++punktacja[gracze[decyzje]-97][2] == 4)
                        zwyciezca = gracze[decyzje];
                }
                plansza[doceloweMiejsce] = plansza[ruch];
                plansza[ruch] = 'x';
                wykonanoRuch = liczbaOczek != 6;
                liczbaOczek = losuj();
            }
            if (++decyzje==iloscGraczy)
                decyzje=0;
        }

        void wypisz(){
            char[] chars = new char[16];
            int index = 0;
            for (int[] gracz : punktacja) {
                for (int i = 0; i < gracz[1]; i++)
                    chars[index++] = (char) gracz[0];
                for (int i = 0; i < 4 - gracz[1]; i++)
                    chars[index++] = ' ';
            }
            String[] plansza = {
                    "               0",
                    "     "+chars[15]+" "+chars[14]+"   "+(char) Chinczyk.plansza[38]+" "+(char) Chinczyk.plansza[39]+" "+(char) Chinczyk.plansza[0]+"   "+chars[0]+" "+chars[1],
                    "     "+chars[13]+" "+chars[12]+"   "+(char) Chinczyk.plansza[37]+"   "+(char) Chinczyk.plansza[1]+"   "+chars[2]+" "+chars[3],
                    "           "+(char) Chinczyk.plansza[36]+"   "+(char) Chinczyk.plansza[2],
                    "           "+(char) Chinczyk.plansza[35]+"   "+(char) Chinczyk.plansza[3],
                    "30 "+(char) Chinczyk.plansza[30]+" "+(char) Chinczyk.plansza[31]+" "+(char) Chinczyk.plansza[32]+" "+(char) Chinczyk.plansza[33]+" "+(char) Chinczyk.plansza[34]+"   "+(char) Chinczyk.plansza[4]+" "+(char) Chinczyk.plansza[5]+" "+(char) Chinczyk.plansza[6]+" "+(char) Chinczyk.plansza[7]+" "+(char) Chinczyk.plansza[8],
                    "   "+(char) Chinczyk.plansza[29]+"                   "+(char) Chinczyk.plansza[9],
                    "   "+(char) Chinczyk.plansza[28]+" "+(char) Chinczyk.plansza[27]+" "+(char) Chinczyk.plansza[26]+" "+(char) Chinczyk.plansza[25]+" "+(char) Chinczyk.plansza[24]+"   "+(char) Chinczyk.plansza[14]+" "+(char) Chinczyk.plansza[13]+" "+(char) Chinczyk.plansza[12]+" "+(char) Chinczyk.plansza[11]+" "+(char) Chinczyk.plansza[10]+" 10",
                    "           "+(char) Chinczyk.plansza[23]+"   "+(char) Chinczyk.plansza[15],
                    "           "+(char) Chinczyk.plansza[22]+"   "+(char) Chinczyk.plansza[16],
                    "     "+chars[9]+" "+chars[8]+"   "+(char) Chinczyk.plansza[21]+"   "+(char) Chinczyk.plansza[17]+"   "+chars[4]+"  "+chars[5],
                    "     "+chars[11]+" "+chars[10]+"   "+(char) Chinczyk.plansza[20]+" "+(char) Chinczyk.plansza[19]+" "+(char) Chinczyk.plansza[18]+"   "+chars[6]+"  "+chars[7],
                    "           20"
            };
            for (String s : plansza)
                System.out.println(s);
        }
    }
}