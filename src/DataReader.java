import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class DataReader implements Runnable{
    Socket actualSocket;
    ObjectInputStream objIn;
    MyCoolDataStructure inData;
    public DataReader(Socket actualSocket, MyCoolDataStructure inData) throws IOException {
        this.actualSocket = actualSocket;
        InputStream in = actualSocket.getInputStream();
         objIn = new ObjectInputStream(in);
        this.inData = inData;
    }

    public void run(){
    while(true){
        Object inMessage = null;
        try {
            inMessage = objIn.readObject();
            inData.put(inMessage);
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

}
