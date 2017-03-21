package medizin;

public class Beispiel {
	
	private static int BSP=1;
	public static void Pfad()
	{
		Variablen.Pfad = "/Users/michaelschafferer/Desktop/Beispiel.arx";
	}
	public static void Datenbank()
	{
		
        Variablen.VDaten[0]="localhost";
        Variablen.VDaten[1]="3306";
        Variablen.VDaten[2]="Test";
        Variablen.VDaten[3]="root";
        Variablen.VDaten[4]="";
        
	}
	public static void Primärschlüssel ()
	{
		if(BSP==1)
        {
			Variablen.Primärschlüssel[0]="Studenten";
			Variablen.Primärschlüssel[1]="MatrNr";
        }
		if(BSP==2)
        {
			Variablen.Primärschlüssel[0]="Professoren";
            Variablen.Primärschlüssel[1]="PersNr";
        }
	}
	public static void Verknüpfungen()
	{

		if(BSP==1)
        {
       
			Variablen.Verkn[0][0]="Studenten";
			Variablen.Verkn[0][1]="MatrNr";
			Variablen.Verkn[0][2]="JOIN";
			Variablen.Verkn[0][3]="hoeren";
			Variablen.Verkn[0][4]="MatrNr";
    
			Variablen.Verkn[1][0]="hoeren";
			Variablen.Verkn[1][1]="VorlNr";
			Variablen.Verkn[1][2]="JOIN";
			Variablen.Verkn[1][3]="Vorlesungen";
			Variablen.Verkn[1][4]="VorlNr";
        }  
        if(BSP==2)
        {
        	Variablen.Verkn[0][0]="Professoren";
        	Variablen.Verkn[0][1]="PersNr";
        	Variablen.Verkn[0][2]="JOIN";
        	Variablen.Verkn[0][3]="Assistenten";
        	Variablen.Verkn[0][4]="Boss";
        }
	}
}
