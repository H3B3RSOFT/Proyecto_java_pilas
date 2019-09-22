package ColaCircNum;

class Pila extends PilaCola
{
    int tope;
    Pila ()
    {
	tope = 0;
    }

    boolean esvacia ()
    {
	if (tope == 0)
	    return (true);
	return (false);
    }

    boolean esllena ()
    {
	if (tope == max)
	    return (true);
	return (false);
    }


    int nroelem ()
    {
	return (tope);
    }


    void adicionar (int elem)
    {
	if (!esllena ())
	{
	    tope++;
	    v [tope] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }


    int eliminar ()
    {
	int elem = 0;
	if (!esvacia ())
	{
	    elem = v [tope];
	    tope--;
	}
	else
	    System.out.println ("Pila vacia");
	return (elem);
    }


    void mostrar ()
    {
	int elem;
	if (esvacia ())
	    System.out.println ("Pila vacia");
	else
	{
	    System.out.println ("\n Datos de la Pila ");
	    Pila aux = new Pila ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		System.out.println (elem);
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
	Pila aux = new Pila ();
	if (esvacia ())
	    System.out.println ("\nPila vacia");
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
	Pila aux = new Pila ();
	if (esvacia ())
	    System.out.println ("\nPila vacia");
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
	Pila a = new Pila ();
	Pila b = new Pila ();
	int m, elem;
	while (!esvacia ())
	{
	    m = eliminar ();

	    while (!esvacia ())
	    {
		elem = eliminar ();
		if (m < elem)
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
	Pila a = new Pila ();
	Pila b = new Pila ();
	while (!esvacia ())
	    a.adicionar (eliminar ());
	while (!a.esvacia ())
	    b.adicionar (a.eliminar ());
	while (!b.esvacia ())
	    adicionar (b.eliminar ());
    }


    void vaciar (Pila a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar ());
	
    }
}
