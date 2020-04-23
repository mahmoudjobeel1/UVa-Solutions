// Shortest Path Technque -> Dijkstra Algorithm


import java.util.*;
import java.io.*;

public class Main {
	static long [] distance;
	static ArrayList<Integer>[] lists;
	static boolean [] airports;
	static void dijkstra(int start,int end) {
		PriorityQueue<pair> pq=new PriorityQueue<>();
		distance[start]=airports[start]?0:1;
		pq.add(new pair(distance[start],start));
		
		while(!pq.isEmpty()) {
			pair temp=pq.poll();
			long d=temp.d; int parent=temp.x;
			if(d>distance[parent]) continue;
			if(parent==end) break;
			for(int child:lists[parent]) {
				if(airports[child] && d<distance[child]) {
					pq.add(new pair(distance[child]=d,child));
				}else if(!airports[child] && d+1<distance[child]) {
					pq.add(new pair(distance[child]=d+1,child));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		for(int k=1;k<=t;k++) {
			pw.println("Case "+k+":");
			int x=sc.nextInt(); int m=sc.nextInt(); int y=sc.nextInt();
			airports=new boolean[x];
			while(y-->0) airports[sc.nextInt()-1]=true;
			
			lists=new ArrayList[x];
			for(int i=0;i<x;i++) {lists[i]=new ArrayList<>();}
			while(m-->0) {
				int u=sc.nextInt()-1; int v=sc.nextInt()-1;
				lists[u].add(v);
				lists[v].add(u);
			}
			int c=sc.nextInt();
			while(c-->0) {
				distance=new long[x];
				Arrays.fill(distance,Integer.MAX_VALUE);
				int start=sc.nextInt()-1; int end=sc.nextInt()-1;
				if(start==end) {pw.println(0); continue;}
				dijkstra(start, end);
				pw.println(distance[end]==Integer.MAX_VALUE ? -1:distance[end]);
				//pw.println(Arrays.toString(distance));
			}
			pw.println();
		}
		pw.flush();
		pw.close();
	}
	static class pair implements Comparable<pair>{
		long d;
		int x;
		long m;
		public pair(long d,int x) {
			this.d=d; this.x=x; 
		}
		public int compareTo(pair o) {
			return Long.compare(d, o.d);
		}
		public String toString() {
			return d+" "+x;
		}
	}
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

  }
