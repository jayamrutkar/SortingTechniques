package geeks.algo.sort;

public class QuickSort extends Sort{

	QuickSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int[] arr= this.arr;
		int n = arr.length;
		quickSort(arr, 0, n-1);
	}
	
	private void quickSort(int[] arr, int low, int high){
		
		if(low<high){
			
			int pivot = partitions(arr, low, high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
			
		}
		
	}

	private int partitions(int[] arr, int low, int high) {

		int index = high;
		
		int i=low-1;
		for(int j=low; j<high;j++){
			if(arr[j]<=arr[index]){
				int tmp =arr[++i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		}
		
		int tmp =arr[++i];
		arr[i]=arr[index];
		arr[index]=tmp;
		
		return i;
	}
	
	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n * Log(n))";
		this.spaceComplexity="O(n)";
		this.type="Quick Sort";
		
	}
	
	
}
