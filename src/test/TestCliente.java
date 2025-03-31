package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Cliente;

class TestCliente {

	Cliente cli;
	@BeforeEach
	void setUp() throws Exception {
		cli=new Cliente();
		cli.setNombre("Mikel");
		
		///ppppp
	}
	@Test
	public void testGetNombre() {
		assertEquals("Mikel", cli.getNombre());
	}
	
	@Test
	public void testSetNombre () {
		cli.setNombre("Jon Ander");
		assertEquals("Jon Ander", cli.getNombre());
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	

}