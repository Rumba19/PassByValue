public class PassByValue{
    
    // Method that receives a copy of the primitive value
    public static void tryToChangeNumber(int number) {
        System.out.println("  Inside method - received number: " + number);
        number = 1;  // This changes only the local copy
        System.out.println("  Inside method - changed number to: " + number);
    }
    
    public static void main(String[] args) {
        System.out.println("=== PRIMITIVE PASS-BY-VALUE ===");
        
        int myNumber = 13;
        System.out.println("Before method call: myNumber = " + myNumber);
        
        tryToChangeNumber(myNumber);
        
        System.out.println("After method call: myNumber = " + myNumber);
        
        System.out.println("\nExplanation:");
        System.out.println("- Java passed a COPY of myNumber's value (13) to the method");
        System.out.println("- The method changed its local copy to 1");
        System.out.println("- The original myNumber remains unchanged at 13");
    }
}