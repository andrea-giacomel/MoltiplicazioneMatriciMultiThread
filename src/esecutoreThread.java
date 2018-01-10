public class esecutoreThread extends Thread {
    private int riga;
    private int dimMatrice;
    private int colonna;
    private int [][] A;
    private int [][] B;
    private int [][] C;
    
    public esecutoreThread(int dimMatrice, int riga, int colonna, int[][] A, int[][] B, int[][] C) {
    	this.dimMatrice = dimMatrice;
    	this.riga = riga;
        this.colonna = colonna;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    public void run() {
    	//faccio il prodotto scalare riga di A * colonna di B
    	for(int i = 0; i<dimMatrice; i++) {
			C[riga][colonna] += A[riga][i] * B[i][colonna];
		} 
    }   
}