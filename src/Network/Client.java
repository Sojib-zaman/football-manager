package Network;

import util.NetworkUtil;

public class Client {


    NetworkUtil networkUtil ;
    public Client(String clubname) {
        try {
            networkUtil= new NetworkUtil("127.0.0.1", 2222);
            System.out.println(clubname);
            networkUtil.write(clubname);
            new ReadThreadClient(networkUtil);
            //new WriteThreadClient();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }
}

