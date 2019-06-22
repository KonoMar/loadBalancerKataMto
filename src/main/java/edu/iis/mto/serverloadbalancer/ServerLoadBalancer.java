package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {
    public void balance(Server[] servers, Vm[] vms) {

        for (Vm vm : vms) {
            Server lessLoadedServer = null;
            for (Server server : servers) {
                if(lessLoadedServer == null || server.currentLoadPercentage < lessLoadedServer.currentLoadPercentage) {
                    lessLoadedServer = server;
                }

            }

            lessLoadedServer.addVm(vm);
        }
    }
}
