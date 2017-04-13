package geeks.algo.sort;

public class ShellSort extends Sort {

	ShellSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int n = arr.length;
		for(int gap = n/2; gap>0; gap=gap/2){
			
			for(int i=gap; i<n; i++){
				
				int temp = this.arr[i];
				int j;
				for(j=i; (j>=gap && arr[j-gap]>temp); j-=gap){
					arr[j] = arr[j-gap];
				}
				arr[j] = temp;
			}
		}
		
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n^2)";
		this.spaceComplexity="O(1)";
		this.type="Shell Sort";

	}

}
