package pattern.structural;


import java.util.concurrent.TimeUnit;

/**
 * The basic principle is to perform the process only when needed.
 */

public class ProxyPattern
{
    public static void main(String[] args) throws InterruptedException
    {
        new ProxyPattern();
    }

    ProxyPattern() throws InterruptedException
    {
        Data data = new ProxyData("/data.csv");
        System.out.println("something happen ");

        // data will be parse
        show(data);

        // data will not be parse
        show(data);
    }

    private void show(Data data) throws InterruptedException
    {
        long startTime = System.nanoTime();
        data.getProcessedData();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(" data loaded in " + TimeUnit.NANOSECONDS.toMillis(duration) + " milliseconds");
    }

    public interface Data
    {
        public void getProcessedData() throws InterruptedException;
    }

    public class RealData implements Data
    {

        private String dataFile;

        public RealData(String dataFile) throws InterruptedException
        {
            this.dataFile = dataFile;
            process(dataFile);
        }

        @Override
        public void getProcessedData()
        {
            System.out.println("loading " + dataFile);
        }

        private void process(String fileName) throws InterruptedException
        {
            // parsing stuff
            System.out.println("parsing " + fileName);
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public class ProxyData implements Data
    {
        private RealData realData;
        private String dataFile;

        public ProxyData(String dataFile)
        {
            this.dataFile = dataFile;
        }

        @Override
        public void getProcessedData() throws InterruptedException
        {
            if (realData == null)
            {
                realData = new RealData(dataFile);
            }
            realData.getProcessedData();
        }
    }
}
