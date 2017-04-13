package geeks.algo.sort;

import java.util.Arrays;

public class RadixSort extends Sort {

	RadixSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {
		// TODO Auto-generated method stub
		
		int maxNumber = 0;
		for(int i=0;i<arr.length;i++){
			if(maxNumber<this.arr[i])
				maxNumber =this.arr[i];
		}
		
		int exp=1;
		
		while(maxNumber/exp>0){
			int[] count = new int[10];
			Arrays.fill(count, 0);
			int[] output = new int[arr.length];
			
			for(int j=0;j<arr.length;j++){
				count[arr[j]/exp%10]++;
			}
			
			for(int j=1;j<10;j++){
				count[j] += count[j-1];
			}
			
			for(int j=arr.length-1; j>=0; j--){
				output[count[(arr[j]/exp)%10] -1 ] =arr[j];
				count[(arr[j]/exp)%10]--;
			}
			
			for(int j=0;j<arr.length;j++){
				arr[j] = output[j];
			}
			exp = exp *10;
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n * Log(n))";
		this.spaceComplexity="N/A";
		this.type="Radix Sort";
	}

}
