import java.util.ArrayList;

public class CircleQueueAL 
{
	private int front, rear, index;
	private ArrayList<Object> list = new ArrayList<Object>();
	
	public CircleQueueAL()
	{
		//I set the values equal to -1 because if they were 0 that would mean there was 1 object 
		//already in the arraylist
		front = 0; //front should always be at zero, since [0] should be front element no matter what (jared)
		rear = -1; //will get incremented to 0 when first element is added
		index = 0;
	}
	
	public Object getFirstObject()
	{
	  	index = front;

	    if (list.size() == 0)
	    	return null;
	    else
	    	return list.get(index);
	}
	
	public Object getLastObject()
	{
		index = rear;

	    if (list.size() == 0)
	    	return null;
	    else
	    	return list.get(index);
	}
	 
	public Object getObject(int index)
	{
		//prevents crash if list is empty
		if(list.size() == 0) {
			return null;
		}
		else {
			//prevents indexing of illegal index (beyond edge of array or negative index)
		    if (index == list.size() + 1 || index < 0)
		  	  return null;
		    else
		      return list.get(index);
		}
	}
	
	/*
	 * getNext() will return next object within the list, relies on prior
	 * initialization of index
	 */
	public Object getNext()
	{
		index++; //increment to move index to next

		// never let currentNode be null, wrap to head
		if (index == list.size() || index < 0)
			index = front;
		
		return this.getObject(index);
	}
	
	/*
	 * getPrevious() will return previous object within the list, relies on
	 * prior initialization of index
	 */
	public Object getPrevious()
	{
		index--; //decrement to move index to previous 
		
		// never let currentNode be null, wrap to head
		if (index == list.size() || index < 0)
			index = rear;
		
		return this.getObject(index);
	}
	
	public void add(Object opaqueObject)
	{
		//if (index == list.size()) 
		//{
            //System.out.println("Queue Full");

            //System.exit(1);
        //} 
		//else 
		//{
			
		/* Andrei Code
            list.set(rear, opaqueObject); //would break because you can't set to an index that doesn't already exist
            if(front == -1)
            	front = rear;
            rear = (rear + 1) % list.size();
           */
            
        //}
            //bruh
		
		list.add(opaqueObject); //simply add the object to end of list
		rear++; //rear keeps track of total members added to the list (used to reference last element)
	}
	
	//To make iterating through queue easier using getNext and getPrevious
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String toString()
	{
	    String queueToString = "[";

	    index = front;  			// start from the head
	    while (index != list.size())
	    {
	    	queueToString += "("+list.get(index)+")"; 	// append the data to output string
	    	index++;				// go to next node
	    	if (index != list.size())
	    		queueToString += ", ";
	    }										// loop 'till queue ends
	    queueToString += "]";
	    return queueToString;
	}
	
	public void run()
	{
		CircleQueueAL trial = new CircleQueueAL();
		
		trial.add(new Cupcakes("Red", 4, "Red Velvet"));
	
		System.out.println(trial.toString());
	
	}
	
	public static void main(String[] args) {
		CircleQueueAL trial = new CircleQueueAL();
		
		trial.add(new Cupcakes("Red", 4, "Red Velvet"));
		trial.add(new Cupcakes("Blue", 5, "Chocolate"));
		trial.add(new Cupcakes("Green", 10, "Vanilla"));
		trial.add(new Cupcakes("Yellow", 1, "Funfetti"));
	
		System.out.println("Print All Test");
		System.out.println(trial.toString() + "\n");
		
		System.out.println("Print First Test");
		System.out.println(trial.getFirstObject().toString() + "\n");
		
		System.out.println("Print Last Test");
		System.out.println(trial.getLastObject().toString() + "\n");
		
		System.out.println("Print 2nd Element Test");
		System.out.println(trial.getObject(2).toString() + "\n");
		
		System.out.println("Get Next Test");
		trial.setIndex(0);
		System.out.println(trial.getFirstObject().toString());
		System.out.println(trial.getNext().toString());
		System.out.println(trial.getNext().toString());
		System.out.println(trial.getNext().toString());
		System.out.println(trial.getNext().toString());
		System.out.println();
		
		System.out.println("Get Previous Test");
		trial.setIndex(3);
		System.out.println(trial.getObject(3).toString());
		System.out.println(trial.getPrevious().toString());
		System.out.println(trial.getPrevious().toString());
		System.out.println(trial.getPrevious().toString());
		System.out.println(trial.getPrevious().toString());
		System.out.println();
			
	}
}
