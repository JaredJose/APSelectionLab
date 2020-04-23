import java.util.ArrayList;

public class CircleQueueAL 
{
	private int front, rear, index;
	private ArrayList<Object> list = new ArrayList<Object>();
	
	public CircleQueueAL()
	{
		//I set the values equal to -1 because if they were 0 that would mean there was 1 object 
		//already in the arraylist
		front = -1;
		rear = 0;
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
	 
	public Object getObject()
	{
	    if (index == list.size() + 1 || index < 0)
	  	  return null;
	    else
	      return list.get(index);
	}
	
	public void setNext()
	{
		index = index + 1;
		
		// never let currentNode be null, wrap to head
		if (index == list.size() + 1 || index > 0)
			index = front;
	}
	
	public void setPrevious()
	{
		index = index - 1;
		
		// never let currentNode be null, wrap to head
		if (index == list.size() + 1 || index < 0)
			index = rear;
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
            list.set(rear, opaqueObject);
            if(front == -1)
            	front = rear;
            rear = (rear + 1) % list.size();
           
        //}
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
}
