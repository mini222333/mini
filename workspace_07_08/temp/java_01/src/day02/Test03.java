package day02;

public class Test03 {
	public static void main(String[] args) {
        int x = 600, y= 700;
        System.out.println("x="+x+", y="+y);
        System.out.printf("x=%d, y=%d %n",x,y);
        
       int temp = x;
       x=y;
       y=temp;
         
        System.out.printf("x=%d, y=%d %n",x,y);
        System.out.println("-------------------------");
        
        double d1 = 99.15689,d2=77.34677;
        //System.out.printf("d1=%f , d2=%f %n" ,d1,d2);
        System.out.printf("d1=%5.2f , d2=%5.2f %n" ,d1,d2);

        double temp2 = d1;
        d1=d2;		
        d2=temp2;
        
        System.out.printf("d1=%5.2f , d2=%5.2f %n" ,d1,d2);
        
        
   }
}
