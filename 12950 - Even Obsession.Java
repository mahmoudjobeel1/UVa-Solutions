// Shortest path technique -> Dijkstra Algoritm
// finding the minumum number of roads to go from the start point to every node and the same from the end point
// then check for distance1[i]+distance2[child.x]+child.d<min && (roads1[i]+roads2[child.x]+1)%2==0 

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<edge> [] lists;
	static long [] distance1,distance2;
	static int [] roads1,roads2;
	static void dijkstra(int start,long [] distance,int [] roads) {
		distance[start]=0;
		PriorityQueue<pair> pq=new PriorityQueue<>();
		pq.add(new pair(0, start));
		while(!pq.isEmpty()) {
			pair temp=pq.poll();
			long d=temp.d; int parent=temp.x;
			if(d>distance[parent]) continue;
			for(edge child:lists[parent]) {
				if(child.d+d<distance[child.x]) {
					pq.add(new pair(distance[child.x]=child.d+d, child.x));
					roads[child.x]=roads[parent]+1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		while (sc.hasNext()) {
			int x=sc.nextInt(); int m=sc.nextInt();
			lists=new ArrayList[x];
			distance1=new long[x];
			distance2=new long[x];
			roads1=new int [x];
			roads2=new int [x];
			for(int i=0;i<x;i++) {
				lists[i]=new ArrayList<>();
				distance1[i]=distance2[i]=Integer.MAX_VALUE;
			}
			while(m-->0) {
				int u=sc.nextInt()-1; int v=sc.nextInt()-1; long d=sc.nextLong();
				lists[u].add(new edge(v, d));
				lists[v].add(new edge(u, d));
			}
			dijkstra(0, distance1, roads1);
			dijkstra(x-1, distance2, roads2);
			long min=Integer.MAX_VALUE;
			for(int i=0;i<x;i++) {
				for(edge child:lists[i]) {
					if(distance1[i]+distance2[child.x]+child.d<min && (roads1[i]+roads2[child.x]+1)%2==0) {
						min=distance1[i]+distance2[child.x]+child.d;
					}
				}
			}
			pw.println(min==Integer.MAX_VALUE ? -1:min);
			pw.flush();
		}
		pw.flush();
		pw.close();
	}
	static class pair implements Comparable<pair>{
		long d; int x;
		public pair(long d,int x) {this.x=x; this.d=d;}
		public String toString() {return x+" "+d;}
		public int compareTo(pair o) {return Long.compare(d, o.d);}
	}
	static class edge{
		int x; long d;
		public edge(int x,long d) {this.x=x; this.d=d;}
		public String toString() {return x+" "+d;}
	}
    static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
