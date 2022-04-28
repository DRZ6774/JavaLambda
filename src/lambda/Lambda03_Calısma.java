package lambda;

import java.util.*;

public class Lambda03_Calısma {
    public static void main(String[] args) {

        List<String> menü=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havucDilim","buryan",
                "yaglama","kokareç","arabAşı","güveç","trileçe","trileçe","trileçe","Waffle"));
        alfBykTekrrsz (menü);
        System.out.println("\n========***============   "); //KÜŞLEME ADANA TRİLEÇE HAVUCDİLİM BURYAN YAGLAMA KOKAREÇ ARABAŞI GÜVEÇ

        characterSayisiniTersSiraliTekrarsiz(menü);
        System.out.println("\n========***============   "); //10 7 6 5

        characterSayisinaKcktenByk(menü);//adana güveç buryan küşleme trileçe yaglama kokareç arabAşı trileçe trileçe trileçe havucDilim
        System.out.println("\n========***============   ");

        sonHrfBkSirala(menü); //arabAşı kokareç güveç buryan havucDilim küşleme trileçe trileçe trileçe trileçe adana yaglama
        System.out.println("\n========***============   ");

        charKaresiCiftElSirala(menü);//100 36
        System.out.println("\n========***============   ");

        harfSayisi7denAzKontrol(menü); //7 den fazla karaktere sahip
        System.out.println("\n========***============   ");//7 den fazla karaktere sahip

        wIleBaslayanElKontrol(menü);//w ile baslayan var
        System.out.println("\n========***============   ");

        xIleBitenElKontrol(menü);//x ile baslayan var
        System.out.println("\n========***============   ");

        charSayisiBykElPrint(menü);//Optional[havucDilim]
        System.out.println("\n========***============   ");

        ilkElHarcSonHrfSiraliPrint(menü);//yaglama küşleme trileçe trileçe trileçe trileçe Waffle havucDilim buryan kokareç güveç arabAşı
        System.out.println("\n========***============   ");

    }
    // Task1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
     public static void alfBykTekrrsz(List<String> menü) {
        menü.stream().map(String::toUpperCase).distinct().forEach(each-> System.out.print(each+" "));
     }
   // Task2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void characterSayisiniTersSiraliTekrarsiz(List<String> menü) {

        menü.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(each-> System.out.print(each+" "));

    }
    // Task3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void characterSayisinaKcktenByk(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(String::length)).forEach(each-> System.out.print(each+" "));

    }
    // Task4: list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(each->each.toString().charAt(each.toString().length()-1)).reversed()).forEach(each-> System.out.print(each+" "));
    }
    // Task5 : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.stream().map(each->each.length()*each.length()).filter(Lambda01::ciftBul).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir);
    }
    // Task6 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menü) {

        boolean kontrol=menü.stream().allMatch(each->each.length()<=7);
        if (kontrol){
            System.out.println("7 ve daha az karaktere sahip");
        }else {
            System.out.println("7 den fazla karaktere sahip");
        }

        System.out.println(menü.stream().allMatch(each->each.length()<=7) ? "7 ve daha az karaktere sahip":"7 den fazla karaktere sahip");
    }
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menü) {
        System.out.println(menü.stream().noneMatch(each->each.startsWith("W")) ? "w baslayan var":"w ile baslayan yok");
    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> menü) {
        System.out.println(menü.stream().allMatch(each->each.endsWith("x"))? "x baslayan yok":"x ile baslayan var");
    }
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiBykElPrint(List<String> menü) {
        System.out.println(menü.stream().sorted(Comparator.comparing(each->each.toString().length()).reversed()).findFirst());
        Optional<String> enBuyukEleman=menü.stream().sorted(Comparator.comparing(each->each.toString().length()).reversed()).findFirst();
        System.out.println(enBuyukEleman);
    }
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHarcSonHrfSiraliPrint(List<String> menü) {
        menü.stream().sorted(Comparator.comparing(each->each.charAt(each.length()-1))).skip(1).forEach(each-> System.out.print(each+" "));
    }


}
