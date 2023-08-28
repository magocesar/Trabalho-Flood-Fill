package v1;
import aux_ff.*;

//Int vazio == 0;
//Int bloqueado == 1;
//Int espalha == 2;

public class ff {
    private int[][] matrix;

    public ff(int [][] matrix){
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void start(int line, int column) throws Exception{
        //Escolher tipo de fila / pilha / Dll
        //CircularQueue<pos> queue = new CircularQueue<pos>(arr[0].length * arr.length);
        //Stack<pos> queue = new Stack<pos>(arr[0].length * arr.length);
        //StackV2<pos> queue = new StackV2<pos>();

        if(line < 0 || line >= matrix.length || column < 0 || column >= matrix[0].length){
            throw new Exception("Invalid position");
        }

        if(matrix[line][column] == 1){
            throw new Exception("Initial position blocked");
        }

        if(matrix[line][column] == 2){
            throw new Exception("Initial position already visited");
        }

        QueueV2<pos> queue = new QueueV2<pos>();
        
        try{
            queue.add(new pos(line, column));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Pinta o primeiro ponto
        matrix[line][column] = 2;

        print();

        while(!queue.isEmpty()){
            try{
                pos p = queue.remove();
                int auxLine = p.getl();
                int auxColumn = p.getc();

                if(isSafe(auxLine + 1, auxColumn)){
                    matrix[auxLine + 1][auxColumn] = 2;
                    print();
                    queue.add(new pos(auxLine + 1, auxColumn));
                }

                if(isSafe(auxLine - 1, auxColumn)){
                    matrix[auxLine - 1][auxColumn] = 2;
                    print();
                    queue.add(new pos(auxLine - 1, auxColumn));
                }

                if(isSafe(auxLine, auxColumn + 1)){
                    matrix[auxLine][auxColumn + 1] = 2;
                    print();
                    queue.add(new pos(auxLine, auxColumn + 1));
                }

                if(isSafe(auxLine, auxColumn - 1)){
                    matrix[auxLine][auxColumn - 1] = 2;
                    print();
                    queue.add(new pos(auxLine, auxColumn - 1));
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isSafe(int line, int column){
        if(line < 0 || line >= matrix.length || column < 0 || column >= matrix[0].length || matrix[line][column] == 2 || matrix[line][column] == 1){
            return false;
        }
        return true;
    }

    public void print(){
        System.out.println();
        for(int i = 0; i < matrix.length; i++){
            System.out.print("[");
            for(int j = 0; j < matrix[0].length; j++){
                    if(j == matrix[0].length - 1)
                        System.out.print(matrix[i][j]);
                    else
                        System.out.print(matrix[i][j] + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }
}