package medizin;



public class Programm {
	
public static void laden(){

	Beispiel.Datenbank();
	Beispiel.Pfad();

    Beispiel.Primärschlüssel();
    Beispiel.Verknüpfungen();
}

public static void start() {
        
//SQL_Befehl_back

        String SQL = Befehl.SQL_hinten(medizin.Variablen.Primärschlüssel, medizin.Variablen.Verkn);
        
 //Verbindung
        
///Wie viele Tabellen
        Verbindung.anzahl();
        int AnzahlTabellen = medizin.Variablen.anzahl_Tabellen; 
        
//Array Tabellennamen initialisieren
        String [] ArrayTabellennamen = new String [AnzahlTabellen]; 
        
      
//Tabellennamen
        
        ArrayTabellennamen = Verbindung.Tabellennamen(ArrayTabellennamen);

                
// Wie viele Zeilen und Spalten
        
        int AnzahlSpalten = Verbindung.spalten(SQL);
        int AnzahlZeilenGroup = Verbindung.zeilenGroup(SQL,medizin.Variablen.Primärschlüssel);
        
// Spaltennamen auslesen
        
        String [][] Namen = new String [medizin.Variablen.Vergleichdaten.length][AnzahlSpalten];
        String [] []Spaltennamen = new String[(medizin.Variablen.Vergleichdaten.length*AnzahlSpalten)][3];
        int zaehler=0;
        for (int k=0;k<Spaltennamen.length;k++)
        {
            Spaltennamen[k][1]="3";
            Spaltennamen[k][2]=null;
        }
        for(int k = 0;medizin.Variablen.Vergleichdaten[k] != null;k++)
        {
            Namen[k] = Verbindung.Spaltenname(medizin.Variablen.Vergleichdaten[k], Namen[k]);
            
        } 
        for(int k = 0;Namen[k][0]!=null;k++)
        {
            for (int m=0;Namen[k][m]!=null;m++)
            {
                Spaltennamen[zaehler][0]=Namen[k][m];
                zaehler++;
            }
            
            
                
        }
        

//Array Daten initialisieren

        int Schluesselanzahl = Verbindung.Schluesselanzahl(SQL, medizin.Variablen.Primärschlüssel);
        String Schluessel [] = new String [Schluesselanzahl];
        Schluessel = Verbindung.Schlusselnamen(SQL,Schluessel, medizin.Variablen.Primärschlüssel);
        
//Datei schreiben
        
        try{Verbindung.schreiben(SQL,UserInterface.Variablen.Spaltennamen,AnzahlSpalten,AnzahlZeilenGroup,medizin.Variablen.Pfad,Schluessel,medizin.Variablen.Primärschlüssel);}
        catch(Exception e)
        {System.out.println("***** FEHLERMELDUNG *****"+e);}
        System.out.println("Fertig!!!!");
        
    }
public static void BSP_Daten()
{
	//Bsp.: Spaltendaten laden
	        for (int g=0;g<UserInterface.Variablen.Spaltennamen.length;g++)
	        {
	        	
	        /*
	        	if (UserInterface.Variablen.Spaltennamen[g][0]!="")
				{
					Spaltennamen[g][0] = UserInterface.Variablen.Spaltennamen[g][0];
					Spaltennamen[g][1] = UserInterface.Variablen.Spaltennamen[g][1];
					
				if (UserInterface.Variablen.Spaltennamen[g][1]!="3")
				{	
					Spaltennamen[g][1] = UserInterface.Variablen.Spaltennamen[g][1];
					
				}

				if(UserInterface.Variablen.Spaltennamen[g][2].equals("null")==false)
				{
					Spaltennamen[g][2] = UserInterface.Variablen.Spaltennamen[g][2];
					
				}
	        }
	        int BSP=1;
	        if(BSP==1)
	        {
	        Spaltennamen[0][1]="1";
	        Spaltennamen[1][1]="1";
	        Spaltennamen[2][1]="1";
	        Spaltennamen[3][1]="3";
	        Spaltennamen[4][1]="2";
	        Spaltennamen[5][1]="3";
	        Spaltennamen[6][1]="2";
	        Spaltennamen[7][1]="2";
	        Spaltennamen[8][1]="2";
	        
	        Spaltennamen[0][2]="Matrikelnummer";
	        Spaltennamen[1][2]="Name";
	        Spaltennamen[2][2]="Semester";
	        Spaltennamen[3][2]="1";
	        Spaltennamen[4][2]="2";
	        Spaltennamen[5][2]="3";
	        Spaltennamen[6][2]="4";
	        Spaltennamen[7][2]="5";
	        Spaltennamen[8][2]="6";
	        }
	        if(BSP==2)
	        {
	        Spaltennamen[0][1]="1";
	        Spaltennamen[1][1]="1";
	        Spaltennamen[2][1]="1";
	        Spaltennamen[3][1]="1";
	        Spaltennamen[4][1]="2";
	        Spaltennamen[5][1]="2";
	        Spaltennamen[6][1]="2";
	        Spaltennamen[7][1]="3";
	        }*/
	        }
	
}

}
