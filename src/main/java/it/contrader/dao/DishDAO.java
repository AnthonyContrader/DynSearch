package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Dish;


public class DishDAO{
	private final String QUERY_ALL = "SELECT * FROM dish";
	private final String QUERY_CREATE = "INSERT INTO dish (nome, cal, carb, fat, prot, category, weight) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM dish WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE dish SET nome=?, cal=?, carb=?, fat=?, prot=?, category=?, weight=?,  WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM dish WHERE id=?";
	
	public DishDAO() {

	}
	
	public List<Dish> getAll() {
		List<Dish> dishesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Dish dish;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float cal = resultSet.getFloat("cal");
				float carb = resultSet.getFloat("carb");
				float fat = resultSet.getFloat("fat");
				float prot = resultSet.getFloat("prot");
				String category = resultSet.getString("category");
				float weight = resultSet.getFloat("weight");

		dish = new Dish(name, cal, carb, fat, prot, category,weight);
			dish.setId(id);
				dishesList.add(dish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dishesList;
	}
	
	public boolean insert(Dish userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, userToInsert.getName());
			preparedStatement.setFloat(2, userToInsert.getCal());
			preparedStatement.setFloat(3, userToInsert.getCarb());
			preparedStatement.setFloat(4, userToInsert.getFat());
			preparedStatement.setFloat(5, userToInsert.getProt());
			preparedStatement.setString(6, userToInsert.getCategory());
			preparedStatement.setFloat(7, userToInsert.getWeight());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	
	public Dish read(int DishId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, DishId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name,category;
			Float cal, carb, fat, prot, weight;

			name = resultSet.getString("name");
			cal = resultSet.getFloat("cal");
			carb = resultSet.getFloat("carb");
			fat = resultSet.getFloat("fat");
			prot = resultSet.getFloat("prot");
			category = resultSet.getString("category");
			weight = resultSet.getFloat("weight");
			Dish dish = new Dish(name, cal, carb, fat, prot, category, weight);
			dish.setId(resultSet.getInt("id"));

			return dish;
		} catch (SQLException e) {
			return null;
		}

	}
	
	
	
	
	public boolean update(Dish dishToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (dishToUpdate.getId() == 0)
			return false;

		Dish dishRead = read(dishToUpdate.getId());
		if (!dishRead.equals(dishToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (dishToUpdate.getName() == null || dishToUpdate.getName().equals("")) {
					dishToUpdate.setName(dishRead.getName());
				}

				if (dishToUpdate.getCal() == 0.0f ) {
					dishToUpdate.setCal(dishRead.getCal());
				}
				if (dishToUpdate.getCarb() == 0.0f ) {
					dishToUpdate.setCarb(dishRead.getCarb());
				}
				if (dishToUpdate.getFat() == 0.0f ) {
					dishToUpdate.setFat(dishRead.getFat());
				}
				if (dishToUpdate.getProt() == 0.0f ) {
					dishToUpdate.setProt(dishRead.getProt());
				}
				if (dishToUpdate.getCategory() == null || dishToUpdate.getCategory().equals("")) {
					dishToUpdate.setCategory(dishRead.getCategory());
				}
				if (dishToUpdate.getWeight() == 0.0f ) {
					dishToUpdate.setWeight(dishRead.getWeight());
				}


				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, dishToUpdate.getName());
				preparedStatement.setFloat(2, dishToUpdate.getCal());
				preparedStatement.setFloat(3, dishToUpdate.getCarb());
				preparedStatement.setFloat(4, dishToUpdate.getFat());
				preparedStatement.setFloat(5, dishToUpdate.getProt());
				preparedStatement.setString(6, dishToUpdate.getCategory());
				preparedStatement.setFloat(7, dishToUpdate.getWeight());
				preparedStatement.setInt(8, dishToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
}