package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Ingredient;

public class IngredientDAO implements DAO<Ingredient>{
	private final String QUERY_ALL = "SELECT * FROM ingredient";
	private final String QUERY_CREATE = "INSERT INTO ingredient (category, name, weight, cal, carb, prot, fat) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM ingredient WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE ingredient SET category=?, name=?, weight=?, cal=?, carb=?, prot=?, fat=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM ingredient WHERE id=?";
	
	public IngredientDAO() {
		
	}
	
	public List<Ingredient> getAll() {
		List<Ingredient> ingredientsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Ingredient ingredient;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String category = resultSet.getString("category");
				String name = resultSet.getString("name");
				float weight = resultSet.getFloat("weight");
				float cal = resultSet.getFloat("cal");
				float carb = resultSet.getFloat("carb");
				float prot = resultSet.getFloat("prot");
				float fat = resultSet.getFloat("fat");
				ingredient = new Ingredient(category, name, weight, cal, carb, prot, fat );
				ingredient.setId(id);
				ingredientsList.add(ingredient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredientsList;
	}
	
	public boolean insert(Ingredient ingredientToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, ingredientToInsert.getCategory());
			preparedStatement.setString(2, ingredientToInsert.getName());
			preparedStatement.setFloat(3, ingredientToInsert.getWeight());
			preparedStatement.setFloat(4, ingredientToInsert.getCal());
			preparedStatement.setFloat(5, ingredientToInsert.getCarb());
			preparedStatement.setFloat(6, ingredientToInsert.getProt());
			preparedStatement.setFloat(7, ingredientToInsert.getFat());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Ingredient read(int ingredientId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, ingredientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String category, name;
			float weight, cal, carb, prot, fat;

			category = resultSet.getString("category");
			name = resultSet.getString("name");
			weight = resultSet.getFloat("weight");
			cal = resultSet.getFloat("cal");
			carb = resultSet.getFloat("carb");
			prot = resultSet.getFloat("prot");
			fat = resultSet.getFloat("fat");
			Ingredient ingredient = new Ingredient(category, name, weight, cal, carb, prot, fat );
			ingredient.setId(resultSet.getInt("id"));

			return ingredient;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Ingredient ingredientToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (ingredientToUpdate.getId() == 0)
			return false;

		Ingredient ingredientRead = read(ingredientToUpdate.getId());
		if (!ingredientRead.equals(ingredientToUpdate)) {
			try {
				// Fill the ingredientToUpdate object
				if (ingredientToUpdate.getCategory() == null || ingredientToUpdate.getCategory().equals("")) {
					ingredientToUpdate.setCategory(ingredientRead.getCategory());
				}

				if (ingredientToUpdate.getName() == null || ingredientToUpdate.getName().equals("")) {
					ingredientToUpdate.setName(ingredientRead.getName());
				}

				// Update the ingredient
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, ingredientToUpdate.getCategory());
				preparedStatement.setString(2, ingredientToUpdate.getName());
				preparedStatement.setFloat(3, ingredientToUpdate.getWeight());
				preparedStatement.setFloat(4, ingredientToUpdate.getCal());
				preparedStatement.setFloat(5, ingredientToUpdate.getCarb());
				preparedStatement.setFloat(6, ingredientToUpdate.getProt());
				preparedStatement.setFloat(7, ingredientToUpdate.getFat());
				preparedStatement.setInt(8, ingredientToUpdate.getId());
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