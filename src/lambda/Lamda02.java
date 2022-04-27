package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lamda02 {
    public static void main(String[] args) {


        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("");

        tekKupFazlaPrint(sayi);
        System.out.println("");

        ciftKarePrint1(sayi);
        System.out.println("");

        listEnBuyukEleman(sayi);
        System.out.println("");

        karelerininEnBuyugu(sayi);
        System.out.println("");

        listElemanTopla(sayi);
        System.out.println("");

        listElemanTopla1(sayi);
        System.out.println("");

        ciftSayılarınCarpımları(sayi);
        System.out.println("");

        ciftSayılarınCarpımları2(sayi);
        System.out.println("");
    }
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(each -> each * each).forEach(Lambda01::yazdir);
    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static void tekKupFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(each -> each % 2 == 1).
                map(each -> (each * each * each) + 1).
                forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarePrint1(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(each -> System.out.print(each + ""));
    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void listEnBuyukEleman(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);
        System.out.println(maxSayi);
        /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void karelerininEnBuyugu(List<Integer> sayi) {
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
    public static void listElemanTopla(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(Integer::sum));
    }

    public static void listElemanTopla1(List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(0, (a, b) -> a + b));
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftSayılarınCarpımları(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));
    }
    public static void ciftSayılarınCarpımları2(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b)));
    }
}