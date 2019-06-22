package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class ServerLoadBalancer {

    public void balance(Server[] servers, Vm[] vms) {
        for (Vm vm : vms) {
            addToLessLoadedServer(servers, vm);
        }
    }

    private void addToLessLoadedServer(Server[] servers, Vm vm) {
        List<Server> capableServers = new ArrayList<>();
        for (Server server : servers) {
            if(server.canFit(vm)) {
                capableServers.add(server);
            }
        }

        Server lessLoadedServer = findLessLoadedServer(capableServers);
        if (lessLoadedServer != null) {
            lessLoadedServer.addVm(vm);
        }
    }

    private Server findLessLoadedServer(List<Server> capableServers) {
        Server lessLoadedServer = null;
        for (Server server : capableServers) {
            if (lessLoadedServer == null || server.currentLoadPercentage < lessLoadedServer.currentLoadPercentage) {
                lessLoadedServer = server;
            }

        }
        return lessLoadedServer;
    }
}
