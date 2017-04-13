package geeks.algo.sort;

public class InsertionSort extends Sort{

	InsertionSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {
		
		int[] arr= this.arr;
		int n = arr.length;
		for(int i=1;i<n;i++){
			
			int j=i-1;
			int key =arr[i];
			
			while(j>=0 && key < arr[j]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n^2)";
		this.spaceComplexity="O(1)";
		this.type="Insertion Sort";
		
	}
	
}
