package Betul_Mentol;

import java.util.Arrays;

public class MethodCreation {
    public static void main(String[] args)
    {
        //--------------------Soru-1:
        String str = "bugün hava çok güzel ";
        String sonuc1 = camelcase(str);
        System.out.println("methodCamelcase: "+sonuc1);

        //--------------------Soru-2:
        String[] countryNames = {"USA" ,"Mexico" ,"Canada"};
        int[] countryPopulation = {100000 , 120000 , 130000};
        String str2 = "Mexico";
        int population=  populationOfCountry(str2, countryNames, countryPopulation);
        System.out.println("methodPopulationOfCountry: "+population);

        //--------------------Soru-3:
        int sayi1 = 10;
        int sayi2 = 5;
        System.out.println(getSumOfSquares(sayi1));
        System.out.println(getSumOfSquares(sayi2));
        System.out.println("methodSubstSquare: "+substSquare(sayi1, sayi2));

        //--------------------Soru-4:
        int[] arr ={1,2,3,4,5};
        System.out.println("threeEvenOrOdd: "+threeEvenOrOdd(arr));

        //--------------------Soru-5:
        int[] arr5 = { 1,6,12,15,22,18,30,16};
        int num1 = 10;
        int num2 = 20;
        System.out.println("URange: "+URange(arr5, num1, num2));


    }

    //-----------------------------Soru 1:
    /*CamelCase : camelcase adında Kendisine gönderilen bir cümledeki kelimelerin ilk karakterlerini
                büyük harfe çevirip geri döndüren metodun yazınız.
                Örnek:  bugün hava çok güzel    Result : Bugün Hava Çok Güzel */
    public static String camelcase(String s)
    {
        String[] arr = s.trim().split("\\s+"); // " " -> yanyana birden fazla boşluk olduğunda bu boş dizeler yaratabilir, \\s+ -> birden fazla boşluğu birleştirerek eşler
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i].substring(0,1).toUpperCase()+arr[i].substring(1).toLowerCase();
        }
        for (String w : arr){
            sb.append(w);   //arr arrayındaki kelimeleri StringBuilder a ekliyoruz
            sb.append(" "); // her kelimenin ardından boşluk bırakıyoruz.
        }

        return sb.toString().trim() ; //sb 'yi toString ile String e dönüştürdük, Trim ile eklediğimiz sondaki boşluğu kaldırdık.
    }

    //-----------------------------Soru 2:
    /*getPopulation:
          main de aşağıdaki isimlerle Array leri tanımlayınız.Verilen örnek değerleri kullanabilirsiniz.
          countryNames Ülke isimleri
          countryPopulations Ülke nüfusları
        populationOfCountry adında bir metod yaznız.
        Bu method 1 String array(countryNames) , 1 int array (countryPopulations) ve  1 String (ulkeAdi) alacak
        Eğer Ülke adı countryNames de var ise, aynı sıradaki ülke nüfusunu diğer Array den bulup geri
        göndersin.
          Ornegin;
          countryNames = {"USA" ,"Mexico" ,"Canada"}
          countryPopulations = {100000 , 120000 , 130000}
          str = "Mexico"
          return 120000 olmali
          NOT : eger (ulkeAdi) icin verilen ulke countryNames icinde yoksa return -1 olmali */
    private static int populationOfCountry(String name,String[] arrString, int[] arrInt)
    { int population = -1;

        for (int i = 0; i <arrString.length ; i++) {
            if(arrString[i].toLowerCase().equals(name.toLowerCase())){
                population=arrInt[i];
                break;
            }
        }
        return  population;
    }

    //--------------------------Soru 3:
    /*SubtractionSquare:
       getSumOfSquares adında bir sayı alan ve bu sayıya kadar olan sayıları
       toplayıp çıkan sonucun karesini döndüren bir metod yazınız.
       substSquare isminde 2 adet int parametre alan ve int sonuç döndüren bir metod daha yazınız.
       main den   substSquare   metoduna 2 tane sayı gönderiniz, bu metodun içinden de
       getSumOfSquares metodunu çağırarak gönderilen bu iki sayı için işlem sonuçlarını toplayarak
       main metodundan yazdırınız.
       Örnek:
        int 1 = 10;              yazacağınız method 10 u kullanarak 3025 sonucu verir
        int 2 = 5;                yazacağınız method 5 i kullanarak 225 sonucu verir
        3025 + 225 = 3250
        return 3250 */

    private static int getSumOfSquares(int a )
    {
        int sum = 0;

        for (int i = 1; i <=a ; i++) {
            sum = sum + i;
        }

        return sum*sum;
    }

    private static int substSquare(int a, int b){
        int sum = getSumOfSquares(a) + getSumOfSquares(b);
        return sum;
    }


    //--------------------------Soru 4:
    /*ThreeEvenOdd
      threeEvenOrOdd  isminde int Array paramaetre alan bir metod yazınız. Bu metod kendisine
      gönderilen Array de 3 tane çift veya 3 tane tek var ise true geri döndürsün. Yok ise
      false göndersin.
      Örnek:
       intArray([2, 1, 3, 5]) sonuc  true olmalı
       intArray([2, 1, 2, 5]) sonuc   false olmalı
       intArray([2, 4, 2, 5]) sonuc   true olmalı*/
    private static boolean threeEvenOrOdd(int[] arr)
    {
        boolean cntrl = false;
        int sayacTek = 0 ;
        int sayacCift = 0 ;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i]%2==0){
                sayacCift++;
                if (sayacCift==3){
                    cntrl=true;
                    break;
                }
            } else{
                sayacTek++;
                if(sayacTek==3){
                    cntrl =true;
                    break;
                }
            }
        }
        return cntrl;
    }


    //---------------------------------Soru 5:
    /*UpdateRange
      URange isminde bir metod yazınız,
      Bu metod parametre olarak int Array ve 2 adet int almalı.
      Metod kendisine gönderilen Array ın içindeki elemanlardan, yine kendisine gönderilen
      rakamlar arasında olanlarına -1 değerini atasın.oluşan yeni diziyi göndersin.main de yazdırınız.
      Örnek:
       int array = 1,6,12,15,22,18,30,16
       int 1 = 10
       int 2 = 20
       sonuc  1,6,-1,-1,22,-1,30,-1  olmalı.*/

    public static String URange(int[] arr, int a, int b){
        for (int i = 0; i < arr.length; i++)
        {
            if ((arr[i]<a && arr[i]>b) ||(arr[i]<b && arr[i]>a))
            {
                arr[i]=-1;
            }
        }

        return Arrays.toString(arr);
    }









}