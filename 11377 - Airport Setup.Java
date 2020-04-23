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
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

  }
