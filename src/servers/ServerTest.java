package servers;

public class ServerTest {
    private final String name;
    private boolean isAvailable;

    public ServerTest(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void handleRequest(String request) {
        if (this.isAvailable) {
            IO.println("Request \"" + request + "\" handled by the server: " + this.name);
            return;
        }

        IO.println("Server " + this.name + " is down!");
    }
}
