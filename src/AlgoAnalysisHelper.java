/* Algo Analsyis Helper
 * reading, timing, and writing
 */
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
import java.time.*;

public class AlgoAnalysisHelper{

    public static int[][] getArrays(String fileName){
	//open a scanner for the file passed in
	try{
	    Scanner in = new Scanner(new File(fileName));
	    //in.useDelimiter(", ");
	    int[][] output = new int[7][101];
	    // 7 arrays of 100 ints
	    for (int i = 0; i < 7; i++){
		int[] arr = new int[101];
		for (int j = 0; j < 101; j++){
		    // read in as string, strip comma, convert to int
		    arr[j] = Integer.valueOf(in.next().replace(",",""));
		}
		output[i] = arr;
	    }
	    in.close();
	    return output;
	}
	catch(Exception e){ System.out.println(e); }
	return null;   
    }


    public static void codeToTime(){
	for (int i = 0; i < 1000; i++){
	    int j = i * 2 - 3 + i% 10;
	}
    }

    public static long measureTime(int n){
	LocalTime start = LocalTime.now();
	primeChecker3(n,2); 
	LocalTime end = LocalTime.now();
	Duration length = Duration.between(start, end);
	return length.toNanos();
    }

    public static void output(long[] data, String fileName){
	
	try{
	    File f = new File(fileName);
	    if (f.createNewFile()) System.out.println("created file");
	    else { System.out.println("File already exists");}
	    FileWriter write = new FileWriter(fileName);
	    for (int i = 0; i < data.length; i++){
		write.write(Long.toString(data[i]));
		write.write("\n");
	    }
	    write.close();
	}
	catch(Exception e) {System.out.println(e);}
    }

    
    public static void main(String[] args) {
    	int[][] primeArr = getArrays("primes.txt");
    	long[] times = new long[7];
    	long sum=0;
    	long avg;
    	for (int row = 0; row < primeArr.length; row++) {
    		for(int col = 0; col < primeArr[row].length; col++) {
    			sum += measureTime(primeArr[row][col]);
    		}
    		avg = sum/100;
    		times[row]=avg;
    		System.out.println(avg);
    		
    	}
    	output(times, "output.csv");
    	
    }
    
    
    public static boolean primeChecker1(int n) { // Big-o = O(n)
    	if (n<= 1) { 
    		return false;
    	}
    	for (int i = 2; i < n; i++) 
            if (n % i == 0) {
            	
                return false;
            }
        return true;
    }
    
    public static boolean primeChecker2(int n) {// Big-o = O(sqrt(n))
    	if (n <= 1) {
    		return false;	
    	}
    	if (n == 2) {
    		return true;
    	}
    	else if (n % 2 == 0) {
    		return false;
    	}
    	for (int i = 3; i<= Math.sqrt(n); i+=2) {
    		 if (n % i == 0) {
    			 return false;
    		 }		 
    	}
    	return true;
    	
    }
    
    public static boolean primeChecker3(int n, int i) { // Big-o = O(sqrt(n)
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
      
        return primeChecker3(n, i + 1);
    }


    	 
    	      
    	
    
    
}
    
