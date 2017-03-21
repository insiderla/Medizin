package medizin;

public class Befehl {
	public static String SQL_hinten(String Primärschlüssel[],String Verkn[][])
    {
        String SQL="FROM "+ Primärschlüssel[0];
        String SQL_hinten ="";
        for (int k=0;k<100;k++)
        {
        	 medizin.Variablen.Vergleichdaten[k]=null;
        }
        
        medizin.Variablen.Vergleichdaten[0] = Primärschlüssel[0];
        boolean check=true;
        boolean check2=false;
        boolean check3=false;
        int i = 0;
        int Zaehler = 1; 
        while(check)
        {
            if(Verkn[i][0] != null)
            {
                if(i==0)
                {
                  SQL_hinten = " ON " + Verkn[i][0] + "." + Verkn[i][1]+" = " + Verkn[i][3]+"." + Verkn[i][4] ;
                }
                if(i!=0)
                {
                  SQL_hinten = SQL_hinten + " AND " + Verkn[i][0] + "." + Verkn[i][1]+" = " + Verkn[i][3]+"." + Verkn[i][4] ;
                }
                
                for(int t=0;t<medizin.Variablen.Vergleichdaten.length && medizin.Variablen.Vergleichdaten[t] != null;t++)
                {
                    if(medizin.Variablen.Vergleichdaten[t].equals(Verkn[i][0]))
                    {
                        check2 = true;
                    }
                    if(medizin.Variablen.Vergleichdaten[t].equals(Verkn[i][3]))
                    {
                        check3 = true;
                    }
                    
                }
                if(check2 == false)
                {   
                    SQL = SQL + " JOIN " + Verkn[i][0];
                    medizin.Variablen.Vergleichdaten[Zaehler]=Verkn[i][0];
                    Zaehler++;
                    
                }
                
                if(check3 == false)
                {
                    SQL = SQL + " JOIN " + Verkn[i][3];
                    medizin.Variablen.Vergleichdaten[Zaehler] = Verkn[i][3];
                    Zaehler++;
                }
                check2 = false;
                check3 = false;
            }
            else 
            {
                check = false;
            }
            i++;
        }
        SQL = SQL + SQL_hinten;
        return SQL;
    }
}


