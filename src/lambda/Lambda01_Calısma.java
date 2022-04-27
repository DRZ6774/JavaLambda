package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01_Calısma {public static void main(String[] args) {

    List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

    printElStructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15  amelece


    printElFunctional(sayi);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15   Lambda Expression
    System.out.println("");

    printElFunctional1(sayi);//342216113520632165446664813815 ihtiyaca cevap vermez method referans
    System.out.println("");

    printElFunctional2(sayi);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15 method referans
    System.out.println("");

    printCiftElStructured(sayi);//34 22 16 20 44 66 64 38  amelece
    System.out.println("");

    printCiftElStructured1(sayi);//34 22 16 20 44 66 64 38
    System.out.println("");

    printCiftElStructured2(sayi);//34 22 16 20 44 66 64 38
    System.out.println("");

    printCiftElStructured3(sayi); //22 16 20
    System.out.println("");

    printCiftElStructured4(sayi);//34 22 16 35 20 63 65 44 66 64 81 38
}
    //Task1 : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            System.out.print(each + " ");
        }
    }
    //Task2 : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach(each -> System.out.print(each + " ")); //Lambda Expression
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print); //method referans
    }

    public static void yazdir(int a) { //tohum metod
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir); //method referans
    }
    //Task3 : Structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz

    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }
        }
    }
    //Task4 : Functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElStructured1(List<Integer> sayi) {
        sayi.
                stream().
                filter(each->each%2==0).
                forEach(Lambda01::yazdir);
    }
    public static boolean ciftBul(int a){  //tohum metod
        return a%2==0;
    }
    public static void printCiftElStructured2(List<Integer> sayi) {
        sayi.
                stream().//List elemanları akısa alındı
                filter(Lambda01::ciftBul). //cift bul metodu refere edilerek akıstakı elemanlar filtrelendi
                forEach(Lambda01::yazdir);//filtreden gelen elemanlar  yazdır() method ile refere edilerek print edildi
    }
    //Task5 : Functional Programming ile list elemanlarinin 34 den küçük cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElStructured3(List<Integer> sayi) {
        sayi.
                stream().
                //filter(each->each%2==0 && each<34).  Lambda Expression
                        filter(Lambda01::ciftBul).
                filter(each->each<34).
                forEach(Lambda01::yazdir);
    }
    //Task6 : Functional Programming ile list elemanlarinin 34 den buyuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElStructured4(List<Integer> sayi) {
        sayi.
                stream().
                filter(each->each%2==0|| each>34).
                forEach(Lambda01::yazdir);
    }
}
