import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class starter {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			start = System.nanoTime();

			//  Put your method between these two comments

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
}