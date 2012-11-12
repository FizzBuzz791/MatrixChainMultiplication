public class matrixtest
{
	public static void main(String[] args)
	{
		Matrix myMatrix = new Matrix();
		myMatrix.setRows(2);
		myMatrix.setColumns(3);
		System.out.println("Rows = " + myMatrix.getRows());

		myMatrix.setRows(0);
		System.out.println("New Rows = " + myMatrix.getRows());
	}
}
