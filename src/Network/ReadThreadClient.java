package Network;

import Subclass.Player;
import Subclass.Playersoftheclub;
import Subclass.Playersofthemarket;
import util.NetworkUtil;

public class ReadThreadClient implements  Runnable {
    private static Playersoftheclub obj;
    private static Playersofthemarket obj2 ;

    private Thread thread;
    private NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {

                Object o = networkUtil.read();
                if (o instanceof Playersoftheclub)
                {
                     obj = (Playersoftheclub) o;
                     //for (Player p:obj.getPlayerList()) System.out.println("IN READ THREAD CLIENT : "+p.getPlayername());

                }
                if(o instanceof Playersofthemarket)
                {

                    obj2 = (Playersofthemarket) o;
                   // for(Player p:obj2.marketplayer)
                        //System.out.println(p.getPlayername() + " obj2");
                }

            }
        } catch (Exception e) {
            System.out.println(e + "PROBLEM HERE");
        }
    }

    public static Playersoftheclub getlist() {
        return obj;
    }
    public static Playersofthemarket getmarketlist()
    {
            return obj2;
    }
}
