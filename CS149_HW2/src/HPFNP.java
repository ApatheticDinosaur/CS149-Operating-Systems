import java.util.*;

// FCFS
public class HPFNP{

	public static void main(String[] args)
	{
		Process p1 = new Process("A", 3);
		Process p2 = new Process("B", 4);
		Process p3 = new Process("C", 2);
		Process p4 = new Process("D", 1);
		
		Process[] pArray = new Process[4];
		Process[] sortedArray = new Process[4];
		
		pArray[0] = p1;
		pArray[1] = p2;
		pArray[2] = p3;
		pArray[3] = p4;
		
		sort(pArray);
		sortPriority(pArray);
			
		/** Debugging
		for (int k = 0; k < pArray.length; k++)
		{
			System.out.println(pArray[k].name);
			System.out.println(pArray[k].getArrivalTime());
			System.out.println(pArray[k].getRunTime());
			System.out.println(pArray[k].getPriority());
		}
		*/
		
		ArrayList<String> quanta = new ArrayList<String>();
		int currentProcess = 0;
		for (int currentTime = 0; currentTime < 200; currentTime++) {
			if (pArray.length == currentProcess) {
				break;
			}
			Process theProcess = pArray[currentProcess];
			if (Math.ceil(theProcess.getArrivalTime()) <= currentTime) {
				int processTime = 0;
				for (processTime = currentTime; processTime < currentTime
						+ Math.ceil(theProcess.getArrivalTime()); processTime++) {
					quanta.add(theProcess.name);
				}
				currentProcess++;
				currentTime += processTime - currentTime - 1;
			} else {
				quanta.add("~");
			}
		}	
		
		System.out.print(quanta);
		System.out.println("\nAverage turnaround time: "
				+ (quanta.lastIndexOf("A") + quanta.lastIndexOf("B")
						+ quanta.lastIndexOf("C") + quanta.lastIndexOf("D"))
				/ 4 + " quanta");
		System.out.println("Average waiting time: "
				+ Collections.frequency(quanta, "~") / 4 + " quanta");
		System.out.println("Average response time: "
				+ pArray[0].getArrivalTime() + " quanta");
		System.out.println("Throughput: 0.25");
		
	}
	
	// Use bubblesort to sort Array by arrival time.
	public static void sort(Process[] p)
	{
		Process temp;
		for (int i = p.length - 1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (p[j].getArrivalTime() > p[j+1].getArrivalTime())
				{
					temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
	}
	
	// Sort based on priority if two processes are waiting
	public static void sortPriority(Process[] p)
	{
		final float SECOND = 1;
		
		Process temp = null;
		for (int i = p.length - 1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (((p[j].getRunTime() > p[j+1].getArrivalTime())) && (p[j].getRunTime() > p[j+2].getArrivalTime())) 
				{
					if((p[j+2].getPriority() > p[j+1].getPriority()) && ((p[j+2].getArrivalTime()) < p[j].getRunTime()))
					temp = p[j+1];
					p[j+1] = p[j+2];
					p[j+2] = temp;
				}
			}
		}
	}
	
}
