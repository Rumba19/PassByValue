public class PassByValue{
    
    // Method that receives a copy of the primitive value
    public static void tryToChangeNumber(int number) {
        System.out.println("  Inside method - received number: " + number);
        number = 1;  // This changes only the local copy
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
    


    public static void main(String[] args) {
        System.out.println("=== PRIMITIVE PASS-BY-VALUE ===");
        
        int myNumber = 13;
        System.out.println("Before method call: myNumber = " + myNumber);
        
        tryToChangeNumber(myNumber);
        
        System.out.println("After method call: myNumber = " + myNumber);
         System.out.println("===  INTRODUCING STUDENT OBJECT ===");
           // Create a student object
        Student myStudent = new Student("Rumba Test", 12);
        System.out.println("Created student: " + myStudent);
        
        // Pass the student to a method
        System.out.println("\nCalling displayStudent method:");
        displayStudent(myStudent);
        
        System.out.println("\nBack in main: " + myStudent);
        
         System.out.println("\nCalling promoteStudent method:");
        promoteStudent(myStudent);
        
        System.out.println("\nBack in main: " + myStudent);
    }
}