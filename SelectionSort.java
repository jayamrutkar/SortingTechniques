package geeks.algo.sort;

public class SelectionSort extends Sort{

	SelectionSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int n = this.arr.length;
		int[] arr= this.arr;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i]>arr[j]){
					int tmp =arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n^2)";
		this.spaceComplexity="O(1)";
		this.type="Selection Sort";
	}
	
}