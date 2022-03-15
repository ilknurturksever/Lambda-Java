import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("Mehmet", "Emre", "Nilgun", "Yildiz", "Kader", "Emine", "Islam", "Islam", "Emre", "Su"));


        buyukHarfTekrarsizSira(list);
        System.out.println();
        System.out.println(" ----- ");
        karekterTersSiraliTekrarsiz(list);
        System.out.println();
        System.out.println(" ----- ");
        karakterSayisiKucuktenBuyuge(list);
        System.out.println();
        System.out.println(" ----- ");
        sonHarfTers(list);
        System.out.println();
        System.out.println(" ----- ");
        ciftKareTekrarsizTersSira( list );
    }

    // List elamnlarini alfabetik buyuk harf ve tekrarsiz yazdiriniz
    public static void buyukHarfTekrarsizSira(List<String> list) {

        list.
                stream(). // akisa girdi
                map(t -> t.toUpperCase()). // elemanlar buyuk harf update edildi
                sorted(). // alfabetik sira
                distinct(). // tekrarsiz yapildi ----- COK ONEMLI
                forEach(t -> System.out.print(t + " "));// yazdirildi
    }

    // List elemanlarinin karekter sayisi ters sirali olarak tekrarsiz yazdiriniz
    public static void karekterTersSiraliTekrarsiz(List<String> list) {

        list.
                stream(). // AKISA GIRDI
                map(t -> t.length()). // STRING KARAKTER SAYISI ICIN INT'A UPDATE EDİLDİ
                sorted(Comparator.reverseOrder()). // TERS SIRALADI
                distinct(). // TEKRARLİ ELEMANLARI ALMAYARAK TEKRARSIZ YAPTI
                forEach(Lambda01::printEl); // YAZDIRDI
    }

    // List elemanlarini character sayisina gore kucukten  buyuge gore yazdiriniz
    public static void karakterSayisiKucuktenBuyuge(List<String> list) {

        list.
                stream(). // AKISA GIRDI
                sorted(Comparator.comparing(t -> t.length())). // ELEMAN KARAKTER SAYISINA GORE SIRALAMA YAPTI
                forEach(t -> System.out.print(t + " ")); // YAZDIRDI
    }

    // List eleemnalarini son harfine gore ters sirali yazdiriniz
    public static void sonHarfTers(List<String> list) {

        list.
                stream(). // AKISA GIRDI
                sorted(Comparator.comparing(t -> t.toString(). // ELEMANIN LENGTH()-1 'I SON INDEXININ KARAKTERİNİ ALIR
                charAt(t.toString().length() - 1)). // ELEMANIN LENGTH()-1 'I SON INDEXININ KARAKTERINI TERS SIRALAR Z->A
                reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Listin elemanlarin karakterlerin  Cift sayili oalnlarinin  karelerini hesaplayan, tekrarsiz buyukten kucuge dogru yazdiran bir program yaziniz.
    public static void ciftKareTekrarsizTersSira(List<String> list ){

        list.
                stream(). // AKISA GIRDI
                map(t->t.length()*t.length()). // STRING ELEMNALAR CHARACTER SAYISINA CEVRILDI
                filter(Lambda01::ciftBul). // CIFT SARTI
                distinct(). // TEKARASIZ
                sorted(Comparator.reverseOrder()). // TERS SIRA BUYUKTEN ---> KUCUGE
                forEach(Lambda01::printEl); // YAZDIRILDI
    }




























}
