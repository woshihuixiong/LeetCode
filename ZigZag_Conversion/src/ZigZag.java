import java.util.Scanner;

public class ZigZag {
	public static void main(String[] args) {
		Solution ss = new Solution();
		int numRows = 9;
        
		System.out.println("Please input the string:");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		
		System.out.println(ss.convert(s, numRows));
	}

}

class Solution {
    public String convert(String s, int numRows) {
    	if(s.equals("")) return "";
    	if(numRows == 1) return s;
    	
    	int len = s.length();
    	int groupNum = 2*numRows-2;
        int numCols = (len/groupNum+1)*(numRows-1);
        char cc[][] = new char[numRows][numCols];
        int curr=0;
        
        for(int i=0;i<=len/groupNum;i++) {
        	for(int j=0;j<numRows;j++) {
        		if(curr == len) break;
        		cc[j][i*(numRows-1)] = s.charAt(curr++);
        	}
        	if(curr == len) break;
        	for(int j=1;j<(numRows-1);j++) {
        		if(curr == len) break;
        		cc[numRows-j-1][i*(numRows-1)+j] = s.charAt(curr++);
        	}
        	if(curr == len) break;
        }
        
        String ans = new String();
        
        for(int i=0;i<numRows;i++) {
        	for(int j=0;j<numCols;j++) {
//        		System.out.printf("%c, ",cc[i][j]);
        		if(cc[i][j] != '\0') ans+=cc[i][j];
        		else continue;
        	}
//        	System.out.printf("\n");
        }
        
        return ans;
    }
}