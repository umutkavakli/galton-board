import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import static java.lang.System.out;

public class Test {
    @Option(name="-numThread", required = true, usage = "Number of threads to for filling the bins randomly, must be positive number")
    private static int numberOfThreads;
    @Option(name="-numBins", required = true, usage = "Number of bins to gather to be filled, must be positive number")
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
        if (args.length != 4) {
            parser.printUsage(out);
            System.exit(-1);
        }

        try{
            parser.parseArgument(args);
            if (numberOfThreads < 1 || numberOfBins < 1){
                parser.printUsage(out);
                System.exit(-1);
            }
        } catch (CmdLineException exception) {
            out.println("Error to parse arguments: " + exception);
        }
    }

    public static void printInfo(BinList bins) {
        int sum = 0;

        for (int i = 0; i < bins.size(); i++){
            sum += bins.getData(i);
            out.printf("%-10d%d\n", i, bins.getData(i));
        }

        out.printf("Number of requested thread: %d\n" +
                "Sum of Bin Values: %d\n", numberOfThreads, sum);

        if (sum == numberOfThreads)
            out.println("Nice work! Both of them are equal");
    }
}
