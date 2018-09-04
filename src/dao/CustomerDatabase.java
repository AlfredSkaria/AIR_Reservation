package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Registration;

public class CustomerDatabase {
	
	public boolean insertOperation(Registration r1, DBConnectionManager db)
	{
		String sql = "insert into customer values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, r1.getName());
			preparedStatement.setString(2, r1.getMobile());
			preparedStatement.setString(3, r1.getEmail());
			preparedStatement.setString(4, r1.getUsername());
			preparedStatement.setString(5, r1.getPassword());
			preparedStatement.setString(6, r1.getGender());
			preparedStatement.setString(7, r1.getCity());
			
			preparedStatement.execute();
			System.out.println("values inserted into db");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("problem while inserting");
			return false;
		}
		return true;
		
	}

}
