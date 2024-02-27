
import com.sun.jna.Library;
import  com.sun.jna.Native;

public interface Pkcs7 extends Library{
    Pkcs7 INSTANCE = (Pkcs7) Native.loadLibrary("src/main/resources/windows/pkcs7", Pkcs7.class);
    String Encrypt(byte[] content,int contentLenth,byte[] certBytes,int certBytesLenth);
    String Decrypt(byte[] content,int contentLenth,byte[] certBytes,int certBytesLenth);
}
