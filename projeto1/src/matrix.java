import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 


public class matrix {

    private static final double CLOCKS_PER_SEC = 1000000000;

    static FileWriter fileWriter;
    static PrintWriter printWriter;

    static FileWriter fileWriterMD;
    static PrintWriter printWriterMD;

    public static void OnMult(int m_ar, int m_br){

        printWriter.printf("Multiplication, %d, -, ", m_ar);
        long startTime, endTime,duration;
        
        double temp;
        int i, j, k;
    
        
        double pha[] = new double[m_ar * m_ar];
        double phb[] = new double[m_ar * m_ar];
        double phc[] = new double[m_ar * m_ar];

    
        for(i=0; i<m_ar; i++)
            for(j=0; j<m_ar; j++)
                pha[i*m_ar + j] = (double)1.0;
    
    
        for(i=0; i<m_br; i++)
            for(j=0; j<m_br; j++)
                phb[i*m_br + j] = (double)(i+1);
    
        startTime = System.nanoTime();
        
        for(i=0; i<m_ar; i++) {
            for( j=0; j<m_br; j++) {
                temp = 0;
                for( k=0; k<m_ar; k++) {	
                    temp += pha[i*m_ar+k] * phb[k*m_br+j];
                }
                phc[i*m_ar+j]=temp;
            }
        }
    
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        
        System.out.println("Time: " + duration/ CLOCKS_PER_SEC + " seconds");

        printWriter.printf("%3.3f\n", duration / CLOCKS_PER_SEC);
        
        // display 10 elements of the result matrix tto verify correctness
        System.out.println("Result matrix: ");
        for(i=0; i<1; i++)
        {	for(j=0; j< Math.min(10,m_br); j++)
                System.out.print(phc[j] + " ");
        }
        System.out.println();
    }
    public static void OnMultLine(int m_ar, int m_br){

        printWriter.printf("Line Multiplication, %d, -, ", m_ar);

        long startTime, endTime, duration;
        
        int i, j, k;
    
        double pha[] = new double[m_ar * m_ar];
        double phb[] = new double[m_ar * m_ar];
        double phc[] = new double[m_ar * m_ar];

        for(i=0; i<m_ar; i++)
            for(j=0; j<m_ar; j++)
                pha[i*m_ar + j] = (double)1.0;
    
    
        for(i=0; i<m_br; i++)
            for(j=0; j<m_br; j++)
                phb[i*m_br + j] = (double)(i+1);
    
        startTime = System.nanoTime();
        
        for (i = 0; i < m_ar; i++){
            for (k = 0; k < m_ar; k++){
                for (j = 0; j < m_br; j++){
                    phc[i*m_ar+j] += pha[i*m_ar+j] * phb[k*m_br+j];
                }
            }
        }
    
        endTime = System.nanoTime();
        duration = (endTime - startTime);

        System.out.println("Time: " + duration/CLOCKS_PER_SEC + " seconds");

        printWriter.printf("%3.3f, ", duration / CLOCKS_PER_SEC);
    
        // display 10 elements of the result matrix tto verify correctness
        System.out.println("Result matrix: ");
        for(i=0; i<1; i++)
        {	for(j=0; j< Math.min(10,m_br); j++)
                System.out.print(phc[j] + " ");
        }
        System.out.println();
    }
   
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 
        int operation = 0;
        int lin, col;

        try {
            fileWriter = new FileWriter("data_java.csv");
            printWriter = new PrintWriter(fileWriter);

	        printWriter.printf("type, size, block_size, time, L1_DCM, L2_DCM, TOT_CYC\n");
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        do{
            System.out.println("1. Multiplication");
            System.out.println("2. Line Multiplication");
            System.out.println("0. Exit");
            System.out.println("Selection?: ");

            operation = input.nextInt();
            if (operation == 0)
			    break;

            System.out.println("Dimensions: lins=cols ? ");
            lin = input.nextInt();
            col=lin;

            switch (operation){
                case 1: 
                    OnMult(lin, col);
                    break;
                case 2:
                    OnMultLine(lin, col);  
                    break;
            }
        } while (operation != 0);
    
        
        try {
            fileWriter.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}