package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.CookingMetod;

public class CookingMetodDAO{
	//Classe per ottenere informazioni dalla tabella cookingmetod
	
	private final String QUERY_ALL = "SELECT * FROM cookingmetod";
	private final String QUERY_CREATE = "INSERT INTO cookingmetod (cookingtime,name,desc) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM cookingmetod WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE cookingmetod SET cookingtime=?, name=?, desc=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM cookingmetod WHERE id=?";
	//Query per da eseguire nel database
	public CookingMetodDAO() {	
	}
	
	public List<CookingMetod> getAll(){
		List<CookingMetod> cookingMetodsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			CookingMetod cookingMetod;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int cookingTime = resultSet.getInt("cookingtime");
				String name = resultSet.getString("name");
				String desc = resultSet.getString("desc");
				cookingMetod = new CookingMetod(id, cookingTime, name, desc);
				cookingMetodsList.add(cookingMetod);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cookingMetodsList;
	}
	public boolean insert(CookingMetod cookingMetod) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
				preparedStatement.setInt(1, cookingMetod.getCookingTime());
				preparedStatement.setString(2, cookingMetod.getName());
				preparedStatement.setString(3, cookingMetod.getDesc());
				return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}