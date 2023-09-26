package kodol;

public class Main {
    public static void main(String[] args) {
        Feladatok.f2();
        ADFGVXrejtjel adfgvXrejtjel = new ADFGVXrejtjel("kodtabla.txt", Feladatok.uzenet,
                Feladatok.kulcs);
        adfgvXrejtjel.atalakitottUzenet();
        System.out.println("6. feladat: s -> " + adfgvXrejtjel.betupar('s') +
                " x -> " + adfgvXrejtjel.betupar('x'));
        System.out.println("7. feladat: A kódszöveg: " + adfgvXrejtjel.kodszoveg());
        System.out.println("8. feladat: A kódolt szöveg: " + adfgvXrejtjel.kodoltUzenet());
    }
}
