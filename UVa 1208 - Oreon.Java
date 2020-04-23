// Minimum Spanning Tree -> Kruscal Algorithm (DSU)

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		for(int k=1;k<=t;k++) {
			pw.println("Case "+k+":");
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			ArrayList<tuble>list=new ArrayList<>();
			for(int i=0;i<x;i++) {
				st=new StringTokenizer(br.readLine(),", ");
				int j=0;
			    while(st.hasMoreTokens()) {
			    	int y=Integer.parseInt(st.nextToken());
			    	if(y!=0) list.add(new tuble(i,j,y));
			    	j++;
			    }
			}
			Collections.sort(list);
			DSU d=new DSU(x);
			for(int i=0;i<list.size();i++) {
				tuble temp=list.get(i);
				if(!d.same(temp.x,temp.y)) {
					d.union(temp.x, temp.y);
					pw.println((char)('A'+temp.x)+"-"+(char)('A'+temp.y)+" "+temp.z);
				}
			}
		}
		pw.flush();
		pw.close();
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
		int x,y; long z;
		public tuble(int x,int y,long z) {
			this.x=x; this.y=y; this.z=z;
		}
		public int compareTo(tuble o) {return Long.compare(z,o.z);}
		public String toString() {
			return x+" "+y+" "+z;
		}
	}
    static PrintWriter pw=new PrintWriter(System.out);
}
