package pattern.creational;

public class SingletonPattern
{
    public static void main(String[] args)
    {
        new SingletonPattern();
    }

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
}

// singleton object
class Calculator
{
    private static Calculator instance = null;

    protected Calculator()
    {
        System.out.println("created new calculator object");
    }

    public static Calculator getInstance()
    {
        if (instance == null)
        {
            instance = new Calculator();
        }
        return instance;
    }

    public void printHashCode()
    {
        System.out.println("object hash code: " + this.hashCode());
    }
}

/**
 * @source https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
class ThreadSafeCalculator
{
    private static class StaticHolder
    {
        static final ThreadSafeCalculator INSTANCE = new ThreadSafeCalculator();
    }

    protected ThreadSafeCalculator()
    {
        System.out.println("created new thread-safe calculator object");
    }

    public static ThreadSafeCalculator getInstance()
    {
        return StaticHolder.INSTANCE;
    }

    public void printHashCode()
    {
        System.out.println("object hash code: " + this.hashCode());
    }
}