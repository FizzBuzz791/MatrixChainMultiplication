/*********************************************************
 * Author:  Trent Jones                                  *
 * Version: 1.0 - Basic functionality			 *
 * Date:    12/11/12					 *
 * Summary: Class to represent a matrix			 *
 *          Version 1.0 is dimensions only		 *
 *********************************************************/

public class Matrix
{
	private int rows;
	private int columns;

	/*************************************
	 * Default constructor, 0 x 0 matrix *
	 *************************************/
	public Matrix()
	{
		rows = 0;
		columns = 0;
	}

	/***********************************
	 * Main constructor                *
	 * Input: # of rows & # of columns *
	 ***********************************/
	public Matrix(int inRows, int inColumns)
	{
		rows = inRows;
		columns = inColumns;
	}

	/**********************************************
	 * Returns the number of rows for this matrix *
	 **********************************************/
	public int getRows()
	{
		return rows;
	}

	/*************************************************
	 * Returns the number of columns for this matrix *
	 *************************************************/
	public int getColumns()
	{
		return columns;
	}

	/******************************************
	 * Sets the number of rows for the matrix *
	 ******************************************/
	public void setRows(int inRows) throws IllegalArgumentException
	{
		if (inRows > 0)
		{
			rows = inRows;
		}
		else
		{
			throw new IllegalArgumentException("Input must be greater than 0.");
		}
	}

	/*********************************************
	 * Sets the number of columns for the matrix *
	 *********************************************/
	public void setColumns(int inColumns) throws IllegalArgumentException
	{
		if (inColumns > 0)
		{
			columns = inColumns;
		}
		else
		{
			throw new IllegalArgumentException("Input must be greater than 0.");
		}
	}
}
