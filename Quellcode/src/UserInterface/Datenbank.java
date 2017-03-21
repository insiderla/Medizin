package UserInterface;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
public class Datenbank {
	
	private static Composite Datenbank;
	public static void open(Shell shell)
	{
		Datenbank = new Composite(shell, SWT.NONE);
		Datenbank.setBounds(10, 10, 780, 527);
		Datenbank.setVisible(false);
		
		Group group_Datenbank = new Group(Datenbank, SWT.NONE);
		group_Datenbank.setBounds(10, 10, 760, 507);
		group_Datenbank.setText("Datenbankeinstellungen");
		
		Label lblServer = new Label(Datenbank, SWT.NONE);
		lblServer.setBounds(30, 30, 100, 14);
		lblServer.setText("Server:");
		
		Label lblPort = new Label(Datenbank, SWT.NONE);
		lblPort.setBounds(30, 60, 100, 14);
		lblPort.setText("Port:");
		
		Label lblDBName = new Label(Datenbank, SWT.NONE);
		lblDBName.setBounds(30, 90, 100, 14);
		lblDBName.setText("Datenbankname:");
		
		Label lblDBBenutzer = new Label(Datenbank, SWT.NONE);
		lblDBBenutzer.setBounds(30, 120, 100, 14);
		lblDBBenutzer.setText("Benutzer:");
		
		Label lblDBPasswort = new Label(Datenbank, SWT.NONE);
		lblDBPasswort.setBounds(30, 150, 100, 14);
		lblDBPasswort.setText("Passwort:");
		
		Variablen.txt_DBServer = new Text(Datenbank, SWT.BORDER);
		Variablen.txt_DBServer.setBounds(136, 27, 250, 19);
		Variablen.txt_DBServer.setText("localhost");
		
		Variablen.txt_DBPort = new Text(Datenbank, SWT.BORDER);
		Variablen.txt_DBPort.setBounds(136, 57, 250, 19);
		Variablen.txt_DBPort.setText("3306");
		
		Variablen.txt_DBName = new Text(Datenbank, SWT.BORDER);
		Variablen.txt_DBName.setBounds(136, 87, 250, 19);
		Variablen.txt_DBName.setText("Test");
		
		Variablen.txt_DBBenutzer = new Text(Datenbank, SWT.BORDER);
		Variablen.txt_DBBenutzer.setBounds(136, 117, 250, 19);
		Variablen.txt_DBBenutzer.setText("root");
		
		Variablen.txt_DBPasswort = new Text(Datenbank,SWT.SINGLE | SWT.BORDER);
		Variablen.txt_DBPasswort.setEchoChar('*');
		Variablen.txt_DBPasswort.setBounds(136, 147, 250, 19);
		Variablen.txt_DBPasswort.setText("");
		
		Button btnVerbindungTesten = new Button(group_Datenbank, SWT.NONE);
		btnVerbindungTesten.setBounds(136, 200, 250, 28);
		btnVerbindungTesten.setText("Verbindung testen");
		
		final Label lblVerbindungOK = new Label(group_Datenbank, SWT.NONE);
		lblVerbindungOK.setBounds(136, 234, 581, 149);
		lblVerbindungOK.setText("Verbindung OK");
		lblVerbindungOK.setVisible(false);
		
		btnVerbindungTesten.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					speichern();
					String test = medizin.Verbindung.test();
					if (test == null)
					{
						lblVerbindungOK.setText("Verbindung OK");
						lblVerbindungOK.setVisible(true);
						Allgemein.enable_Weiter();
					}
					else
					{
						lblVerbindungOK.setText("Fehler in der Verbindung! \n"+test);
						lblVerbindungOK.setVisible(true);
						Allgemein.disable_Weiter();
					}
				}
			});
	}
	
	public static void speichern()
	{
		medizin.Variablen.VDaten[0] = Variablen.txt_DBServer.getText();
		medizin.Variablen.VDaten[1] = Variablen.txt_DBPort.getText();
	    medizin.Variablen.VDaten[2] = Variablen.txt_DBName.getText();
	    medizin.Variablen.VDaten[3] = Variablen.txt_DBBenutzer.getText();
	    medizin.Variablen.VDaten[4] = Variablen.txt_DBPasswort.getText();
	    
	    Variablen.laden_0=true;
	    
	}

	public static void laden()
	{
		Variablen.txt_DBServer.setText(medizin.Variablen.VDaten[0]);
		Variablen.txt_DBPort.setText(medizin.Variablen.VDaten[1]);
		Variablen.txt_DBName.setText(medizin.Variablen.VDaten[2]);
		Variablen.txt_DBBenutzer.setText(medizin.Variablen.VDaten[3]);
		Variablen.txt_DBPasswort.setText(medizin.Variablen.VDaten[4]);


	}
	public static void visible_true()
	{
		Datenbank.setVisible(true);
	}
	public static void visible_false()
	{
		Datenbank.setVisible(false);
	}

}
