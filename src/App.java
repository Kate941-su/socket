import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = new int[100];
        int[] b;
        b = a;
        
        for (int i = 0;i < a.length; i++) {
            a[i] = i;
//            System.out.println(a[i]);
        }
        b[0] = 100;
        System.out.println(a[0]);
        String str = "hello";
        String str2 = "world";
        String str3 = "japan";
        String str4 = str + str2;
        String[] strarr = {str,str2,str3};
        System.out.println(str4);
        for(String st:strarr){
            System.out.println(st);
        }
       System.out.println(str2.equals(str3)); 
       sample c = new sample();
       System.out.println(c.a);

    }
}
