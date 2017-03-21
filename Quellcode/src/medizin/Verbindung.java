package medizin;
import java.sql.*;
import java.io.*;

public class Verbindung {
	
    public static String test()
    {
        
        
        try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
				
		con.setReadOnly(true);
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("Show tables from "+Variablen.VDaten[2]);
                    while (rs.next())
                        {
            
                        }
                        rs.close();
                        stat.close();
                        con.close();
                    
		
	}
	catch(Exception e){
		return e.getMessage();
	}
    return null; 

        
    }

        public static void anzahl()
        {
            
            int zaehler = 0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Show tables from "+Variablen.VDaten[2]);
                        
                        while (rs.next())
                            {
                                zaehler++;
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        Variablen.anzahl_Tabellen=zaehler;

            
        }
         public static String [] Tabellennamen(String [] Tabelle)
        {
            int zaehler =0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Show tables from Test ");
                        
                        while (rs.next())
                            {
                                Tabelle[zaehler] = rs.getString(1);
                                zaehler++;
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        return Tabelle; 

            
        }
        public static int zeilen(String SQL)
        {
            String Befehl = "SELECT COUNT(*) " + SQL;
            
            int zaehler = 0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+medizin.Variablen.VDaten[0]+":"+medizin.Variablen.VDaten[1]+"/"+medizin.Variablen.VDaten[2], medizin.Variablen.VDaten[3],medizin.Variablen.VDaten[4]);
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(Befehl);
                        while (rs.next())
                            {
                                zaehler = rs.getInt(1);
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        return zaehler; 

            
        }
        public static int zeilenGroup(String SQL,String Primärschlüssel[])
        {
            String Befehl = "SELECT COUNT(*) AS Anzahl " + SQL + " GROUP BY "+Primärschlüssel[0]+"."+Primärschlüssel[1]+" ORDER BY Anzahl ASC";
            int zaehler = 0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(Befehl);
                        
                        while (rs.next())
                            {
                                zaehler = rs.getInt(1);
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			//System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        return zaehler; 

            
        }
        public static int spalten(String SQL)
        {
            
            int zaehler = 0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Select * " + SQL );
                        
                        zaehler = rs.getMetaData().getColumnCount(); //WICHTIG
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        return zaehler; 

            
        }
        public static String [][] Daten_holen(String [][] Daten,String SQL)
        {
            int zaehler =1;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
			
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * " + SQL);
                        while (rs.next()&& zaehler<10002)
                            {
                                int k = zaehler+1;
                                for (int i=0;i<Daten[zaehler].length;i++)
                                {
                                    int j = i+1;
                                    Daten[k][i] = rs.getString(j);
                                }
                                    zaehler++;
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG ***** "+e);
			System.exit(0);
		}
        return Daten; 

            
        }
         public static String [] Spaltenname(String Tabelle, String []Namen)
        {
           
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Show Columns from "+Tabelle);
                        int zaehler=0;
                        
                        while (rs.next())
                            { 
                                Namen[zaehler] =Tabelle+"."+ rs.getString(1);
                                zaehler++;
                               
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
            
        return Namen; 

            
        }
         public static String [] Spaltenname2(String Tabelle, int zaehler2 )
        {
        	 String []Namen = new String[zaehler2];
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Show Columns from "+Tabelle);
                        int zaehler=0;
                        
                        while (rs.next())
                            { 
                                Namen[zaehler] =rs.getString(1);
                                zaehler++;
                               
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
            
        return Namen; 

            
        }
        public static int Schluesselanzahl(String SQL,String Primärschlüssel[])
        {
            String Befehl = "SELECT ";
            Befehl= Befehl+"Count(Distinct "+Primärschlüssel[0]+"."+Primärschlüssel[1]+") "+SQL;
            int zaehler = 0;
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(Befehl);
                        
                        while (rs.next())
                            {
                                zaehler = rs.getInt(1);
                
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
        return zaehler; 

            
        }
        public static String [] Schlusselnamen(String SQL,String Namen[],String Primärschlüssel[])
        {
            
           
            
            try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
					
			con.setReadOnly(true);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Select " +Primärschlüssel[0]+"."+Primärschlüssel[1]+" " +SQL+" Group by "+Primärschlüssel[0]+"."+Primärschlüssel[1]);
                        int zaehler=0;
                        
                        while (rs.next())
                            { 
                                Namen[zaehler] = rs.getString(1);
                                zaehler++;
                               
                            }
                            rs.close();
                            stat.close();
                            con.close();
                        
			
		}
		catch(Exception e){
			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
			System.out.println("***** FEHLERMELDUNG *****"+e);
			System.exit(0);
		}
            
        return Namen; 

            
        }
         public static void schreiben(String SQL,String Spaltennamen[][], int Spalten,int AnzahlZeilenGroup, String Pfad, String Schluessel[],String Primärschlüssel[]) throws IOException
         {
             String Befehl = "SELECT ";
             boolean check = true;
             int zaehler=0;
             int zaehler2=0;
             FileWriter fw = new FileWriter(Pfad);
             BufferedWriter bw = new BufferedWriter(fw);
             
             for(int k=0;k<Spaltennamen.length;k++)
             {
                 if(Spaltennamen[k][1]=="1")
                 {
                     if(check==true)
                     {
                         Befehl = Befehl+Spaltennamen[k][0]+"";
                         check=false;
                     }
                     else
                     {
                         Befehl = Befehl+", "+Spaltennamen[k][0];
                         
                     }
                     if(Spaltennamen[k][2]==null)
                     {
                         bw.write(Spaltennamen[k][0]+" |");
                     }
                     if(Spaltennamen[k][2]!=null)
                     {
                         bw.write(Spaltennamen[k][2]+" |");
                     }
                     zaehler++;
                     
                 }
             }
             for(int k=0;k<Spaltennamen.length;k++)
             {
                 if(Spaltennamen[k][1]=="2")
                 {
                     Befehl = Befehl+", "+Spaltennamen[k][0];
                     zaehler2++;
                 }
                 
             }
             for(int m=0;m<AnzahlZeilenGroup;m++)
             {
                for(int k=0;k<Spaltennamen.length;k++)
                {
                     if(Spaltennamen[k][1]=="2")
                     {
                         if(Spaltennamen[k][2]==null)
                         {
                             bw.write(Spaltennamen[k][0]+" |");
                         }
                         if(Spaltennamen[k][2]!=null)
                         {
                             bw.write(Spaltennamen[k][2]+" |");
                         }
                     }
                 
                 } 
             }
             bw.write("\n");
             
             Befehl=Befehl+" "+SQL+ " Where "+Primärschlüssel[0]+"."+Primärschlüssel[1]+" = ";
             
             
             
             for (int o=0;o<Schluessel.length;o++)
             {
                 String Befehl2= Befehl+Schluessel[o];
              
             
             try {
 			
 			Class.forName("com.mysql.jdbc.Driver").newInstance();
 			
 			Connection con = DriverManager.getConnection(
 					"jdbc:mysql://"+Variablen.VDaten[0]+":"+Variablen.VDaten[1]+"/"+Variablen.VDaten[2], Variablen.VDaten[3],Variablen.VDaten[4]);
 					
 			con.setReadOnly(true);
 			Statement stat = con.createStatement();
 			ResultSet rs = stat.executeQuery(Befehl2);
                         boolean check2 = true;
                         int zaehlerges=zaehler+zaehler2;
                         while (rs.next())
                             {
                                 if (check2==true)
                                 {
                                    for (int k=1; k<=zaehlerges; k++)
                                     {
                                         bw.write(rs.getString(k)+ " |");
                                     } 
                                    check2=false;
                                    
                                 }
                                 else
                                 {
                                     for (int k=1+zaehler; k<=zaehlerges; k++)
                                     {
                                         bw.write(rs.getString(k)+ " |");
                                     }
                                 }
                                 
                 
                             }
             
                             
                             rs.close();
                             stat.close();
                             con.close();
             
                         
 			
 		}
 		catch(Exception e){
 			UserInterface.Error.open("Fehler Datenbankverbindung \n", e);
 			//System.out.println("***** FEHLERMELDUNG *****"+e);
 			System.exit(0);
 		}
             bw.write("\n");
             }
             
             bw.close();

             
         }
}
