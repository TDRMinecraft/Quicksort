import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class QuickSort {

    public static void quicksort(ArrayList<Integer> A, int lo, int hi){
        if (lo < hi){
            int q = partition(A, lo, hi);
            quicksort(A, lo, q-1);
            quicksort(A, (q+1), hi);
        }
    }

    private static int partition(ArrayList<Integer> A,int lo,int hi){
        int constant = 11;
	if((hi - lo) > constant) {
            int med = mo3(A, lo, hi);
            swap(A, med, hi);
        }
        int piv = A.get(hi);
        int i = (lo - 1);
        for (int j = lo; j < hi; j++) {
            if (A.get(j) <= piv) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, (i + 1), hi);
        return i+1;
    }

    //Swap function to swap indexes of ArrayList
    private static void swap(ArrayList<Integer> A, int num1, int num2){
        if(num1 != num2) {
            int temp = A.get(num1);
            A.set(num1, A.get(num2));
            A.set(num2, temp);
	    
        }
    }
    
    public static String printString(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = A.iterator();
        while (iterator.hasNext())
            sb.append(String.format("%09d%n", iterator.next()));
        return sb.toString();
	
    }
    
    // function to find the median of the high low and middle numbers in an ArrayList
    public static int mo3(ArrayList<Integer> A, int lo, int hi){
        int num1 = lo;
        int num2 = lo + (hi - lo) / 2;
        int num3 = hi;
        //case 1
        if (A.get(num1) >= A.get(num2) && A.get(num2) <= A.get(num3)
	    && A.get(num1) >= A.get(num3))
	    return num3;
        if (A.get(num1) >= A.get(num2) && A.get(num2) <= A.get(num3)
	    && A.get(num1) <= A.get(num3))
	    return num1;
	if (A.get(num1) <= A.get(num2) && A.get(num2) >= A.get(num3)
	    && A.get(num1) >= A.get(num3))
	    return num1;
	if (A.get(num1) <= A.get(num2) && A.get(num2) >= A.get(num3)
	    && A.get(num1) <= A.get(num3))
	    return num3;
	if (A.get(num3) >= A.get(num1) && A.get(num1) <= A.get(num2) && A.get(num2) <= A.get(num3)){
 	    return num2;
	}
	if (A.get(num3) <= A.get(num1) && A.get(num1) >= A.get(num2) && A.get(num2) >= A.get(num3)){   
	    return num2;
	}
	System.out.println("here");
	return num3;
    }
    
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        ArrayList<Integer> Arr = new ArrayList<Integer>();
        while (stdin.hasNextInt())
            Arr.add(stdin.nextInt());
        quicksort(Arr, 0, Arr.size() - 1);
	//        System.out.println(printString(Arr));
    }
}
