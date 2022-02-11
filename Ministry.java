import java.util.ArrayList;
import java.util.Scanner;

public class Ministry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] mat = new int[M][N];
        int[][] costToW = new int[M][N];
        int min = Integer.MAX_VALUE;
        int minCoord = -1;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                mat[i][j] = sc.nextInt();
                if(i == 0){
                    costToW[i][j] = mat[i][j];
                }
            }
            if(i != 0){
                costToW[i][0] = mat[i][0] + costToW[i-1][0];
                for(int j = 1; j < N; j++){
                    costToW[i][j] = mat[i][j] + Math.min(costToW[i][j-1], costToW[i-1][j]);
                }
                for(int j = N - 2; j >= 0; j--){
                    costToW[i][j] = Math.min(costToW[i][j], mat[i][j] + costToW[i][j+1]);
                }

                //for(int j = 0; j < N; j++)
                //    System.out.print(costToW[i][j]+" ");
                //System.out.println();
            }
        }
        for(int j = 0; j < N; j++){
            if(min > costToW[M-1][j]) {
                min = costToW[M-1][j];
                minCoord = j;
            }
        }
        int x = M - 1;
        int y = minCoord;
        //System.out.print(minCoord+1 +" ");
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(minCoord+1);
        while(x != 0){
            if(y != N-1 && costToW[x][y] - mat[x][y] == costToW[x][y+1]){
                y += 1;
            }else if(y != 0 && costToW[x][y] - mat[x][y] == costToW[x][y-1]){
                y -= 1;
            }else{
                x -= 1;
            }
            ret.add(y+1);
        }
        for(int i = ret.size() - 1; i >= 0; i--){
            System.out.print(ret.get(i)+" ");
        }
    }
}
