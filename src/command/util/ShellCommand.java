package command.util;

import java.io.IOException;

public class ShellCommand {


    public static Process executeShellCommand(String command) throws IOException {
        return Runtime.getRuntime().exec(command);
    }
}
