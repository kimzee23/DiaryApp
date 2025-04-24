import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class DairyMainApp {
    public static int generateRandomId() {
        return (int) (Math.random() * 1000000);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiaryLogs diaryLogs = new DiaryLogs();
        Random ram = new Random();
        while (true) {
            System.out.println("\nWelcome to Diary App!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(scanner, diaryLogs);
                    break;
                case 2:
                    loginUser(scanner, diaryLogs);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void registerUser(Scanner scanner, DiaryLogs diaryLogs) {
        String username ="";
        while (true) {

            System.out.print("Enter username: ");
            username = scanner.nextLine();
            if(username.isEmpty()||!username.matches("^[A-z]")) {
                System.out.println("Invalid, username enter alphabet only");
            }else {
                break;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Diary diary = new Diary(username, password);
        diaryLogs.registerUser(diary);
        System.out.println("Registration successful!");
    }


    private static void loginUser(Scanner scanner, DiaryLogs diaryLogs) {
        String username= "";
        String password = "";
        while (true) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            if(username.isEmpty()|| !username.matches("^[A-z]")) {
                System.out.println("Invalid username!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            if (password.isEmpty() || password.length() < 8) {
                System.out.println("Invalid password!");
            }else {
                break;
            }
        }

        Diary diary = diaryLogs.login(username, password);
        if (diary != null) {
            System.out.println("Login successful!");
            diaryMenu(scanner, diary);
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    private static void diaryMenu(Scanner scanner, Diary diary) {
        String title = "";
        String body ="";
        while (true) {
            System.out.println("\nDiary Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. Delete Entry");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1: {
                    while (true) {
                        System.out.print("Enter title: ");
                         title = scanner.nextLine();
                         if (title.isEmpty()){
                             System.out.println("Invalid, title cannot be empty!");
                         }
                         else {
                             break;
                         }
                    }
                    while (true) {

                        System.out.print("Enter body: ");
                        body = scanner.nextLine();
                        if (body.isEmpty()){
                            System.out.println("Invalid, body cannot be empty!");
                        }else{
                            break;
                        }
                    }

                    Entry newEntry = new Entry(generateRandomId(), title, body, LocalDate.now().toString());
                    diary.addEntry(newEntry);
                    System.out.println("Entry added.");
                    break;
                }

                case 2: {
                    System.out.println("+".repeat(40));
                    for (Entry entry : diary.getInputs()) {
                        System.out.println(entry.getId() + ": " + entry.getTitle() + " - " + entry.getBody());
                    }
                    break;
                }

                case 3: {
                    System.out.println("+".repeat(40));
                    System.out.print("Enter entry ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    diary.deleteEntry(id);
                    System.out.println("Entry deleted.");
                    break;
                }
                case 4: {
                    System.out.println("+".repeat(40));
                    diary.lockDiary();
                    System.out.println("Logged out.");
                    return;
                }
                default:
                    System.out.println("Invalid option.");
            }
        }
    }


}
