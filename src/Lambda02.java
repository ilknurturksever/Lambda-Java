import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,-3, 3, 7,34,22,-60,42,55));

        ciftKareMAx(list);
        System.out.println();
        System.out.println("*****");
        toplaEl1(list);
        System.out.println();
        System.out.println("*****");
        toplaEl2(list);
        System.out.println();
        System.out.println("*****");
        carpCiftel1(list);
        System.out.println();
        System.out.println("*****");
        carpCift2(list);
        System.out.println();
        System.out.println("*****");
        min1(list);
        System.out.println();
        System.out.println("*****");
        min2(list);
        System.out.println();
        System.out.println("*****");
        min3(list);
        System.out.println();
        System.out.println("*****");
        min4(list);
        System.out.println();
        System.out.println("*****");
        buyukEnkucukTek(list);
        System.out.println();
        System.out.println("*****");
        ciftKareKucuktenBuyuge(list);
        System.out.println();
        System.out.println("*****");
        tekKareBuyuktenKucuge(list);
    }

    // List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz

    public static void ciftKareMAx( List<Integer> list){

      Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max);

      // reduce(Math::max) da kullanilabilir ancak reduce (Integer::max); daha specific oldugu icin hizli calisir

      // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max);

        // reduce() return edilen eleman ya da int2den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
        // Optional class'a sart kosuyor

        System.out.println(maxEl);

    }

    // List'deki tum elemenalrin toıplamini yazdiriniz
    // Lambda Expression...

    public static void toplaEl1(List<Integer> list){

       int toplam = list.stream().reduce(0,(x,y)-> x+y);

       // x her zaman ilk degerini atanan degerden(0) alir
       // y her zaman degerini list.stream()'den alir(akis)
       // x ilk degerden sonraki degerlerini islemden alir

        System.out.println(toplam);
    }

    // List'deki tum elemenalrin toıplamini yazdiriniz
    // Method Referance...

    public static void toplaEl2(List<Integer> list){

        Optional<Integer>  toplam = list.stream().reduce(Integer::sum);
        Optional<Integer>  toplam1 = list.stream().reduce(Math::addExact);

        System.out.println(toplam);
        System.out.println(toplam1);
    }

    // Liste'deki cift elemanlarin carpinimi yazdiriniz
    // Method Referance...
    public static void  carpCiftel1(List<Integer> list){

        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);

        System.out.println(carp);

    }

    // Liste'deki cift elemanlarin carpinimi yazdiriniz
    // Lambda Expression...

    public static void carpCift2(List<Integer> list){

        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1,(x,y)->(x*y));
        System.out.println(carp);

        // Pozitif deger uretiniz

        Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce(-1,(x,y)->(x*y));
        System.out.println(carpPoz);

    }

    // List'deki elemanlardan en kucugunu 4 farkli yontem ile yazdiriniz
    // 1.Yontem : Method Reference ---> Integer class
    public static void min1(List<Integer>list){

        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    // 2.Yontem : Method Reference ---> Math class
    public static void min2(List<Integer>list){

        Optional<Integer> min1 = list.stream().reduce(Math::min);
        System.out.println(min1);
    }

    // 3.Yontem : Method Reference ---> Haluk class
    public static int minBul(int x, int y) {

        return x < y ? x : y; // TERNARY
    }

    public static void min3(List<Integer>list){

    Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    // 4. Yontem: Lambda Expression
    public static void min4(List<Integer>list){

        Integer min = list.stream().reduce(Integer.MAX_VALUE,(x,y)-> x<y ? x:y);
        System.out.println(min);
    }

    // List'deki 15'den buyuk en kucuk tek sayiyi yazdiriniz
    public static void buyukEnkucukTek(List<Integer>list){

        // list.stream().filter(t -> t % 2 == 1).filter(t -> t > 15).reduce(Integer::min);
        System.out.println( list.stream().filter(t -> t % 2 == 1).filter(t -> t > 15).reduce(Integer::min));
    }

    // List2in cift elemnalarin karelerini kucukten buyuge yazdiriniz
    public static void ciftKareKucuktenBuyuge(List<Integer>list){

        list.stream().filter(Lambda01::ciftBul).map(t-> t*t).sorted().forEach(Lambda01::printEl);
    }

    // List'in tek elemanlarinin karelerini buyukten kucuge yazdirinizq
    public static void tekKareBuyuktenKucuge(List<Integer>list){

        list.stream().filter(t-> t%2 != 0).map(t-> t*t).sorted(Comparator.reverseOrder()).forEach(Lambda01::printEl);
    }
}
