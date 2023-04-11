import java.util.ArrayList;
import java.util.Random;

public class GaltonBoard implements Runnable{
    public BinList bins;
    public GaltonBoard(BinList bins){
        this.bins = bins;
    }

    @Override
    public synchronized void run() {
        int currentBin = 0;
        Random rand = new Random();

        for (int i = 0; i < this.bins.size() - 1; i++) {
            int direction = rand.nextInt(2);
            currentBin += direction;
        }
        this.bins.increase(currentBin);
    }
}
