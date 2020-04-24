
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Selection};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sswaps = 0;

    /**
     * Constructor for objects of class Sorts
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
                System.out.println("Insertions Sort -- "
                        + " Operations: " + (this.icompares + this.iswaps)
                        + " Compares: " + this.icompares
                        + " Swaps: " + this.iswaps);
                list = this.ilist;
                break;
            case Selection:
            	System.out.println("Selection Sort -- "
            			+ " Operations: " + (this.scompares + this.sswaps)
            			+ " Compares: " + this.scompares
            			+ " Swaps: " + this.sswaps);
            	list = this.slist;
            	break;
            default:
            	list = this.list;
            	System.out.println("Log: Error in switch case");
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    private int[] SelectionSort() {
    	//Iterate through list at each index, one less than length
    	for(int i = 0; i < slist.length - 1; i++) {
    		int index = i;
    		
    		//Secondary iteration looks for next lowest value in the array
    		for(int j = i + 1; j < slist.length; j++) {
    			//finding lowest value and storing index
    			if(slist[j] < slist[index]) {
    				index = j; //changes index of lowest found value
    			}
    			this.scompares++; //compare counter
    		}
    		
    		//Swapping the lowest value into the current index
    		int lowNum = slist[index];
    		slist[index] = slist[i];
    		slist[i] = lowNum;
    		this.sswaps++; //swaps counter
    	}
    	return slist;
    }

    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        //Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
    }
    
    /*
     * Between the bubble sort, insertion sort, and selection sort. The sort which
     * routinely returns the lowest number of total operations (compares + swaps)
     * is the insertion sort. Although the insertion sort completes a roughly equal number
     * of swaps to the bubble sort, the insertion sort completes an extremely low
     * number of total comparisons. This, in turn, allows it to minimize its total
     * number of operations. The selection sort is subjectively the second best
     * among the three sorts. The selection sort has a predetermined number of compares that
     * it completes on each data set which causes its comparisons to be relatively high.
     * The selection sort, however, makes up for this by having an extremely low number 
     * of swap operations that it has to complete. The bubble sort is subjectively the worst
     * sort as it takes the high number of compares from the selection sort and combines
     * it with the high number of swaps of the insertion sort. This causes for an extremely
     * high number of total operations that is usually almost double that of the insertion or 
     * selection sort. These rankings are specifically in regards to this data set, with different
     * sizes of data sets/different contents of data set these rankings could be drastically different.
     */
}
