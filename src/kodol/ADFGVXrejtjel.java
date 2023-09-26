package kodol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ADFGVXrejtjel {
    private char[][] kodtabla;
    private String uzenet;
    private String kulcs;

    public String atalakitottUzenet() {
        // 5. feladat:
        String alakit = uzenet.replace(" ", "");
        int marad = alakit.length() % kulcs.length();
        if (marad != 0) {
            alakit += "x".repeat(kulcs.length() - marad);
        }
        System.out.println("5. feladat: Az átalakított üzenet: " + alakit);
        return alakit;
    }

    public String kodszoveg() {
        // 7. feladat
        StringBuilder kod = new StringBuilder();
        String alak = atalakitottUzenet();
        for (int i = 0; i < alak.length(); i++) {
            kod.append(betupar(alak.charAt(i)));
        }
        return kod.toString();
    }

    public String betupar(char k) {
        String[] adfgvx = {"A", "D", "F", "G", "V", "X"};
        for (int sorIndex = 0; sorIndex <= 5; sorIndex++) {
            for (int oszlopIndex = 0; oszlopIndex <= 5; oszlopIndex++) {
                if (kodtabla[sorIndex][oszlopIndex] == k){
                    return adfgvx[sorIndex] + adfgvx[oszlopIndex];
                }
            }
        }
        return "hiba";
    }

    public String kodoltUzenet() {
        char[] kodszoveg = kodszoveg().toCharArray();
        int sorokSzama = kodszoveg.length / kulcs.length();
        int oszlopokSzama = kulcs.length();
        char[][] m = new char[sorokSzama][oszlopokSzama];
        int index = 0;
        for (int sor = 0; sor < sorokSzama; sor++) {
            for (int oszlop = 0; oszlop < oszlopokSzama; oszlop++) {
                m[sor][oszlop] = kodszoveg[index++];
            }
        }

        StringBuilder kodoltUzenet = new StringBuilder();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            int oszlopIndex = kulcs.indexOf(ch);
            if (oszlopIndex != -1) {
                for (int sorIndex = 0; sorIndex < sorokSzama; sorIndex++) {
                    kodoltUzenet.append(m[sorIndex][oszlopIndex]);
                }
            }
        }
        return kodoltUzenet.toString();
    }

    public ADFGVXrejtjel(String kodtablaFile, String uzenet, String kulcs) {
        this.uzenet = uzenet;
        this.kulcs = kulcs;

        kodtabla = new char[6][6];
        int sorIndex = 0;
        File inputFile = new File(kodtablaFile);
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String aktualisSor = scanner.nextLine();
                for (int oszlopIndex = 0; oszlopIndex < aktualisSor.length(); oszlopIndex++) {
                    kodtabla[sorIndex][oszlopIndex] = aktualisSor.toCharArray()[oszlopIndex];
                }
                sorIndex++;
            }
        } catch (FileNotFoundException exception) {
            System.err.print("FĂĄjl nem talĂĄlhatĂł!");
        }
    }
}