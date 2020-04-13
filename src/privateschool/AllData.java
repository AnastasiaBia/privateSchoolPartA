/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natasa
 */
public class AllData {

    Course courses1 = new Course("Course 1", " Java", "Part-Time", LocalDate.of(2019, Month.OCTOBER, 14), LocalDate.of(2020, Month.APRIL, 24));
    Course courses2 = new Course("Course 2", " Java", "Full-Time", LocalDate.of(2019, Month.OCTOBER, 14), LocalDate.of(2020, Month.JANUARY, 24));
    Course courses3 = new Course("Course 3", " C#", "Part-Time", LocalDate.of(2020, Month.APRIL, 14), LocalDate.of(2020, Month.SEPTEMBER, 24));
    Course courses4 = new Course("Course 4", " C#", "Full-Time", LocalDate.of(2020, Month.APRIL, 14), LocalDate.of(2020, Month.JUNE, 24));

    List<Course> myCourses = new ArrayList<>();

    List<Student> myStudents = new ArrayList<>();
    List<Student> myStudentsJava = new ArrayList<>();
    List<Student> myStudentsJavaPT = new ArrayList<>();
    List<Student> myStudentsJavaFT = new ArrayList<>();
    List<Student> myStudentsC = new ArrayList<>();
    List<Student> myStudentsCPT = new ArrayList<>();
    List<Student> myStudentsCFT = new ArrayList<>();
    List<Student> myStudentsBothCourses = new ArrayList<>();

    List<Trainer> myTrainers = new ArrayList<>();
    List<Trainer> myTrainersJava = new ArrayList<>();
    List<Trainer> myTrainersJavaPT = new ArrayList<>();
    List<Trainer> myTrainersJavaFT = new ArrayList<>();
    List<Trainer> myTrainersC = new ArrayList<>();
    List<Trainer> myTrainersCPT = new ArrayList<>();
    List<Trainer> myTrainersCFT = new ArrayList<>();

    List<Assignment> myAssignments = new ArrayList<>();
    List<Assignment> myAssignmentsJava = new ArrayList<>();
    List<Assignment> myAssignmentsJavaPT = new ArrayList<>();
    List<Assignment> myAssignmentsJavaFT = new ArrayList<>();
    List<Assignment> myAssignmentsC = new ArrayList<>();
    List<Assignment> myAssignmentsCPT = new ArrayList<>();
    List<Assignment> myAssignmentsCFT = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void insertStudent() {
        do {
            Student st01 = new Student();
            System.out.println("Enter student's name: ");
            String firstName = sc.nextLine();
            if (firstName.isEmpty() || !firstName.matches("[a-zA-Z_]+")) {

                System.out.println("Not valid name.");
                System.out.println("Please enter student data again.");
                continue;
            } else {
                st01.setFirstName(firstName);
            }

            System.out.println("Enter student's surname: ");
            String surName = sc.nextLine();

            if (surName.isEmpty() || !surName.matches("[a-zA-Z_]+")) {
                System.out.println("Not valid name.");
                System.out.println("Please enter student data again.");
                continue;
            } else {
                st01.setLastName(surName);
            }

            System.out.println("Enter student's birth date: ");
            System.out.println("The pattern should be: d/M/yyyy");
            Scanner sc1 = new Scanner(System.in);
            String userInput = sc1.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");

            try {
                LocalDate date = LocalDate.parse(userInput, dateFormat);
                st01.setDateOfBirth(date);
                st01.setFirstName(firstName);
                st01.setLastName(surName);
                System.out.println(st01.toString() + ".Date of birth:" + st01.getDateOfBirth().format(dateFormat).toString());
            } catch (Exception e) {

                System.out.println("Not valid date.");
                System.out.println("Please enter student data again.");
                continue;
            }

            System.out.println("Press 'Java' for Java course or 'C' for C# course : ");
            String course = sc.nextLine().toLowerCase();
            if (!(course.toLowerCase().equals("java") || course.toLowerCase().equals("c")) || course.isEmpty()) {

                System.out.println("You did not type a correct letter.");
                System.out.println("Please enter student data again.");
                continue;
            }

            System.out.println("Press 'P' for Part-Time or 'F' for Full-Time");
            String stream = sc.nextLine().toLowerCase();

            if (course.toLowerCase().equals("java")) {

                if (stream.toLowerCase().equals("p")) {

                    System.out.println("Would you like this student to be added to C# Part-Time as well? ");
                    System.out.println("The price will double if the student follows both courses.");
                    System.out.println("Press 'y' for yes, 'n' for no");
                    String addcourse = sc.nextLine().toLowerCase();

                    if (addcourse.toLowerCase().equals("y")) {
                        try {
                            System.out.println("Student successfully added to C# Part-Time.");
                            System.out.println("Please enter fees for this student.");
                            Scanner sc2 = new Scanner(System.in);
                            double fees = sc2.nextDouble();
                            st01.setFees(fees * 2);
                            st01.setFirstName(firstName);
                            st01.setLastName(surName);
                            myStudentsJava.add(st01);
                            myStudentsJavaPT.add(st01);
                            System.out.println("Student was successfully created.");
                            System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                            System.out.println(courses1.toString());
                            System.out.println(courses3.toString());
                            System.out.println("Fees for Courses 1 & 3: " + st01.getFees());
                            myStudents.add(st01);
                            st01.setCourse(courses1);
                            myStudentsC.add(st01);
                            myStudentsCPT.add(st01);
                            myStudentsBothCourses.add(st01);
                            st01.setCourse(courses3);
                            System.out.println("Would you like to add another student?");
                            System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                            Scanner sc3 = new Scanner(System.in);
                            String addst = sc3.nextLine().toLowerCase();
                            if (addst.toLowerCase().equals("y")) {
                                continue;

                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println("Not valid number.");
                            System.out.println("Please enter student data again.");
                            continue;
                        }

                    } else if (addcourse.toLowerCase().equals("n")) {
                        System.out.println("This student will only follow one course.");
                        System.out.println("Please enter fees for this student.");
                        Scanner sc2 = new Scanner(System.in);
                        double fees = sc2.nextDouble();
                        st01.setFees(fees);
                        st01.setFirstName(firstName);
                        st01.setLastName(surName);
                        myStudents.add(st01);
                        myStudentsJava.add(st01);
                        myStudentsJavaPT.add(st01);
                        System.out.println("Student was successfully created.");
                        System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                        System.out.println(courses1.toString());
                        System.out.println("Fees for Course 1: " + st01.getFees());

                        st01.setCourse(courses1);
                        System.out.println("Would you like to add another student?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } else if (!(addcourse.toLowerCase().equals("n") || addcourse.toLowerCase().equals("y")) || addcourse.isEmpty()) {
                        System.out.println("You did not type the correct letter.");
                        System.out.println("Please enter student data again.");
                        continue;
                    }
                } else if (stream.toLowerCase().equals("f")) {
                    System.out.println("Would you like this student to be added to C# Full-Time as well? ");
                    System.out.println("The price will double if the student follows both courses.");
                    System.out.println("Press 'y' for yes, 'n' for no");
                    String addcourse = sc.nextLine().toLowerCase();

                    if (addcourse.toLowerCase().equals("y")) {
                        try {
                            System.out.println("Student successfully added to C# Full-Time.");
                            System.out.println("Please enter fees for this student.");
                            Scanner sc2 = new Scanner(System.in);
                            double fees = sc2.nextDouble();
                            st01.setFees(fees * 2);
                            st01.setFirstName(firstName);
                            st01.setLastName(surName);
                            myStudentsJava.add(st01);
                            myStudentsJavaFT.add(st01);
                            System.out.println("Student was successfully created.");
                            System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                            System.out.println(courses2.toString());
                            System.out.println(courses4.toString());
                            System.out.println("Fees for Courses 2 & 4: " + st01.getFees());
                            myStudents.add(st01);
                            st01.setCourse(courses2);
                            myStudentsC.add(st01);
                            myStudentsCFT.add(st01);
                            myStudentsBothCourses.add(st01);
                            st01.setCourse(courses4);
                            System.out.println("Would you like to add another student?");
                            System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                            Scanner sc3 = new Scanner(System.in);
                            String addst = sc3.nextLine().toLowerCase();
                            if (addst.toLowerCase().equals("y")) {
                                continue;

                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println("Not valid number.");
                            System.out.println("Please enter student data again.");
                            continue;
                        }

                    } else if (addcourse.toLowerCase().equals("n")) {
                        System.out.println("This student will only follow one course.");
                        System.out.println("Please enter fees for this student.");
                        Scanner sc2 = new Scanner(System.in);
                        double fees = sc2.nextDouble();
                        st01.setFees(fees);
                        st01.setFirstName(firstName);
                        st01.setLastName(surName);
                        myStudentsJava.add(st01);
                        myStudentsJavaPT.add(st01);
                        System.out.println("Student was successfully created.");
                        System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                        System.out.println(courses2.toString());
                        System.out.println("Fees for Course 2: " + st01.getFees());
                        myStudents.add(st01);
                        st01.setCourse(courses2);
                        System.out.println("Would you like to add another student?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } else if (!(addcourse.toLowerCase().equals("n") || addcourse.toLowerCase().equals("y")) || addcourse.isEmpty()) {
                        System.out.println("You did not type the correct letter.");
                        System.out.println("Please enter student data again.");
                        continue;
                    }

                }
            } else if (course.toLowerCase().equals("c")) {

                if (stream.toLowerCase().equals("p")) {

                    System.out.println("Would you like this student to be added to Java Part-Time as well? ");
                    System.out.println("The price will double if the student follows both courses.");
                    System.out.println("Press 'y' for yes, 'n' for no.");
                    String addcourse = sc.nextLine().toLowerCase();

                    if (addcourse.toLowerCase().equals("y")) {
                        try {
                            System.out.println("Student successfully added to Java Part-Time.");
                            System.out.println("Please enter fees for this student.");
                            Scanner sc2 = new Scanner(System.in);
                            double fees = sc2.nextDouble();
                            st01.setFees(fees * 2);
                            st01.setFirstName(firstName);
                            st01.setLastName(surName);
                            myStudentsJava.add(st01);
                            myStudentsJavaPT.add(st01);
                            System.out.println("Student was successfully created.");
                            System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                            System.out.println(courses3.toString());
                            System.out.println(courses1.toString());
                            System.out.println("Fees for Courses 3 & 1: " + st01.getFees());
                            myStudents.add(st01);
                            st01.setCourse(courses3);
                            myStudentsC.add(st01);
                            myStudentsCPT.add(st01);
                            myStudentsBothCourses.add(st01);
                            st01.setCourse(courses1);
                            System.out.println("Would you like to add another student?");
                            System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                            Scanner sc3 = new Scanner(System.in);
                            String addst = sc3.nextLine().toLowerCase();
                            if (addst.toLowerCase().equals("y")) {
                                continue;

                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println("Not valid number.");
                            System.out.println("Please enter student data again.");
                            continue;
                        }

                    } else if (addcourse.toLowerCase().equals("n")) {
                        System.out.println("This student will only follow one course.");
                        System.out.println("Please enter fees for this student.");
                        Scanner sc2 = new Scanner(System.in);
                        double fees = sc2.nextDouble();
                        st01.setFees(fees);
                        st01.setFirstName(firstName);
                        st01.setLastName(surName);

                        myStudentsC.add(st01);
                        myStudentsCPT.add(st01);
                        System.out.println("Student was successfully created.");
                        System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                        System.out.println(courses3.toString());
                        System.out.println("Fees for Course 1: " + st01.getFees());
                        myStudents.add(st01);
                        st01.setCourse(courses3);
                        System.out.println("Would you like to add another student?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } else if (!(addcourse.toLowerCase().equals("n") || addcourse.toLowerCase().equals("y")) || addcourse.isEmpty()) {
                        System.out.println("You did not type the correct letter.");
                        System.out.println("Please enter student data again.");
                        continue;
                    }
                } else if (stream.toLowerCase().equals("f")) {
                    System.out.println("Would you like this student to be added to Java Full-Time as well? ");
                    System.out.println("The price will double if the student follows both courses.");
                    System.out.println("Press 'y' for yes, 'n' for no.");
                    String addcourse = sc.nextLine().toLowerCase();

                    if (addcourse.toLowerCase().equals("y")) {
                        try {
                            System.out.println("Student successfully added to Java Full-Time.");
                            System.out.println("Please enter fees for this student.");
                            Scanner sc2 = new Scanner(System.in);
                            double fees = sc2.nextDouble();
                            st01.setFees(fees * 2);
                            st01.setFirstName(firstName);
                            st01.setLastName(surName);
                            myStudentsJava.add(st01);
                            myStudentsJavaFT.add(st01);
                            System.out.println("Student was successfully created.");
                            System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                            System.out.println(courses4.toString());
                            System.out.println(courses2.toString());
                            System.out.println("Fees for Courses 4 & 2: " + st01.getFees());
                            myStudents.add(st01);
                            st01.setCourse(courses4);
                            myStudentsC.add(st01);
                            myStudentsCFT.add(st01);
                            myStudentsBothCourses.add(st01);
                            st01.setCourse(courses2);
                            System.out.println("Would you like to add another student?");
                            System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                            Scanner sc3 = new Scanner(System.in);
                            String addst = sc3.nextLine().toLowerCase();
                            if (addst.toLowerCase().equals("y")) {
                                continue;

                            } else {
                                break;
                            }

                        } catch (Exception e) {

                            System.out.println("Not valid number.");
                            System.out.println("Please enter student data again.");
                            continue;
                        }

                    } else if (addcourse.toLowerCase().equals("n")) {
                        System.out.println("This student will only follow one course.");
                        System.out.println("Please enter fees for this student.");
                        Scanner sc2 = new Scanner(System.in);
                        double fees = sc2.nextDouble();
                        st01.setFees(fees);
                        st01.setFirstName(firstName);
                        st01.setLastName(surName);

                        myStudentsC.add(st01);
                        myStudentsCFT.add(st01);
                        System.out.println("Student was successfully created.");
                        System.out.println(st01.toString() + ".Birth date: " + st01.getDateOfBirth().format(dateFormat).toString());
                        System.out.println(courses4.toString());
                        System.out.println("Fees for Course 4: " + st01.getFees());
                        myStudents.add(st01);
                        st01.setCourse(courses4);
                        System.out.println("Would you like to add another student?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } else if (!(addcourse.toLowerCase().equals("n") || addcourse.toLowerCase().equals("y")) || addcourse.isEmpty()) {
                        System.out.println("You did not type the correct letter.");
                        System.out.println("Please enter student data again.");
                        continue;
                    }
                }
            }

        } while (true);

    }

    public void viewAllStudents() {

        System.out.println(toString());

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("All of the students are: ");

        for (Student student : myStudents) {
            sb.append("\n");
            sb.append(student);

        }

        return sb.toString();
    }

    public void viewJavaStudents() {

        System.out.println(toString2());
    }

    public String toString2() {
        StringBuilder sb2 = new StringBuilder("The students in Java are: ");

        for (Student student : myStudentsJava) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void viewJavaPTstudents() {

        System.out.println(toString3());
    }

    public String toString3() {
        StringBuilder sb2 = new StringBuilder("The students in Java Part-Time are: ");

        for (Student student : myStudentsJavaPT) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void viewJavaFTstudents() {

        System.out.println(toString4());
    }

    public String toString4() {
        StringBuilder sb2 = new StringBuilder("The students in Java Full-Time are: ");

        for (Student student : myStudentsJavaFT) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void viewCstudents() {

        System.out.println(toString5());
    }

    public String toString5() {
        StringBuilder sb2 = new StringBuilder("The students in C# are: ");

        for (Student student : myStudentsC) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void viewCPTstudents() {

        System.out.println(toString6());
    }

    public String toString6() {
        StringBuilder sb2 = new StringBuilder("The students in C# Part-Time are: ");

        for (Student student : myStudentsCPT) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void viewCFTstudents() {

        System.out.println(toString7());
    }

    public String toString7() {
        StringBuilder sb2 = new StringBuilder("The students in C# Full-Time are: ");

        for (Student student : myStudentsCFT) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void insertTrainer() {
        do {
            System.out.println("Enter trainer's name: ");
            String name = sc.nextLine();

            if (name.isEmpty() || !name.matches("[a-zA-Z_]+")) {

                System.out.println("Not valid name.");
                System.out.println("Please enter trainer data again.");
                continue;
            }

            System.out.println("Enter trainer's surname: ");
            String surname = sc.nextLine();

            if (surname.isEmpty() || !surname.matches("[a-zA-Z_]+")) {

                System.out.println("Not valid surname.");
                System.out.println("Please enter trainer data again.");
                continue;
            }

            System.out.println("Press 'Java' for Java course or 'C' for C# course : ");
            String course = sc.nextLine().toLowerCase();

            if (!(course.toLowerCase().equals("java") || course.toLowerCase().equals("c")) || course.isEmpty()) {

                System.out.println("You did not type a correct letter.");
                System.out.println("Please enter trainer data again.");
                continue;
            }

            System.out.println("Press 'P' for Part-Time or 'F' for Full-Time");
            String stream = sc.nextLine().toLowerCase();

            if (course.toLowerCase().equals("java")) {
                if (stream.toLowerCase().equals("p")) {
                    Trainer t01 = new Trainer(name, surname, courses1);
                    myTrainersJava.add(t01);
                    myTrainersJavaPT.add(t01);
                    System.out.println("Trainer was successfully created.");
                    System.out.println(courses1.toString());
                    myTrainers.add(t01);
                    System.out.println("Would you like to add another trainer?");
                    System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                    Scanner sc3 = new Scanner(System.in);
                    String addtr = sc3.nextLine().toLowerCase();
                    if (addtr.toLowerCase().equals("y")) {
                        continue;

                    } else {
                        break;
                    }

                } else if (stream.toLowerCase().equals("f")) {
                    Trainer t01 = new Trainer(name, surname, courses2);
                    myTrainersJava.add(t01);
                    myTrainersJavaFT.add(t01);
                    System.out.println("Trainer was successfully created.");
                    System.out.println(courses2.toString());
                    myTrainers.add(t01);
                    System.out.println("Would you like to add another trainer?");
                    System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                    Scanner sc3 = new Scanner(System.in);
                    String addtr = sc3.nextLine().toLowerCase();
                    if (addtr.toLowerCase().equals("y")) {
                        continue;

                    } else {
                        break;
                    }

                } else if (!(stream.toLowerCase().equals("f") || course.toLowerCase().equals("p")) || course.isEmpty()) {

                    System.out.println("You did not type a correct letter.");
                    System.out.println("Please enter trainer data again.");
                    continue;
                }

            } else if (course.toLowerCase().equals("c")) {
                if (stream.toLowerCase().equals("p")) {
                    Trainer t01 = new Trainer(name, surname, courses3);
                    myTrainersC.add(t01);
                    myTrainersCPT.add(t01);
                    System.out.println("Trainer was succesfully created.");
                    System.out.println(courses3.toString());
                    myTrainers.add(t01);
                    System.out.println("Would you like to add another trainer?");
                    System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                    Scanner sc3 = new Scanner(System.in);
                    String addtr = sc3.nextLine().toLowerCase();
                    if (addtr.toLowerCase().equals("y")) {
                        continue;

                    } else {
                        break;
                    }

                } else if (stream.toLowerCase().equals("f")) {
                    Trainer t01 = new Trainer(name, surname, courses4);
                    myTrainersC.add(t01);
                    myTrainersCFT.add(t01);
                    System.out.println("Trainer was succesfully created.");
                    System.out.println(courses4.toString());
                    myTrainers.add(t01);
                    System.out.println("Would you like to add another trainer?");
                    System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                    Scanner sc3 = new Scanner(System.in);
                    String addtr = sc3.nextLine().toLowerCase();
                    if (addtr.toLowerCase().equals("y")) {
                        continue;

                    } else {
                        break;
                    }

                } else if (!(stream.toLowerCase().equals("f") || stream.toLowerCase().equals("p")) || stream.isEmpty()) {

                    System.out.println("You did not type a correct letter.");
                    System.out.println("Please enter enter trainer data again.");
                    continue;
                }

            }
        } while (true);

    }

    public void viewAllTrainers() {

        System.out.println(toString8());

    }

    public String toString8() {
        StringBuilder sb = new StringBuilder("All of the trainers are: ");

        for (Trainer trainer : myTrainers) {
            sb.append("\n");
            sb.append(trainer);

        }

        return sb.toString();
    }

    public void viewAllCourses() {

        System.out.println(toString29());

    }

    public String toString29() {
        StringBuilder sb = new StringBuilder("All of the courses are: ");

        for (Course course : myCourses) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
            sb.append("\n");
            sb.append(course.getTitle() + ":" + course.getStream() + " " + course.getType() + ". Lessons start: " + course.getStart_date().format(dateFormat) + ". Lessons end: " + course.getEnd_date().format(dateFormat));

        }

        return sb.toString();
    }

    public void viewJavaTrainers() {

        System.out.println(toString9());
    }

    public String toString9() {
        StringBuilder sb2 = new StringBuilder("The trainers in Java are: ");

        for (Trainer trainer : myTrainersJava) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void viewJavaPTtrainers() {

        System.out.println(toString10());
    }

    public String toString10() {
        StringBuilder sb2 = new StringBuilder("The trainers in Java Part-Time are: ");

        for (Trainer trainer : myTrainersJavaPT) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void viewJavaFTtrainers() {

        System.out.println(toString11());
    }

    public String toString11() {
        StringBuilder sb2 = new StringBuilder("The trainers in Java Full-Time are: ");

        for (Trainer trainer : myTrainersJavaFT) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void viewCtrainers() {

        System.out.println(toString12());
    }

    public String toString12() {
        StringBuilder sb2 = new StringBuilder("The trainers in C# are: ");

        for (Trainer trainer : myTrainersC) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void viewCPTtrainers() {

        System.out.println(toString13());
    }

    public String toString13() {
        StringBuilder sb2 = new StringBuilder("The trainers in C# Part-Time are: ");

        for (Trainer trainer : myTrainersCPT) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void viewCFTtrainers() {

        System.out.println(toString14());
    }

    public String toString14() {
        StringBuilder sb2 = new StringBuilder("The trainers in C# Full-Time are: ");

        for (Trainer trainer : myTrainersCFT) {
            sb2.append("\n");
            sb2.append(trainer);

        }
        return sb2.toString();
    }

    public void insertAssignment() {
        do {
            System.out.println("Enter assignment's title: ");
            String title1 = sc.nextLine();

            if (title1.isEmpty()) {

                System.out.println("Not valid title.");
                System.out.println("Please enter assignment data again.");
                continue;
            }

            System.out.println("Enter assignment's description: ");
            String desc1 = sc.nextLine();

            if (desc1.isEmpty() || desc1.matches("^[0-9]*$")) {
                System.out.println("Not valid description.");
                System.out.println("Please enter assignment data again.");
                continue;
            }

            System.out.println("Press 'Java' for Java course assignemt or 'C' for C# course assignment: ");
            String course = sc.nextLine().toLowerCase();

            if (!(course.toLowerCase().equals("java") || course.toLowerCase().equals("c")) || course.isEmpty()) {

                System.out.println("You did not type a correct letter.");
                System.out.println("Please enter assignment data again.");
                continue;
            }

            System.out.println("Press 'P' for Part-Time or 'F' for Full-Time");
            String stream = sc.nextLine().toLowerCase();
            if (course.toLowerCase().equals("java")) {

                if (stream.toLowerCase().equals("p")) {

                    try {
                        System.out.println("Type submission date for assignment.");
                        System.out.println("The pattern should be: d/M/yyyy");
                        Scanner sc1 = new Scanner(System.in);
                        String userInput = sc1.nextLine();

                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
                        LocalDate date = LocalDate.parse(userInput, dateFormat);

                        Assignment a1 = new Assignment(title1, desc1, date, courses1);
                        myAssignmentsJava.add(a1);
                        myAssignmentsJavaPT.add(a1);
                        System.out.println("Assignment was succesfully created.");
                        System.out.println(a1.toString());
                        System.out.println(courses1.toString());
                        myAssignments.add(a1);
                        a1.setCourse(courses1);
                        System.out.println("Would you like to add another assignment?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Not valid date.");
                        System.out.println("Please enter assignment data again.");
                        continue;
                    }

                } else if (stream.toLowerCase().equals("f")) {
                    try {
                        System.out.println("Type submission date for assignment.");
                        System.out.println("The pattern should be: d/M/yyyy");
                        Scanner sc1 = new Scanner(System.in);
                        String userInput = sc1.nextLine();

                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
                        LocalDate date = LocalDate.parse(userInput, dateFormat);

                        Assignment a1 = new Assignment(title1, desc1, date, courses2);
                        myAssignmentsJava.add(a1);
                        myAssignmentsJavaFT.add(a1);
                        System.out.println("Assignment was succesfully created.");
                        System.out.println(a1.toString());
                        System.out.println(courses2.toString());
                        myAssignments.add(a1);
                        a1.setCourse(courses2);
                        System.out.println("Would you like to add another assignment?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Not valid date.");
                        System.out.println("Please enter assignment data again.");
                        continue;
                    }

                } else if (!(stream.toLowerCase().equals("f") || stream.toLowerCase().equals("p")) || stream.isEmpty()) {

                    System.out.println("You did not type a correct letter.");
                    System.out.println("Please enter assignment data again.");
                    continue;
                }
                System.out.println("Insert assignment submission date. ");
                System.out.println("Type the date with the following pattern: d/M/yyyy ");

            } else if (course.toLowerCase().equals("c")) {

                if (stream.toLowerCase().equals("p")) {
                    try {
                        System.out.println("Type submission date for assignment.");
                        System.out.println("The pattern should be: d/M/yyyy");
                        Scanner sc1 = new Scanner(System.in);
                        String userInput = sc1.nextLine();

                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
                        LocalDate date = LocalDate.parse(userInput, dateFormat);

                        Assignment a1 = new Assignment(title1, desc1, date, courses3);
                        myAssignmentsC.add(a1);
                        myAssignmentsCPT.add(a1);
                        System.out.println("Assignment was succesfully created.");
                        System.out.println(a1.toString());
                        System.out.println(courses3.toString());
                        myAssignments.add(a1);
                        a1.setCourse(courses3);
                        System.out.println("Would you like to add another assignment?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Not valid date.");
                        System.out.println("Please enter assignment data again.");
                        continue;
                    }

                } else if (stream.toLowerCase().equals("f")) {
                    try {
                        System.out.println("Type submission date for assignment.");
                        System.out.println("The pattern should be: d/M/yyyy");
                        Scanner sc1 = new Scanner(System.in);
                        String userInput = sc1.nextLine();

                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
                        LocalDate date = LocalDate.parse(userInput, dateFormat);

                        Assignment a1 = new Assignment(title1, desc1, date, courses4);
                        myAssignmentsC.add(a1);
                        myAssignmentsCFT.add(a1);
                        System.out.println("Assignment was succesfully created.");
                        System.out.println(a1.toString());
                        System.out.println(courses4.toString());
                        myAssignments.add(a1);
                        a1.setCourse(courses4);
                        System.out.println("Would you like to add another assignment?");
                        System.out.println("Press 'y' for yes or any other key to exit to main menu.");
                        Scanner sc3 = new Scanner(System.in);
                        String addst = sc3.nextLine().toLowerCase();
                        if (addst.toLowerCase().equals("y")) {
                            continue;

                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Not valid date.");
                        System.out.println("Please enter assignment data again.");
                        continue;
                    }

                } else if (!(stream.toLowerCase().equals("f") || stream.toLowerCase().equals("p")) || stream.isEmpty()) {

                    System.out.println("You did not type a correct letter.");
                    System.out.println("Please enter assignment data again.");
                    continue;
                }

            }

        } while (true);

    }

    public void viewAllAssignments() {

        System.out.println(toString15());

    }

    public String toString15() {
        StringBuilder sb = new StringBuilder("All of the assignments are: ");

        for (Assignment assignment : myAssignments) {
            sb.append("\n");
            sb.append(assignment);

        }

        return sb.toString();
    }

    public void viewJavaAssignments() {

        System.out.println(toString16());
    }

    public String toString16() {
        StringBuilder sb2 = new StringBuilder("The assignments in Java are: ");

        for (Assignment assignment : myAssignmentsJava) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewJavaPTassignments() {

        System.out.println(toString17());
    }

    public String toString17() {
        StringBuilder sb2 = new StringBuilder("The assignments in Java Part-Time are: ");

        for (Assignment assignment : myAssignmentsJavaPT) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewJavaFTassignments() {

        System.out.println(toString18());
    }

    public String toString18() {
        StringBuilder sb2 = new StringBuilder("The assignments in Java Full-Time are: ");

        for (Assignment assignment : myAssignmentsJavaFT) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewCassignments() {

        System.out.println(toString19());
    }

    public String toString19() {
        StringBuilder sb2 = new StringBuilder("The assignments in C# are: ");

        for (Assignment assignment : myAssignmentsC) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewCPTassignments() {

        System.out.println(toString20());
    }

    public String toString20() {
        StringBuilder sb2 = new StringBuilder("The assignments in C# Part-Time are: ");

        for (Assignment assignment : myAssignmentsCPT) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewCFTassignments() {

        System.out.println(toString21());
    }

    public String toString21() {
        StringBuilder sb2 = new StringBuilder("The Assignments in C# Full-Time are: ");

        for (Assignment assignment : myAssignmentsCFT) {
            sb2.append("\n");
            sb2.append(assignment);

        }
        return sb2.toString();
    }

    public void viewAssignmentPerStudent() {
        for (Student student : myStudentsJavaPT) {

            System.out.println(student.toString() + "\nAssignments:" + myAssignmentsJavaPT.toString());
            System.out.println(courses1.toString());
        }
        System.out.println();
        for (Student student : myStudentsJavaFT) {
            System.out.println(student.toString() + "\nAssignments:" + myAssignmentsJavaFT.toString());
            System.out.println(courses2.toString());
        }
        System.out.println();
        for (Student student : myStudentsCPT) {
            System.out.println(student.toString() + "\nAssignments:" + myAssignmentsCPT.toString());
            System.out.println(courses3.toString());
        }
        System.out.println();
        for (Student student : myStudentsCFT) {
            System.out.println(student.toString() + "\nAssignments:" + myAssignmentsCFT.toString());
            System.out.println(courses4.toString());
        }

    }

    public void DateMethod() {

        System.out.println("Insert Date you would like to check for assignments to be submitted. ");
        System.out.println("Type the date with the following pattern: d/M/yyyy ");
        try {

            Scanner sc1 = new Scanner(System.in);
            String userInput = sc1.nextLine();

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date = LocalDate.parse(userInput, dateFormat);
            for (Assignment assignment : myAssignments) {
                assignment.getSubDateTime();
                LocalDate event = assignment.getSubDateTime();
                LocalDate today = date;
                LocalDate endOfWeek;
                LocalDate startOfWeek;

                today.getDayOfWeek();
                if (today.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    endOfWeek = today.minusDays(1);
                    startOfWeek = today.minusDays(5);
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    endOfWeek = today.minusDays(2);
                    startOfWeek = today.minusDays(6);
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                    endOfWeek = today.plusDays(4);
                    startOfWeek = today;
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
                    endOfWeek = today.plusDays(3);
                    startOfWeek = today.minusDays(1);
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {

                    endOfWeek = today.plusDays(2);
                    startOfWeek = today.minusDays(2);

                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                    endOfWeek = today.plusDays(1);
                    startOfWeek = today.minusDays(3);
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) < 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                } else if (today.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    endOfWeek = today;
                    startOfWeek = today.minusDays(4);
                    if (startOfWeek.compareTo(event) <= 0 && event.compareTo(endOfWeek) <= 0) {
                        System.out.println();
                        System.out.println("Assignments for calendar week " + startOfWeek.format(dateFormat).toString() + " to " + endOfWeek.format(dateFormat).toString() + " are the following:");
                        System.out.println(assignment.getTitle() + " has to be submitted on:" + assignment.getSubDateTime().format(dateFormat));
                        System.out.println(assignment.getCourse());
                        System.out.println();
                        System.out.println("Students who owe this assignment are: ");
                        for (Student student : myStudents) {
                            if (student.getCourse().equals(assignment.getCourse())) {
                                System.out.println(student);
                            }

                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Not valid date.");
        }

    }

    public void viewStudentsInManyCourses() {
        System.out.println(toString22());
    }

    public String toString22() {
        StringBuilder sb2 = new StringBuilder("The Students following both courses are: ");

        for (Student student : myStudentsBothCourses) {
            sb2.append("\n");
            sb2.append(student);

        }
        return sb2.toString();
    }

    public void syntheticData() {
        Student st1 = new Student("George", "Bennett", courses1);
        st1.setCourse(courses1);
        Student st2 = new Student("Joanna", "Morgan", courses2);
        st2.setCourse(courses2);
        Student st3 = new Student("Helen", "Long", courses3);
        st3.setCourse(courses3);
        Student st4 = new Student("Adam", "Scott", courses4);
        st4.setCourse(courses4);
        st4.setCourse(courses2);

        myStudents.add(st1);
        myStudentsJava.add(st1);
        myStudentsJavaPT.add(st1);

        myStudents.add(st2);
        myStudentsJava.add(st2);
        myStudentsJavaFT.add(st2);
        myStudents.add(st4);
        myStudentsJava.add(st4);
        myStudentsJavaFT.add(st4);

        myStudents.add(st3);
        myStudentsC.add(st3);
        myStudentsCPT.add(st3);

        myStudents.add(st4);
        myStudentsC.add(st4);
        myStudentsCFT.add(st4);

        myStudentsBothCourses.add(st4);

        Assignment as1 = new Assignment("First Assignment in Java Part-Time", "This is your first assignment", LocalDate.of(2020, Month.FEBRUARY, 14), courses1);
        Assignment as2 = new Assignment("First Assignment in Java Full-Time", "This is your first assignment", LocalDate.of(2019, Month.NOVEMBER, 11), courses2);
        Assignment as3 = new Assignment("First Assignment in C# Part-Time", "This is your first assignment", LocalDate.of(2020, Month.JUNE, 11), courses3);
        Assignment as4 = new Assignment("First Assignment in C# Full-Time", "This is your first assignment", LocalDate.of(2020, Month.MAY, 14), courses4);
        myAssignments.add(as1);
        as1.setCourse(courses1);
        myAssignmentsJava.add(as1);
        myAssignmentsJavaPT.add(as1);

        myAssignments.add(as2);
        as2.setCourse(courses2);
        myAssignmentsJava.add(as2);
        myAssignmentsJavaFT.add(as2);

        myAssignments.add(as3);
        as3.setCourse(courses3);
        myAssignmentsC.add(as3);
        myAssignmentsCPT.add(as3);

        myAssignments.add(as4);
        as4.setCourse(courses4);
        myAssignmentsC.add(as4);
        myAssignmentsCFT.add(as4);

        Trainer tr1 = new Trainer("Ross", "Henderson", courses1);
        Trainer tr2 = new Trainer("Kim", "Turner", courses2);
        Trainer tr3 = new Trainer("Kelly", "Walker", courses3);
        Trainer tr4 = new Trainer("Martin", "Thompson", courses4);

        myTrainers.add(tr1);
        myTrainersJava.add(tr1);
        myTrainersJavaPT.add(tr1);

        myTrainers.add(tr2);
        myTrainersJava.add(tr2);
        myTrainersJavaFT.add(tr2);

        myTrainers.add(tr3);
        myTrainersC.add(tr3);
        myTrainersCPT.add(tr3);

        myTrainers.add(tr4);
        myTrainersC.add(tr4);
        myTrainersCFT.add(tr4);

        myCourses.add(courses1);
        myCourses.add(courses2);
        myCourses.add(courses3);
        myCourses.add(courses4);

    }

}
