package ColaCadena;

class ColaSimple extends Cola
{
    ColaSimple ()
    {
		super ();
	}
	
	boolean esvacia ()
	{
		if (ini == 0 && fin == 0)
			return (true);
		return (false);
    }

    boolean esllena ()
    {
		if (fin == max)
		    return (true);
		return (false);
	}
	
	int nroelem ()
	{
		return (fin - ini);
	}
	
	void adicionar (String elem)
	{
		if (!esllena ())
		{
		    fin++;
		    v [fin] = elem;
		}
		else
		    System.out.println ("Cola Simple llena");
    }

	String eliminar ()
    {
    	String elem = "";
		if (!esvacia ())
		{
		    ini++;
		    elem = v [ini];
		    if (ini == fin)
			ini = fin = 0;
		}
		else
		    System.out.println ("Cola Simple vacia");
		return (elem);
    }

    void mostrar ()
    {
    	String elem;
		if (esvacia ())
		    System.out.println ("Cola vacia");
		else
		{
		    System.out.println ("\n Datos de la Cola ");
		    ColaSimple aux = new ColaSimple ();
		    while (!esvacia ())
		    {
				elem = eliminar ();
				aux.adicionar (elem);
				System.out.print (" " + elem);
		    }
		    while (!aux.esvacia ())
		    {
				elem = aux.eliminar ();
				adicionar (elem);
		    }
		}
    }

    void llenar (int n)
    {
		for (int i = 1 ; i <= n ; i++)
		    adicionar (Leer.dato());
	}

    void invertir ()
    {
		ColaSimple a = new ColaSimple ();
		ColaSimple b = new ColaSimple ();
		while (!esvacia ())
		{
		    while (nroelem () != 1)
			a.adicionar (eliminar ());
		    b.adicionar (eliminar());
		    while (!a.esvacia ())
			adicionar (a.eliminar ());
		}
		while (!b.esvacia ())
		    adicionar (b.eliminar ());
	
	    }
	
	    void vaciar (ColaSimple a)
	    {
		while (!a.esvacia ())
		    adicionar (a.eliminar ());
    }
}
