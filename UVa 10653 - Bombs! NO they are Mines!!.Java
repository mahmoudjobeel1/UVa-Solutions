// making flood fill in the 4 directions

import java.util.*;
import java.io.*;


public class Main {
	static boolean [][] visited;
	static int row,col,targrtx,targety;
	static int [] dr= {1,-1,0,0};
	static int [] dc= {0,0,-1,1};
	static boolean check(int i,int j) {
		return i>=0 && j>=0 && i<row && j<col && !visited[i][j];
	}
	static int solve(int r,int c) {
			
			Queue<tuble> queue=new LinkedList<Main.tuble>();
			queue.add(new tuble(r, c, 0));
			visited[r][c]=true;
			while(!queue.isEmpty()) {
				tuble temp=queue.poll();
				if(temp.x==targrtx && temp.y==targety) return temp.z;
				
				for(int i=0;i<4;i++) {
					int cx=dr[i]+temp.x;
					int cy=dc[i]+temp.y;
					if(check(cx, cy)) {
						visited[cx][cy]=true;
						queue.add(new tuble(cx, cy, temp.z+1));
					}
				}
			}
			return -1;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		row=sc.nextInt();  col=sc.nextInt();
		while(row!=0 && col!=0) {
			 visited=new boolean[row][col];
			 int x=sc.nextInt();
			 while(x-->0) {
				 int y=sc.nextInt();
				 int t=sc.nextInt();
				 while(t-->0) visited[y][sc.nextInt()]=true;
			 }
			int u=sc.nextInt(); int v=sc.nextInt();
			targrtx=sc.nextInt(); targety=sc.nextInt();
			System.out.println(solve(u, v));
			
			row=sc.nextInt(); col=sc.nextInt();
		}
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
