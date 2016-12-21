package cl.acid.desafio.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cl.acid.desafio.dao.ImagenDao;
import cl.acid.desafio.dto.ImagenDto;

/**
 * 
 * Implementación de interface ImagenDao Esta clase se tendra interacción con la
 * base de datos
 * 
 * @author Roberto Olavarria
 *
 */
public class ImagenDaoImpl implements ImagenDao
{

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Metodo que inserta un objeto imagen a la base de datos
	 */
	public int insertImagenDto(final ImagenDto imagen)
	{
		try{
				
			final String sql = "INSERT INTO imagen(image, username) VALUES(?,?)";
			
			PreparedStatementCreator ps = new PreparedStatementCreator()
			{

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException
				{
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, imagen.getImage());
					ps.setString(2, imagen.getUsername());
					
					return ps;
				}
			};
			
			KeyHolder keyHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(ps,keyHolder);
			
			
			Number id = keyHolder.getKey();
			
		
	         
			return Integer.parseInt(id.toString());
		}catch(Exception ex)
		{
			return -1;
		}
		
	}

	/**
	 * Metodo para obtener una imagen desde la base de datos a través de su id
	 */
	public ImagenDto findImagenDtoById(final int id)
	{

		final String sql = "SELECT id, image, username FROM imagen WHERE id = ?";

		PreparedStatementCreator ps = new PreparedStatementCreator()
		{

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				return ps;
			}
		};

		List<ImagenDto> lista = new ArrayList<ImagenDto>();
		lista = jdbcTemplate.query(ps, new RowMapper<ImagenDto>()
		{

			@Override
			public ImagenDto mapRow(ResultSet rs, int idx) throws SQLException
			{

				ImagenDto img = new ImagenDto();
				img.setId(rs.getInt("id"));
				img.setImage(rs.getString("image"));
				img.setUsername(rs.getString("username"));
				return img;
			};
		});
		
		return lista.isEmpty() ?  null : lista.get(0);
	}

}
