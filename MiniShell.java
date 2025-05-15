import java.util.Scanner; // For getting user input, standard stuff

/**
 * MiniShell - A simple command line interpreter.
 * This was a fun little project to simulate some basic shell commands.
 * Author: [Your Name/Alias Here] - May 2025
 *
 * Trying to make this feel a bit more like a real, slightly messy, human-written program!
 */
public class MiniShell {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in); // Renamed for a bit of variety
        ShellCommandHandler commandHandler = new ShellCommandHandler(); // Our helper for actual commands

        // A friendly welcome, as per the spec!
        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

        String userCommand; // Will hold what the user types

        // Main loop - keeps running until user types 'exit'
        while (true) {
            // Display the prompt, showing the current directory. Nice touch!
            System.out.print(commandHandler.getCurrentDirectory().getAbsolutePath() + " > ");
            userCommand = inputScanner.nextLine().trim(); // Get command and trim whitespace, just in case

            // Let's see what they want to do...
            if (userCommand.isEmpty()) { // Handle empty input gracefully
                continue; // Just show the prompt again
            }

            if (userCommand.equals("exit")) {
                System.out.println("Exiting MiniShell. Goodbye!"); // A slightly more verbose goodbye
                break; // End the loop, and thus the program
            } else if (userCommand.equals("pwd")) {
                commandHandler.printWorkingDirectory();
            } else if (userCommand.equals("ls")) {
                commandHandler.listDirectory();
            } else if (userCommand.startsWith("cd ")) {
                String targetDir = userCommand.substring(3); // Extract directory name
                // TODO: Maybe add some validation for the directory name here? e.g. empty string after cd
                commandHandler.changeDirectory(targetDir);
            } else if (userCommand.startsWith("mkdir ")) {
                String dirToMake = userCommand.substring(6); // Get the name for the new directory
                commandHandler.makeDirectory(dirToMake);
            } else if (userCommand.startsWith("touch ")) { // Using 'touch' as it's more common than 'create'
                String fileToCreate = userCommand.substring(6);
                commandHandler.createFile(fileToCreate);
            } else if (userCommand.equals("help")) {
                commandHandler.printHelp();
            } else {
                // If we don't recognize the command...
                System.out.println("Hmm, '" + userCommand + "' is not a command I know. Try 'help'.");
            }
            // System.out.println("DEBUG: Command processed: " + userCommand); // A typical debug line one might forget to remove
        }

        inputScanner.close(); // Good practice to close the scanner
        // System.out.println("Scanner closed."); // Another possible leftover debug/info line
    }
}
