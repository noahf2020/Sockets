import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        int port = 3256;

        System.out.println("connecting to server");
        Socket newSocket = new Socket("10.37.159.214",port);
        OutputStream out =  newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject("Hi Mr. Hernandez, Noah");
        System.out.println("Sent -> ");
        objOut.writeObject("Hi Mr. Hernandez, Noah2");
        System.out.println("Sent -> ");

        MyCoolDataStructure Queue = new MyCoolDataStructure();
        DataReader myReader = new DataReader(newSocket,Queue);
        ProgramLogic logic = new ProgramLogic(Queue);
        Thread DataReadThread = new Thread(myReader);
        Thread logicThread = new Thread(logic);
        DataReadThread.start();
        logicThread.start();

//        InputStream in = newSocket.getInputStream();
//        ObjectInputStream objIn = new ObjectInputStream(in);
//        Object message = objIn.readObject();
//        System.out.println(message);
    }
}