// Topological sort by using bfs 
// Using a priority queue becauce there is only one valid answer

import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k=1;
		Thread.sleep(3000);
	    while (sc.hasNext()) {
	    	int t=sc.nextInt();
	    	ArrayList<Integer> [] list=new ArrayList[t];
	    	HashMap<String, Integer> map=new HashMap<>();
	    	ArrayList<String> names=new ArrayList<>();
	    	for(int i=0;i<t;i++) {
	    		String y=sc.next();
	    		map.put(y,i);
	    		list[i]=new ArrayList<Integer>();
	    		names.add(y);
	    	}
	    	boolean [] visited=new boolean [t];
	    	int [] freq=new int [t];
	    	int x=sc.nextInt();
	    	for(int i=0;i<x;i++) {
	    		int u=map.get(sc.next()); int v=map.get(sc.next());
	    		freq[v]++;
	    		list[u].add(v);
	    	}
	    	StringBuilder sb=new StringBuilder();
	    	//System.out.println(Arrays.toString(freq)+"\n"+names);
	    	PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
	    	for(int i=0;i<t;i++) 
	    		if(freq[i]==0) {
	    			
	    		     queue.add(i);
	    		}
	    			while(!queue.isEmpty()) {
	    				int u=queue.poll();
	    				sb.append(names.get(u)+" ");
	    				for(int v:list[u])
	    					if(--freq[v]==0) {queue.add(v);}
	    			}
	    		
	    	
	    	System.out.println("Case #"+k+": Dilbert should drink beverages in this order: "+sb.deleteCharAt(sb.length()-1)+"."+"\n");
	    	k++;
	    }
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
