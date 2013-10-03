import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		//Scanner to read input
		try {
			Scanner in = new Scanner(new File("triangle2.txt"));
			
			ArrayList<Integer> partial_sum_row = new ArrayList<Integer>();
			
			
			partial_sum_row.add(in.nextInt());
			while(in.hasNextInt()) {
				ArrayList<Integer> working_row = new ArrayList<Integer>();
				for(int i = 0; i < partial_sum_row.size() + 1; i++) {
					int cur = in.nextInt();
					//System.out.print(cur + " ");
					working_row.add(cur);
					
				}
				//System.out.println();
				for(int i = 0; i < working_row.size(); i++) {
					int current = working_row.get(i);
					if(i == 0) { //first element in the row
						working_row.set(0, partial_sum_row.get(0) + current);
					} else if (i == working_row.size() - 1) { // last
						working_row.set(i, partial_sum_row.get(i-1) + current);
					} else {
						int bigger = Math.max(partial_sum_row.get(i-1), partial_sum_row.get(i));
						working_row.set(i, bigger + current);
					}
				}
				
				partial_sum_row = working_row;
			}
			in.close();
			int ans = Collections.max(partial_sum_row);
			System.out.println(ans);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
