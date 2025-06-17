package ds;

public class Backtracking {
	
	    		public static void find(int[] nums, int index, int sum, int target, String path) {
	    			if (sum == target) {
	            System.out.println("Found: " + path);
	            return;
	    			}

	    			if (index >= nums.length || sum > target) {
	        	System.out.println("->"+path);
	            return ; // Stop exploring this path
	    			}

	        /*Start: index = 0, sum = 0, path = ""
			Try 2 → sum = 2, path = "2 "
  				Try 3 → sum = 5, path = "2 3 "
    				Try 5 → sum = 10 
    				Skip 5 → sum = 5
  					Skip 3 → sum = 2
    					Try 5 → sum = 7 
    						Skip 5 → sum = 2

							Back to start:
							Skip 2 → sum = 0
  							Try 3 → sum = 3
    							Try 5 → sum = 8 
*/
	        // Include current number
	       find(nums, index + 1, sum + nums[index], target, path + nums[index] + " ");

	        // Don't include current number
	       find(nums, index + 1, sum, target, path);
	    }

	    	public static void main(String[] args) {
	        int[] numbers = {2, 3, 5, 1};
	        int target = 8;
	        find(numbers, 0, 0, target, "");
	    }
	
}
