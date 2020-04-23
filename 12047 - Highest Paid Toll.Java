//  dijkstar algorthim for shortest path technique
//  we will get the shortest distance for every node from the start point -> distance1[x]
//  then we will reverse the direction of our graph and make the previous step , getting the distance from 
//	the end point -> distance2[x]
//  Using a simple for loop to travers the node and its child we will get the answer 
//	distance1[node]+distance2[child]+the distance between child and its node <=cost
// we will take the max distance if this condition is right


import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<edge>[] lists1,lists2;
	static long [] distance1,distance2;
	static long max=-1,cost;
	static boolean [] visited;
	static void dijkstra(int start,int end,ArrayList<edge>[]lists,long []distance) {
		distance[start]=0;
		PriorityQueue<pair> pq=new PriorityQueue<>();
		pq.add(new pair(0, start));
		while(!pq.isEmpty()) {
			pair temp=pq.poll();
			long d=temp.d; int parent=temp.x;
			for(edge child:lists[temp.x])
				if(child.y+d<distance[child.x]) {
					pq.add(new pair(distance[child.x]=temp.d+child.y,child.x));
				}
		}
	}
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			max=-1;
			int x=sc.nextInt(); int y=sc.nextInt();
			int start=sc.nextInt()-1; int end=sc.nextInt()-1; 
			cost=sc.nextLong();
			lists1=new ArrayList[x];
			lists2=new ArrayList[x];
			distance1=new long [x];
			distance2=new long [x];
			for(int i=0;i<x;i++) {
				lists1[i]=new ArrayList<>();
				distance1[i]=Integer.MAX_VALUE;
				lists2[i]=new ArrayList<>();
				distance2[i]=Integer.MAX_VALUE;
			}
			while(y-->0) {
				int u=sc.nextInt()-1; 
				int v=sc.nextInt()-1;
				int d=sc.nextInt();
				lists1[u].add(new edge(v, d));
				lists2[v].add(new edge(u, d));
			}
			dijkstra(start,end,lists1,distance1);
			dijkstra(end,start ,lists2, distance2);
			//pw.println(Arrays.toString(distance1)+"\n"+Arrays.toString(distance2));
			long max=-1;
			for(int i=0;i<x;i++) {
				for(edge child:lists1[i]) {
					if(distance1[i]+distance2[child.x]+child.y<=cost) {
						max=Math.max(max, child.y);
						//pw.println(child.y);
					}
				}
			}
			pw.println(max);
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
	static class edge{
		int x;
		long y;
		public edge(int x,long y) {
			this.y=y; this.x=x;
		}
		public String toString() {
			return x+" "+y;
		}
	}
  static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }
 }
