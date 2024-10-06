import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sklad {
    public static void main(String[] args) {
        // Testovací data přímo v kódu
        strings s = new strings();

        String input = s.s2;

        // Scanner, který bere data z řetězce místo z konzole
        Scanner scanner = new Scanner(input);

        // Načtení počtu řádků
        int n = scanner.nextInt();
        scanner.nextLine();  // Přejdeme na další řádek

        // 3 hodnoty: operace, typ, cena
        ArrayList<Object[]> list = new ArrayList<>();


        // Načítání jednotlivých řádků
        for (int i = 0; i < n; i++) {
            Object[] item = new Object[3];
            item[0] = scanner.next().charAt(0);  // operace ('P' nebo 'N')
            item[1] = scanner.nextInt();         // typ (int)
            item[2] = scanner.nextInt();         // cena (int)
            list.add(item);
        }

        for (Object[] item : list) {
            System.out.println(item[0] + " " + item[1] + " " + item[2]);
        }

        list = DiscardFirstLast(list, n);















        scanner.close();
    }

    static ArrayList<Object[]> MergeOrders(ArrayList<Object[]> list, int n) {
        int[] lowestBuy = new int[n];

        // Procházení operací v ArrayListu
        for (int i = 0; i < list.size(); i++) {
            // Získání aktuálního řádku z ArrayListu
            Object[] item = list.get(i);
            char operation = (char) item[0];  // operace ('P' nebo 'N')
            int typ = (int) item[1];          // typ (int)
            int price = (int) item[2];        // cena (int)


        }







        return list;
    }


    static ArrayList<Object[]> DiscardFirstLast(ArrayList<Object[]> list, int n) {

        boolean[] bought = new boolean[n];
        boolean[] sold = new boolean[n];

        // Procházení operací v ArrayListu
        for (int i = 0; i < list.size(); i++) {
            // Získání aktuálního řádku z ArrayListu
            Object[] item = list.get(i);
            char operation = (char) item[0];  // operace ('P' nebo 'N')
            int typ = (int) item[1];          // typ (int)
            int price = (int) item[2];        // cena (int)

            if (operation == 'N') {
                bought[typ] = true;  // Označení, že byl typ koupen
            }
            if (operation == 'P' && !bought[typ]) {
                list.remove(i);
                i--; // Snížíme index, protože po odstranění se velikost zmenší
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            Object[] item = list.get(i);
            char operation = (char) item[0];
            int typ = (int) item[1];
            int price = (int) item[2];

            if (operation == 'P') {
                sold[typ] = true;  // Označení, že byl typ prodán
            }

            if (operation == 'N' && !sold[typ]) {
                list.remove(i);  // Odstranění posledního prodeje pro daný typ
            }
        }
    return list;
    }

}




class strings
{
    // Demo
    // +20
    String d1 = "6\n" +
            "N 1 15\n" +
            "N 1 10\n" +
            "N 2 1\n" +
            "P 1 30\n" +
            "P 2 20\n" +
            "P 1 20";
    // +0
    String d2 = "2\n" +
            "P 1 1000\n" +
            "N 1 1";

    // +20
    String d3 = "4\n" +
            "N 3 70\n" +
            "P 3 80\n" +
            "N 3 10\n" +
            "P 3 20";

    // +30
    String s1 = "6\n" +
            "N 1 5\n" +
            "N 1 10\n" +
            "P 1 20\n" +
            "P 1 25\n" +
            "N 1 2\n" +
            "P 1 12";


    String s2 = "6\n" +
            "P 1 5\n" +
            "N 1 10\n" +
            "P 1 20\n" +
            "P 1 25\n" +
            "P 2 2\n" +
            "N 1 12";
}