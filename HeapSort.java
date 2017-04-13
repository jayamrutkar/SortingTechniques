package geeks.algo.sort;

public class HeapSort extends Sort {

	class BinaryHeap{
		
		int[] heap;
		int heapSize;
		
		BinaryHeap(int capacity){
			heap = new int[capacity];
			heapSize=0;
		}
		
		private int getParentIndex(int childIndex){
			return (childIndex-1)/2;
		}
		
		private void heapifyUp(int childIndex){
			
			int val = heap[childIndex];
			int parentIndex =getParentIndex(childIndex);
			while(childIndex>0 &&
					val< heap[parentIndex = getParentIndex(childIndex)]){
				heap[childIndex]=heap[parentIndex];
				childIndex=parentIndex;
			}
			heap[childIndex]=val;
		}
		
		public void insertIntoHeap(int ele){
			
			if(isFull()){
				throw new RuntimeException("OVerflow");
			}
			heap[heapSize++]=ele;
			heapifyUp(heapSize-1);
		}

		private boolean isFull() {

			if(heapSize>heap.length){
				return true;
			}
			return false;
		}
		
		
		private void heapifyDown(int childIndex){
			
			while(heapSize> (childIndex*2+1)){
				
				if(heapSize> (childIndex*2+2)){

					if(heap[childIndex]<heap[childIndex*2+1] 
							&& heap[childIndex]<heap[childIndex*2+2]){
						break;
					}else{
						if(heap[childIndex*2+1]<heap[childIndex*2+2]){
							
							int tmp = heap[childIndex];
							heap[childIndex]=heap[childIndex*2+1];
							heap[childIndex*2+1] =tmp;
							childIndex = childIndex*2+1;
						}else{
							int tmp = heap[childIndex];
							heap[childIndex]=heap[childIndex*2+2];
							heap[childIndex*2+2] =tmp;
							childIndex = childIndex*2+2;
						}
					}
				}else{
					int tmp = heap[childIndex];
					heap[childIndex]=heap[childIndex*2+1];
					heap[childIndex*2+1] =tmp;
					childIndex = childIndex*2+1;
				}
			}
		}
		
		int deleteItem(int index){
			
			if(heapSize==0){
				throw new RuntimeException("Underflow");
			}
			
			int item=heap[index];
			heap[index]=heap[heapSize-1];
			heapSize--;
			heapifyDown(index);
			return item;
		}
		
		public void show(){
			System.out.println();
			for(int i=0;i<heapSize;i++)
				System.out.print(heap[i]+" ");
				
			System.out.println();
		}
		
	}
	
	
	HeapSort(int[] arr) {
		super(arr);
	}

	@Override
	protected void performSort() {

		BinaryHeap heap = new BinaryHeap(arr.length+2);
		for(int i=0;i<arr.length;i++){
			heap.insertIntoHeap(arr[i]);
		}
		
		int i=0;
		while(heap.heapSize>0){
			this.arr[i++] =heap.deleteItem(0);
		}
	}

	@Override
	protected void setComplexities() {
		this.timeComplexity="O(n * Log(n))";
		this.spaceComplexity="N/A";
		this.type="Heap Sort";
	}

}
