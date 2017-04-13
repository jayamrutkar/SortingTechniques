package geeks.algo.sort;

import java.util.Arrays;

public class CountingSort extends Sort {

	CountingSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int[] tmpArr = new int[256];
		Arrays.fill(tmpArr, 0);
		
		int max=0;
		for(int i=0;i<arr.length;i++){
			tmpArr[arr[i]]=tmpArr[arr[i]]+1;
			if(max<arr[i]){
				max=arr[i];
			}
		}
		
		int k=0;
		for(int i=0;i<=max;i++){
			if(tmpArr[i]>0){
				for(int j=0;j<tmpArr[i];j++)
					this.arr[k++] = i;
			}
		}
		
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n+k)";
		this.spaceComplexity="O(n+k)";
		this.type="Counting Sort";
	}

}
