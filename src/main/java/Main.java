import commands.RemoteCommand;
import receivers.Receiver;
import remote.TvRemote;

public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        TvRemote remote = new TvRemote(receiver);
        remote.execute("VOLUME");
    }
}
