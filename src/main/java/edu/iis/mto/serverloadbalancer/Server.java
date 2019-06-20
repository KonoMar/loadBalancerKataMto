package edu.iis.mto.serverloadbalancer;

public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    public boolean contains(Vm theVm) {
        return true;
    }

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public void addVm(Vm vm) {
        currentLoadPercentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
    }
}
