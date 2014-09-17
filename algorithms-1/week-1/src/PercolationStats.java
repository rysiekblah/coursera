
/**
 * Created by tomek on 9/10/14.
 */
public class PercolationStats {

    private int T;
    private double[] openSitesCnts;
    private int counter;
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.T = T;
        this.openSitesCnts = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(N);
            counter = 0;
            while (!percolation.percolates()) {
                int p = 1 + StdRandom.uniform(N);
                int q = 1 + StdRandom.uniform(N);
                //System.out.println(" ids: " + p + ", " + q);
                if (!percolation.isOpen(p, q)) {
                    counter++;
                    percolation.open(p, q);
                }
            }
            openSitesCnts[i] = (double) counter/(double) (N*N);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openSitesCnts);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openSitesCnts);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96*stddev())/Math.sqrt(T);
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96*stddev())/Math.sqrt(T);
    }

    public static void main(String[] args) {

        int n = 20;
        int t = 10;
        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }

        PercolationStats percolationStats = new PercolationStats(n, t);

        System.out.println("mean         = " + percolationStats.mean());
        System.out.println("stddec       = " + percolationStats.stddev());
        System.out.println("confidenceLo = " + percolationStats.confidenceLo());
        System.out.println("confidenceHi = " + percolationStats.confidenceHi());
    }

}
