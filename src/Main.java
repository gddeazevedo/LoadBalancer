import loadbalance.LoadBalancer;
import servers.Server;


void main() {
    IO.println("Starting LoadBalancer...");

    var loadBalancer = new LoadBalancer();

    var s1 = new Server("Server-1");
    var s2 = new Server("Server-2");
    var s3 = new Server("Server-3");

    loadBalancer.addServer(s1);
    loadBalancer.addServer(s2);
    loadBalancer.addServer(s3);

    for (int i = 0; i < 10; i++) {
        loadBalancer.distributeRequest(String.format("Request %d", i));
        sleep(1000);
    }

    s2.setIsAvailable(false);

    for (int i = 11; i <= 15; i++) {
        loadBalancer.distributeRequest(String.format("Request %d", i));
        sleep(1000);
    }

    s2.setIsAvailable(true);
    s3.setIsAvailable(false);
    for (int i = 16; i <= 20; i++) {
        loadBalancer.distributeRequest("Request " + i);
        sleep(500);
    }
}

void sleep(long millis) {
    try {
        Thread.sleep(millis);
    } catch (Exception _) {}
}