package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
	 	1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
	 	   Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
	       Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
	 	   Lambda’lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
	   	   Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	     	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
           Lambda kullanmak hatasız code kullanmaktır.

            Collections Nedir?
            Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
            yapar. Array’ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
            yaptığı gibi, daha fazlasını da yapar.
            Java’da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
            topluluğu bir arada tutan bir yapıdır. ‘Collections Framework’ ise arayüzler ve onların kurgularından
            (implementations) oluşur.
	 */
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15  amelece
        System.out.println("");

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
    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            System.out.print(each + " ");
        }
    }
    //Task : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi) {
        sayi.
                stream().
                forEach(each -> System.out.print(each + " ")); //Lambda Expression
    }
/*
        stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        forEach() :datanin parametresine gore her bir elemanı isler
        t-> : Lambda operatoru
         Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
             -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
             Body: Expressionları ve statementları içerir.

            Bir kod bloğundan oluşan bir body...
            Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
            Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                () -> {
                 double pi = 3.1415;
                    return pi;
                };
       ahanda trick köşeşinde bugun :   Lambda Expression  yapisi cok tavsiye edilmez
        daha cok METHOD REFERENCE kullanilir

        */

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
    //Task : Structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz

    public static void printCiftElStructured(List<Integer> sayi) {
        for (Integer each : sayi) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }
        }
    }
    //Task : Functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
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
    //Task : Functional Programming ile list elemanlarinin 34 den küçük cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElStructured3(List<Integer> sayi) {
        sayi.
                stream().
                //filter(each->each%2==0 && each<34).  Lambda Expression
                filter(Lambda01::ciftBul).
                filter(each->each<34).
                forEach(Lambda01::yazdir);
    }
//Task : Functional Programming ile list elemanlarinin 34 den buyuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElStructured4(List<Integer> sayi) {
    sayi.
            stream().
            filter(each->each%2==0|| each>34).
            forEach(Lambda01::yazdir);
}


}