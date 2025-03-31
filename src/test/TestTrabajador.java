package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import modelo.Tipo;
import modelo.Trabajador;

class TestTrabajador {

	Trabajador trab;
	@BeforeEach
	void setUp() throws Exception {
		trab=new Trabajador();
		trab.setNombre("Jon Ander");
		trab.setSueldo((float) 2800.5);
		trab.setTipo(Tipo.ADMIN);
	}

	@Test
	public void testGetNombre() {
		assertEquals("Jon Ander", trab.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		trab.setNombre("Ekain");
		assertEquals("Ekain", trab.getNombre());
	}
	
	@Test
	public void testGetSueldo() {
		assertEquals(2800.5, trab.getSueldo());
	}
	
	@Test
	public void testSetSueldo() {
		trab.setSueldo((float) 2300);
		assertEquals(2300,trab.getSueldo());
	}
	@Test
	public void testGetTipo() {
		assertEquals(Tipo.ADMIN,trab.getTipo());
	}
	
	@Test
	public void testSetTipo() {
		trab.setTipo(Tipo.TRABAJADOR);
		assertEquals(Tipo.TRABAJADOR, trab.getTipo());
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
