package clasesbasicas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import excepciones.EndingDateException;

/*
    Clase UsuarioApostador --> Clase hija de Usuario

    Propiedades Básicas:

        - balance --> double, Consultable y Modificable
        - startingDate --> GregorianCalendar, Consultable
        - endingDate --> GregorianCalendar, Consultable y Modificable

    Propiedades Compartidas: No hay

    Propiedades Derivadas: No hay

    Getters y/o Setters

        public double getBalance();

 		public GregorianCalendar getStartingDate();
 		public int getStartingDateDay();
 		public int getStaringDateMonth();
 		public int getStartingDateYear();
 		public String getStartingDateString();

  		public GregorianCalendar getEndingDate();
  		public void setEndingDate(GregorianCalendar endingDate);
 		public int getEndingDateDay();
 		public int getEndingDateMonth();
 		public int getEndingDateYear();
 		public String getEndingDateString();

    Métodos añadidos:

        public changeBalance(double amount);

    Restricciones:
        - Al crear un usuario nuevo el saldo se inicializa a 0 y el saldo debe ser un número mayor que 0.
        - La fecha de baja debe ser mayor a la de alta.
 */

public class UsuarioApostador extends Usuario implements Cloneable {

    //Declaracion de las propiedades de la clase
    private double balance;
    private GregorianCalendar startingDate;
    private GregorianCalendar endingDate;

    //Constructores

    //Constructor por defecto
    public UsuarioApostador() 
    {
        super();
        this.balance = 0;
        this.startingDate = new GregorianCalendar();
        this.endingDate = null;
    }

    //Constructor con parámetros
    public UsuarioApostador(String nick, String password) 
    {
        super(nick, password);
        this.balance = 0;
        this.startingDate = new GregorianCalendar();
        this.endingDate = null;
    }
    
    //ConstructorSQL
    public UsuarioApostador(String nick, String password, double balance, GregorianCalendar startingDate, GregorianCalendar endingDate) 
    {
        super(nick, password);
        this.balance = balance;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    //Constructor de copia
    public UsuarioApostador(UsuarioApostador usuarioApostador) 
    {
        super(usuarioApostador.getNick(), usuarioApostador.getPassword());
        this.balance = usuarioApostador.balance;
        this.startingDate = usuarioApostador.startingDate;
        this.endingDate = usuarioApostador.endingDate;
    }

    //Getters y/o Setters
    public double getBalance()
    {
        return this.balance;
    }

    public GregorianCalendar getStartingDate()
    {
        return this.startingDate;
    }

    public int getStartingDateDay()
    {
        return this.startingDate.get(Calendar.DATE);
    }

    public int getStartingDateMonth()
    {
        return this.startingDate.get(Calendar.MONTH) + 1;
    }

    public int getStartingDateYear()
    {
        return this.startingDate.get(Calendar.YEAR);
    }

    public String getStartingDateString()
    {
        return this.getStartingDateDay()+"/"+this.getStartingDateMonth()+"/"+this.getStartingDateYear();
    }

    public GregorianCalendar getEndingDate()
    {
        return this.endingDate;
    }

    public void setEndingDate(GregorianCalendar endingDate) throws EndingDateException
    {
        if(this.startingDate.compareTo(endingDate) < 0)
        {
            this.endingDate = endingDate;
        }
        else
        {
            throw new EndingDateException("Fecha de baja incorrecta");
        }

    }

    public int getEndingDateDay()
    {
        return this.endingDate.get(Calendar.DATE);
    }

    public int getEndingDateMonth()
    {
        return this.endingDate.get(Calendar.MONTH) + 1;
    }

    public int getEndingDateYear()
    {
        return this.endingDate.get(Calendar.YEAR);
    }

    public String getEndingDateString()
    {
    	String endingDate = "NULL";
    	
    	if(this.endingDate != null)
    	{
    		endingDate = this.getEndingDateDay()+"/"+this.getEndingDateMonth()+"/"+this.getEndingDateYear();;
    	}
    	
        return endingDate;
    }

    //Métodos añadidos

    /*
     * Método que modifica una cantidad fija en el saldo actual
     * Signatura: public void changeBalance(double amount)
     * Entradas:
     * 		- double amount
     * Precondiciones: No hay
     * Salidas: No hay
     * Postcondiciones: En caso de valor positivo en la cantidad se
     * 					incrementará el saldo y en caso negativo
     *					decrementará.
     */
    public void changeBalance(double amount)
    {
        this.balance += amount;
    }

    //Métodos Sobreescritos y compareTo

    //hashCode
    @Override
    public int hashCode()
    {
    	int  hashEndingDate = 0;
    	
    	if(this.endingDate != null)
    	{
    		hashEndingDate = this.endingDate.hashCode();
    	}
    	
        return this.startingDate.hashCode() + Double.hashCode(this.balance) + hashEndingDate + super.hashCode();
    }

    //compareTo
    /*
     * Criterio de igualdad: startingDate, balance y endingDate y criterio del padre
     * Devolverá un valor entero:
     * Negativo --> Si el Usuario que recibe la llamada es menor al pasado por parámetros
     * 0 --> Si ambos son iguales
     * Positivo --> Si el Usuario que recibe la llamada es mayor al pasado por parámetros
     */
    @Override
    public int compareTo(Usuario usuario)
    {
        int ret;
        
        UsuarioApostador usuarioApostador = (UsuarioApostador) usuario;
        
        ret = this.getStartingDateString().compareTo(usuarioApostador.getStartingDateString());
        
        if(ret == 0)
        {
        	ret = Double.compare(this.balance, usuarioApostador.balance);

            if(ret == 0)
            {
                if(this.endingDate != null)
                {
                	ret = this.endingDate.compareTo(usuarioApostador.endingDate);
                }

                if(ret == 0)
                {
                	ret = super.compareTo(usuario);
                }
            }

        }
        
        return ret;
    }

    //clone
    @Override
    public UsuarioApostador clone()
    {
        UsuarioApostador usuarioApostador = null;
        
        usuarioApostador = (UsuarioApostador) super.clone();
		usuarioApostador.startingDate = (GregorianCalendar) this.startingDate.clone();
		
		if(this.endingDate != null)
		{
			usuarioApostador.endingDate = (GregorianCalendar) this.endingDate.clone();
		}

        return usuarioApostador;
    }

    //toString
    @Override
    public String toString()
    {
        return super.toString()+","+this.balance+","+this.getStartingDateString()+","+this.getEndingDateString();
    }


}
