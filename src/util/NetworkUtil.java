package util;

import Subclass.Playersoftheclub;
import Subclass.Playersofthemarket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkUtil {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public NetworkUtil(String s, int port) throws IOException { //for client
        this.socket = new Socket(s, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public NetworkUtil(Socket s) throws IOException { //for server
        this.socket = s;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readUnshared(); //serialized
    }

    public void write(Object o) throws IOException {
        System.out.println("pailam mama");
        if(o instanceof Playersoftheclub)
            System.out.println(((Playersoftheclub) o).getPlayerList().size());
        if(o instanceof Playersofthemarket)
            System.out.println(((Playersofthemarket) o).getPlayerList().size());
        oos.writeUnshared(o);
        oos.flush();
        oos.reset();
    }

    public void closeConnection() throws IOException {
        ois.close();
        oos.close();
    }
}

