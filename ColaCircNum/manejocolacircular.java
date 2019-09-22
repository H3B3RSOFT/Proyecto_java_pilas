package ColaCircNum;

class manejocolacircular
{
    public static void intercalar (ColaCircular a, ColaCircular b)
    {
		ColaCircular c = new ColaCircular ();
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
		ColaCircular A = new ColaCircular ();
		ColaCircular B = new ColaCircular ();
		A.llenar (5);
		A.mostrar ();
		A.ordenar();
		A.mostrar();
	
	
	
    }
}
