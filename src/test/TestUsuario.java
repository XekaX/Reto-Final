package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Usuario;

class TestUsuario {

	Usuario usu;
	@BeforeEach
	void setUp() throws Exception {
	usu=new Usuario();
	usu.setIdentificacion("Jon Ander");
	usu.setContrasenia("jonander1");
	//aaa
	}

	@Test
	public void testGetIdentificacion() {
	assertEquals("Jon Ander", usu.getIdentificacion());
	}

	@Test
	public void testSetIdentificacion() {
	usu.setIdentificacion("Ekain");
	assertEquals("Ekain", usu.getIdentificacion());
	}

	@Test
	public void testGetContrasenia() {
	assertEquals("jonander1", usu.getContrasenia());
	}

	@Test
	public void testSetContrasenia() {
	usu.setContrasenia("ekain1");
	assertEquals("ekain1", usu.getContrasenia());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	

}
