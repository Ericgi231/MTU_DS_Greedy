package cs2321;

public class TaskScheduling {
	/**
	 * Goal: Perform all the tasks using a minimum number of machines. 
	 * 
	 *       
	 * @param tasks tasks[i][0] is start time for task i
	 *              tasks[i][1] is end time for task i
	 * @return The minimum number or machines
	 */
   public static int NumOfMachines(int[][] tasks) {
	   //convert array of array of int into heap Priority Queue
	   //key: start time
	   //value: end time
	   HeapPQ<Integer, Integer> taskHeap = new HeapPQ<Integer, Integer>();
	   for(int[] n : tasks) {
		   taskHeap.insert(n[0],n[1]);
	   }
	   
	   //create heap priority queue to track active machines
	   //key: end time
	   //value: start time
	   HeapPQ<Integer, Integer> machineHeap = new HeapPQ<Integer, Integer>();
	   
	   //the largest amount of machines used at any one moment
	   int machinesUsed = 0;
	   
	   //while tasks remain
	   while (taskHeap.size() > 0) {
		   int s = taskHeap.min().getKey();
		   int e = taskHeap.removeMin().getValue();
		   
		   //while machines exist and current task has greater or equal start time than the smallest end time of active tasks
		   //in human:
		   //when a new task comes in, check if any machines should have finished their tasks
		   //remove all expired tasks from their machines
		   while(!machineHeap.isEmpty() && machineHeap.min().getKey() <= s) {
			   machineHeap.removeMin();
		   }
		   
		   //add new task to a new machine
		   machineHeap.insert(e, s);
		   
		   //if currently used machines is greater than machinesUsed, set machinesUsed to current machines in use
		   if (machinesUsed < machineHeap.size()) {
			   machinesUsed = machineHeap.size();
		   }
	   }
	   
	   return machinesUsed;
   }
}
