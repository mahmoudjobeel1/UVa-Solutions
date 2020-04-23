// Minimum Spanning Tree -> Kruscal Algorithm (DSU)
// find the ditance from eveypoint to the other sorting them and get the Minimum Spanning tree

import java.util.*;
import java.io.*;

public class Main{
	static double distance(double x1,double y1,double x2,double y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt();
			pair1 [] arr=new pair1[x];
			for(int i=0;i<x;i++) arr[i]=new pair1(sc.nextDouble(), sc.nextDouble());
			ArrayList<tuble> list=new ArrayList<>();
			for(int i=0;i<x;i++)
				for(int j=i+1;j<x;j++) {
				    double x1=arr[i].x,y1=arr[i].y,x2=arr[j].x,y2=arr[j].y;
				    list.add(new tuble(i,j,distance(x1, y1, x2, y2)));
				}
			Collections.sort(list);
			DSU d1=new DSU(x);
			double ans=0;
			for(int i=0;i<list.size();i++) {
				tuble temp=list.get(i);
				if(!d1.same(temp.x,temp.y)) {
					d1.union(temp.x, temp.y);
					ans+=temp.z;
				}
			}
			pw.printf("%.2f%n",ans);
			if(t>0) pw.println();
		}
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
		int x,y; double z;
		public tuble(int x,int y,double z) {
			this.x=x; this.y=y; this.z=z;
		}
		public int compareTo(tuble o) {return Double.compare(z,o.z);}
		public String toString() {
			return x+" "+y+" "+z;
		}
	}
  static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);

}
