package clasesbasicas;

import excepciones.PasswordException;


/*
    Clase Usuario

    Propiedades Básicas:

        - nick --> String, Consultable
        - password --> String, Consultable y Modificable

    Propiedades Compartidas: No hay

    Propiedades Derivadas: No hay

    Getters y/o Setters

        public String getNick();

        public String getPassword();
        public void setPassword(String password);

    Métodos añadidos: No hay

    Restricciones:
    	- El nick debe ser una cadena con longitud mínima de 3
        - La contraseña debe ser de 7 dígitos o más y contener al menos un número
 */

public class Usuario implements Cloneable, Comparable<Usuario> {

    //Declaración de las propiedades de la clase
    private String nick;
    private String password;

    //Constructores

    //Constructor sin parámetros
    public Usuario() 
    {
        this.nick = "usuario";
        this.password = "qwerty7";
    }

    //Constructor con parámetros
    public Usuario(String nick, String password)
    {
    	if(nick.length() >= 3)
    	{
    		this.nick = nick;
    	}
    	else
    	{
    		this.nick = "usuario";
    	}
       
		if(password.length() >= 7 && (password.matches(".*[0-9].*") && (password.matches(".*[a-z].*") || password.matches(".*[A-Z].*"))))
		{
			this.password = password;	
		
        }
        else 
        {
            this.password = "qwerty7";
        }
    }

    //Constructor de copia
    public Usuario(Usuario usuario) 
    {
        this.nick = usuario.nick;
        this.password = usuario.password;
    }

    //Getters y/o Setters
    
    public String getNick()
    {
        return this.nick;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password) throws PasswordException
    {
		if(password.length() >= 7 && (password.matches(".*[0-9].*") && (password.matches(".*[a-z].*") || password.matches(".*[A-Z].*"))))
		{
			this.password = password;	
		
        }
        else
        {
            throw new PasswordException("Password no valida");
        }
    }

    //Métodos sobreescritos y compare to
    @Override
    public int hashCode() 
    {
        return this.nick.hashCode();
    }

    //compareTo
    /*
     * Criterio de igualdad: nick
     * Devolverá un valor entero:
     * Negativo --> Si el Usuario que recibe la llamada es menor al pasado por parámetros
     * 0 --> Si ambos son iguales
     * Positivo --> Si el Usuario que recibe la llamada es mayor al pasado por parámetros
     */
    public int compareTo(Usuario usuario) 
    {

        int ret;

        ret = this.nick.compareTo(usuario.nick);

        return ret;
    }

    //equals
    @Override
    public boolean equals(Object obj)
    {
        boolean ret = false;

        if(this == obj)
        {
            ret = true;
        }
        else if(obj != null && obj instanceof Usuario)
        {
            Usuario usuario = (Usuario) obj;

            if (this.nick == usuario.nick && this.password == usuario.password)
            {
                ret = true;
            }
        }

        return ret;
    }

    //clone
    @Override
    public Usuario clone()
    {
        Usuario usuario = null;

        try
        {
            usuario = (Usuario) super.clone();
        }
        catch(CloneNotSupportedException error)
        {
            error.printStackTrace();
        }

        return usuario;
    }

    //toString
    @Override
    public String toString()
    {
        return this.nick+","+this.password;
    }

}
