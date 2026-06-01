package rvt.StudentRegistration;

import java.util.Scanner;

public class RegistrationInterface {
    private final Registration registrate = new Registration(); 
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("commands:\n help\n show\n register\n remove\n edit\n exit"); 

        while (true) { 
            System.out.println("Enter command: ");
            String command = scanner.nextLine(); 
            if (command.equals("register")) {
                registrate.register();
                continue;
            } else if (command.equals("show")) {
                registrate.show();
                continue;
            } else if (command.equals("remove")) {
                registrate.remove();
                continue;
            } else if (command.equals("edit")) {
                registrate.edit();
                continue;
            } else if (command.equals("exit")) {
                break; // beidzam programmas izvēlni
            } else if (command.equals("help")) {
        
        System.out.println("Enter a command:\n help\n show\n register\n remove\n edit\n exit");

            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}