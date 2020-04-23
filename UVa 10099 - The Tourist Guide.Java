// Maximum Spanning Tree -> Kruscal Algorithm (DSU)
// find the ditance from eveypoint to the other sorting them and get the Maximum Spanning tree
// travers the MST by using dfs or bfs technique to get the min number in the path from start to end 
// decrease 1 in the calculation as we consider the tour guide
import java.util.*;
import java.io.*;

  
public class Main{
	static  ArrayList<edge>[]mst;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		int x=sc.nextInt(); int m=sc.nextInt();
		int c=1;
		while(m!=0 || x!=0) {
		    DSU d=new DSU(x);
		    ArrayList<tuble>list=new ArrayList<>();
		    while(m-->0)list.add(new tuble(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
		    Collections.sort(list);
		    mst  =new ArrayList[x];
		    visited=new boolean[x];
		    for(int i=0;i<x;i++)mst[i]=new ArrayList<edge>();
		    for(tuble temp:list)
		    	if(!d.same(temp.x, temp.y)) {
		    		d.union(temp.x, temp.y);
		    		mst[temp.x].add(new edge(temp.y, temp.z));
		    		mst[temp.y].add(new edge(temp.x, temp.z));
		    	}
		    int start=sc.nextInt()-1; int end=sc.nextInt()-1; int tourists=sc.nextInt();
		    Queue<pair1>queue=new LinkedList<>();
		    queue.add(new pair1(start, Integer.MAX_VALUE));
		    int min=Integer.MAX_VALUE;
		    while(!queue.isEmpty()) {
		    	pair1 temp=queue.poll();
		    	if(temp.x==end) min=Math.min(min, temp.y);
		    	visited[temp.x]=true;
		    	for(edge child:mst[temp.x]) if(!visited[child.x]) queue.add(new pair1(child.x, Math.min(temp.y, child.y)));
		    	
		    }
		    min--;
		    pw.println("Scenario #"+c++);
		    pw.println("Minimum Number of Trips = "+(int)(Math.ceil((tourists*1.0)/min)));
		    pw.println();
			x=sc.nextInt(); m=sc.nextInt();
			
		}
		pw.flush();
		pw.close();
	}
	static class pair1{
		int x,y; 
		public pair1(int x,int y) {this.x=x; this.y=y;}
	}
	static class DSU{
		int [] links,size;
		public DSU(int n) {
			links=new int [n];
			size=new int [n];
			for(int i=0;i<n;i++) {links[i]=i; size[i]=1;}
		}
		public int find(int x) {
			while(x!=links[x]) x=links[x];
			return x;
		}
		public boolean same(int a,int b) {
			return find(a)==find(b);
		}
		public void union(int a,int b) {
			a=find(a);
			b=find(b);
			if(size[b]>size[a]) {int temp=a; a=b; b=temp;}
			size[a]+=size[b];
			links[b]=a;
		}
		public String toString() {return Arrays.toString(links)+"\n"+Arrays.toString(size);}
	}
	static class tuble implements Comparable<tuble>{
		int x,y, z;
		public tuble(int x,int y,int z) {
			this.x=x; this.y=y; this.z=z;
		}
		public int compareTo(tuble o) {return Integer.compare(o.z,z);}
		public String toString() {
			return x+" "+y+" "+z;
		}
	}
    static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);

 }
