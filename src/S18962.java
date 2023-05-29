import java.util.Scanner;

public
    class S18962 {
    public static void main(String[] args) {
        Chinczyk.start(4, new int[ ][ ]{
                                        {'a', 3},
                                        {'b', 6},
                                        {'c', 22},
                                        {'d', 31},
                                    } ,new int[ ]{2}, new int[ ]{3});
    }

    static class Chinczyk {
        static int iloscGraczy;
        static int losowania;
        static int decyzje;
        static int[] plansza = new int[40];
        static {
            for (int i = 0; i < plansza.length; i++)
                plansza[i]=120;
        }
        static Scanner scanner = new Scanner(System.in);
        static void start(int iloscGraczy, int[][] piony, int[] losowania, int[] decyzje){
            Chinczyk.iloscGraczy = iloscGraczy;
            for (int[] tab : piony)
                for (int i = 1; i < tab.length; i++)
                    plansza[tab[i]] = tab[0];
            Chinczyk.losowania = losowania[0];
            Chinczyk.decyzje = decyzje[0];
            new Chinczyk();
        }

        static void start(){
            System.out.println("Ile graczy?");
            Chinczyk.iloscGraczy = scanner.nextInt();
            Chinczyk.losowania = losuj();
            Chinczyk.decyzje = (int) (Math.random()*10%iloscGraczy+1);
        }

        static int losuj(){
            return (int) (Math.random()*10%6+1);
        }

        private Chinczyk() {
            while (true) {
                wypisz();
                int liczbaOczek = losuj();
                System.out.println("> wylosowano: " + liczbaOczek);
                System.out.print("> podaj numer pola na ktorym stoi pionek ktory nalezy przesunac: ");
                int ruch = scanner.nextInt();
                if (plansza[ruch] != 120){
                    plansza[ruch+liczbaOczek] = plansza[ruch];
                    plansza[ruch] = 120;
                }
            }
        }

        void wypisz(){
            String[] plansza = {
                    "               0",
                    "     d d   "+(char) Chinczyk.plansza[38]+" "+(char) Chinczyk.plansza[39]+" "+(char) Chinczyk.plansza[0]+"   a a",
                    "     d d   "+(char) Chinczyk.plansza[37]+"   "+(char) Chinczyk.plansza[1]+"   a a",
                    "           "+(char) Chinczyk.plansza[36]+"   "+(char) Chinczyk.plansza[2],
                    "           "+(char) Chinczyk.plansza[35]+"   "+(char) Chinczyk.plansza[3],
                    "30 "+(char) Chinczyk.plansza[30]+" "+(char) Chinczyk.plansza[31]+" "+(char) Chinczyk.plansza[32]+" "+(char) Chinczyk.plansza[33]+" "+(char) Chinczyk.plansza[34]+"   "+(char) Chinczyk.plansza[4]+" "+(char) Chinczyk.plansza[5]+" "+(char) Chinczyk.plansza[6]+" "+(char) Chinczyk.plansza[7]+" "+(char) Chinczyk.plansza[8],
                    "   "+(char) Chinczyk.plansza[29]+"                   "+(char) Chinczyk.plansza[9],
                    "   "+(char) Chinczyk.plansza[28]+" "+(char) Chinczyk.plansza[27]+" "+(char) Chinczyk.plansza[26]+" "+(char) Chinczyk.plansza[25]+" "+(char) Chinczyk.plansza[24]+"   "+(char) Chinczyk.plansza[14]+" "+(char) Chinczyk.plansza[13]+" "+(char) Chinczyk.plansza[12]+" "+(char) Chinczyk.plansza[11]+" "+(char) Chinczyk.plansza[10]+" 10",
                    "           "+(char) Chinczyk.plansza[23]+"   "+(char) Chinczyk.plansza[15],
                    "           "+(char) Chinczyk.plansza[22]+"   "+(char) Chinczyk.plansza[16],
                    "     c c   "+(char) Chinczyk.plansza[21]+"   "+(char) Chinczyk.plansza[17]+"   b  b",
                    "     c c   "+(char) Chinczyk.plansza[20]+" "+(char) Chinczyk.plansza[19]+" "+(char) Chinczyk.plansza[18]+"   b  b",
                    "           20"
            };
            for (String s : plansza)
                System.out.println(s);
        }
    }
}