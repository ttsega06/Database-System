
import java.awt.*;
import java.util.Scanner;

public class DriverMethod {

    
        public static void main(String[] args) {

        	welcome1();
        	access();


        }
        public static void welcome1() {
    
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

    public static void welcome2() {
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
    public static void access() {
        Statements state = new Statements();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in your option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        if (userId.equals("student") && password.equals("password")) {
            switch(choice) {
                case 2:
                	welcome2();
                	access2();
                    break;

                case 4:
                    System.out.println("What do you want to delete?");
                    System.out.println("1. Equipment; 2. Service; 3. Customer; 4. Employee");
                    int deletChoice= sc.nextInt();
                    sc.nextLine();
                    String ID;
                    switch(deletChoice) {
                        case 1:
                            System.out.println("Enter the Equipment ID:");
                            ID = sc.nextLine();
                            Equipment eq = new Equipment();
                            eq.setEquipment_ID(ID);
                            state.deleteEquipment(eq);
                            break;
                        case 2:
                            System.out.println("Enter the Service ID:");
                            ID = sc.nextLine();
                            Service se = new Service();
                            se.setService_ID(ID);
                            state.deleteService(se);
                            break;
                        case 3:
                            System.out.println("Enter the Customer ID:");
                            ID = sc.nextLine();
                            System.out.println(ID);
                            Customer cus = new Customer();
                            cus.setID_Number(ID);
                            state.deleteCustomer(cus);
                            break;
                        case 4:
                            System.out.println("Enter the Employee ID:");
                            ID = sc.nextLine();
                            Employee emp = new Employee();
                            emp.setEmploye_ID_number(ID);
                            state.deleteEmployee(emp);
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

    public static void access2() {
        Statements st = new Statements();
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in your option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        int new_choice;

        switch (choice) {
            case 1:
                System.out.println("1. Total number of new customers");
                System.out.println("2. Total number of services this month");
                System.out.println("Type in your option: ");
                new_choice = sc.nextInt();
                switch (new_choice) {
                    case 1:
                        int count = st.countCustomers();
                        System.out.println(count);
                        break;
                    case 2:
                        count = st.countServicesThisMonth();
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
                new_choice = sc.nextInt();

                switch (new_choice) {
                    case 1:
                        String i = st.mostRequestedService();
                        System.out.println(i);
                        break;
                    case 2:
                        i = st.getCountLast6Months();
                        System.out.println(i);
                        break;
                    case 3:
                        i = st.getCountAmount();
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
                new_choice = sc.nextInt();

                switch (new_choice) {
                    case 1:
                        String i = st.getListCustomers();
                        System.out.println(i);
                        break;
                    case 2:
                        i = st.getCountCustomersPerMonth();
                        System.out.println(i);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 4:
            	welcome1();
            	access();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

 



}
