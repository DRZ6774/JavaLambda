package lambda;

import lambdaSearch.Lambda02;

import java.util.*;

public class Lambda02_Calısma {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        listinCıftElemanlarınınKaresi(sayi); //16 4 36
        System.out.println("\n");

        listinTekElemanlarınınKüpleri(sayi);//1332 -124 344 28 3376
        System.out.println("\n");

        listinCiftKarakok(sayi);//2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n");

        listinEnBuyukElemanı(sayi); //Optional[15]
        System.out.println("\n");

        listinCıftElemanlarınınKaresininEnBuyugu(sayi); //Optional[36]
        System.out.println("\n");

        listinTumEleanlsrınToplamı(sayi); // 43
                                          // Optional[43]
        System.out.println("\n");

        listinCıftEleanlsrınToplamı(sayi); //Optional[48]
                                           // 48
        System.out.println("\n");
        minBul(sayi);

        System.out.println("\n");
        bestenBykEnKck(sayi);

        System.out.println("\n");
        ciftKareKbPrint(sayi);

        System.out.println("\n");
        tekKareBkPrint(sayi);

        System.out.println("\n");
    }
    // Task1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void listinCıftElemanlarınınKaresi(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(each -> each * each).
                forEach(Lambda01::yazdir);
    }

    // Task2 : Functional Programming ile listin tek elemanlarinin  kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void listinTekElemanlarınınKüpleri(List<Integer> sayi) {
        sayi.
                stream().
                filter(each -> each % 2 != 0).
                map(each -> (each * each * each) + 1).
                forEach(Lambda01::yazdir);
    }

    // Task3: Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void listinCiftKarakok(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(each -> System.out.print(each + " "));
    }

    // Task4: list'in en buyuk elemanini yazdiriniz
    public static void listinEnBuyukElemanı(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);
        System.out.println(maxSayi);
        System.out.println(sayi.stream().reduce(Math::max));
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void listinCıftElemanlarınınKaresininEnBuyugu(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(each -> each * each).
                reduce(Math::max));

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(each -> each * each).
                reduce(Integer::max));
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void listinTumEleanlsrınToplamı(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(0, (a, b) -> (a + b)));
        System.out.println(sayi.stream().reduce(Integer::sum));

    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void listinCıftEleanlsrınToplamı(List<Integer> sayi) {
        //method ref ile
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
        //Lambda Expression
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b)));

    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);  //Optional[-5]
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath); //Optional[-5]
        //3. yontem Lambda Expression
        int minSayiLambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLambda); //-5
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiHaluk = sayi.stream().reduce(Lambda02::byHalukMin);
        System.out.println(minSayiHaluk);//Optional[-5]
    }
    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(each -> each > 5 && each % 2 == 1).reduce(Lambda02::byHalukMin)); //Optional[7]
    }
    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbPrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(each->each*each).sorted().forEach(Lambda01::yazdir); //4 16 36
    }
    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBkPrint(List<Integer> sayi) {
        sayi.stream().filter(each->each%2==1).map(each->each*each).sorted(Comparator.reverseOrder()).forEach(Lambda01::yazdir); //225 121 49 9
    }
}