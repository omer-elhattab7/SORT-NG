
import java.util.Random;


public class arama {
    //random aRYY ULUŞTURMAK İCİN BİR METOD
    public static int [] random_aryy(int a){
        int[] aryy=new int[a];
        Random random=new Random();
        for(int i=0;i<a;i++){
            aryy[i]=random.nextInt(a);
            
        }
        return aryy;
    }
    //ARYY YAZDIRMAK İCİN 
    public static void aryy_print(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println(" ");
    }
    //KARŞILAŞTIRIB SIRALAMA
     public static int [] selectionsort(int []aryy){
        for(int i=0;i<aryy.length-1;i++){
            for(int j=i+1;j<aryy.length;j++){
               
               if(aryy[i]>aryy[j]){
                   int tmp=aryy[i];
                   aryy[i]=aryy[j];
                   aryy[j]=tmp;
               }
            }
        }
        return aryy;
              
    }
     //BİR ELMANI YANINDAKİYKLE YER DEĞİŞTİRİB SIRASLAMA
    
    public static int [] bubblesort(int[] aryy){
      for(int i=0;i<aryy.length;i++){//dış döngu
          for(int j=0;j<aryy.length-1;j++){//iç dongu
              if(aryy[j]>aryy[j+1]){
                  int gec=aryy[j];
                  aryy[j]=aryy[j+1];
                  aryy[j+1]=gec;
              }
          }
      }
        return aryy;
    }
    //BİR ELMANI ALIB DİZİ KAYDIRMA
    public static int [] comnbsort(int [] aryy){
        int n=aryy.length;
        int gap=n;
        boolean swatsh=true;
        while(gap!=1 || swatsh){
            gap=nextgap(gap);
            swatsh=false;
            for(int i=0;i<n-gap;i++){
                if(aryy[i]>aryy[i+gap]){
                    int gec=aryy[i];
                    aryy[i]=aryy[i+gap];
                    aryy[i+gap]=gec;
                }
            }
        }
        return aryy;
        
    }
    public static int nextgap( int gap){
        gap=(gap*10)/13;
        if(gap<1){
            return 1;
        }
        return gap;
    }
    //DOĞRUSAL ARAMA 
  
    public static int linear_search(int [] aryy,int x){
         for(int i=0;i<aryy.length;i++){
            if(aryy[i]==x){
                return i;
            }
        }
     
     return -1;
    }
    //İKİLİ ARAMA
       
    public static int birnerysearch(int[] aryy,int elman){

        int low=0;
        int high=aryy.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(aryy[mid]==elman){
                return mid;   
            }
            else if(aryy[mid]<elman){
                low=mid+1;
            }
            else if(aryy[mid]>elman){
                high=mid-1;
            }
        } return -1;
    }
    public static void liner_olcmek(int[] aryy ,int değer){
       
         long startTime = System.nanoTime();
        
        birnerysearch(aryy, değer);
        
       
       long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(" liner çalışma zamanı "+totalTime);
    }
    
    public static void main(String[] args) {

       int[] randomaryy=random_aryy(100000000);
        
        int değer =randomaryy[100000000-2];
       int[] comb1=comnbsort(randomaryy);
         
        //briny çalışma hızı performansı olcmek 
        long startTime = System.nanoTime();
        birnerysearch(comb1, değer);
       long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(" birny çalışma zamanı "+totalTime);
       //briny çalışma hızı performansı olcmek 
        liner_olcmek(comb1, değer);
        
     
     
        
    }
    
}
