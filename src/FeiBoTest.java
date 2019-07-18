import java.util.*;

public class FeiBoTest {

    Long temp = 0L;
    public static void main(String[] args) {
        Integer len = 0;
        Long count = 0L;
        long a = 1 ;
        long b = 1;
        long c =0;
        while(len<100000){
            c = a+b;
            a = b;
            b = c;
            len = Long.toString(c).length();
            count ++;
            System.out.println("len="+len+";count="+count);
        }
    }

}
