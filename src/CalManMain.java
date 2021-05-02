/**
 * CalMan - Verwaltung der Kalibrierungen.
 * 
 * Alle im "Calibration Management" abgelegte Kalibrierung werden durch den CalIdx Identifiziert.
 * Dieses Programm erm�glicht die Eingabe zus�tzlicher Informationen die an verschiedenen Stellen im System
 * gebraucht werden.
 * <ul>
 * 		<li>Powercurve Auswertung Kopf</li>
 * 		<li>Berechnete Stufenpunkte zb. 20h COP</li>
 * 		<li>Kolossus, Kenndaten z.b f�r Aufbaumatrix</li>
 * 		<li>Limits und Sollwerte f�r WOT Stufenpunkte</li>
 * </ul>
 * 
 * @author Sascha Zapf
 * @version 1.0, 25.04.2021
 */
public class CalManMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calibrations calibrations = new Calibrations();
		
		calibrations.getVcmeList().forEach((idx) -> System.out.println(idx));
		
	}

}
