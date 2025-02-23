class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i=l;
        int j=h-1;

        // for(int j=l; j<h-1; j++) {
        //     if(arr[j]<=pivot) {
        //         swap(arr, i, j);
        //         i++;
        //     }
        // }
        // swap(arr, i, h);
        // return i;

        while(i<=j) {
            while(arr[i]<pivot && arr[i]<=arr[j]) {
                i++;
            }
            while(arr[j]>pivot && arr[i]<=arr[j]) {
                j--;
            }
            if(i<j) {
                swap(arr, i, j);
            }
        }
        if(arr[i]>pivot) {
            swap(arr, i, high);            
        }
        return i;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack stk = new Stack();
        stk.push(l);
        stk.push(h);

        while(!stk.isEmpty) {
            int y = (int) stk.pop();
            int x = (int) stk.pop();

            int p = partition(arr, x, y);
            stk.push(p+1);
            stk.push(y);
            stk.push(x);
            stk.push(p);
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 