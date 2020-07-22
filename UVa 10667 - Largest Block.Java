import java.util.*;


import java.io.*;

public class Main{
	static int n;
	static int [][] grid;
	static int [][] memo;
	
	static void fill(int r1,int c1,int r2,int c2) {
		for(int i=r1;i<=r2;i++)
			for(int j=c1;j<=c2;j++) grid[i][j]=1;
	}
	static void build_memo() {
		memo[0][0]=grid[0][0];
		for(int i=1;i<=n;i++) memo[0][i]+=memo[0][i-1]+grid[0][i];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(j==1) memo[i][j]=grid[i][j]+memo[i-1][j];
				else memo[i][j]=grid[i][j]+memo[i-1][j]+memo[i][j-1]-memo[i-1][j-1];
		}
	}
	static int solve() {
		int max=0;
		for(int i1=1;i1<=n;i1++) 
			for(int j1=1;j1<=n;j1++) 
				if(grid[i1][j1]!=1)
					for(int i2=i1;i2<=n;i2++) 
						for(int j2=j1;j2<=n;j2++) 
							if(grid[i2][j2]!=1) 
								if(memo[i2][j2]-memo[i2][j1-1]-memo[i1-1][j2]+memo[i1-1][j1-1]==0) {
									int w=Math.abs(i2-i1+1)*Math.abs(j2-j1+1);
						             max=Math.max(max, w);
								}
	
		return max;
	}
	public static void main(String[] args) throws IOException {
		int t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			grid=new int [n+1][n+1];
			memo=new int [n+1][n+1];
			int m=sc.nextInt();
			while(m-->0) {
				int r1=sc.nextInt(); int c1=sc.nextInt(); 
				int r2=sc.nextInt(); int c2=sc.nextInt();
				fill(r1, c1, r2, c2);
			}
			build_memo();

			pw.println(solve());

		}
		pw.flush();
		pw.close();
	}
	static void print(int [][] arr) {
		for(int []a:arr) pw.println(Arrays.toString(a));
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
