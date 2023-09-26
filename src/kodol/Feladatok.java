package kodol;

import java.util.Scanner;

public class Feladatok {

    public static String kulcs;
    public static String uzenet;
    public static void f2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("2. feladat");
        System.out.print("\tKérem a kulcsot [HOLD]: ");
        kulcs = sc.nextLine();
        if (kulcs.isEmpty()){
            kulcs = "HOLD";
        } else {
            kulcs = kulcs.toUpperCase();
        }
        System.out.print("\tKérem az üzenetet [szeretem a csokit]: ");
        uzenet = sc.nextLine();
        if (uzenet.isEmpty()){
            uzenet = "szeretem a csokit";
        } else {
            uzenet = uzenet.toLowerCase();
        }
    }
}
