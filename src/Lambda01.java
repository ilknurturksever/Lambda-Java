import java.security.spec.RSAOtherPrimeInfo;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

        /*
        1) Lambda "Functional Programming"
           "Functional Programming" de "NASIL YAPARIM ?" degil "NE YAPARIM ?" DUSUNULUR
        2) "Structured Programming" de "NE YAPARIM ? " dan cok "NASIL YAPARIM ? " dusunulur
        3) "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz code yazma acilarindan faydali.
        4) Lambda sadece collections'larda (List, Queue ve Set) ve Array'lerde kullanilabilir ancak map'lerde kullanilmaz.
           Lambda kullanmak hatasiz kod kullanmaktir.
         */
        public static void main(String[] args) {

           List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
           printElStructured(list); // method call
            System.out.println();
            System.out.println("  ---- ");
            printElFunctional(list); // Lambda expression
            System.out.println();
            System.out.println("  ---- ");
            printElFunctional1(list); // method referance
            System.out.println();
            System.out.println("  ---- ");
            printCiftElStructured(list);
            System.out.println();
            System.out.println("  ---- ");
            printCiftElFunctional1(list);
            System.out.println();
            System.out.println("  ---- ");
            printCiftElFunctional2(list);
            System.out.println();
            System.out.println("  ---- ");
            printCiftAltmısKucuk(list);
            System.out.println();
            System.out.println("  ---- ");
            printTekYirmiBuyuk(list);
            System.out.println();
            System.out.println("  ---- ");
            printCiftKare(list);
            System.out.println();
            System.out.println("  ---- ");
            printTekKupBirFazla(list);
            System.out.println();
            System.out.println("  ---- ");
            printCiftKarekok(list);
            System.out.println();
            System.out.println("  ---- ");
            printEnBuyuk(list);


    }
     // Structured Programming ile list elemanlarinin tamamini  aralarina bosluk birakarak yazdiriniz
     public static void printElStructured(List<Integer> list){ // 12 13 65 3 7 34 22 60 42 55
         for (Integer w: list) {
             System.out.print(w + " ");

         }
     }
    // Functional Programming ile list elemanlarinin tamamini  aralarina bosluk birakarak yazdiriniz

    public static void printElFunctional(List<Integer> list){
            list.stream().forEach(t->System.out.print(t+" ")); // Lambda Expression : Lambda ifadesi
        // stream() : datalari yukaridan asagiya akis sekline getirir.
        // forEach() : datalarin parametresine gore her bir elamani isler
        // t-> : Lambda operatoru
        // Lambda Experssion yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
        }
    //   Method Referance : kendi create ettigimiz veya java'da aldigimiz method ile
    //   ClassName::MethodName

    public static void printEl(int a){ // Referans edilecek method create edildi
        System.out.print(a+" ");

    }

    public static void printElFunctional1(List<Integer> list){

            list.stream().forEach(Lambda01::printEl);

    }

    // Structured Programming ile list elemanlarinin cift olannlari ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftElStructured(List<Integer> list){

            for (Integer w : list){
                if (w%2 == 0){
                    System.out.print(w + " ");
                }
            }
    }

    // Functional Programming ile list elemanlarinin cift olannlari ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftElFunctional1(List<Integer>list){

            list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
    }

    public static boolean ciftBul(int i) { // refere edilecek tohum method create edildi

            return i % 2 == 0;

    }

    public static void printCiftElFunctional2(List<Integer>list) {

        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); //  IKI TANE METHOD REFERE ETTIK
    }


   // Functional Programming ile list elemanlarinin cift olanlarinin 60 dan kucuk olanlari ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftAltmısKucuk(List<Integer>list){

            list.stream().filter(t-> t%2==0 & t<60).forEach(Lambda01::printEl);

    }

    // Functional Programming ile list elemanlarinin tek olanlarini veya  20 den buyuk olanlari ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printTekYirmiBuyuk(List<Integer>list){

            list.stream().filter(t-> t%2==1 || t>20).forEach(Lambda01::printEl);

    }

    // Functional Programming ile list elemanlarinin cif olanlarinin kareelerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftKare(List<Integer>list){

            list.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::printEl);

                // map() --> bir ara islemde kullanilir. Elemanlari istenilen isleme gore degistirmek update etmek icin kullanilir.

    }

    // Functional Programming ile list elemanlarinin tek olanlarinin kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printTekKupBirFazla(List<Integer>list){

            list.stream().filter(t-> t%2==1).map(t-> (t*t*t)+1).forEach(Lambda01::printEl);
    }

    // Functional Programming ile list elemanlarinin cift olanlarinin karekok  ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftKarekok(List<Integer>list){

            list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.println(t + " "));
    }

    // List'in en buyuk elemanini yazdiriniz

    public static void printEnBuyuk(List<Integer>list){

          Optional<Integer> maxEl = list.stream().reduce(Math::max);
               System.out.println(maxEl);

        // reduce() --> Azaltmak.. bir cok datayi tek bir dataya (max, min, carp, top vs islemlerde) cevirmek icin kullanilir
    }
}
