// making a flood fill in the 4 directions

import java.util.*;
import java.io.*;


public class Main {
    static int[] dr1 = { 0, 0, 1,-1};
    static int[] dc1 = { -1, 1, 0, 0};
    static int row=0,col=0;
    static char [][] land;
    static boolean [][]visited;
    static char king;
    static boolean check(int i, int j) {
    	return i>=0 && j>=0 && i<row && j<col && !visited[i][j] && land[i][j]==king;
    }
    static int solve(int r,int c) {
    	if(!check(r, c)) return 0;
    	int ans=1;
    	visited[r][c]=true;
    	for(int i=0;i<4;i++)
    		ans+=solve(r+dr1[i],c+dc1[i]);
    	if(c==col-1 || c==0)ans+=solve(r,col-1-c);
//    	if(r==row-1|| r==0) ans+=solve(row-1-r, c);
    	return ans;
    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		StringBuilder sb=new StringBuilder();
		while(sc.hasNext()) {
			
			row=col=0;
			row=sc.nextInt();
			col=sc.nextInt();
			
			land=new char[row][col];
			visited=new boolean[row][col];
			for(int i=0;i<row;i++) {
				land[i]=sc.next().toCharArray();
			
			}
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			king=land[x][y];
			solve(x, y);
			int max=0;
			for(int j=0;j<row;j++) {
				for(int k=0;k<col;k++)
			    for(int i=0;i<4;i++) {
				max=Math.max(max, solve(j+dr1[i],k+dc1[i]));
			}
			}
			sb.append(max+"\n");
			
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
