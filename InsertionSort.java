package insertion_sort;
import java.util.ArrayList;

public class InsertionSort {

	public static void main(String[] args) {
		
		System.out.println("insertion sort");
		
		
		int[] l = {5,1,4,2,3};
		int [] sorted = new int[5];
		
		
		int i, j, key, temp;
		for(i = 1; i<l.length;i++) {
			key = l[i];
			j = i - 1;
			while(j >=0 && key < l[j]) {
				temp = l[j];
				l[j] = l[j+1];
				l[j+1] = temp;
				j--;
			}
		}
		
		
		
		for(i = 0;i< 5;i++) {
			
			System.out.println(l[i]);
			
		}
		
			

	}

}
