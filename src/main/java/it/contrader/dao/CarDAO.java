package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Car;



/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CarDAO implements DAO<Car> {

	private final String QUERY_ALL = "SELECT * FROM car";
	private final String QUERY_CREATE = "INSERT INTO car (brand, model, doors, engineCapacity) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM car WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE car SET brand=?, model=?, doors=?, engineCapacity=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM car WHERE id=?";

	public CarDAO() {

	}

	public List<Car> getAll() {
		List<Car> carsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Car car;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String brand = resultSet.getString("brand");
				String model = resultSet.getString("model");
				int doors = resultSet.getInt("doors");
				float engineCapacity = resultSet.getFloat("engineCapacity");
			
				car = new Car(brand, model, doors, engineCapacity);
				car.setId(id);
				carsList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carsList;
	}
	

	public boolean insert(Car carToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, carToInsert.getBrand());
			preparedStatement.setString(2, carToInsert.getModel());
			preparedStatement.setInt(3, carToInsert.getDoors());
			preparedStatement.setFloat(4, carToInsert.getEngineCapacity());
						preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	//fino qui
	public Car read(int carId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String brand, model;
			int doors;
			float engineCapacity;

			brand = resultSet.getString("brand");
			model = resultSet.getString("model");
			doors = resultSet.getInt("doors");
			engineCapacity = resultSet.getFloat("enginecapacity");
			Car car = new Car(brand, model, doors, engineCapacity);
			
			car.setId(resultSet.getInt("id"));

			return car;
		} catch (SQLException e) {
			return null;
		}

	}

	//FINO QUI OK
	public boolean update(Car carToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (carToUpdate.getId() == 0)
			return false;

		Car carRead = read(carToUpdate.getId());
		if (!carRead.equals(carToUpdate)) {
			try {
				// Fill the carsToUpdate object
				if (carToUpdate.getBrand() == null || carToUpdate.getBrand().equals("")) {
					carToUpdate.setBrand(carRead.getBrand());
				}

				if (carToUpdate.getModel() == null || carToUpdate.getModel().equals("")) {
					carToUpdate.setModel(carRead.getModel());
				}

				
				if (carToUpdate.getDoors() == 0) {
					carToUpdate.setDoors(carRead.getDoors());
				}
				if (carToUpdate.getEngineCapacity() == 0) {
					carToUpdate.setEngineCapacity(carRead.getEngineCapacity());
				}
				
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, carToUpdate.getBrand());
				preparedStatement.setString(2, carToUpdate.getModel());
				preparedStatement.setInt(3, carToUpdate.getDoors());
				preparedStatement.setFloat(4, carToUpdate.getEngineCapacity());
				preparedStatement.setInt(5, carToUpdate.getId());
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