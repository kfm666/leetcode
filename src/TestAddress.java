
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestAddress{

    public static void main(String[] args) throws IOException {
        new Thread().start();
    }

    public static void test() throws IOException {
        Process process = Runtime.getRuntime().exec("ipconfig");
        InputStream stream = process.getInputStream();
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int s = 0;
        while (( s = stream.read(bytes))!=-1){
            os.write(bytes,0,s);
        }

        System.out.println(new String(os.toByteArray(), "GBK"));
    }

}
