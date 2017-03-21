package UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import medizin.Verbindung;

public class VerknZusatz {
	
	public static Combo[] combo0 = new Combo[Variablen.verknAnzahl];
	public static Combo[] combo1 = new Combo[Variablen.verknAnzahl];
	public static Combo[] combo2 = new Combo[Variablen.verknAnzahl];
	public static Combo[] combo3 = new Combo[Variablen.verknAnzahl];
	public static Label[] lblJoin = new Label[Variablen.verknAnzahl];
	
	public static void BoxBau(Group group_Verknuepfungen)
	{
		for (int i =0; i<Variablen.verknAnzahl;i++)
		{
			combo0[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo0[i].setBounds(5, 74+(30*(i+1)), 170, 22);
			combo0[i].setVisible(false);
			final int id = i;			
			
			combo1[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo1[i].setBounds(175, 74+(30*(i+1)), 170, 22);
			combo1[i].setVisible(false);
			combo1[i].setEnabled(false);
			
			
			lblJoin[i] = new Label(group_Verknuepfungen, SWT.NONE);
			lblJoin[i].setBounds(360, 76+(30*(i+1)), 80, 22);
			lblJoin[i].setText("JOIN");
			lblJoin[i].setVisible(false);
			
			
			combo2[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo2[i].setBounds(415, 74+(30*(i+1)), 170, 22);
			combo2[i].setVisible(false);
			
			
			combo3[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo3[i].setBounds(585, 74+(30*(i+1)), 170, 22);
			combo3[i].setVisible(false);
			combo3[i].setEnabled(false);
			
			combo0[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					combo1[id].setEnabled(true);
					int zaehler = Verbindung.spalten("from "+ ((Combo)e.getSource()).getText());
					combo1[id].setItems(Verbindung.Spaltenname2(((Combo)e.getSource()).getText(), zaehler));
				}
	      });
			
			combo2[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					combo3[id].setEnabled(true);
					int zaehler = Verbindung.spalten("from "+ ((Combo)e.getSource()).getText());
					combo3[id].setItems(Verbindung.Spaltenname2(((Combo)e.getSource()).getText(), zaehler));

				}
			});
			
		}
	}
}
