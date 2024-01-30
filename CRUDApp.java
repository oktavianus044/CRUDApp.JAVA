import java.util.ArrayList;
import java.util.Scanner;

public class CRUDApp {

    private static ArrayList<Person> persons = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("1. Add Person");
            System.out.println("2. View All Persons");
            System.out.println("3. Update Person");
            System.out.println("4. Delete Person");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    viewAllPersons();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addPerson() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        persons.add(new Person(firstName, lastName));
        System.out.println("Person added successfully!");
    }

    private static void viewAllPersons() {
        System.out.println("List of Persons:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void updatePerson() {
        viewAllPersons();
        System.out.print("Enter index of person to update: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < persons.size()) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new First Name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Enter new Last Name: ");
            String newLastName = scanner.nextLine();
            Person person = persons.get(index);
            person.setFirstName(newFirstName);
            person.setLastName(newLastName);
            System.out.println("Person updated successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    private static void deletePerson() {
        viewAllPersons();
        System.out.print("Enter index of person to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < persons.size()) {
            persons.remove(index);
            System.out.println("Person deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
