package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Pelicula;

class TestPelicula {

	Pelicula peli;
	@BeforeEach
	void setUp() throws Exception {
		peli=new Pelicula();
		peli.setIdP("P001");
		peli.setNombre("Fust and Furious");
		peli.setPrecio((float) 8.5);
		peli.setDuracion(120);
		peli.setCalificacion((float) 4.5);
		peli.setIdG("G001");
	}

	@Test
	public void testGetIdP() {
		assertEquals("P001", peli.getIdP());
	}
	
	@Test
	public void testSeIdP () {
		peli.setIdP ("P002");
		assertEquals("P002", peli.getIdP ());
	} 
	
	@Test
	public void testGetNombre() {
		assertEquals("Fust and Furious", peli.getNombre());
	}
	
	@Test
	public void testSetNombre () {
		peli.setNombre("Mi Villano Favorito");
		assertEquals("Mi Villano Favorito", peli.getNombre());
	} 
	
	@Test
	public void testGetPrecio() {
		assertEquals(8.5, peli.getPrecio());
	}
	
	@Test
	public void testSetPrecio () {
		peli.setPrecio((float) 9.100000381469727);
		assertEquals(9.100000381469727, peli.getPrecio());
	} 
	
	@Test
	public void testGetDuracion() {
		assertEquals(120, peli.getDuracion());
	}
	
	@Test
	public void testSetDuracion () {
		peli.setDuracion(130);
		assertEquals(130, peli.getDuracion());
	} 
	@Test
	public void testGetCalificacion() {
		assertEquals(4.5, peli.getCalificacion());
	}
	
	@Test
	public void testSetCalificacion () {
		peli.setCalificacion((float) 4.699999809265137);
		assertEquals(4.699999809265137, peli.getCalificacion());
	} 
	
	@Test
	public void testGetIdG() {
		assertEquals("G001", peli.getIdG());
	}
	
	@Test
	public void testSetIdG () {
		peli.setIdG("G002");
		assertEquals("G002", peli.getIdG());
	} 
	
	@Test
	public void testToString () {
		String pelic;
		pelic=peli.toString();
		assertEquals("Pelicula [idP=P001, nombre=Fust and Furious, precio=8.5, duracion=120, calificacion=4.5, idG=G001, genero=]", peli.toString());
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
