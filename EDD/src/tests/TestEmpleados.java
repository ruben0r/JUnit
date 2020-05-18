package tests;


import static org.junit.Assert.*;

import org.junit.Test;
import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleados
{
	Exception expected;
	Empleado e = new Empleado();
	@Test 
	public void establecerNumeroDeEmpleadoCorrecto() 
	{
        try 
        {
            e.establecerNumeroEmpleado("4");
        }
        catch (NumeroEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals(4,e.getNumeroEmpleado());
	}
	@Test (expected=java.lang.AssertionError.class)//No se por qué pero si pones
	// NumeroEmpleadoException.class la excepción devuelve java.lang.AssertionError en vez de NumeroEmpleadoException
	//Por lo que he visto en los errores es  porque en una comprobación que hace creo que antes del catch,
	//Eclipse espera que sea null pero le devuelve excepciones.NumeroEmpleadoException y entonces es cuando transforma el error
	//a java.lang.AssertionError, lo que no consigo averiguar es cuando realiza dicha comprobación para así modificarla.
	public void establecerNumeroDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.establecerNumeroEmpleado("aaaa");
        } 
        catch (NumeroEmpleadoException ex) 
        {
        	assertEquals(expected,ex);
        }
	}
	@Test 
	public void establecerNombreDeEmpleadoCorrecto() 
	{
        try 
        {
            e.estableceNombreEmpleado("rubenrodriguez");
        } catch (NombreEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals("rubenrodriguez",e.getNombreEmpleado());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void establecerNombreDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.estableceNombreEmpleado("123456789");
        } catch (NombreEmpleadoException ex) 
        {
        	assertEquals(expected,ex);
        }
	}
	@Test (expected=java.lang.AssertionError.class)
	public void establecerMesesDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.estableceMesesTrabajo("example Incorrect");
        } catch (MesesTrabajoException ex) 
        {
        	assertEquals(expected,ex);
        }
	}
	@Test 
	public void establecerMesesDeEmpleadoCorrecto() 
	{
        try 
        {
            e.estableceMesesTrabajo("13");
        } catch (MesesTrabajoException ex) 
        {
        	fail();
        }
        	assertEquals(13,e.getMesesTrabajo());
	}
	@Test 
	public void establecerEsDirectivoCorrecto() 
	{
        try 
        {
            e.establecerSerDirectivo("+");
        } catch (CargoException ex) 
        {
        	fail();
        }
        	assertEquals(true,e.getDirectivo());
	}
	@Test 
	public void establecerNoEsDirectivoCorrecto() 
	{
        try 
        {
            e.establecerSerDirectivo("-");
        }
        catch (CargoException ex) 
        {
        	fail();
        }
        	assertEquals(false,e.getDirectivo());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void establecerDirectivoIncorrecto() 
	{
        try 
        {
            e.establecerSerDirectivo("asd");
        } catch (CargoException ex) 
        {
        	assertEquals(expected,ex);
        }
	}
	@Test 
	public void CalcularPrimas() 
	{
        try 
        {
            e.calcularPrima("4", "rubenrodriguez", "15", "+");
        } catch (CargoException ex)  {
        	ex.printStackTrace();
        } catch (NumeroEmpleadoException e) {
			e.printStackTrace();
		} catch (NombreEmpleadoException e) {
			e.printStackTrace();
		} catch (MesesTrabajoException e) {
			e.printStackTrace();
		}
        assertEquals(Prima.P1,e.getPrima());
	}
	@Test 
	public void CalcularPrimas2() 
	{
        try 
        {
            e.calcularPrima("4", "rubenrodriguez", "15", "-");
        } catch (CargoException ex)  {
        	ex.printStackTrace();
        } catch (NumeroEmpleadoException e) {
			e.printStackTrace();
		} catch (NombreEmpleadoException e) {
			e.printStackTrace();
		} catch (MesesTrabajoException e) {
			e.printStackTrace();
		}
        assertEquals(Prima.P2,e.getPrima());
	}
	@Test 
	public void CalcularPrimas3() 
	{
        try 
        {
            e.calcularPrima("4", "rubenrodriguez", "10", "+");
        } catch (CargoException ex)  {
        	ex.printStackTrace();
        } catch (NumeroEmpleadoException e) {
			e.printStackTrace();
		} catch (NombreEmpleadoException e) {
			e.printStackTrace();
		} catch (MesesTrabajoException e) {
			e.printStackTrace();
		}
        assertEquals(Prima.P3,e.getPrima());
	}
	@Test 
	public void CalcularPrimas4() 
	{
        try 
        {
            e.calcularPrima("4", "rubenrodriguez", "10", "-");
        } catch (CargoException ex)  {
        	ex.printStackTrace();
        } catch (NumeroEmpleadoException e) {
			e.printStackTrace();
		} catch (NombreEmpleadoException e) {
			e.printStackTrace();
		} catch (MesesTrabajoException e) {
			e.printStackTrace();
		}
        assertEquals(Prima.P4,e.getPrima());
	}
}