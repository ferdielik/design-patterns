package pattern.creational.singleton;

/**
 * Created by stuff on 3/4/2017.
 */ // singleton object
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
