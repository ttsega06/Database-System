import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void MenuInterface() {
        System.out.println("*****************************************************************************");
        System.out.println("                      *********************                                  ");
        System.out.println("                   Welcome to Clean-and-Go Shop                              ");
        System.out.println("                      *********************                                  ");
        System.out.println("*****************************************************************************");
        System.out.println("                     1. Equipment & Supplies                                 ");
        System.out.println("                     2. Customer & Services                                  ");
        System.out.println("                          3. Employee                                        ");
        System.out.println("                          4. Delete                                          ");
        System.out.println("                          5. Quit                                            ");
    }

    public static void MenuInterface2() {
        System.out.println("*****************************************************************************");
        System.out.println("                      *********************                                  ");
        System.out.println("                   Welcome to Clean-and-Go Shop                              ");
        System.out.println("                      2. Customers & Services                                ");
        System.out.println("                      *********************                                  ");
        System.out.println("*****************************************************************************");
        System.out.println("         1. Analyze the progress of the business                             ");
        System.out.println("                     2. Services                                             ");
        System.out.println("                     3. Customers                                            ");
        System.out.println("                      4. Quit                                                ");
    }

    public static void start2() {
        Statements statements = new Statements();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        int new_option;

        switch (option) {
            case 1:
                System.out.println("1. Total number of new customers");
                System.out.println("2. Total number of services this month");
                System.out.println("Type in your option: ");
                new_option = scanner.nextInt();
                switch (new_option) {
                    case 1:
                        int count = statements.countCustomers();
                        System.out.println(count);
                        break;
                    case 2:
                        count = statements.countServicesThisMonth();
                        System.out.println(count);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 2:
                System.out.println("1. Requested services");
                System.out.println("2. Service transactions");
                System.out.println("3. Annual revenue from services");
                System.out.println("Type in your option: ");
                new_option = scanner.nextInt();

                switch (new_option) {
                    case 1:
                        String i = statements.mostRequestedService();
                        System.out.println(i);
                        break;
                    case 2:
                        i = statements.getCountLast6Months();
                        System.out.println(i);
                        break;
                    case 3:
                        i = statements.getCountAmount();
                        System.out.println(i);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 3:
                System.out.println("1. Customer list for a service");
                System.out.println("2. Customer number");
                System.out.println("Type in your option: ");
                new_option = scanner.nextInt();

                switch (new_option) {
                    case 1:
                        String i = statements.getListCustomers();
                        System.out.println(i);
                        break;
                    case 2:
                        i = statements.getCountCustomersPerMonth();
                        System.out.println(i);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 4:
                MenuInterface();
                start();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void start() {
        Statements statements = new Statements();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        if (userId.equals("admin") && password.equals("admin")) {
            switch(option) {
                case 2:
                    MenuInterface2();
                    start2();
                    break;

                case 4:
                    System.out.println("What do you want to delete?");
                    System.out.println("1. Equipment; 2. Service; 3. Customer; 4. Employee");
                    int deleteOption = scanner.nextInt();
                    scanner.nextLine();
                    String ID;
                    switch(deleteOption) {
                        case 1:
                            System.out.println("Enter the Equipment ID:");
                            ID = scanner.nextLine();
                            Equipment equipment = new Equipment();
                            equipment.setEquipment_ID(ID);
                            statements.deleteEquipment(equipment);
                            break;
                        case 2:
                            System.out.println("Enter the Service ID:");
                            ID = scanner.nextLine();
                            Service service = new Service();
                            service.setService_ID(ID);
                            statements.deleteService(service);
                            break;
                        case 3:
                            System.out.println("Enter the Customer ID:");
                            ID = scanner.nextLine();
                            System.out.println(ID);
                            Customer customer = new Customer();
                            customer.setID_Number(ID);
                            statements.deleteCustomer(customer);
                            break;
                        case 4:
                            System.out.println("Enter the Employee ID:");
                            ID = scanner.nextLine();
                            Employee employee = new Employee();
                            employee.setEmploye_ID_number(ID);
                            statements.deleteEmployee(employee);
                            break;
                        default:
                            System.out.println("Invalid option!");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        else
            System.out.println("User or password incorrect!");
    }



    public static void main(String[] args) {

        MenuInterface();
        start();


    }
}
