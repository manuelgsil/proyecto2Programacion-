package proyectoModelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
	
	  protected List<Usuario> ciudades;

	    
	    public Filtro(List<Usuario> ciudades) {
	        this.ciudades = ciudades;
	    }

	    public List<Usuario> getCiudades() {
	        return ciudades;
	    }

	    public void setCiudades(List<Usuario> ciudades) {
	        this.ciudades = ciudades;
	    }

	    public static List<Usuario> filtrarPorCiudad( List<Usuario> ciudades,String ciudad) {
	        List<Usuario> filtradas = new ArrayList<>();
	        for (Usuario c : ciudades) {
	            if (c.getCiudad().equalsIgnoreCase(ciudad)) {
	                filtradas.add(c);
	            }
	        }
	        return filtradas;
	    }
	    public static List<Usuario> filtrarPorEdad(List<Usuario> listausuarios, int edadMinima, int edadMaxima) {
	        return listausuarios.stream()
	                .filter(ciudades -> ciudades.getEdad() >= edadMinima && ciudades.getEdad() <= edadMaxima)
	                .collect(Collectors.toList());
	    }


}
