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
        
        if(line < 0 || line >= matrix.length || column < 0 || column >= matrix[0].length){
            throw new Exception("Invalid position");
        }

        if(matrix[line][column] == 1){
            throw new Exception("Initial position blocked");
        }

        if(matrix[line][column] == 2){
            throw new Exception("Initial position already visited");
        }

        Stack<pos> need_to_paint_points = new Stack<pos>(4);
        CircularQueue<pos> painted_pos = new CircularQueue<pos>(matrix[0].length * matrix.length);
        
        try{
            painted_pos.add(new pos(line, column));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Pinta o primeiro ponto
        matrix[line][column] = 2;

        print();

        while(!painted_pos.isEmpty()){
            try{
                pos p = painted_pos.remove();
                int auxLine = p.getl();
                int auxColumn = p.getc();

                if(isSafe(auxLine + 1, auxColumn)){
                    try{
                        need_to_paint_points.add(new pos(auxLine + 1, auxColumn));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                if(isSafe(auxLine - 1, auxColumn)){
                    try{
                        need_to_paint_points.add(new pos(auxLine - 1, auxColumn));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                if(isSafe(auxLine, auxColumn + 1)){
                    try{
                        need_to_paint_points.add(new pos(auxLine, auxColumn + 1));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                if(isSafe(auxLine, auxColumn - 1)){
                    try{
                        need_to_paint_points.add(new pos(auxLine, auxColumn - 1));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                while(!need_to_paint_points.isEmpty()){
                    try{
                        pos aux = need_to_paint_points.remove();
                        int auxl = aux.getl();
                        int auxc = aux.getc();

                        matrix[auxl][auxc] = 2;
                        print();
                        painted_pos.add(aux);

                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
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