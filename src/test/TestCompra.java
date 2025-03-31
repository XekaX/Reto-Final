package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Cliente;
import modelo.Compra;

class TestCompra {
	Compra com;
	@BeforeEach
	void setUp() throws Exception {
		com=new Compra();	
		com.setDni("22762260B");
		com.setNombre("Ekain");
		com.setContrasenia("ekain1");
		}

	@Test
	public void testGetDni() {
		assertEquals("22762260B", com.getDni());
	}
	
	@Test
	public void testSetDni () {
		com.setDni("22762261N");
		assertEquals("22762261N", com.getDni());
	} 
	
	@Test
	public void testGetNombre() {
		assertEquals("Ekain", com.getNombre());
	}
	
	@Test
	public void testSetNombre () {
		com.setNombre("Jon Ander");
		assertEquals("Jon Ander", com.getNombre());
	} 
	
	@Test
	public void testGetContrasenia() {
		assertEquals("ekain1", com.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia () {
		com.setContrasenia("JonAnder1");
		assertEquals("JonAnder1", com.getContrasenia());
	} 
	@AfterEach
	void tearDown() throws Exception {
	}

	

}