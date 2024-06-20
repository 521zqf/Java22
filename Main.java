import java.util.List;
import java.util.Scanner;

public class Main {
    private static CinemaService cinemaService = new CinemaService();
    private static UserService userService = new UserService();
    private static MovieService movieService = new MovieService();
    private static TicketService ticketService = new TicketService();
    private static AdminService adminService = new AdminService();
    private static ShowtimeService showtimeService = new ShowtimeService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Manage Cinemas");
            System.out.println("2. Manage Users");
            System.out.println("3. Manage Movies");
            System.out.println("4. Manage Tickets");
            System.out.println("5. Manage Admins");
            System.out.println("6. Manage Showtime");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageCinemas(scanner);
                    break;
                case 2:
                    manageUsers(scanner);
                    break;
                case 3:
                    manageMovies(scanner);
                    break;
                case 4:
                    manageTickets(scanner);
                    break;
                case 5:
                    manageAdmins(scanner);
                    break;
                case 6:
                    manageShowtime(scanner);
                    break;
                case 7:
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("错误，重新输入");
            }
        }
    }

    private static void manageCinemas(@org.jetbrains.annotations.NotNull Scanner scanner) {
        while (true) {
            System.out.println("1. List Cinemas");
            System.out.println("2. Add Cinema");
            System.out.println("3. Update Cinema");
            System.out.println("4. Delete Cinema");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listCinemas();
                    break;
                case 2:
                    addCinema(scanner);
                    break;
                case 3:
                    updateCinema(scanner);
                    break;
                case 4:
                    deleteCinema(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listCinemas() {
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        for (Cinema cinema : cinemas) {
            System.out.println(cinema);
        }
    }

    private static void addCinema(Scanner scanner) {
        System.out.print("Enter cinema name: ");
        String name = scanner.nextLine();
        System.out.print("Enter cinema location: ");
        String location = scanner.nextLine();
        System.out.print("Enter ID: ");
        Long adminId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Cinema cinema = new Cinema();
        cinema.setName(name);
        cinema.setLocation(location);
        cinema.setId(adminId);

        cinemaService.saveCinema(cinema);
        System.out.println("Cinema added successfully.");
    }

    private static void updateCinema(Scanner scanner) {
        System.out.print("Enter cinema ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // consume newline

        Cinema cinema = cinemaService.getCinemaById(id);
        if (cinema == null) {
            System.out.println("Cinema not found.");
            return;
        }

        System.out.print("Enter new cinema name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new cinema location: ");
        String location = scanner.nextLine();
        System.out.print("Enter new ID: ");
        Long adminId = scanner.nextLong();
        scanner.nextLine(); // consume newline

        cinema.setName(name);
        cinema.setLocation(location);
        cinema.setId(adminId);

        cinemaService.saveCinema(cinema);
        System.out.println("Cinema updated successfully.");
    }

    private static void deleteCinema(Scanner scanner) {
        System.out.print("Enter cinema ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // consume newline

        cinemaService.deleteCinema(id);
        System.out.println("Cinema deleted successfully.");
    }

    private static void manageUsers(Scanner scanner) {
        while (true) {
            System.out.println("1. List Users");
            System.out.println("2. Add User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listUsers();
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter email: ");
        long Id = Long.parseLong(scanner.nextLine());
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setId(Id);

        userService.saveUser(user);
        System.out.println("User added successfully.");
    }

    private static void updateUser(Scanner scanner) {
        System.out.print("Enter user ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // consume newline

        User user = userService.getUserById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new Id): ");
        long Id = Long.parseLong(scanner.nextLine());

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setId(Id);
        userService.saveUser(user);
        System.out.println("User updated successfully.");
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Enter user ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // consume newline

        userService.deleteUser(id);
        System.out.println("User deleted successfully.");
    }

    private static void manageMovies(Scanner scanner) {
        // Similar to manageCinemas, implement movie management here
    }

    private static void manageTickets(Scanner scanner) {
        // Similar to manageCinemas, implement ticket management here
    }

    private static void manageAdmins(Scanner scanner) {
        // Similar to manageCinemas, implement payment management here
    }

    private static void manageShowtime(Scanner scanner) {
        // Similar to manageCinemas, implement payment management here
    }
}