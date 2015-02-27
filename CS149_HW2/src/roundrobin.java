import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class roundrobin {
	public static void main (String [] args)
	{
		ArrayList<Process> a = new ArrayList<Process>();
		   int incr = 0;
			while(incr < 4)
			{
				Process j = new Process("p" + Integer.toString(incr));
				a.add(j);
				incr++;
				System.out.println("name: " + j.name + " activation time: " + j.getArrivalTime() + " run time: " + j.getRunTime());
			}
			
				 
				   ArrayList<String> timeline = new ArrayList<String>();
				   Collections.sort(a, new Comparator<Process>() {
				       public int compare(Process o1, Process o2) {
				           if(o1.getArrivalTime() > o2.getArrivalTime()) {return 1;}
				           else if (o1.getArrivalTime() < o2.getArrivalTime()) {return -1;}
				           else {return 0;}
				       }
				   });
				   for(Process p : a) {
				       System.out.println(p.name);
				   }
				   int currentprocess = 0;
				   
				   LinkedList<String> active = new LinkedList<String>();
				   
				   int check = 0;
				   for (int currenttime = 0; currenttime < 120; currenttime++) {
				       if(a.size() == currentprocess) { break;}
				       Process current = a.get(currentprocess);
				       
				       if(Math.ceil(current.getArrivalTime()) <= currenttime) {	
				           //running process
				           int processtime;
				           
				           
				             
				             
				              
				           
				           for (processtime = currenttime; processtime < currenttime + Math.ceil(current.getRunTime()); processtime++) {
				               if(!active.contains(current.name))
				            		   {
				            	   			active.add(current.name);
				            	   			check++;
				            	   			
				            	   	   }
				               int what = (int)Math.ceil(current.getArrivalTime());
				               timeline.add(what, active.get(0));
				           }
				           
				          if(processtime >= currenttime + Math.ceil(current.getRunTime())) 
				          {
				        	  for(int i = 0; i < active.size(); i++)
				        	  {
				        		  active.remove(current.name);
				        	  }
				          }
			
				           currentprocess++;
				           currenttime += processtime - currenttime - 1;
				       }
				       else {
				           //waiting for process
				           timeline.add(currenttime, "~");
				       }
				   }
				   System.out.println(timeline);

				

			
		}
	}

