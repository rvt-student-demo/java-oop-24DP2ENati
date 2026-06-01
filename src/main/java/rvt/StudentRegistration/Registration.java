package rvt.StudentRegistration;

import java.io.*;
import java.util.*;
import java.time.*;

public class Registration {
    private TablePrint printer = new TablePrint();
    private ArrayList<String> intermed = new ArrayList<>();

    private final String columnnames = "vards,uzvards,epasts,personas kods,timestamp";
    private final Scanner scanner = new Scanner(System.in);
    private final String path = "src/main/java/rvt/studentregistration/RegistrationTo.csv";
    private final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final String perscodRegex = "^\\d{6}-\\d{5}$";
    
    public Registration() {
        loadFromFile();
    }

    public void register() {

        System.out.println("Ievadiet studenta vārdu: ");
        String vards = scanner.nextLine();
        System.out.println("Ievadiet studenta uzvārdu: ");
        String uzvards = scanner.nextLine();
        System.out.println("Ievadiet studenta e-pastu: ");
        String epasts = scanner.nextLine();
        while (!epasts.matches(emailRegex)) {
            System.out.println("ievadiet derīgu e-pastu!");
            epasts = scanner.nextLine(); 
        }
        System.out.println("Ievadiet studenta personas kodu: ");
        String personasKods = scanner.nextLine();
        while (!personasKods.matches(perscodRegex)) {
            System.out.println("ievadiet derīgu personas kodu!");
            personasKods = scanner.nextLine(); 
        }
        LocalDateTime stamp = LocalDateTime.now(); 
        new Student(vards, uzvards, epasts, personasKods, stamp);
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(vards + "," + uzvards + "," + epasts + "," + personasKods + "," + stamp);
        }
        catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void show() {

        try {
            printer.printTable(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarray() {
 
        for (int i = 0; i < intermed.size(); i++) {
            System.out.println(intermed.get(i));
        }
    }

    public void remove() {
 
        int id = -1;
        System.out.print("Ievadiet studenta personas kodu: ");
        String personasKods = scanner.nextLine();
        for (int i = 0; i < intermed.size(); i++) {
            String[] parts = intermed.get(i).split(",");
        
            if (parts.length > 3 && parts[3].trim().equals(personasKods)) {
               id = i;
               break;
            }
        }
        if (id == -1) {
            System.out.println("Students nav atrasts.");
            return;
        }

        System.out.println("Dzēst studentu? y/n");
        String YorN = scanner.nextLine();
        if (YorN.equals("y") || YorN.equals("Y")) {
            intermed.remove(id);
            uploadToFile();
            System.out.println("Students tika izdzēsts.");
        } else if (YorN.equals("n") || YorN.equals("N")) {
            System.out.println("Dzēšana tika atcelta.");
        } else {
            System.out.println("Nepareiza izvēle");
        }
    }

    public void edit() {

        int id = -1;
        System.out.print("Ievadiet studenta personas kodu: ");
        String personasKods = scanner.nextLine();
        for (int i = 0; i < intermed.size(); i++) {
            String[] parts = intermed.get(i).split(",");
        
            if (parts.length > 3 && parts[3].trim().equals(personasKods)) {
               id = i;
               break;
            }
        }
        if (id == -1) {
            System.out.println("Students nav atrasts.");
            return;
        }
        
        System.out.println("Vai esat pārliecināti? y/n");
        String YorN = scanner.nextLine();
        if (YorN.equals("y") || YorN.equals("Y")) {
            intermed.remove(id);
            uploadToFile();
            System.out.println("Ievadiet jaunus datus");
            register();
        } else if (YorN.equals("n") || YorN.equals("N")) {
            System.out.println("Rediģēšana tika atcelta.");
        } else {
            System.out.println("Nepareiza izvēle");
        }
    }

    private void loadFromFile() {

        String line;
        boolean isHeader = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                if (!line.trim().isEmpty()) {
                    intermed.add(line.trim());
                }
            }
            br.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    private void uploadToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            pw.println(columnnames); 

            for (String line : intermed) {
                pw.println(line); 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}