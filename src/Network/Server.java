package Network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Subclass.Player;
import sample.fileoperations;
import util.NetworkUtil;
public class Server
{
    private ServerSocket serverSocket;
    List<Player> playerList = new ArrayList<>();
    public static HashMap<String, NetworkUtil> clientMap;
    public static List<NetworkUtil> network_list = new ArrayList<NetworkUtil>();
    public static List<Player> getMarketplayerlist() {
        return marketplayerlist;
    }

    static List<Player>marketplayerlist = new ArrayList() ;
     List<Player>all ;

    Server() throws Exception {
        all = fileoperations.allplayer();
        clientMap = new HashMap<>();
        try {
            System.out.println("inside server");
            serverSocket = new ServerSocket(2222);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }
    public void serve(Socket clientSocket) throws Exception {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        network_list.add(networkUtil);
        String clientName = (String) networkUtil.read(); //client connected and writes his own name here
        clientMap.put(clientName, networkUtil);
        playerList = new ArrayList();
        for(Player p:all)
        {
            if(p.getClubname().equalsIgnoreCase(clientName))
                playerList.add(p);
        }

        new WritethreadServer(networkUtil , playerList ,marketplayerlist, clientName , all ) ;


    }

    public static void main(String args[]) throws Exception {

        Server server = new Server();

    }
}
