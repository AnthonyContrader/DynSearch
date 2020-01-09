package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Cocktail;
import it.contrader.utils.ConnectionSingleton;

public class CocktailDAO implements DAO<Cocktail> {
	private final String QUERY_ALL ="SELECT * FROM cocktail";
	private final String QUERY_CREATE = "INSERT INTO cocktail (name, type, alcohol, avg) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM cocktail WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE cocktail SET name=?, type=?, alcohol=?, avg=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM cocktail WHERE id=?";
	
	public  CocktailDAO() {
		
	}
	
	public List<Cocktail> getAll(){
		List<Cocktail> cocktailList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				Cocktail cocktail;
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String type = resultSet.getString("type");
					byte alcohol = (byte) resultSet.getInt("alcohol");
					int avg = resultSet.getInt("avg");
					cocktail = new Cocktail(id, name, type, alcohol, avg);
					cocktailList.add(cocktail);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cocktailList;
	}
	public boolean insert(Cocktail cocktail) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1,cocktail.getName());
			preparedStatement.setString(2,cocktail.getType());
			preparedStatement.setInt(3, cocktail.getIsAlcohol()? 1 : 0);
			preparedStatement.setInt(4,cocktail.getAVG());
			preparedStatement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		return true;
	}
	public Cocktail read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int alcohol,avg;
			String name, type;
			name = resultSet.getString("name");
			type = resultSet.getString("type");
			alcohol = resultSet.getInt("alcohol");
			avg = resultSet.getInt("avg");
			Cocktail cocktail = new Cocktail (id, name, type, alcohol, avg);
			return cocktail;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean update (Cocktail cocktailToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (cocktailToUpdate.getId() == 0)
			return false;
		
		Cocktail cocktail = read(cocktailToUpdate.getId());
		if(!cocktail.equals(cocktailToUpdate)) {
			try {
				if (cocktailToUpdate.getName() == null || cocktailToUpdate.getName().equals("")) {
					cocktailToUpdate.setName(cocktail.getName());
				}
				if (cocktailToUpdate.getType() == null || cocktailToUpdate.getType().equals("")) {
					cocktailToUpdate.setType(cocktail.getType());
				}
				
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1,cocktailToUpdate.getName());
				preparedStatement.setString(2,cocktailToUpdate.getType());
				preparedStatement.setInt(3, cocktailToUpdate.getIsAlcohol()? 1 : 0);
				preparedStatement.setInt(4,cocktailToUpdate.getAVG());
				preparedStatement.setInt(5,cocktailToUpdate.getId());
				int r = preparedStatement.executeUpdate();
				if(r>0) {
					return true;
				}else {
					return false;
				}
			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	public boolean delete (int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int d = preparedStatement.executeUpdate();
			if(d>0) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
