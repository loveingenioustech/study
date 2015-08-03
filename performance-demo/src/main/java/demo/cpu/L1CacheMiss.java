package demo.cpu;

/**
 * http://www.importnew.com/16346.html
 * 
 * @version
 */
public class L1CacheMiss
{
    private static final int RUNS = 10;
    private static final int DIMENSION_1 = 1024 * 1024;
    private static final int DIMENSION_2 = 6;

    private static long[][] longs;

    public static void main(String[] args) throws Exception
    {
        // Thread.sleep(10000);
        longs = new long[DIMENSION_1][];
        for (int i = 0; i < DIMENSION_1; i++)
        {
            longs[i] = new long[DIMENSION_2];
            for (int j = 0; j < DIMENSION_2; j++)
            {
                longs[i][j] = Math.round(100d);
            }
        }
        System.out.println("starting....");

        long sum = 0L;
        long processTime = 0L;
        for (int r = 0; r < RUNS; r++)
        {

            final long start = System.nanoTime();

            // slow
            // average process time 44011377
            // for (int j = 0; j < DIMENSION_2; j++)
            // {
            // for (int i = 0; i < DIMENSION_1; i++)
            // {
            // sum += longs[i][j];
            // }
            // }

            // fast
            // average process 9959151
            for (int i = 0; i < DIMENSION_1; i++)
            {
                for (int j = 0; j < DIMENSION_2; j++)
                {
                    sum += longs[i][j];
                }
            }

            processTime += (System.nanoTime() - start);
            // System.out.println((System.nanoTime() - start));
        }

        System.out.println("Process Time: " + processTime / RUNS);
        System.out.println("Sum: " + sum);
    }

}
