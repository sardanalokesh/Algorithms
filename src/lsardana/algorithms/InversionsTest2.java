package lsardana.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InversionsTest2 {

	public static void main(String[] args) {
		try {
			String filepath = new File("").getAbsolutePath();
			filepath = filepath.concat("/data/IntegerArray.txt");
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			long[] inputArray = new long[100000];
			String line = null;
			int index = 0;
			while((line  = br.readLine()) != null) {
				inputArray[index] = Integer.parseInt(line);
				index++;
			}
			br.close();
			//System.out.println(Arrays.toString(inputArray));
			Inversions inv1 = new Inversions(inputArray);
			//System.out.println(Arrays.toString(inv1.getSortedArray()));
			System.out.println(inv1.getInversionCount());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
