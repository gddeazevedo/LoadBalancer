package loadbalance;

import servers.ServerTest;
import java.util.ArrayList;


public class LoadBalancer {
    private final ArrayList<ServerTest> servers;
    private int currentIndex;

    public LoadBalancer() {
        this.servers = new ArrayList<>();
        this.currentIndex = 0;
    }

    public void addServer(ServerTest server) {
        this.servers.add(server);
    }

    public void distributeRequest(String request) {
        if (this.servers.isEmpty()) {
            IO.println("No servers available");
            return;
        }

        int attempts = 0;
        while (attempts < this.servers.size()) {
            var server = servers.get(currentIndex);
            currentIndex = (currentIndex + 1) % this.servers.size();

            if (server.getIsAvailable()) {
                server.handleRequest(request);
                return;
            }

            attempts++;
        }

        IO.println("All servers are down! Request \"" + request + "\" could not be handled.");
    }
}
