package remote;

import commands.BrightnessCommand;
import commands.RemoteCommand;
import commands.VolumeCommand;
import receivers.Receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TvRemote {

    List<RemoteCommand> remoteCommands = new ArrayList<>();

    public TvRemote(Receiver receiver) {
        remoteCommands.add(new BrightnessCommand(receiver));
        remoteCommands.add(new VolumeCommand(receiver));
    }

    public void execute(String commandName, List<String> parameters){
        Optional<RemoteCommand> command = remoteCommands.stream().filter(cmd -> cmd.isApplicable(commandName)).findFirst();
        if(command.isPresent()){
            command.get().execute();
        }
    }
}
