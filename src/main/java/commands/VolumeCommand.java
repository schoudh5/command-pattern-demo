package commands;

import receivers.Receiver;

public class VolumeCommand extends RemoteCommand{

    private static final String COMMAND_NAME = "VOLUME";
    private int currentLevel = 10;
    private static final int MINIMUM_LEVEL = 0;
    private static final int MAX_LEVEL = 20;
    private final Receiver receiver;

    public VolumeCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute() {
        if(currentLevel+1<=MAX_LEVEL){
            System.out.println("Volume increased by one level");
            currentLevel++;
            receiver.action("Volume up");
            return "Volume up";
        }
        return "";
    }

    @Override
    public String unexecute() {
        if(currentLevel-1>=MINIMUM_LEVEL){
            System.out.println("Volume decreased by one level");
            currentLevel--;
            receiver.action("Volume down");
            return "Volume down";
        }
        return "";
    }


    public boolean isApplicable(String name) {
        return super.isValidCommand(name, COMMAND_NAME);
    }
}
