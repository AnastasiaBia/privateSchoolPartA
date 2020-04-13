package privateschool;

import java.util.Scanner;

/**
 *
 * @author Natasa
 */
public class MenuMethods {

    public void startMenu() {

        Scanner sc = new Scanner(System.in);
        AllData s1 = new AllData();
        s1.syntheticData();
        String menuChoice;
        System.out.println("Welcome to Private School Management.");

        do {

            System.out.println("Press 1 to create a new student.");
            System.out.println("Press 2 to view all of the students in the school.");
            System.out.println("Press 3 to view the students per course.");
            System.out.println("Press 4 to view the students following both courses.");
            System.out.println("Press 5 to create a new trainer.");
            System.out.println("Press 6 to view all of the trainers in the school.");
            System.out.println("Press 7 to view the trainers per course.");
            System.out.println("Press 8 to view all of the courses in the school.");
            System.out.println("Press 9 to create a new assignment.");
            System.out.println("Press 10 to view all of the assignments in the school.");
            System.out.println("Press 11 to view the assignments per course.");
            System.out.println("Press 12 to view the assignments per student.");
            System.out.println("Press 13 to view the assignments to be submitted by date.");

            System.out.println("Press 0 to quit.");

            menuChoice = sc.nextLine();

            if (menuChoice.isEmpty()) {

                System.out.println("Please try again.");
                continue;
            }

            switch (menuChoice) {

                case "1":

                    s1.insertStudent();
                    System.out.println();
                    break;

                case "2":

                    s1.viewAllStudents();
                    System.out.println();
                    break;

                case "3":
                    System.out.println("Students per course");
                    System.out.println("Which students would you like to see?");
                    System.out.println("Type 'a' for all, 'j' for Java,or 'c' for C#.");

                    OUTER:
                    do {
                        String submenuChoice = sc.nextLine();
                        switch (submenuChoice) {
                            case "a":

                                s1.viewJavaPTstudents();
                                System.out.println();
                                s1.viewJavaFTstudents();
                                System.out.println();
                                s1.viewCPTstudents();
                                System.out.println();
                                s1.viewCFTstudents();
                                System.out.println();
                                break OUTER;
                            case "j":

                                s1.viewJavaPTstudents();
                                System.out.println();
                                s1.viewJavaFTstudents();
                                System.out.println();
                                break OUTER;
                            case "c":
                                s1.viewCPTstudents();
                                System.out.println();
                                s1.viewCFTstudents();
                                System.out.println();
                                break OUTER;
                            default:
                                if (submenuChoice.isEmpty() || !(submenuChoice.equals("j") || !submenuChoice.equals("c") || !submenuChoice.equals("a"))) {

                                    continue;

                                }
                                System.out.println("Please try again");
                                System.out.println("Type 'a' for all, 'j' for Java,or 'c' for C#.");
                                break;

                        }
                    } while (!menuChoice.equals("0"));
                    break;

                case "4":

                    s1.viewStudentsInManyCourses();
                    System.out.println();
                    break;
                case "5":

                    s1.insertTrainer();
                    System.out.println();
                    break;
                case "6":

                    s1.viewAllTrainers();
                    System.out.println();
                    break;

                case "7":
                    System.out.println("Trainers per course");
                    System.out.println("Which trainers do you want to see?");
                    System.out.println("Type 'a' for all, 'j' for Java,or 'c' for C#.");

                    OUTER:
                    do {
                        String submenuChoice3 = sc.nextLine();
                        switch (submenuChoice3) {
                            case "a":

                                s1.viewJavaPTtrainers();
                                System.out.println();
                                s1.viewJavaFTtrainers();
                                System.out.println();
                                s1.viewCPTtrainers();
                                System.out.println();
                                s1.viewCFTtrainers();
                                System.out.println();
                                break OUTER;
                            case "j":

                                s1.viewJavaPTtrainers();
                                System.out.println();
                                s1.viewJavaFTtrainers();
                                System.out.println();
                                break OUTER;
                            case "c":

                                s1.viewCPTtrainers();
                                System.out.println();
                                s1.viewCFTtrainers();
                                System.out.println();
                                break OUTER;
                            default:
                                if (submenuChoice3.isEmpty() || !(submenuChoice3.equals("j") || !submenuChoice3.equals("c") || !submenuChoice3.equals("a"))) {

                                    continue;

                                }
                                System.out.println("Please try again");
                                System.out.println("Type 'a' for all, 'j' for Java,or 'c' for C#.");
                                break;

                        }
                    } while (menuChoice != "0");
                    break;

                case "8":

                    s1.viewAllCourses();
                    System.out.println();
                    break;

                case "9":

                    s1.insertAssignment();
                    System.out.println();
                    break;
                case "10":

                    s1.viewAllAssignments();
                    System.out.println();
                    break;

                case "11":
                    System.out.println("Assignments per course");
                    System.out.println("Which assignments do you want to see?");
                    System.out.println("Type 'a' for all, 'j' for Java, or 'c' for C#.");

                    OUTER:
                    do {
                        String submenuChoice5 = sc.nextLine();
                        switch (submenuChoice5) {
                            case "a":

                                s1.viewJavaPTassignments();
                                System.out.println();
                                s1.viewJavaFTassignments();
                                System.out.println();
                                s1.viewCPTassignments();
                                System.out.println();
                                s1.viewCFTassignments();
                                System.out.println();
                                break OUTER;
                            case "j":

                                s1.viewJavaPTassignments();
                                System.out.println();
                                s1.viewJavaFTassignments();
                                System.out.println();
                                break OUTER;
                            case "c":

                                s1.viewCPTassignments();
                                System.out.println();
                                s1.viewCFTassignments();
                                System.out.println();
                                break OUTER;
                            default:
                                if (submenuChoice5.isEmpty() || !(submenuChoice5.equals("j") || !submenuChoice5.equals("c") || !submenuChoice5.equals("a"))) {

                                    continue;

                                }
                                System.out.println("Please try again");
                                System.out.println("Type 'a' for all, 'j' for Java or 'c' for C#.");
                                break;

                        }
                    } while (!"0".equals(menuChoice));
                    break;

                case "12":

                    s1.viewAssignmentPerStudent();
                    System.out.println();
                    break;

                case "13":

                    s1.DateMethod();
                    System.out.println();
                    break;

            }
        } while (!menuChoice.equals("0"));

    }

}
