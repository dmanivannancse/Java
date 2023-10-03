package handson;

public class FISample implements FISampleI, FISample2I {
    

    @Override
    public double tax(double amount) {
        return (tax*amount) /100;
    }

    @Override
    public void welcome(String message) {
        //If same default method is available in two interface, we have to override the method.
        //otherwise compilation error will occur. 
        // Call the one of the default method like below. use the Interface Name
        FISampleI.super.welcome(message);
    }

    public static void main(String[] args) {
        FISampleI fiSample = new FISample();
        System.out.println(fiSample.tax(500));
        FISampleI fiSampleI = amount -> amount; 
        System.out.println(fiSample.getClass() +", "+ fiSampleI.getClass());
    }

}


/// Interface can have any number of default and static methods. 
/// Interface becomes FuntionalInterface when its having only one abstarct method.  
/// Funtional Interfaces are introduced for lambda expressions.
/// Check Streams API for more Funtional Interfaces

@FunctionalInterface
interface FISampleI {
    double tax = 20;

    double tax(double amount);

    default void welcome(String message){
        System.out.println("Welcome "+message);
    }
    
    default void goodBye(String message){
        System.out.println("Goodbye "+message);
    }

    static double profit(double borrowedPrice, double soldPrice){
        return soldPrice - borrowedPrice;
    }

}


interface FISample2I {
    default void welcome(String message){
        System.out.println("Welcom "+message);
    }
    default void greetings(){

    }
    static double profit(double borrowedPrice, double soldPrice){
        return soldPrice - borrowedPrice;
    }
}