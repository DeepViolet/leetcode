package com.sansec.liuhuiyi.test;

public class digitOne {
	public static void main(String[] args) {
		
		int a = 1000000000;
		int b = 1410065408;
		int d = a*10;
		int c = b/(a*10);
//		System.out.print(c);
		int rv = Solution.countDigitOne1(1410065408);
		System.out.print(rv);
	}

	public static class Solution {
		public Solution() {

		}

		public static int countDigitOne(int n) {
			int rv = 0;
			for (int i = 1; i <= n; i++) {
				rv += (new Integer(i).toString().length())
						- (new Integer(i).toString().replaceAll("1", "")
								.length());
			}
			return rv;

		}

		public static int countDigitOne1(int n) {
			   long currentNum = 0;
				long factorNum = 1;
				long highNum = 0;
				long lowerNum = 0;
				long sum = 0;
				while (n / factorNum > 0) {
					highNum = n / (factorNum * 10);  //Ô½½ç
					currentNum = (n / factorNum)%10;
					lowerNum = n - (n / factorNum) * factorNum;
					switch ((int)currentNum) {
					//the current digit is zero
					case 0: 
						sum += highNum * factorNum;
						break;
					//the current digit is one
					case 1: 
						sum += highNum * factorNum + lowerNum + 1;
						break;
					//the currnt digit is bigger than one
					default: 
						sum += (highNum + 1) * factorNum;
						break;
					}
					factorNum *= 10;
				}
				return (int)sum;
		}
		
		
		public static int countDigitOne3(int k) {
		    int count = 0, factor = 1, n = k;
		    while(n>0){
		    	int m = n/10, r = n%10, amount;
		    	
		    	if(r == 0) {
		    		amount = 0;
		    		count += m*factor;
		    	}
		    	else if(r > 1) {
		    		amount = factor;
		    		count += (m+1)*factor;
		    	}
		    	else {
		    		amount = k%factor+1;
		    		count += m*factor + amount;
		    	}
		    	factor *= 10;
		    	n = n/10;
		    }
		    return count;
		}
	}
}
