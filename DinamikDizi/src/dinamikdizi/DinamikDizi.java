
package dinamikdizi;
import java.util.Scanner;


public class DinamikDizi {

    
    
    private int[] dinamikDizi;
    
    private int boyut;
    
    private int kapasite;
    
    private static final int Varsayılan_Kapasite = 5;
    
    public DinamikDizi(){
        this.kapasite = Varsayılan_Kapasite;
        dinamikDizi = new int[Varsayılan_Kapasite];
    }
    public DinamikDizi(int[] dinamikDizi, int kapasite){
        this.kapasite = kapasite;
        dinamikDizi = new int[kapasite];
    }
    
    public  void Ekle(int veri){
        if (boyut == kapasite) {
            Yeniden_Boyutlandir();
        }
        dinamikDizi[boyut] = veri;
        boyut++;
        
    }

    private void Yeniden_Boyutlandir() {
        int[] yeniDinamikDizi = new int[kapasite*2];
        for (int i = 0; i < kapasite; i++) {
            yeniDinamikDizi[i] = dinamikDizi[i];
        }
        dinamikDizi = yeniDinamikDizi;
        
        this.kapasite = kapasite*2;
        
     
    }
    
    public int boyut(){
        return this.boyut;
    }
    
    
    public void ekle(int veri , int index){
        if (boyut == kapasite) {
           Yeniden_Boyutlandir();
        }
           
        for (int j = boyut; j > index; j--) {
            dinamikDizi[j]=dinamikDizi[j-1];
        }
        
        
         dinamikDizi[index] = veri;
         boyut++;
    }
    
    public void sil(){        
        int[] geciciDizi = new int[kapasite];
        dinamikDizi = geciciDizi;
        
    }
    
    public void sil(int veri){
        int silinecekindex = veriarama(veri);
        for (int i = silinecekindex; i < boyut-1; i++) {
            dinamikDizi[i] = dinamikDizi[i+1];
        }
        boyut--;
    }
    public void silindex(int index){
        for (int i = index; i < boyut-1; i++) {
            dinamikDizi[i] = dinamikDizi[i+1];
        }
        boyut--;
    }
    
    public int veriarama(int gelenveri){
        for (int i = 0; i < boyut-1; i++) {
            if (gelenveri == dinamikDizi[i]) {
                return i;
            }
            
        }
        return -1;
    }
    
    public void temizle(){
        kapasite=Varsayılan_Kapasite;
        int[] geciciDizi = new int[kapasite];
        dinamikDizi = geciciDizi;
    }
    
    public int kapasite(){
        return kapasite;
    }
    public void yazdir(){
        System.out.println("Dizi elemanları:");
        for (int i = 0; i < boyut; i++) {            
            System.out.println(i+" - "+ dinamikDizi[i]);
        }
    }
    public static void main(String[] args) {
        Scanner girdi = new Scanner(System.in);
        DinamikDizi dizi = new DinamikDizi();
        int secim = 0;
       
        
        System.out.println("Dizi oluşturuldu.");
        Secim:
        while(true){
        System.out.println("Lütfen Yapmak istediğiniz işlemi giriniz.");
        System.out.println("1- Veri Ekle");
        System.out.println("2- Veri Sil");
        System.out.println("3- Kapasite Sorgula");
        System.out.println("4- Temizle");
        System.out.println("5- Diziyi Görüntüle");
        System.out.println("6- Çıkış");
        
        secim = girdi.nextInt();
        
        switch(secim){
            case 1:
               System.out.print("Eklemek istediğiniz sayıyı giriniz:");
               int girilenSayi = girdi.nextInt();
               dizi.Ekle(girilenSayi);
               System.out.println(girilenSayi+" Sayısı eklenmiştir");
               continue Secim;
               
            case 2:
                System.out.println("Silmek istediğiniz yöntemi seçiniz.");
                System.out.println("1- Dizinin tüm elemanlarını Sil");
                System.out.println("1- Veri girerek Sil");
                System.out.println("1- İndex ile sil");
                secim = girdi.nextInt();
                switch(secim){
                    case 1:
                        dizi.sil();
                        System.out.println("Dizinin tüm elemanları silindi");
                        continue Secim;
                    case 2:
                        System.out.print("Silmek istediğiniz veriyi giriniz:");
                        girilenSayi = girdi.nextInt();
                        dizi.sil(girilenSayi);
                        System.out.println(girilenSayi+" Sayısı diziden silinmiştir");
                        continue Secim;
                    case 3:
                        System.out.print("Silmek istediğiniz indexi giriniz:");
                        girilenSayi = girdi.nextInt();
                        dizi.silindex(girilenSayi);
                        System.out.println(girilenSayi+" indexindeki veri diziden silinmiştir");
                        continue Secim;
                        
                }
            case 3:
                System.out.println("Dizinin kapasitesi = "+dizi.kapasite());
                continue Secim;
                
            case 4:
                dizi.temizle();
                System.out.println("Dizi başarıyla temizlenmiştir.");
                continue Secim;
                
            case 5:
                dizi.yazdir();
                continue Secim;
            case 6:
                break;
            }
        }

    }
}
