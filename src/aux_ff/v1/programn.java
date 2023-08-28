package v1;

public class programn {
    public static int[][] createArr(){
        int[][] arr = new int[10][10];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++)
                if(i == j){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
        }
        return arr;
    }

    public static void main(String[] args){

        int[][] arr = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 0, 0, 0},  
        };

        ff f = new ff(arr);

        try{
            f.start(0, 1);
            f.print();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
