package cl.acid.desafio.dao;

import cl.acid.desafio.dto.ImagenDto;

/**
 * Interface que define los servicios para consultar o ingresar una imagen al sistema.
 * 
 * @author Roberto Olavarria
 * 
 */
public interface ImagenDao {
	/**
	 * Metodo que inserta un objeto tipo ImagenDto
	 * 
	 * @param imagen: Objeto con los datos de usuario e imagen a insertar
	 * @return 1: Si el archivo fue insertado
	 * 			0: Si hubieron problemas al insertar
	 */
	public int insertImagenDto(ImagenDto imagen);
	
	/**
	 * Metodo que a través de un id de imagen
	 * retorna un objeto de ImagenDto
	 * 
	 * @param id: identificador con el cual fue persistido el registro
	 * @return ImagenDto
	 * 			Retornara null en caso de que el archivo no exista.
	 * 
	 * 
	 */
	public ImagenDto findImagenDtoById(int id);
	

}
