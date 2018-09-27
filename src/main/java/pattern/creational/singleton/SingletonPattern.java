package pattern.creational.singleton;

/**
 * Created by stuff on 3/4/2017.
 */
public class SingletonPattern
{
    SingletonPattern()
    {
        System.out.println("Simple singleton pattern");
        Calculator calculator = Calculator.getInstance();
        calculator.printHashCode();

        calculator = Calculator.getInstance(); // always the same object
        calculator.printHashCode();

        calculator = new Calculator(); // new object without singleton pattern
        calculator.printHashCode();


        System.out.println("\nThread safe singleton pattern");
        ThreadSafeCalculator threadSafeCalculator = ThreadSafeCalculator.getInstance();
        threadSafeCalculator.printHashCode();

        threadSafeCalculator = ThreadSafeCalculator.getInstance(); // always the same object
        threadSafeCalculator.printHashCode();

        threadSafeCalculator = new ThreadSafeCalculator(); // new object without singleton pattern
        threadSafeCalculator.printHashCode();
    }

    public static void main(String[] args)
    {
        new SingletonPattern();
    }
}
