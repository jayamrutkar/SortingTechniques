package geeks.algo.sort;

public class BubbleSort extends Sort{
	
	BubbleSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int n = this.arr.length;
		int arr[] = this.arr;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i]<arr[j]){
					int tmp = arr[i];
					arr[i]= arr[j];
					arr[j]=tmp;
				}
			}
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n^2)";
		this.spaceComplexity="O(1)";
		this.type="Bubble Sort";
	}
	
}