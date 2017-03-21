package UserInterface;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import medizin.Verbindung;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class Allgemein {
	
	static Button btnWeiter;
	static Button btnZurck;
	
	public static void open(Shell shell)
	{
		btnWeiter = new Button(shell, SWT.NONE);
		btnWeiter.setBounds(596, 540, 94, 28);
		btnZurck = new Button(shell, SWT.NONE);
		btnZurck.setBounds(496, 540, 94, 28);
		btnZurck.setEnabled(false);
		btnWeiter.addMouseListener(new MouseAdapter() { //WEITER
			@Override
			public void mouseDown(MouseEvent e) {
				
				UserInterface.Variablen.Zaehler_Windows++;
				if (UserInterface.Variablen.Zaehler_Windows==2)
				{
					Datenbank.speichern();
					Datenbank.visible_false();
					Verbindung.anzahl();
					String [] table = new String [medizin.Variablen.anzahl_Tabellen];
					table = medizin.Verbindung.Tabellennamen(table);
					Verknuepfungen.initialisieren(table);
					if (UserInterface.Variablen.laden_1==true)
					{
						Verknuepfungen.laden();
					}
					Verknuepfungen.visible_true();
					
				}
				if (UserInterface.Variablen.Zaehler_Windows==3)
				{
					Verknuepfungen.speichern();
					Verknuepfungen.visible_false();
					Spalten.initialisieren();
					Spalten.laden();
					if (UserInterface.Variablen.laden_2==true)
					{
						Spalten.laden();
					}
					Spalten.visible_true();
				}
				if (UserInterface.Variablen.Zaehler_Windows==4)
				{
					Spalten.visible_false();
					Spalten.speichern();
					medizin.Beispiel.Pfad();
					Speicherort.laden();
					if (UserInterface.Variablen.laden_3==true)
					{
						Speicherort.laden();
					}
					Speicherort.visible_true();
					btnWeiter.setText("Fertig");
				}
				if (UserInterface.Variablen.Zaehler_Windows==5)
				{
					Speicherort.speichern();
					medizin.Programm.start();
					System.exit(0);
				}
				btnZurck.setEnabled(true);
				
			}
		});
		btnWeiter.setText("Weiter");
		btnWeiter.setEnabled(false);
		
		
		btnZurck.addMouseListener(new MouseAdapter() {  //ZURÜCK
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				UserInterface.Variablen.Zaehler_Windows--;
				
				if (UserInterface.Variablen.Zaehler_Windows==1)
				{
					Datenbank.laden();
					Datenbank.visible_true();
					Verknuepfungen.visible_false();
					btnZurck.setEnabled(false);
					btnWeiter.setEnabled(false);
				}
				if (UserInterface.Variablen.Zaehler_Windows==2)
				{
					Verknuepfungen.visible_true();
					Spalten.visible_false();
				}
				if (UserInterface.Variablen.Zaehler_Windows==3)
				{
					Spalten.visible_true();
					Speicherort.visible_false();
				}
				 
			}
		});
		btnZurck.setText("Zurück");
		btnZurck.setEnabled(false);
		
		Button btnAbbrechen = new Button(shell, SWT.NONE);
		btnAbbrechen.setBounds(696, 540, 94, 28);
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.exit(0);
			}
		});
		btnAbbrechen.setText("Abbrechen");
		

	}
	public static void enable_Weiter()
	{
		btnWeiter.setEnabled(true);
	}
	public static void disable_Weiter()
	{
		btnWeiter.setEnabled(false);
	}
	public static void enable_Zurueck()
	{
		btnZurck.setEnabled(true);
	}
	public static void disable_Zurueck()
	{
		btnZurck.setEnabled(false);
	}

}
