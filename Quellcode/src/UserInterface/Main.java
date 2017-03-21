package UserInterface;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("MySQL to ARX");
		shell.setLayout(null);
		Allgemein.open(shell);
		Datenbank.open(shell);
		Verknuepfungen.open(shell);
		Spalten.open(shell);
		Speicherort.open(shell,display);
		Datenbank.visible_true();
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}