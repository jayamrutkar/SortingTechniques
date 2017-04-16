package geeks.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort extends Sort {

	BucketSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		int n = arr.length;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i=0;i<n;i++){
		
			List<Integer> ls = list.get(n * arr[i]);
			if(null == ls){
				ls=new ArrayList<Integer>();
			}
			ls.add(arr[i]);
			list.set(n*arr[i], ls);
		}
		
		for(List<Integer> ls:list){
			Integer[] tmp =  ls.toArray(new Integer[ls.size()]);
			Arrays.sort(tmp);
		}
		
		int i=0;
		for(List<Integer> ls:list){
			for(int j=0;j<ls.size();j++){
				arr[i++] = ls.get(j);
			}
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n * k)";
		this.spaceComplexity="O(n)";
		this.type="Bucket Sort";

	}

}
