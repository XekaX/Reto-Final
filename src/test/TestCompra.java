package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Compra;

class TestCompra {
	Compra com;

	@BeforeEach
	void setUp() throws Exception {
		com = new Compra();	
		com.setDni("22762260B");
		com.setIdP("P001");
		com.setFechaCompra(LocalDate.parse("2025-04-09"));
	}

	@Test
	public void testGetDni() {
		assertEquals("22762260B", com.getDni());
	}
	
	@Test
	public void testSetDni() {
		com.setDni("22762261N");
		assertEquals("22762261N", com.getDni());
	} 
	
	@Test
	public void testGetIdP() {
		assertEquals("P001", com.getIdP());
	}
	
	@Test
	public void testSetIdP() {
		com.setIdP("P002");
		assertEquals("P002", com.getIdP());
	} 
	
	@Test
	public void testGetFechaCompra() {
		assertEquals(LocalDate.parse("2025-04-09"), com.getFechaCompra());
	}
	
	@Test
	public void testSetFechaCompra() {
		com.setFechaCompra(LocalDate.parse("2024-04-10"));
		assertEquals(LocalDate.parse("2024-04-10"), com.getFechaCompra());
	} 
	
	@Test
	public void testToString() {
		String esperado = "Compra [dni=22762260B, nombre=P001, fechaCompra=2025-04-09]";
		assertEquals(esperado, com.toString());
	}


	@AfterEach
	void tearDown() throws Exception {
	}

	

}