// Minimum Spanning Tree -> Kruscal Algorithm (DSU)
// find the ditance from eveypoint to the other sorting them and get the Minimum Spanning tree


import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt(); int m=sc.nextInt();
			ArrayList<tuble> list=new ArrayList<>();
			while(m-->0) {list.add(new tuble(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));}
			Collections.sort(list);
			DSU d=new DSU(x);
			int sum=0;
			StringBuilder sb=new StringBuilder();
			for(tuble temp:list) {
				if(!d.same(temp.x, temp.y)) d.union(temp.x, temp.y);
				else {
					sum+=temp.z;
				}
			}
			pw.println(sum);
			
		}
		sc.nextInt();
		pw.flush();
		pw.close();
	}
	static class pair1{
		double x,y; 
		public pair1(double x,double y) {this.x=x; this.y=y;}
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
