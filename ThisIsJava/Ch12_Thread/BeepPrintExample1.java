package ThisIsJava.Ch12_Thread;
import java.awt.*;

public class BeepPrintExample1 {
    public static void main(String[] args){
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        for(int i=0;i<5;i++){
            toolkit.beep();
            try{Thread.sleep(2000);}
            catch(Exception e){}
        }
        for(int i=0;i<5;i++){
            System.out.println("띵");
            try{Thread.sleep(2000);}
            catch(Exception e){}
        }
    }
}
