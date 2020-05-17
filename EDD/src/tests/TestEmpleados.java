package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import syspagos.Empleado;
import syspagos.Prima;
import excepciones.*;

public class TestEmpleados
{
	Empleado e = new Empleado();
	@Test 
	public void establecerNumeroDeEmpleadoCorrecto() 
	{
        try 
        {
            e.establecerNumeroEmpleado("4");
        } catch (NumeroEmpleadoException ex) 
        {
        	fail();
        }
        assertEquals(4,e.getNumeroEmpleado());
	}
	@Test 
	public void establecerNumeroDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.establecerNumeroEmpleado("aaaa");
        } catch (NumeroEmpleadoException ex) 
        {
        	System.out.println("Introducción incorrecta, salta la excepción buena comprobación.");
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
	@Test 
	public void establecerNombreDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.estableceNombreEmpleado("123456789");
        } catch (NombreEmpleadoException ex) 
        {
        	System.out.println("Introducción incorrecta, salta la excepción, buena comprobación.");
        }
	}
	@Test 
	public void establecerMesesDeEmpleadoIncorrecto() 
	{
        try 
        {
            e.estableceMesesTrabajo("example Incorrect");
        } catch (MesesTrabajoException ex) 
        {
        	System.out.println("Introducción incorrecta, salta la excepción, buena comprobación.");
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
	@Test 
	public void establecerDirectivoIncorrecto() 
	{
        try 
        {
            e.establecerSerDirectivo("asd");
        } catch (CargoException ex) 
        {
        	System.out.println("Introducción incorrecta, salta la excepción, buena comprobación.");
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