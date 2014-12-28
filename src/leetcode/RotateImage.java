package leetcode;

public class RotateImage {

}

class RotateImageSolution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int j = 0; j <= n/2 ; j++){
            for(int k=j; k<n-1-j; k++){
               int temp = matrix[j][k];
               
               matrix[j][k] = matrix[n-1-k][j];
               matrix[n-1-k][j] = matrix[n-1-j][n-1-k];
               matrix[n-1-j][n-1-k] = matrix[k][n-1-j];
               matrix[k][n-1-j] = temp;
                
            }
        }
    }
}