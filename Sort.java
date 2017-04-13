package geeks.algo.sort;


public abstract class Sort{
	
	String type;
	String timeComplexity;
	String spaceComplexity;
	
	int[] arr;
	
	Sort(int[] arr){
		this.arr=arr;
	}
	
	abstract protected void performSort();
	abstract protected void setComplexities();
	
	void display(){
		System.out.println("\nSorting type is "+type);
		System.out.print("Sorted Array... ");
		for(int i=0;i<this.arr.length;i++){
			System.out.print(this.arr[i]+" ");
		}
		System.out.println();
		System.out.println("Time Complexity: "+timeComplexity+". Space Complexity: "+spaceComplexity+".");
	}
	
	void performTask(){
		
		performSort();
		setComplexities();
		display();
		
	}
}
