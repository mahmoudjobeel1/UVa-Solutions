// Prime Numbers
// Hints : sieve - complete search
// Every even number ≥ 4 can be expressed as the sum of two prime numbers

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
	

	public static void main(String[] args) throws Exception {
		
	    int [] primes=Prime.sieve(1000001);
	    int x=sc.nextInt();
	    while(x!=0) {
	    	boolean f=true;
	    	for(int i=x-1;f && i>=2;i--) {
	    		if(i>=2 && (x-i)>=2 && primes[i]==0 && primes[x-i]==0) {
	    			pw.println(x+" = "+(x-i)+" + "+i);
	    			f=false;
	    		}
	    	}
	    	if(f) pw.println("Goldbach's conjecture is wrong.");
	    	x=sc.nextInt();
	    }
		pw.flush();
		pw.close();
	}
	
	static class Prime{
		// o(sqrt n)
		// Check if the number is prime 
		static boolean isPrime(int n) { 
		       if(n<2) return false;
		       for(int x=2;x*x<=n;x++) if(n%x==0) return false;
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
		
		static long sumOfFactors(int n) {
			HashMap<Integer, Integer> map=new HashMap<>();
			 for(int x=2;x*x<=n;x++)
				 while(n%x==0) {
					 map.put(x,map.getOrDefault(x,0)+1);
					 n/=x;
				 }
			 if(n>1) map.put(n,map.getOrDefault(n,0)+1);
			 long ans =1;
			 for (Map.Entry x : map.entrySet()) {
				 int a=(Integer)x.getValue();
				 int p=(Integer)x.getKey();
				 ans*=((long)pow(p,a+1)-1)/(p-1);
				 
			 }
			 return ans;
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
	

	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
