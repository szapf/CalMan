import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import java.util.Scanner;

/**
 * Calibrations - Erfaßt alle aktiven Kalibrierungen aus dem Calibration Management.
 * 
 * @author Sascha Zapf
 *
 */

public class Calibrations {
	
	private TreeSet<Integer> idxList = new TreeSet<Integer>(); 
	private TreeSet<Integer> vcmeList = new TreeSet<Integer>();
	
	/**
	 * @param vcmeActive True wenn nur CalIdx die auch in der MasterVCME aktiv sind erfasst werden sollen.
	 * @return ArrayList mit allen aktiven CalIdx.
	 */
	public TreeSet<Integer> getVcmeList() {
		Scanner vcme = null;
		try {
		    vcme = new Scanner(new File("W:\\KEP-Dyno-Daten\\Calibration Management\\master.vcme"));
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		vcme.nextLine(); // Erste Zeile überspringen
		
		int idxCol = findIDXcol(vcme.nextLine().split(";"));
		
		while (vcme.hasNext()) {
			vcmeList.add(Integer.parseInt(vcme.nextLine().split(";")[idxCol]));
		}
		vcme.close();
		return vcmeList;
	}
	
	private int findIDXcol(String[] cols) {
		int idxPos = 0;
		while (idxPos < cols.length) {
			if (cols[idxPos].equals("idx"))  {
				return idxPos;
			}
			idxPos++;
		}
		return -1;
	}
}
