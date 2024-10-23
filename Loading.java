
package netflix;

public class Loading {
    public void loading(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
