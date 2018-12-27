import java.util.Scanner;
class college{
    public static void main(String[] args) {
        details_of_college details = new details_of_college();
        details.firststep();
        college college = new college();
    }
}
class college_details{
    String college_name;
    int no_of_departments;
    String Type_of_university;
    student_details std[];
    Department dept[];
    library lib;
    void print_college(){

        System.out.println(college_name + no_of_departments + Type_of_university);
    }
}
class student_details{

    Department dep = new Department();
    int roll_no;
    String name;
    char section;
    Department dept[];
    college_details col[];
    void print_college_student_details(){
        System.out.println(  name + roll_no + section + dep.department_name + dep.department_head);
    }
}
 class Department {
    String department_name;
    String department_head;
    Lectures lect[] = new Lectures[50];
    student_details std[]  = new student_details[25];
}

 class Lectures{
    String lecturer_name;
    subject sub;
}

class subject{
    String subject_name;

}
 class library {
    String librarin_name;
    int no_of_books;
}
class details_of_college {

    int n = 0;
    college_details all_details[] = new college_details[6];
    student_details all_student_details []  = new student_details[50];
    int f=0;
    Scanner scanner = new Scanner(System.in);

    public void firststep() {
        printHelp();
        System.out.println("Enter yours choice");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int input = scanner.nextInt();
            switch (input) {

                case 1:
                    System.out.println("Enter college details");
                    college_details();
                    break;
                case 2:
                    student_details();

            }

        }
    }

    private void student_details() {
        while (true) {
            System.out.println("1.Add student details");
            System.out.println("2.show Student details");
            System.out.println("3.remove student details");
            System.out.print("4.back to firststep");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                     Add_student();
                    break;
                case 2:
                    show_student_details();
                case 3:

            }
        }

    }

    private void show_student_details() {
        String h="";

               h = all_details[0].college_name;
               System.out.println(h.length());
                for(int t =0;t<h.length();t++)
                {
                  for (int i = 0; i < all_student_details[0].name.length(); i++) {
                     if (all_student_details[i] != null) {
                         all_student_details[i].print_college_student_details();
                     }
                  }
                }
        }


    private void Add_student() {
        student_details s = new student_details();
        System.out.println("Enter Student name : ");
        s.name = scanner.next();
        System.out.println("Enter roll no : ");
        s.roll_no  = scanner.nextInt();
        System.out.println("Enter section");
        s.section = scanner.next().charAt(0);
        all_student_details[f] = s;
        f++;
    }

    private void college_details() {

        while (true) {
            System.out.println("1. Add college details");
            System.out.println("2. show details");
            System.out.println("3. remove college details");
            System.out.println("4.back to firststep");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Addcollege();

                    break;
                case 2:
                    show_details();
                    break;
                case 3:
                    remove_college_details();
                    break;
                case 4:
                    firststep();
                    break;

            }
        }
    }

    private void show_details() {
        for (int i = 0; i < all_details.length; i++) {
            if (all_details[i] != null) {
                all_details[i].print_college();
            }
        }
    }

    private void remove_college_details() {
        System.out.println("Enter college name");
        String name = scanner.next();
        for (int i = 0; i < all_details.length; i++) {
            if (all_details[i] != null) {
                if (all_details[i].college_name.equals(name)) {
                    all_details[i] = null;

                }

            }
        }
    }

    private void Addcollege() {
        college_details d = new college_details();
        System.out.println("Enter name");
        d.college_name  = scanner.next();
        System.out.println("no of departments");
        d.no_of_departments  = scanner.nextInt();
        System.out.println("Type of university");
        d.Type_of_university = scanner.next();
        all_details[n]= d;
        n++;

    }
    void printHelp(){
        System.out.println("Enter the following commands ");
        System.out.println("1. College details");
        System.out.println("2. student_details");
        System.out.println("3. Department details" );
        System.out.println("4. Lecturer details");
        System.out.println("5. show college details");
        System.out.println("6. Add college details");

    }

}