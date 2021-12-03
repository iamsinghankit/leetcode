package competitive.singhankit.leetcode.medium.firstsession;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
     static class StatisticsAggregatorImpl implements StatisticsAggregator {

         private static final ConcurrentHashMap<String, List<CompanyStats>> holder = new ConcurrentHashMap<>();

         @Override
         public void putNewPrice(String symbol, double price) {
             List<CompanyStats> stats = holder.get(symbol);
             if (stats == null) {
                 stats = new ArrayList<>();
             }
             stats.add(new CompanyStats(symbol, price));
             holder.put(symbol, stats);
         }


         @Override
         public double getAveragePrice(String symbol) {
             List<CompanyStats> stats = holder.get(symbol);
             if (stats == null)
                 return 0.0d;
             return stats.stream().filter(e -> e.getSymbol().equals(symbol)).mapToDouble(CompanyStats::getPrice)
                         .average().getAsDouble();
         }

         @Override
         public int getTickCount(String symbol) {
             List<CompanyStats> companyStats = holder.get(symbol);
             if (companyStats == null)
                 return 0;
             return companyStats.size();
         }

         private static class CompanyStats {
             private String symbol;
             private double price;

             CompanyStats(String symbol, double price) {
                 this.symbol = symbol;
                 this.price = price;
             }

             public String getSymbol() {
                 return symbol;
             }

             public double getPrice() {
                 return price;
             }
         }

     }
    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}