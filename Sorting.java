package geeks.algo.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

	public enum SortType{
		BUBBLE_SORT, SELECTION_SORT, INSERTION_SORT, MERGE_SORT, QUICK_SORT, HEAP_SORT, COUNTING_SORT,
		RADIX_SORT, BUCKET_SORT, SHELL_SORT
	}
	
	private Sort sort;
	private SortType sortType;
	
	int[] arr;

	public Sorting() {
		super();
		this.sortType = SortType.MERGE_SORT;
	}

	void setSortingWay(Sort sort){
		this.sort=sort;
	}
	
	void captureInputs(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many: ");
		int n = in.nextInt();
		
		System.out.println("Enter elements: ");
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]= in.nextInt();
		}
		
		System.out.println("Different Sorting Available Options: ");
		for(int i=0;i<SortType.values().length;i++){
			System.out.println((i+1)+". "+SortType.values()[i]);
		}
		System.out.println("Enter yours ");
		int selected = in.nextInt();
		
		if(selected>0 && selected<SortType.values().length){
			this.sortType = SortType.values()[selected-1];
		}
		
		in.close();
	}
	
	void task(){

		//Capture input elements
		captureInputs();
		
		//New Array Here
		int[] localArr = Arrays.copyOf(this.arr, this.arr.length);
		
		switch(this.sortType){
		case BUBBLE_SORT:	
			setSortingWay(new BubbleSort(localArr));
			break;
		case SELECTION_SORT:
			setSortingWay(new SelectionSort(localArr));
			break;
		case INSERTION_SORT:
			setSortingWay(new InsertionSort(localArr));
			break;
		case MERGE_SORT:
			setSortingWay(new MergeSort(localArr));
			break;
		case QUICK_SORT:
			setSortingWay(new QuickSort(localArr));
			break;
		case HEAP_SORT:
			setSortingWay(new HeapSort(localArr));
			break;
		case COUNTING_SORT:
			setSortingWay(new CountingSort(localArr));
			break;
		case RADIX_SORT:
			setSortingWay(new RadixSort(localArr));
			break;
		case BUCKET_SORT:
			setSortingWay(new BucketSort(localArr));
			break;
		case SHELL_SORT:
			setSortingWay(new ShellSort(localArr));
			break;
		default:
			setSortingWay(new MergeSort(localArr));
		}
		this.sort.performTask();
		
	}
	
	public static void main(String[] args) {

		Sorting sorting = new Sorting();
		sorting.task();
		
	}

}
