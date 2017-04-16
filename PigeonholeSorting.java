package geeks.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class PigeonholeSorting extends Sort {

	PigeonholeSorting(int[] arr) {
		super(arr);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void performSort() {
		int min = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}else if(arr[i]<min){
				min=arr[i];
			}
		}
		
		int range= max-min+1;
		
		List<Integer>[] list = new ArrayList[range];
		
		for(int i=0;i<arr.length;i++){
			if(list[arr[i]-min]==null){
				list[arr[i]-min] = new ArrayList<Integer>();
			}
			list[arr[i]-min].add(arr[i]);
		}
		
		int i=0;
		for(int j=0;j<range;j++){
			if(list[j]==null){
				continue;
			}
			int listSize =list[j].size(); 
			int k = 0;
			while(listSize>0){
				arr[i++]=list[j].get(k);
				k++;
				listSize--;
			}
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n+k)";
		this.spaceComplexity="O(k)";
		this.type="Pigeonhole Sorting Technique";
	}

}
