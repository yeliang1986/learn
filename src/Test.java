import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {
        try{
            throw new Exception("1");
        }catch (IOException e){
            throw new Exception("2");
        }catch (Exception e) {
            throw new Exception("3");
        }finally {
            throw new Exception("4");
        }
    }
}
