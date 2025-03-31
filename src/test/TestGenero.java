package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Genero;

class TestGenero {
	
	Genero gen;
	@BeforeEach
	void setUp() throws Exception {
		gen=new Genero();
		gen.setIdG("G001");
		gen.setCategoria("Accion");
	}

	@Test
	public void testGetIdG() {
		assertEquals("G001", gen.getIdG());
	}
	
	@Test
	public void testSetIdG () {
		gen.setIdG("G002");
		assertEquals("G002", gen.getIdG());
	} 
	
	@Test
	public void testGetCategoria() {
		assertEquals("Accion", gen.getCategoria());
	}
	
	@Test
	public void testSetCtegoria () {
		gen.setCategoria("Drama");
		assertEquals("Drama", gen.getCategoria());
	} 
	
	@Test
	public void testToString () {
		String gene;
		gene=gen.toString();
		assertEquals("Genero [idG=G001, categoria=Accion]", gen.toString());
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	

}