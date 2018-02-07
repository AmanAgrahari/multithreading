package parallelMerge;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random =new Random();
		
		int [] nums =new int[30];
		for(int j=0;j<nums.length;j++)
			nums[j]=random.nextInt(1000)-500;
		Mergesort mergesort = new Mergesort(nums);
		mergesort.mergeSort(0, nums.length-1);
		mergesort.showResult();
		
	}

}
