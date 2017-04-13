package geeks.algo.sort;

public class MergeSort extends Sort{

	MergeSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {
		
		int[] arr= this.arr;
		int n = arr.length;
		mergeSort(arr, 0, n-1);
	}

	private void mergeSort(int[] arr, int low, int high){
		
		if(low<high){
			int middle = low+ (high-low)/2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle+1, high);
			merge(arr, low, middle, high);
		}
		
	}
	
	private void merge(int[] arr, int low, int middle, int high) {
		
		int[] tmp = new int[arr.length];
		for(int i=low;i<=high; i++){
			tmp[i] = arr[i];
		}
		
		int i=low;
		int j=middle+1;

		int k=low;
		while(i<=middle && j<=high){
			
			if(tmp[i]<tmp[j]){
				arr[k++]=tmp[i++];
			}else{
				arr[k++]=tmp[j++];
			}
			
		}
		
		while(i<=middle){
			arr[k++]=tmp[i++];
		}
		while(j<=high){
			arr[k++]=tmp[j++];
		}
		
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n * Log(n))";
		this.spaceComplexity="O(n)";
		this.type="Merge Sort";
		
	}
	
}