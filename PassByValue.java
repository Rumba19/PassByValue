public class PassByValue {

    // Method that receives a copy of the primitive value
    public static void tryToChangeNumber(int number) {
        System.out.println("  Inside method - received number: " + number);
        number = 1; // This changes only the local copy
        System.out.println("  Inside method - changed number to: " + number);
    }

    public static class Student {
        String name;
        int grade;
        
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
        
        @Override
        public String toString() {
            return "Student{name='" + name + "', grade=" + grade + "}";
        }
    }

    public static void displayStudent(Student student) {
        System.out.println("  Inside method - received student: " + student);
    }

    // Method that modifies the student's properties
    public static void promoteStudent(Student student) {
        System.out.println("  Inside method - received: " + student);
        // Modify the student's properties
        student.name = student.name + " (Promoted)";
        student.grade = student.grade + 1;
        System.out.println("  Inside method - after changes: " + student);
    }

    public static void replaceStudent(Student student) {
        System.out.println("  Inside method - received: " + student);
        // Try to reassign the reference to a brand new Student object
        student = new Student("Bob", 4);
        System.out.println("  Inside method - reassigned to: " + student);
        System.out.println("  Inside method - modifying the new student...");
        // Modify the new student
        student.name = "Bob to Charlie";
        student.grade = 5;
        System.out.println("  Inside method - after modification: " + student);
    }

    public static void main(String[] args) {
        System.out.println("=== PRIMITIVE PASS-BY-VALUE ===");
        int myNumber = 13;
        System.out.println("Before method call: myNumber = " + myNumber);
        tryToChangeNumber(myNumber);
        System.out.println("After method call: myNumber = " + myNumber);
        
        System.out.println("\n=== INTRODUCING STUDENT OBJECT ===");
        // Create a student object
        Student myStudent = new Student("Rumba Test", 12);
        System.out.println("Created student: " + myStudent);
        
        // Pass the student to a method
        System.out.println("\nCalling displayStudent method:");
        displayStudent(myStudent);
        System.out.println("Back in main: " + myStudent);
        
        System.out.println("\nCalling promoteStudent method:");
        promoteStudent(myStudent);
        System.out.println("Back in main: " + myStudent);
        
        // Pass student to method that tries to replace it
        System.out.println("\nCalling replaceStudent method:");
        replaceStudent(myStudent);
        System.out.println("Back in main: " + myStudent);
        
        System.out.println("\n=== ANALYSIS OF RESULTS ===");
        System.out.println("1. myNumber: UNCHANGED (13) - primitive passed by value");
        System.out.println("2. myStudent after promotion: CHANGED - object contents modified");
        System.out.println("3. myStudent after replacement attempt: UNCHANGED - reference reassignment failed");
        System.out.println("\nThis proves Java passes everything BY VALUE!");
    }
}