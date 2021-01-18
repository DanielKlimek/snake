
package hadik;

 import java.util.Scanner;
 class hra {
   
public static void main(String[] args){
   Scanner scanner = new Scanner(System.in); 
    svet a = new svet(10,5);
    a.init();
    a.kreslenie();



    while(true){
        //get input 
        char smer = scanner.next().charAt(0);

        //apply input 
        a.getHadik().smer = smer;

        //simulate 
        a.pohyb();

        //rendering
        a.kreslenie();
    }
}}


