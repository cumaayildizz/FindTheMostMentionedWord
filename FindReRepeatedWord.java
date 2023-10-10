package FindTheMostMentionedWord;

import java.util.*;

public class FindReRepeatedWord {
    Scanner scanner = new Scanner(System.in);

   public  void run(){

       System.out.println();
       System.out.println("Lütfen metninizi yazınız");
       System.out.println("==================================================================================================");
       String text = scanner.nextLine().toLowerCase(); //Butun texti kucuk harflere cevirdik
       System.out.println("==================================================================================================");
       hashMapMake(textWordArr(text)); //HasMap metoduna textlerden olusturdugumuz diziyi attik
       System.out.println("==================================================================================================");

   }

   public String[] textWordArr(String text){ //verilen metni diziye ceviren metod
       System.out.println(text);
       String[] arr = text.split(" "); //textte her gordugumuz bosluk sonrasindaki yeri ayri bir eleman olarak diziye atiyoruz.
       return arr;                            //Bu sekilde bosluk sonrasidaki her kelime ayri bir dizi icine alinmis olacak
   }

   public void hashMapMake(String arr[]){ //HashMap olusturup split komutu ile kelimeleren olusan diziyi icerisine alabilecek bir metod yazdik


       HashMap<String , Integer> hMapWords = new HashMap<>();
       for (String word : arr ){ // Burda HashMapin elemanlarini geziyoruz
           if(!hMapWords.containsKey(word)){  // Eger i(word) elemani dizide yoksa sayaca(Hmap value degeri) 1 yaziyoruz
               hMapWords.put(word , 1);
           }else {    //Eger forEach ile gezen eleman dizide varsa bunun mevcut sayac degerine 1 ekle(hMapWords.get(word)++ da yazabilirdik)
               hMapWords.put(word , hMapWords.get(word) + 1);
           }

       }
       System.out.println("==================================================================================================");
       enCokTekrarEden(hMapWords); //Olusturdugumuz en cok tekrar eden kelimeyi bulma metoduna HashMapimizi attik
       System.out.println("==================================================================================================");
       System.out.print("Butun kelimelerin tekrar sayisini gormek istiyorsaniz 0 a basin : ");
       int selectNumber = scanner.nextInt();
       System.out.println("==================================================================================================");

       if (selectNumber == 0){ //kullanici 0 i secerse butun kelimelerin tekrar sayilarini ekrana bas
           printTekrarSayisi(hMapWords);
       }

   }

   public void enCokTekrarEden( HashMap <String,Integer> enCokTekrar){ //en cok tekrar eden kelimeyi bulma metodumuz
       int max = 1;  //ilk basta max=1 dememizin sebebi her kelimeden en az 1 adet bulunmasi
       String maxWord = ""; //Max tekrar sayisina sahip kelimemiz ise baslangicta empty yani bo; olarak verdik(herhangi baska string bir deger de verilebilirdi)
       for (String x : enCokTekrar.keySet()){ //bize degeri verir(Yani burda ulke adlari)

           if (enCokTekrar.get(x).intValue() > max){ //x degerinin sayaci > max ise benim mevcut maxsim x in sayac degeridir
               max = enCokTekrar.get(x).intValue();
               maxWord = x.toString(); //her donguye girebilen x icin kelimeyi yazdir. En son donguye girmeyi basaran kelime en cok tekrar eden kelimedir
           }
       }
       System.out.println("Bu dizide en cok tekrar eden kelime  " + maxWord + "  ve tekrar sayisi : " + max );
   }

    public void printTekrarSayisi( HashMap <String,Integer> hMAp){ //butun kelimeleri HashMapte gezip tekrar sayilarini yazdigimiz metod
        for(Map.Entry<String,Integer> x : hMAp.entrySet()){
            System.out.println(x.getKey() + " kelimesi " + x.getValue() + " kere tekrarlandi");
        }
    }




}


