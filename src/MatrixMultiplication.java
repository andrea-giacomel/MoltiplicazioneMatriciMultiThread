public class MatrixMultiplication {
    //definisco la dimensione delle matrici
    public static int N = 3;
    
    //definisco la matrice A
    public static int A[][] = {
    		{-1, 5, 5},
    		{-4, 9, 6}, 
    		{6, -8, 3}
    };
	//definisco la matrice B
    public static int B[][] = {
    		{1, 0, 0}, 
    		{0, 1, 0},
    		{0, 0, 1},
    };
    public static int [][] C = new int [N][N];
    
    //matrice di threads
    public static esecutoreThread [][] Threads = new esecutoreThread[N][N];
    
    public static void main(String[] args) throws InterruptedException {      
        
        //creo N^2 threads dove in ognuno di essi calcolo un elemento della matrice finale
    	for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                Threads[i][j] = new esecutoreThread(N, i, j, A, B, C);
                Threads[i][j].start();
            }
        }
    	
    	for(int i = 0; i<N; i++){
            for(int j=0; j<N; j++){
                Threads[i][j].join();
            }
        }
        
    	//Stampo a schermo le  matrici
	    System.out.println("Matrice A [" + A.length + "]x[" + A[0].length + "]");
	    stampaMatrice(A);
	    System.out.println("Matrice B [" + B.length + "]x[" + B[0].length + "]");
	    stampaMatrice(B);
	    System.out.println("Matrice C=A*B [" + C.length + "]x[" + C[0].length + "]");
	    stampaMatrice(C);  
    }
    
    public static void stampaMatrice(int[][] mat) {
		int numRighe = mat.length;
		int numColonne = mat[0].length;
		
		//per ogni riga
		for (int i = 0; i < numRighe; i++) {
			//per ogni elemento della riga
			for (int j = 0; j < numColonne; j++) {
				//stampo l'elemento
				System.out.printf("%4d " , mat[i][j]);
			}
			//terminata la riga, vado a capo
			System.out.println();
		}
		
		System.out.println();
	}
}