import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Test {
    @Option(name="-numThread", required = true)
    private static int numberOfThreads;
    @Option(name="-numBins", required = true)
    private static int numberOfBins;

    final CmdLineParser parser = new CmdLineParser(this);

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();

        test.getArguments(args);

        BinList bins = new BinList(numberOfBins);
        GaltonBoard galtonBoard = new GaltonBoard(bins);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(galtonBoard);
            thread.start();
            thread.join();
        }

        printInfo(bins);
    }

    public void getArguments(final String[] args){
        try{
            parser.parseArgument(args);
        } catch (CmdLineException exception) {
            System.out.println("Error to parse arguments: " + exception);
        }
    }

    public static void printInfo(BinList bins) {
        int sum = 0;

        for (int i = 0; i < bins.size(); i++){
            sum += bins.getData(i);
            System.out.printf("%-10d%d\n", i, bins.getData(i));
        }

        System.out.printf("Number of requested thread: %d\n" +
                "Sum of Bin Values: %d\n", numberOfThreads, sum);

        if (sum == numberOfThreads)
            System.out.println("Nice work! Both of them are equal");
    }
}
