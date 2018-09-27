package pattern.creational.singleton;

/**
 * @source https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
class ThreadSafeCalculator
{
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

    private static class StaticHolder
    {
        static final ThreadSafeCalculator INSTANCE = new ThreadSafeCalculator();
    }
}