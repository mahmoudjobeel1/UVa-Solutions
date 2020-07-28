import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.BigInteger;
/*
-> Written by <-
  -----------
 |J_O_B_E_E_L|
 |___________|
 |    ___    |
 |   (^_^)   |
 |  /( | )\  |
 |____|_|____|
*/


public class Main{
	static int n,m,c;
	static int [][] memo,grid;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,1,-1};
	
	static boolean valid(int i,int j) {
		return i>=0 && i<n && j>=0 && j<m;
	}
	static int dp(int i,int j) {
		
		if(memo[i][j]!=-1) return memo[i][j];
		int ans=1;
		for(int k=0;k<4;k++) {
			int x=i+dx[k],y=j+dy[k];
			if(valid(x, y) && grid[i][j]>grid[x][y]) {
				ans=Math.max(ans, 1+dp(x, y));
			}
		}
		return memo[i][j]=ans;
	}
	public static void main(String[] args) throws IOException {
		int t=sc.nextInt();
		while(t-->0) {
			String s=sc.next(); n=sc.nextInt(); m=sc.nextInt();
			c=0;
			grid=new int [n][m];
			memo=new int [n][m];
			for(int i=0;i<n;i++) {
				Arrays.fill(memo[i],-1);
				grid[i]=sc.nextIntArray(m);
			}
			int max=0;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++) max=Math.max(max, dp(i, j));
			
			//for(int [] a:freq) pw.println(Arrays.toString(a));
			pw.println(s+": "+max);
		} 
		pw.flush();
		pw.close();
	}
	
	
	
    static class Scanner {
    	 
        private InputStream in;
        private byte[] buffer = new byte[1024];
        private int curbuf;
        private int lenbuf;
 
        public Scanner(InputStream in) {
            this.in = in;
            this.curbuf = this.lenbuf = 0;
        }
 
        public boolean hasNextByte() {
            if (curbuf >= lenbuf) {
                curbuf = 0;
                try {
                    lenbuf = in.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return false;
            }
            return true;
        }
 
        private int readByte() {
            if (hasNextByte())
                return buffer[curbuf++];
            else
                return -1;
        }
 
        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
 
        private void skip() {
            while (hasNextByte() && isSpaceChar(buffer[curbuf]))
                curbuf++;
        }
 
        public boolean hasNext() {
            skip();
            return hasNextByte();
        }
 
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
 
        public int nextInt() {
            if (!hasNext())
                throw new NoSuchElementException();
            int c = readByte();
            while (isSpaceChar(c))
                c = readByte();
            boolean minus = false;
            if (c == '-') {
                minus = true;
                c = readByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return (minus) ? -res : res;
        }
 
        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            int c = readByte();
            while (isSpaceChar(c))
                c = readByte();
            boolean minus = false;
            if (c == '-') {
                minus = true;
                c = readByte();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return (minus) ? -res : res;
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public Integer [] sortedIntArray(int n) {
        	Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            Arrays.sort(a);
            return a;
        }
        public Long [] sortedLongArray(int n) {
        	Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            Arrays.sort(a);
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
 
    }
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
