import java.io.*;
import java.util.Scanner;

public class NotesApp {
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNote(note);
                    break;

                case 2:
                    readNotes();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 3);
        sc.close();
    }

    public static void writeNote(String note) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true); // append mode
            fw.write(note + "\n");
            fw.close();
            System.out.println("✅ Note saved!");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing file: " + e.getMessage());
        }
    }

    public static void readNotes() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("\n📓 Your Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found. Write a note first!");
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    
    }
    
}
