import java.util.Arrays;

public class BinList {

        private int[] data;

        public BinList(int size) {
            this.data = new int[size];
        }

    public int getData(int index) {
        return data[index];
    }

    public void increase(int index) {
        this.data[index]++;
    }

    public int size(){
            return data.length;
    }
}
