package cl.acid.desafio.dto;

import java.io.Serializable;
/**
 * Clase que representa un objeto tipo Imagen el cual se utilizara para guardar y obtener imagenes.
 * @author Roberto Olavarria
 *
 */
public class ImagenDto implements Serializable {

	private int id;
	private String username;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImagenDto [id=" + id + ", usuario=" + username + ", image=" + image + "]";
	}

}
