package gruppuppgift4;

import java.util.Arrays;

import p6.Color;

/**
 * KLassen skapar en 2-dimensionell array
 * 
 * @author SannaRönngård
 *
 */

public class Array7x7 {

	private int[][] array7x7 = new int[7][7];
	private static int[][][] chars = { Chars.ZERO, Chars.ONE, Chars.TWO, 
			Chars.THREE, Chars.FOUR, Chars.FIVE, Chars.SIX, Chars.SEVEN, 
			Chars.EIGHT, Chars.NINE, Chars.SPACE, Chars.DOT, Chars.COMMA, 
			Chars.QUESTION_MARK, Chars.EXCLAMATION_MARK, Chars.AND, Chars.A,
			Chars.B, Chars.C, Chars.D, Chars.E, Chars.F, Chars.G, Chars.H,
			Chars.I, Chars.J, Chars.K, Chars.L, Chars.M, Chars.N, Chars.O, 
			Chars.P, Chars.Q, Chars.R, Chars.S, Chars.T, Chars.U, Chars.V, 
			Chars.W, Chars.X, Chars.Y, Chars.Z, Chars.Å, Chars.Ä, Chars.Ö, 
			Chars.PLUS, Chars.MINUS, Chars.STAR, Chars.CURLYA, Chars.RBRACKET,
			Chars.LBRACKET, Chars.LSLASH, Chars.RSLASH, Chars.HEART };
	public static String allChars = "0123456789 .,?!&abcdefghijklmnopqrstuvwxyzåäö+-*@()/\\§";

	/**
	 * Konstruktor som implicerar superklassen Array7
	 * 
	 * @param letter - Array bed bokstavsvärden (kan hämtas från Chars-klassen)
	 */
	public Array7x7(int[][] letter) {
		for (int i = 0; i < letter.length; i++) {
			for (int j = 0; j < letter[i].length; j++) {
				if (letter[i][j] == 1) {
					array7x7[i][j] = Color.rgb(65,176,135); //Bokstäver
				} else {
					array7x7[i][j] = Color.rgb(230,245,225); //Bakgrund
				}
			}
		}
	}

	/**
	 * Konstruktor som implicerar superklassen Array7
	 */
	public Array7x7() {
		for (int i = 0; i < array7x7.length; i++) {
			for (int j = 0; j < array7x7[i].length; j++) {
				array7x7[i][j] = 0;
			}
		}
	}

	/**
	 * Metod som skriver in ett nytt värde på den via parametrarna angivna positionen
	 * 
	 * @param row - Rad
	 * @param col - Kolumn
	 * @param value - Värde att stoppa in på positionen
	 */
	public void setElement(int row, int col, int value) {
		this.array7x7[row][col] = value;
	}

	/**
	 * Metod som returnerar värdet på positionen man anger med parametrarna
	 * 
	 * @param row - Rad
	 * @param col - Kolumn
	 * @return
	 */
	public int getElement(int row, int col) {
		return this.array7x7[row][col];
	}

	/**
	 * Metod som skriver in värdena från den medskickade Array7-instansen i den angivna raden
	 * 
	 * @param row - Den kolumn man vill mata in till
	 * @param theRow - Array7-objekt man vill stoppa in i kolumnen
	 */
	public void setRow(int row, Array7 theRow) {
		for (int i = 0; i < array7x7[row].length; i++) {
			array7x7[row][i] = theRow.getElement(i);
		}
	}

	/**
	 * Metod som skriver in radens värden i en array i en instans av Array7 och returnerar denna
	 * 
	 * @param row - Rad man vill ska returneras
	 * @return - Returnerar en instans av Array7 innehållande en array med den angivna radens värden
	 */
	public Array7 getRow(int row) {
		Array7 arrRow = new Array7();
		for (int i = 0; i < array7x7[row].length; i++) {
			arrRow.setElement(i, array7x7[row][i]);
		}
		return arrRow;
	}

	/**
	 * Metod som skriver in värdena från den medskickade Array7-instansen i den angivna kolumnen
	 * 
	 * @param col - Den kolumn man vill mata in till
	 * @param theCol - Array7-objekt man vill stoppa in i kolumnen
	 */
	public void setCol(int col, Array7 theCol) {
		for (int i = 0; i < array7x7[col].length; i++) {
			array7x7[i][col] = theCol.getElement(i);
		}
	}

	/**
	 * Metod som skriver in kolumnens värden i en array i en instans av Array7 och returnerar denna
	 * 
	 * @param col - Kolumn man vill ska returneras
	 * @return - Returnerar en instans av Array7 innehållande en array med den angivna kolumnens värden
	 */
	public Array7 getCol(int col) {
		Array7 arrCol = new Array7();
		for (int i = 0; i < array7x7[col].length; i++) {
			arrCol.setElement(i, array7x7[i][col]);
		}
		return arrCol;
	}

	/**
	 * Metod som skiftar innehållet till höger i arrayen
	 * 
	 * @param array7 - Array7-objekt matas in från vänster.
	 */
	public Array7 shiftRight(Array7 array7 ) {
		Array7 tempArray = new Array7();

		for (int row = 0; row < array7x7.length; row++) {
			for (int col = array7x7[row].length-1; col >= 0 ; col--) {
				if(col == array7x7[row].length-1) {
					tempArray.setElement(row, array7x7[row][6]);
				}
				if(col > 0) {
					array7x7[row][col] = array7x7[row][col-1];
				}
				if(col == 0) {
					array7x7[row][col] = array7.getElement(row);
				}
			}
		}
		return tempArray;
	}

	/**
	 * Metod som skiftar innehållet till vänster i arrayen
	 *	 
	 * @param inArray - Array7-objekt matas in från höger.
	 */
	public Array7 shiftLeft(Array7 inArray) {
		Array7 outArray = new Array7();

		for(int i = 0; i < array7x7.length; i++) {
			for(int j = 0; j < array7x7[i].length; j++) {
				if(j == 0) {
					outArray.setElement(i, array7x7[i][0]);
				}

				if(j < array7x7.length - 1) {
					array7x7[i][j] = array7x7[i][j+1];
				}

				if(j == array7x7.length - 1) {
					array7x7[i][j] = inArray.getElement(i);
				}
			}
		}

		return outArray;
	}

	/**
	 * Returnerar Array7x7-objekt motsvarande den bokstav som matas in
	 * @param chr - Den bokstav man vill få returnerad som Array7x7-objekt
	 * @return
	 */
	public static Array7x7 getChar(char chr) {
		for(int i = 0; i < chars.length; i++) {
			if(chr == allChars.charAt(i)) {
				return new Array7x7(chars[i]);
			}
		}
		return new Array7x7(Chars.FILLED);
	}
}
