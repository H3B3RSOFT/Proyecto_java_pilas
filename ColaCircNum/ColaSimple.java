package ColaCircNum;

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


    void adicionar (int elem)
    {
	if (!esllena ())
	{
	    fin++;
	    v [fin] = elem;
	}
	else
	    System.out.println ("Cola Simple llena");
    }


    int eliminar ()
    {
	int elem = 0;
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
	int elem;
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
	int i;
	for (i = 1 ; i <= n ; i++)
	    adicionar (Leer.datoInt ());
    }


    int maximo ()
    {
	int m = 0, elem;
	ColaSimple aux = new ColaSimple ();
	if (esvacia ())
	    System.out.println ("\nCola Simple vacia");
	else
	{
	    m = eliminar ();
	    aux.adicionar (m);
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		if (m < elem)
		    m = elem;

	    }
	    while (!aux.esvacia ())
		adicionar (aux.eliminar ());

	}
	return (m);
    }


    int minimo ()
    {
	int m = 0, elem;
	ColaSimple aux = new ColaSimple ();
	if (esvacia ())
	    System.out.println ("\nColaSimple vacia");
	else
	{
	    m = eliminar ();
	    aux.adicionar (m);
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		if (m > elem)
		    m = elem;

	    }
	    while (!aux.esvacia ())
		adicionar (aux.eliminar ());

	}
	return (m);
    }


    void ordenar ()
    {
	ColaSimple a = new ColaSimple ();
	ColaSimple b = new ColaSimple ();
	int m, elem;
	while (!esvacia ())
	{
	    m = eliminar ();

	    while (!esvacia ())
	    {
		elem = eliminar ();
		if (m > elem)
		{
		    a.adicionar (m);
		    m = elem;
		}
		else
		    a.adicionar (elem);
	    }
	    b.adicionar (m);
	    while (!a.esvacia ())
		adicionar (a.eliminar ());

	}
	while (!b.esvacia ())
	    adicionar (b.eliminar ());

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
