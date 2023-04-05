package commands;

public abstract class RemoteCommand {
    public abstract String execute();
    public abstract String unexecute();
    public boolean isValidCommand(String name, String expectedName) {
        if(name.equals(expectedName)){
            return true;
        }
        return false;
    }

    public abstract boolean isApplicable(String name);
}
