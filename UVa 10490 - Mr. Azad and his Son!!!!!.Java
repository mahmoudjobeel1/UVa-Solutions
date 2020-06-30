// Prime Numbers


import java.util.*;
import java.util.Map.Entry;


import java.io.*;
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


public class Main {
	static int [] primes;
	
	public static void main(String[] args) throws Exception {
		HashMap<Integer, String> map=new HashMap<>();
		for(int i=2;i<=31;i++) {
			long y=1l*(1<<(i-1))*((1<<(i))-1);
			//pw.println(i+" "+Prime.sumOfFactors(y));
			if(y==Prime.sumOfFactors(y)) map.put(i,"Perfect: "+y+"!");
			else if(Prime.isPrime(i) && !Prime.isPrime(((1<<(i))-1))) {
				map.put(i,"Given number is prime. But, NO perfect number is available.");
			}else {
				map.put(i,"Given number is NOT prime! NO perfect number is available.");
			}
		}
		//pw.println(map);
		int x=sc.nextInt();
		while(x!=0) {
			pw.println(map.get(x));
			x=sc.nextInt();
		}
		pw.flush();
		pw.close();
	}
	
	static class Prime{
		// o(sqrt n)
		// Check if the number is prime 
		static boolean isPrime(long n) { 
		       if(n<2) return false;
		       for(long x=2;1l*x*x<=n;x++) if(n%x==0) return false;
		       return true ;
	    } 
		
		
		//o(sqrt n)
		// return a list that contains the prime factors of a num
		static ArrayList<Integer> factors (int n){
			ArrayList<Integer> list=new ArrayList<>();
			 for(int x=2;x*x<=n;x++)
				 while(n%x==0) {
					 list.add(x);
					 n/=x;
				 }
			 if(n>1) list.add(n);
			 return list;
		}
		
		// O(n log log n)
		// check if a given number between 2...n is prime 
		// if arr[i]==0 it is prime else arr[i] is one of the factors of i
		static int []  sieve (int n) {
			int [] arr=new int [n+1];
			for(int x=2;x<=n;x++) {
				if(arr[x]!=0) continue;
				for(int u=2*x;u<=n;u+=x) arr[u]=x;
			}
			return arr;
		}
	    
		
		// The number of factors of a number n
		static int numOfFactors(int n) {
			HashMap<Integer, Integer> map=new HashMap<>();
			 for(int x=2;x*x<=n;x++)
				 while(n%x==0) {
					 map.put(x,map.getOrDefault(x,0)+1);
					 n/=x;
				 }
			 if(n>1) map.put(n,map.getOrDefault(n,0)+1);
			 int ans=1;
			 for (Map.Entry x : map.entrySet()) {
				 ans*=(1+(Integer)x.getValue());
				 
			 }
			 return ans;
		}
		
		static long sumOfFactors(long n) {
			HashMap<Long, Integer> map=new HashMap<>();
			 for(long x=2;x*x<=n;x++)
				 while(n%x==0) {
					 map.put(x,map.getOrDefault(x,0)+1);
					 n/=x;
				 }
			 if(n>1) map.put(n,map.getOrDefault(n,0)+1);
			 long ans =1;
			 for (Map.Entry x : map.entrySet()) {
				 int a=(Integer)x.getValue();
				 long p=(Long)x.getKey();
				 ans*=((long)pow(p,a+1)-1)/(p-1);
				 
			 }
			 return ans>>1;
		}
		
		static long productOfFactors(int n) {
			int x=numOfFactors(n);
			return (long)pow(n, x/2);
		}
		
		// return the number of primes between 1 .. n
		static int densityOfPrimes(int n) {
			return (int)(n/Math.log(n));
		}
		
		//Euler’s totient function
		// To Calculate the Number of Coprimes between 1 .. n
		static int Coprimes(int n) {
			HashMap<Integer, Integer> map=new HashMap<>();
			 for(int x=2;x*x<=n;x++)
				 while(n%x==0) {
					 map.put(x,map.getOrDefault(x,0)+1);
					 n/=x;
				 }
			 if(n>1) map.put(n,map.getOrDefault(n,0)+1);
			 int  ans =1;
			 for (Map.Entry x : map.entrySet()) {
				 int a=(Integer)x.getValue();
				 int p=(Integer)x.getKey();
				 ans*=(pow(p,a-1))*(p-1);
				 
			 }
			 return ans;

		}
		
		static long pow(long a, int n){
			long res = 1;
			while(n != 0)
			{
				if((n & 1) == 1)
					res *= a;
				a *= a;
				n >>= 1;			
			}
			return res;
		}
	}	
	
	
	
	// O(log n)
	static int gcd(int a,int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
//    static class Scanner {
//    	 
//        private InputStream in;
//        private byte[] buffer = new byte[1024];
//        private int curbuf;
//        private int lenbuf;
// 
//        public Scanner(InputStream in) {
//            this.in = in;
//            this.curbuf = this.lenbuf = 0;
//        }
// 
//        public boolean hasNextByte() {
//            if (curbuf >= lenbuf) {
//                curbuf = 0;
//                try {
//                    lenbuf = in.read(buffer);
//                } catch (IOException e) {
//                    throw new InputMismatchException();
//                }
//                if (lenbuf <= 0)
//                    return false;
//            }
//            return true;
//        }
// 
//        private int readByte() {
//            if (hasNextByte())
//                return buffer[curbuf++];
//            else
//                return -1;
//        }
// 
//        private boolean isSpaceChar(int c) {
//            return !(c >= 33 && c <= 126);
//        }
// 
//        private void skip() {
//            while (hasNextByte() && isSpaceChar(buffer[curbuf]))
//                curbuf++;
//        }
// 
//        public boolean hasNext() {
//            skip();
//            return hasNextByte();
//        }
// 
//        public String next() {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            StringBuilder sb = new StringBuilder();
//            int b = readByte();
//            while (!isSpaceChar(b)) {
//                sb.appendCodePoint(b);
//                b = readByte();
//            }
//            return sb.toString();
//        }
// 
//        public int nextInt() {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            int c = readByte();
//            while (isSpaceChar(c))
//                c = readByte();
//            boolean minus = false;
//            if (c == '-') {
//                minus = true;
//                c = readByte();
//            }
//            int res = 0;
//            do {
//                if (c < '0' || c > '9')
//                    throw new InputMismatchException();
//                res = res * 10 + c - '0';
//                c = readByte();
//            } while (!isSpaceChar(c));
//            return (minus) ? -res : res;
//        }
// 
//        public long nextLong() {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            int c = readByte();
//            while (isSpaceChar(c))
//                c = readByte();
//            boolean minus = false;
//            if (c == '-') {
//                minus = true;
//                c = readByte();
//            }
//            long res = 0;
//            do {
//                if (c < '0' || c > '9')
//                    throw new InputMismatchException();
//                res = res * 10 + c - '0';
//                c = readByte();
//            } while (!isSpaceChar(c));
//            return (minus) ? -res : res;
//        }
// 
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
// 
//        public int[] nextIntArray(int n) {
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++)
//                a[i] = nextInt();
//            return a;
//        }
// 
//        public long[] nextLongArray(int n) {
//            long[] a = new long[n];
//            for (int i = 0; i < n; i++)
//                a[i] = nextLong();
//            return a;
//        }
// 
//    }
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
