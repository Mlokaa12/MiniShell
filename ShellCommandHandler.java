import java.io.File;         // Import File class to work with files and folders
import java.io.IOException;  // Import IOException class to handle errors during file creation

public class ShellCommandHandler {

    // Variable to store the current directory the user is working in
    private File currentDirectory;

    //⃣Constructor: Automatically called when an object of the class is created
    public ShellCommandHandler() {
        // We get the current path of the device (the folder from which the program started)
        this.currentDirectory = new File(System.getProperty("user.dir"));
    }

    //  Function to print the full path of the current directory (like the pwd command in Linux)
    public void printWorkingDirectory() {
        System.out.println("Current path: " + currentDirectory.getAbsolutePath());
    }

    //  Function to display files and folders within the current directory (like the ls command)
    public void listDirectory() {
        File[] files = currentDirectory.listFiles(); // We get the list of files
        if (files != null) {
            for (File file : files) {                // We iterate over each item (file or folder)
                System.out.println(file.getName());  // We print its name
            }
        } else {
            System.out.println("Failed to read directory contents.");
        }
    }

    //  Function to change the path to another folder (like the cd command)
    public void changeDirectory(String name) {
        // We create a new path relative to the current directory
        File newDirectory = new File(currentDirectory, name);

        // We check if this path exists and is actually a folder
        if (newDirectory.exists() && newDirectory.isDirectory()) {
            currentDirectory = newDirectory; // We update the current path
            System.out.println("Directory changed to: " + currentDirectory.getAbsolutePath());
        } else {
            System.out.println("Directory does not exist or is not a folder."); // Invalid path
        }
    }

    //  Function to create a new folder within the current path (like mkdir)
    public void makeDirectory(String name) {
        File newDirectory = new File(currentDirectory, name); // We specify the name of the new folder
        if (newDirectory.mkdir()) { // We try to create the folder
            System.out.println("Directory created successfully: " + newDirectory.getAbsolutePath());
        } else {
            System.out.println("Failed to create directory."); // Perhaps because it already exists or there are no permissions
        }
    }

    //  Function to create a new file (like create)
    public void createFile(String name) {
        File newFile = new File(currentDirectory, name); // We specify the name of the new file
        try {
            if (newFile.createNewFile()) { // We try to create the file
                System.out.println("File created successfully: " + newFile.getAbsolutePath());
            } else {
                System.out.println("File already exists."); // The file already exists
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file."); // Print error message
            e.printStackTrace(); // Print error details (for the developer)
        }
    }
    //  Function to print available commands (like help)
    public void printHelp() {
        System.out.println("Supported commands:");
        System.out.println("pwd           - Show current directory path");
        System.out.println("ls            - List contents of the current directory");
        System.out.println("cd [dir]      - Change to directory (.. to go back)");
        System.out.println("mkdir [dir]   - Create a new directory");
        System.out.println("touch [file]  - Create a new file");
        System.out.println("help          - Show this help message");
        System.out.println("exit          - Exit the shell");
    }


    //  Function to return the object representing the current folder (we use it in MiniShell)
    public File getCurrentDirectory() {
        return currentDirectory;
    }
}

