import java.util.concurrent.TimeUnit;

public class PerfTest {
    private long testMaxHeapLogNBuild(Integer[] data, int length) {
        MaxHeap heap = new MaxHeap(length);

        long startTime = System.nanoTime();

        heap.MaxHeapLogN(data);

        long endTime = System.nanoTime();

        while(heap.size!=0){
            heap.pop();
        }

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    private long testMaxHeapNBuild(Integer[] data, int length) {
        MaxHeap heap = new MaxHeap(length);

        long startTime = System.nanoTime();

        heap.MaxHeapN(data);

        long endTime = System.nanoTime();

        while(heap.size!=0){
            heap.pop();
        }

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    @Test
    public void timePQBuild() {
        int start = 100000;
        int end = start * 100;
        for (int i=start; i<=end; i +=200000) {
            Integer[] data = new Integer[i];
            for (int j = 0; j< i; j++) {
                ;data[j] = j;
            }


            long tlogN = testMaxHeapLogNBuild(data, i);

            long tN = testMaxHeapNBuild(data, i);



            System.out.printf("%d %d %d\n", i, tN, tlogN);
        }
    }
}
