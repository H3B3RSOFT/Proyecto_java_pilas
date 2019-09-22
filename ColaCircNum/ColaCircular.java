package ColaCircNum;

class ColaCircular extends Cola
{

    ColaCircular ()
    {
	super ();
    }


    int nroelem ()
    {
	return ((max + fin - ini) % max);
    }


    boolean esvacia ()
    {
	if (nroelem () == 0)
	    return (true);
	return (false);
    }


    boolean esllena ()
    {
	if (nroelem () == max - 1)
	    return (true);
	return (false);
    }


    void adicionar (int elem)
    {
	if (!esllena ())
	{

	    fin = (fin + 1) % max;
	    v [fin] = elem;
	}
	else
	    System.out.println ("Cola circular llena");
    }


    int eliminar ()
    {
	int elem = 0;
	if (!esvacia ())
	{
	    ini = (ini + 1) % max;
	    elem = v [ini];
	    if (nroelem () == 0)
		ini = fin = 0;
	}
	else
	    System.out.println ("Cola circular vacia");
	return (elem);
    }


    void mostrar ()
    {
	int elem;
	if (esvacia ())
	    System.out.println ("Cola vacia xxx");
	else
	{
	    System.out.println ("\n Datos de la Cola ");
	    ColaCircular aux = new ColaCircular ();
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
	ColaCircular aux = new ColaCircular ();
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
	ColaCircular aux = new ColaCircular ();
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
	ColaCircular a = new ColaCircular ();
	ColaCircular b = new ColaCircular ();
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
	ColaCircular a = new ColaCircular ();
	ColaCircular b = new ColaCircular ();
	while (!esvacia ())
	{
	    while (nroelem () != 1)
		a.adicionar (eliminar ());
	    b.adicionar (eliminar ());
	    while (!a.esvacia ())
		adicionar (a.eliminar ());
	}
	while (!b.esvacia ())
	    adicionar (b.eliminar ());

    }


    void vaciar (ColaCircular a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar ());

    }
}
