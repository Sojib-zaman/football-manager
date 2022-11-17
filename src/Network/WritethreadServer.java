package Network;
import Subclass.Boughtplayerinfo;
import Subclass.Player;
import Subclass.Soldplayerinfo;
import Subclass.Playersoftheclub;
import Subclass.Playersofthemarket;
import util.NetworkUtil;
import java.io.IOException;
import java.util.List;
public class WritethreadServer implements Runnable
{
    NetworkUtil networkUtil ;
    String clientname ;
    Thread thread ;
    List<Player>playersoftheclub;
    List<Player>marketplayers;
    List<Player>allplayers;
    List<Player>newplayers;

    public WritethreadServer(NetworkUtil networkUtil, List<Player> playerList, List<Player> market, String clientName, List<Player> all)
    {
        this.allplayers = all ;
        this.networkUtil = networkUtil ;
        this.clientname = clientName ;

        playersoftheclub = playerList ;
        thread = new Thread(this) ;
        marketplayers = market ;
        thread.start();
    }
    @Override
    public void run()
    {
        if(networkUtil!=null) {
            try {


                    Playersoftheclub obj = new Playersoftheclub(playersoftheclub);
                    networkUtil.write(obj);
                    Playersofthemarket obj2 = new Playersofthemarket(marketplayers);
                    networkUtil.write(obj2);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(networkUtil!=null) {
            try {
                while (true) {
                    Object obj = networkUtil.read();

                    if (obj instanceof Soldplayerinfo)
                    {
                        Soldplayerinfo player = (Soldplayerinfo) obj ;
                        //System.out.println(player.player.getPlayername());
                        marketplayers.add(player.getPlayer());
                        //System.out.println(player.player);
                        for(Player p : playersoftheclub)
                        {
                            if(p.getPlayername().equals(player.getPlayer().getPlayername()))
                            {
                                p.isinmarket = 1 ;
                                playersoftheclub.remove(p);
                                break;
                            }
                        }
                        for(Player p:playersoftheclub) System.out.println(p.getPlayername());

                    }
                    //trying to buy
                    if(obj instanceof Boughtplayerinfo)
                    {

                        Boughtplayerinfo player = (Boughtplayerinfo) obj ;
                        System.out.println("Trying to buy "+player.getBoughtplayer().getPlayername());

                        playersoftheclub.add(player.getBoughtplayer());
                        for(Player p:allplayers)
                        {
                            if(p.getPlayername().equals(player.getBoughtplayer().getPlayername()))
                                p.setClubname(clientname);
                        }
                       for(Player p:marketplayers)
                       {
                           if(p.getPlayername().equals(player.getBoughtplayer().getPlayername()))
                           {
                               p.isinmarket = 0 ;
                               marketplayers.remove(p) ;
                               break;
                           }
                       }
                    }
                    //upto this
                    Playersoftheclub obj1 = new Playersoftheclub(playersoftheclub);
                    for(Player p:obj1.getPlayerList()) System.out.println(p.getPlayername() + "market player on bought");
                    networkUtil.write(obj1);
                    /*
                    for(int i = 0; i< Server.network_list.size(); i++) {
                        Playersofthemarket obj2 = new Playersofthemarket(marketplayers);
                        Server.network_list.get(i).write(obj2);
                        //networkUtil.write(obj2);
                    }

                     */

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    networkUtil.closeConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }




    }

    private void showmarket() {
        for(Player p:marketplayers) System.out.println(p.getPosition());
    }


}
