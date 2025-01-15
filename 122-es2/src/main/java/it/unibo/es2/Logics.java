package it.unibo.es2;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	String hit(Pair<Integer, Integer> selectedButton);
	
	public boolean ColumnFull();

	public boolean RowFull();

}
