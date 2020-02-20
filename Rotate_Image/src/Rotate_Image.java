
public class Rotate_Image {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		Solution ss = new Solution();
		ss.rotate(matrix);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(matrix[i][j]);
			}
//			System.out.printf("\n");
		}
	}

}

//以下为暴力法，应该不符合题目要求，但是运行时间怎么超过了100%的用户。。
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] Backup = new int[n][n];
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		Backup[i][j] = matrix[i][j];
        	}
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		matrix[j][n-i-1] = Backup[i][j];
        	}
        }
    }
}