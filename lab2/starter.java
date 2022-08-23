import java.util.*;

class starter {
	static final long createdNano = System.nanoTime();
	static Random r = new Random();

	public static void main(String args[]) {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int[] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int[] nums = new int[100];
		int result;


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			randomize(nums);
			start = System.nanoTime();

			//  Put your method between these two comments
			selection(nums);
			//

			finish = System.nanoTime();
			double ms = (finish-start)/1000000.0;
			double rounded = (double)Math.round(ms*10000.0)/10000.0;
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("Duration(ms): " + rounded);

			for(int j=0;j<5;j++) {
				System.out.print(nums[j]+" ");
			}
			System.out.print("... ");
			for(int j=nums.length-5;j<nums.length;j++) {
				System.out.print(nums[j]+" ");
			}
			System.out.println("\n");
		}
	}

	private static void randomize(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(200000);
		}
	}

	private static int search(int[] arr) {
		int find = r.nextInt(200000);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==find) {
				return i;
			}
		}
		return -1;
	}

	private static void bubble(int[] arr) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}
		}
	}

	// also borrowed
	private static void insertion(int[] arr) {
		int move;
		for(int i=1;i<arr.length;i++) {
			move = arr[i];
			int previous = i - 1;

			while((previous>=0) && (arr[previous]>move)) {
				arr[previous+1] = arr[previous];
				previous--;
			}
			arr[previous+1] = move;
		}
	}

	// also also borrowed(sorting is not my specialty :P)
	private static void selection(int[] arr) {
		int min;
		for(int i=0;i<arr.length-1;i++) {
			min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
