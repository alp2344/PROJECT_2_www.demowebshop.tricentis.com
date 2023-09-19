package Utility;

public class MyFunc {
    public static void bekle(int sn){

        try {
            Thread.sleep(sn*1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
