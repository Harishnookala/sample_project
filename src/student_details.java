import java.util.Scanner;

 class SMSApplication {
    public static void main(String s[]) {
        StudentMainentance sm = new StudentMainentance();
        sm.process();

    }
}
class StudentMainentance
{
    Student[] allStudents = new Student[50];
    int nextStudentIndex = 0;
    int f=0;
    Scanner scanner = new Scanner(System.in);
    public void process() {
        printHelp();
        System.out.println("Enter your's choice:");
        while (scanner.hasNext())
        {
            int input = scanner.nextInt();
            switch (input)
            {
                case 1:
                    showStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    printHelp();
                    break;
                case 7:
                    Search_By_Name();
                    break;
                case 8:
                    Search_By_Section();
                    break;
                case 9:
                    Greaterthanmarks();
                    break;
                case 10:
                    print3_Toppers();
                    break;
                case 11:
                    sort_by_student_name();
                    break;
                case 12:
                    sort_by_student_marks();
                    break;
                case 13:
                    sort_by_student_marks_Desc();
                    break;
                case 6:
                    System.exit(0);
            }
            System.out.println("Enter your choice:");
        }
    }
    private void print3_Toppers() {

        Student[] SortArraym = new Student[50];
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null)
            {
                SortArraym[i] = allStudents[i];
            }


        }

        Student temsMarks = null;
        for (int i = 0; i < SortArraym.length - 1; i++)
        {
            for (int j = i + 1; j < SortArraym.length; j++)
            {
                if ((SortArraym[i] != null) && (SortArraym[j] != null))
                {
                    if (SortArraym[i].marks > SortArraym[j].marks)
                    {
                        temsMarks = SortArraym[i];
                        SortArraym[i] = SortArraym[j];
                        SortArraym[j] = temsMarks;
                    }
                }
            }
        }
        int count = 0;
        System.out.println("---------------------------------------------------");
        for (int i = SortArraym.length - 1; i >= 0; i--)
        {
            if ((SortArraym[i] != null) && (count < 3))
            {
                SortArraym[i].print();
                count++;

            }
        }
        System.out.println("---------------------------------------------------");

    }

    private void Greaterthanmarks() {
        System.out.print("Enter the greater marks");
        int marks = scanner.nextInt();
        for(int i=0;i<allStudents.length;i++) {
            if(allStudents[i]!=null) {
                if(allStudents[i].marks > marks) {
                    allStudents[i].print();
                }
            }
        }
    }
    void Search_By_Section() {

        System.out.print("Enter Student section");
        char section = scanner.next().charAt(0);
        for(int i=0;i<allStudents.length;i++) {
            if(allStudents[i]!=null) {
                if(allStudents[i].section == section ) {
                    allStudents[i].print();
                }
            }
        }

    }
    void Search_By_Name() {

        System.out.print("Enter Student name");
        String name = scanner.next();
        for(int i=0;i<allStudents.length;i++) {
            if(allStudents[i]!=null) {
                if(allStudents[i].name.equals(name)) {
                    allStudents[i].print();
                }
            }
        }
    }
    void showStudents()
    {

        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null)
            {
                allStudents[i].print();
            }
        }
    }
    void addStudent()
    {
        Student student = new Student();
        System.out.println("Enter name :");
        student.name = scanner.next();
        System.out.println("Enter rollNumber :");
        student.rollNumber = scanner.nextInt();
        System.out.println("Enter section :");
        student.section = scanner.next().charAt(0);
        System.out.println("Enter marks :");
        student.marks = scanner.nextInt();
        allStudents[nextStudentIndex] = student;
        nextStudentIndex++;
    }
    void deleteStudent()
    {
        Student student=new Student();
        System.out.println("Enter the Which element ");
        student.rollNumber = scanner.nextInt();
        for (int i=0;i<allStudents.length;i++)
        {
            if (allStudents[i] != null)
            {
                if (allStudents[i].rollNumber == student.rollNumber)
                {

                    allStudents[i] = null;
                }
            }
        }
    }
    void modifyStudent()
    {
        Student student = new Student();
        System.out.println("Enter rollNumber :");
        student.rollNumber = scanner.nextInt();
        for(int i=0;i<allStudents.length;i++){
            if (allStudents[i] != null)
            {
                if (allStudents[i].rollNumber == student.rollNumber) {

                    System.out.println("Enter name :");
                    allStudents[i].name = scanner.next();
                    System.out.println("Enter section :");
                    allStudents[i].section = scanner.next().charAt(0);
                    System.out.println("Enter marks :");
                    allStudents[i].marks = scanner.nextInt();
                }
            }
        }
    }
    void sort_by_student_name() {

        System.out.println("Sorted names -");
        System.out.println("-----------------");
        Student[] SortArray = new Student[100];
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null) {
                SortArray[i] = allStudents[i];
            }


        }

        Student temp = null;
        for (int i = 0; i < SortArray.length - 1; i++) {
            for (int j = i + 1; j < SortArray.length; j++) {
                if ((SortArray[i] != null) && (SortArray[j] != null)) {
                    if (SortArray[i].name.compareTo(SortArray[j].name) > 0) {
                        temp = SortArray[i];
                        SortArray[i] = SortArray[j];
                        SortArray[j] = temp;
                    }
                }
            }
        }
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < SortArray.length; i++) {
            if (SortArray[i] != null) {
                SortArray[i].print();
            }
        }
        System.out.println("---------------------------------------------------");

    }
    void sort_by_student_marks() {
        Student[] SortArraym = new Student[50];
        for (int i = 0; i < allStudents.length; i++)
        {
            if (allStudents[i] != null)
            {
                SortArraym[i] = allStudents[i];
            }


        }

        Student temsMarks = null;
        for (int i = 0; i < SortArraym.length - 1; i++)
        {
            for (int j = i + 1; j < SortArraym.length; j++)
            {
                if ((SortArraym[i] != null) && (SortArraym[j] != null))
                {
                    if (SortArraym[i].marks < SortArraym[j].marks)
                    {
                        temsMarks = SortArraym[i];
                        SortArraym[i] = SortArraym[j];
                        SortArraym[j] = temsMarks;
                    }
                }
            }
        }


        for (int i = SortArraym.length - 1; i >= 0; i--)
        {
            if ((SortArraym[i] != null))
            {
                SortArraym[i].print();


            }
        }
        System.out.println("---------------------------------------------------");

    }
    void sort_by_student_marks_Desc() {

        System.out.println("Sorted marks in descending -");
        System.out.println("-----------------");
        Student[] SortArraym = new Student[50];
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null) {
                SortArraym[i] = allStudents[i];
            }


        }

        Student marks = null;
        for (int i = 0; i < SortArraym.length - 1; i++) {
            for (int j = i + 1; j < SortArraym.length; j++) {
                if ((SortArraym[i] != null) && (SortArraym[j] != null)) {
                    if (SortArraym[i].marks > SortArraym[j].marks) {
                        marks = SortArraym[i];
                        SortArraym[i] = SortArraym[j];
                        SortArraym[j] = marks;
                    }
                }
            }
        }
        for (int i = SortArraym.length - 1; i >= 0; i--) {
            if (SortArraym[i] != null) {
                SortArraym[i].print();
            }
        }
    }



    void printHelp()
    {
        System.out.println("Please use the following commands.");
        System.out.println("1. List");
        System.out.println("2. Add");
        System.out.println("3. Modify");
        System.out.println("4. Delete");
        System.out.println("5. Help");
        System.out.println("6. Exit");
        System.out.println("7. Search_by_name");
        System.out.println("8. SearchBysection");
        System.out.println("9. Greaterthanmarks");
        System.out.println("10.print toppers" );
        System.out.println("11.sort_by_name");
        System.out.println("12.sort_by student marks Asc");
        System.out.println("13.sort_by_student_marks_Desc");
    }
}
class Student
{
    String name;
    int rollNumber;
    char section;
    int marks;
    void print()
    {
        System.out.println(name + " " + rollNumber + " " + section + " " + marks);
    }
}
