package UserInterface;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import medizin.Befehl;
import medizin.Variablen;
import medizin.Verbindung;

public class Spalten {
	
	
	public static Label[] namen = new Label [UserInterface.Variablen.spaltenAnzahl]; 
	public static Button[] checkButton1 = new Button [UserInterface.Variablen.spaltenAnzahl];
	public static Button[] checkButton2 = new Button [UserInterface.Variablen.spaltenAnzahl];
	public static Text[] namen_aendern = new Text[UserInterface.Variablen.spaltenAnzahl];
	
	private static Composite Spalten;
	private static ScrolledComposite sc;
	public static void open(Shell shell)
	{
		
		sc = new ScrolledComposite(shell, SWT.V_SCROLL);
	    sc.setBounds(10, 10, 780, 527);
	    sc.setVisible(false);
		
		Spalten = new Composite(sc, SWT.NONE);
		Spalten.setBounds(10, 10, 780, 134+(30*(UserInterface.Variablen.spaltenAnzahl+1)));
		Spalten.setVisible(true);
		
		Group group_Spalten = new Group(Spalten, SWT.NONE);
		group_Spalten.setBounds(10, 10, 760, 134+(30*(UserInterface.Variablen.spaltenAnzahl+1)));
		group_Spalten.setText("Spalteneinstellungen");
		
		Label Namen = new Label(group_Spalten, SWT.NONE);
		Namen.setBounds(5, 10, 200, 22);
		Namen.setText("Spaltennamen:");
		Namen.setVisible(true);
		
		Label Checkbox1 = new Label(group_Spalten, SWT.NONE);
		Checkbox1.setBounds(205, 10, 200, 22);
		Checkbox1.setText("Hauptspalten:");
		Checkbox1.setVisible(true);
		
		Label Checkbox2 = new Label(group_Spalten, SWT.NONE);
		Checkbox2.setBounds(405, 10, 200, 22);
		Checkbox2.setText("Andere Spalten:");
		Checkbox2.setVisible(true);
		
		Label Namen_aendern = new Label(group_Spalten, SWT.NONE);
		Namen_aendern.setBounds(605, 10, 300, 22);
		Namen_aendern.setText("Spaltenname ändern:");
		Namen_aendern.setVisible(true);
		
		BoxBau(group_Spalten);
		
		Spalten.setSize(780, 174+(30*(UserInterface.Variablen.spaltenAnzahl+1)));

	    sc.setContent(Spalten);
		
				
	   
		
	}
	public static void BoxBau(Group group_Verknuepfungen)
	{
		for (int i =0; i<UserInterface.Variablen.spaltenAnzahl;i++)
		{
			
			namen[i] = new Label(group_Verknuepfungen, SWT.READ_ONLY);
			namen[i].setBounds(5, 34+(30*(i+1)), 200, 22);
			namen[i].setText("");
			namen[i].setVisible(false);
			
			
			checkButton1[i] = new Button(group_Verknuepfungen, SWT.CHECK);
			checkButton1[i].setBounds(245,34+(30*(i+1)),20, 20);;
		    checkButton1[i].setVisible(false);
		    
		    checkButton2[i] = new Button(group_Verknuepfungen, SWT.CHECK);
			checkButton2[i].setBounds(445,34+(30*(i+1)),20, 20);;
		    checkButton2[i].setVisible(false);
		    
		    namen_aendern[i] = new Text(group_Verknuepfungen, SWT.BORDER);
		    namen_aendern[i].setBounds(555,34+(30*(i+1)), 200, 22);
		    namen_aendern[i].setText("");
		    namen_aendern[i].setVisible(false);
		    
			if (UserInterface.Variablen.Spaltennamen[i][0]!=null)
			{
				namen[i].setVisible(true);
				
			}
			
		}
			
		}
	public static void speichern()
	{
		for (int i=0;i<UserInterface.Variablen.spaltenAnzahl;i++)
		{
			if (namen[i].getText()!="")
			{
				UserInterface.Variablen.Spaltennamen[i][0]=namen[i].getText();
				
			
			if (checkButton1[i].getSelection()==true)
			{
				UserInterface.Variablen.Spaltennamen[i][1]="1";
				
			}
			if (checkButton2[i].getSelection()==true)
			{
				UserInterface.Variablen.Spaltennamen[i][1]="2";
				
			}
			if (checkButton2[i].getSelection()==false && checkButton1[i].getSelection()==false)
			{
				UserInterface.Variablen.Spaltennamen[i][1]="3";
				
			}
			
			if (namen_aendern[i].getText()!=null)
			{
				UserInterface.Variablen.Spaltennamen[i][2]=namen_aendern[i].getText();
				
			}
			
			if(namen_aendern[i].getText()==null || "".equals(namen_aendern[i].getText()))
			{
				UserInterface.Variablen.Spaltennamen[i][2]=null;
			}
			}
		}
		UserInterface.Variablen.laden_2 = true;
	}
	
	public static void laden()
	{
		for (int i =0; i<UserInterface.Variablen.spaltenAnzahl;i++)
		{
			
			if (UserInterface.Variablen.Spaltennamen[i][0]!=null)
			{
				namen[i].setText(UserInterface.Variablen.Spaltennamen[i][0]);
				namen[i].setVisible(true);
				
				if (UserInterface.Variablen.Spaltennamen[i][1] == "1")
				{
					checkButton1[i].setSelection(true);
				}
				checkButton1[i].setVisible(true);
				
				if (UserInterface.Variablen.Spaltennamen[i][1] == "2")
				{
					checkButton2[i].setSelection(true);
				}
				checkButton2[i].setVisible(true);
				if(UserInterface.Variablen.Spaltennamen[i][2]!=null)
				{
					namen_aendern[i].setText(UserInterface.Variablen.Spaltennamen[i][2]);
				}
				namen_aendern[i].setVisible(true);

			}
		}
	}
	public static void visible_true()
	{
		Spalten.setVisible(true);
		sc.setVisible(true);
	}
	public static void visible_false()
	{
		Spalten.setVisible(false);
		sc.setVisible(false);
	}
	public static void initialisieren()
	{
		String SQL = Befehl.SQL_hinten(Variablen.Primärschlüssel, Variablen.Verkn);
		int AnzahlSpalten = Verbindung.spalten(SQL);

        String [][] Namen = new String [Variablen.Vergleichdaten.length][AnzahlSpalten];
        int zaehler=0;
        for (int k=0;k<UserInterface.Variablen.Spaltennamen.length;k++)
        {
        	UserInterface.Variablen.Spaltennamen[k][1]="3";
        	UserInterface.Variablen.Spaltennamen[k][2]=null;
        }
        for(int k = 0;Variablen.Vergleichdaten[k] != null;k++)
        {
            Namen[k] = Verbindung.Spaltenname(Variablen.Vergleichdaten[k], Namen[k]);
            
        } 
        for(int k = 0;Namen[k][0]!=null;k++)
        {
            for (int m=0;Namen[k][m]!=null;m++)
            {
                
            	UserInterface.Variablen.Spaltennamen[zaehler][0]=Namen[k][m];
                zaehler++;
            }      
        }
	}
}
