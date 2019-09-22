package ColaCircNum;

class manejocolasimple
{
    public static void intercalar (ColaSimple a, ColaSimple b)
    {
	ColaSimple c = new ColaSimple ();
	while (!a.esvacia () && !b.esvacia ())
	{
	    c.adicionar (a.eliminar ());
	    c.adicionar (b.eliminar ());
	}
	if (!a.esvacia ())
	    while (!a.esvacia ())
		c.adicionar (a.eliminar ());
	else
	    while (!b.esvacia ())
		c.adicionar (b.eliminar ());
	c.mostrar ();
    }


    public static void main (String args [])
    {
	ColaSimple A = new ColaSimple ();
	ColaSimple B = new ColaSimple ();
	A.llenar (4);
	A.mostrar ();
	
	
    }
}
