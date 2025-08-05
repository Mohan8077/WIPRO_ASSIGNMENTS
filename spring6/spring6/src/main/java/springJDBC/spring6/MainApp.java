package springJDBC.spring6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springJDBC.spring6.config.AppConfig;
import springJDBC.spring6.dao.Person;
import springJDBC.spring6.dao.PersonDAOImpl;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDAOImpl dao = context.getBean(PersonDAOImpl.class);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. List All\n2. Get by ID\n3. Create\n4. Update\n5. Delete\n6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    dao.list().forEach(System.out::println);
                    break;
                }
                case 2: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Person person = dao.get(id);
                    if (person != null) {
                        System.out.println(person);
                    } else {
                        System.out.println("No person found with ID " + id);
                    }
                    break;
                }
                case 3: {
                    Person p = new Person();
                    System.out.print("ID: ");
                    p.setId(sc.nextInt());
                    System.out.print("Age: ");
                    p.setAge(sc.nextInt());
                    sc.nextLine(); // consume leftover newline
                    System.out.print("First Name: ");
                    p.setFirstName(sc.nextLine());
                    System.out.print("Last Name: ");
                    p.setLastName(sc.nextLine());
                    dao.insert(p);
                    System.out.println("Created: " + p);
                    break;
                }
                case 4: {
                    Person p = new Person();
                    System.out.print("ID: ");
                    p.setId(sc.nextInt());
                    System.out.print("Age: ");
                    p.setAge(sc.nextInt());
                    sc.nextLine(); // consume newline
                    System.out.print("First Name: ");
                    p.setFirstName(sc.nextLine());
                    System.out.print("Last Name: ");
                    p.setLastName(sc.nextLine());
                    dao.update(p);
                    System.out.println("Updated: " + p);
                    break;
                }
                case 5: {
                    System.out.print("Enter ID to delete: ");
                    dao.delete(sc.nextInt());
                    System.out.println("Deleted.");
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default: {
                    System.out.println("Invalid choice.");
                    break;
                }
            }
        }
    }
}
