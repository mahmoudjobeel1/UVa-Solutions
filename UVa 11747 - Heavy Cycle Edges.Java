// Maximum Spanning Tree -> Kruscal Algorithm (DSU)
// find the ditance from eveypoint to the other sorting them and get the Maximum Spanning tree

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws Exception {
		int x=sc.nextInt(); int m=sc.nextInt();
		while(x!=0 || m!=0) {
			tuble [] arr=new tuble[m];
			DSU d=new DSU(x);
			long sum=0;
			for(int i=0;i<m;i++) {
				long z=0;
				arr[i]=new tuble(sc.nextInt(), sc.nextInt(),z=sc.nextLong());
				sum+=z;
			}
			Arrays.sort(arr);
			
			for(tuble temp:arr) {
				if(!d.same(temp.x, temp.y)) {
					d.union(temp.x, temp.y);
					sum=sum-temp.z;
				}
			}
			pw.println(sum);
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
	static Scanner sc=new Scanner(System.in);

}
