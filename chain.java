/*********************************************************
 * Author:  Trent Jones                                  *
 * Version: 1.1 - Added calculations output		 *
 * Date:    13/11/12					 *
 * Summary: Calculate optimal parenthesization for 	 *
 * 	    matrix multplication                         *
 *********************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class chain
{
	public static void main(String[] args)
	{
		boolean verbose = false; // Verbose output on/off, manual only. TODO: Convert to command line option.
		int iMatriceCount = 0; // Number of matrices
		ArrayList<Matrix> mDimensions = new ArrayList<Matrix>(); // List of matrice dimensions
		ArrayList<String> parentheses = new ArrayList<String>(); // List rep of matrices. Use list to easily insert parentheses.

		System.out.println("Please input the number of matrices (current limit of 26):");

		iMatriceCount = new Scanner(System.in).nextInt();
		if (iMatriceCount > 26)
		{
			System.out.println("This program is currently limited to 26. Please try again.");
			System.exit(0);
		}
		
		// Use helper method to keep main clean-ish
		parentheses = initString(iMatriceCount);

		// Only print if verbose is on (-v)
		if (verbose)
			System.out.println("\nVerbose output is on.\n");
		
		// Receive dimensions
		for (int i = 0; i < iMatriceCount; i++)
		{
			System.out.println("Please input the dimensions of matrix " + (char)(i + 65) + " in the format (m:n):");
			
			// Need to do it this way so that the int's can be parsed.
			String[] sTempArray = new Scanner(System.in).nextLine().split(":");
			mDimensions.add(new Matrix(Integer.parseInt(sTempArray[0]), Integer.parseInt(sTempArray[1])));
		}

		// Loop through and find highest value
		int iCalculations = 0; // Track number of calculations needed for this optimisation.
		int iHighVal = -1; // Used to find highest multiplication.
		int iMatrix = -1; // Track which matrix has the highest columns for multiplications.
		int iLoopCount = 0;
		while (iMatriceCount > 1)
		{
			iHighVal = -1; // Best to reset at the start of each loop
			iMatrix = -1; // Again, best to reset this.
			for (int i = 0; i < iMatriceCount - 1; i++) // Check columns of all except last to find highest value
			{
				int columns = mDimensions.get(i).getColumns();
				if (columns > iHighVal)
				{
					iHighVal = columns;
					iMatrix = i;
				}
			}

			// Now add parentheses around relevant matrix.
			parentheses.set(iMatrix, "(" + parentheses.get(iMatrix) + parentheses.get(iMatrix + 1) + ")");
			parentheses.remove(iMatrix + 1);
			if (verbose)
				System.out.println("\n\tStep " + iLoopCount + " parenthesization: " + getString(parentheses));

			// Figure out needed calculations
			iCalculations += (mDimensions.get(iMatrix).getRows() * mDimensions.get(iMatrix).getColumns() * mDimensions.get(iMatrix + 1).getColumns());
			if (verbose)
				System.out.println("\tStep " + iLoopCount + " calculations: " + iCalculations);
	
			// reset list to represent available multiplication possibilities
			iMatriceCount--;
			mDimensions.get(iMatrix).setColumns(mDimensions.get(iMatrix + 1).getColumns());
			mDimensions.remove(iMatrix + 1);

			iLoopCount++;
		}

		System.out.println("\nPartially optimised parentheses: " + getString(parentheses));
		System.out.println("Calculations needed: " + iCalculations);
	}

	/********************************************
	 * Convert ArrayList to a continuous string *
	 ********************************************/
	private static String getString(ArrayList<String> inList)
	{
		String tempString = "";

		for (String s : inList)
		{
			tempString += s;
		}

		return tempString;
	}

	/*****************************************************
	 * Helper method to initialise parentheses arraylist *
	 *****************************************************/
	private static ArrayList<String> initString(int inCount)
	{
		ArrayList<String> tempList = new ArrayList<String>();

		for (int i = 0; i < inCount; i++)
		{
			tempList.add(new String(Character.toString((char)(i + 65))));
		}

		return tempList;
	}
}
