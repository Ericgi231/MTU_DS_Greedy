package cs2321;

/**
 * @author:
 *
 */
public class FractionalKnapsack {

   
	/**
	 * Goal: Choose items with maximum total benefit but with weight at most W.
	 *       You are allowed to take fractional amounts from items.
	 *       
	 * @param items items[i][0] is weight for item i
	 *              items[i][1] is benefit for item i
	 * @param knapsackWeight
	 * @return The maximum total benefit. Please use double type operation. For example 5/2 = 2.5
	 * 		 
	 */
	public static double MaximumValue(int[][] items, int knapsackWeight) {
		//create Priority Queue to store all item options
		//instantiate with InverseComparator that will put items with the largest keys at the top of the heap
		//the key is an items benefit per weight
		//the value is an items weight
		HeapPQ<Double, Double> options = new HeapPQ<Double, Double>(new InverseComparator<Double>());

		//for all items given, convert values and add them to the options Priority Queue
		for (int n = 0; n < items.length; n++) {
			double v, w;
			v = (double)items[n][1] / (double)items[n][0];
			w = (double)items[n][0];
			options.insert(v, w);
		}
		
		//set total value and weight to 0
		double totalValue = 0;
		double totalWeight = 0;
		
		//while the total weight is less than the max possible weight
		while (!options.isEmpty() && totalWeight < knapsackWeight) {
			//get item with highest value and the weight of that item or the remaining weight left in the knapsack, whichever is smaller.
			double weightRemaining = knapsackWeight - totalWeight;
			double weight = Math.min(options.min().getValue(), weightRemaining);
			double value = options.removeMin().getKey();
			
			//increase total value and weight based on values obtained above
			totalValue += value * weight;
			totalWeight += weight;
		}
		
		return totalValue;
	}
}
