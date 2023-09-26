package com.fssa.inifiniti.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fssa.inifiniti.util.PasswordUtil;
import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;

public class UserDAO {

	private static final String SQLINSERTQUERY = "SELECT * FROM user WHERE email=?";

	/**
	 * Inserts a new user into the database.
	 *
	 * @param user The User object containing user details to be inserted.
	 * @return True if the user insertion is successful, false otherwise.
	 * @throws DaoException If an error occurs during the insertion process or if
	 *                      the user details are invalid.
	 */

	public boolean insertUser(User user) throws DaoException {
		String insertQuery = "INSERT INTO user (username , email , password, salt) VALUES (?,?,?,?)";
		try (Connection connection = App.getConnection();
		         PreparedStatement pst = connection.prepareStatement(insertQuery);) {

		        pst.setString(1, user.getUserName());
		        pst.setString(2, user.getEmail());
		        pst.setString(3, user.getPassword());
		        pst.setString(4, user.getSalt());

		        int rows = pst.executeUpdate();
		        if (rows == 1) {
		            return true;
		        } else {
		            throw new DaoException("Invalid details for registration");
		        }
		    } catch (SQLException  e) {
		        throw new DaoException(e);
		    }
	}

	/**
	 * Retrieves user information by email.
	 *
	 * @param email The email address of the user to retrieve.
	 * @return A User object containing user details if the email is registered;
	 *         otherwise, an exception is thrown.
	 * @throws DaoException If an error occurs during the retrieval process or if
	 *                      the email is not registered.
	 */

	public User findUserByEmail(String email) throws DaoException {
		User user = new User();
		String insertQuery = SQLINSERTQUERY;
		try (

				Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setLoggedIn(rs.getBoolean("logged_in"));
				user.setSalt(rs.getString("salt"));
			} else {
				throw new DaoException("Email is not registered");
			}
			return user;
		} catch (SQLException e) {
			throw new DaoException(e);

		}
	}

	/**
	 * Retrieves the username associated with the provided email.
	 *
	 * @param email The email address for which to retrieve the associated username.
	 * @return A User object containing the username if the email is registered;
	 *         otherwise, an exception is thrown.
	 * @throws DaoException If an error occurs during the retrieval process or if
	 *                      the email is not registered.
	 */

	public User findUserNameByEmail(String email) throws DaoException {
		User user = new User();
		String insertQuery = SQLINSERTQUERY;
		try (

				Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user.setUserName(rs.getString("username"));
			}
			return user;
		} catch (SQLException e) {
			throw new DaoException("Username Doesn't Exists");

		}
	}

	/**
	 * Checks if an email address already exists in the database.
	 *
	 * @param email The email address to check for existence.
	 * @return True if the email address does not exist in the database; otherwise,
	 *         an exception is thrown.
	 * @throws DaoException If an error occurs during the existence check process or
	 *                      if the email already exists.
	 */

	public boolean emailAlreadyExists(String email) throws DaoException {
		String insertQuery = SQLINSERTQUERY;
		try (Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				throw new DaoException("Email Already Exists");
			} else {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);

		}
	}

	/**
	 * Retrieves a list of all users in the database.
	 *
	 * @return A list of User objects containing information about all registered
	 *         users.
	 * @throws DaoException If an error occurs during the retrieval process.
	 */

	public List<User> viewAllUser() throws DaoException {
		String insertQuery = "SELECT * FROM  user";
		List<User> users = new ArrayList<>();
		try (Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException("Unable to View the user");
		}
		return users;
	}

	/**
	 * Sets the "logged_in" status for a user in the database.
	 *
	 * @param email The email address of the user to update the "logged_in" status.
	 * @return True if the status update is successful; otherwise, an exception is thrown.
	 * @throws DaoException If an error occurs during the status update process or if the email is not found.
	 */
	
public  boolean setLoggedIn(String email) throws DaoException {
		
		String insertQuery = "UPDATE user SET logged_in ='1' WHERE email=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		int count  = pst.executeUpdate();
		 if (count==1) {
			 return true;
		 } else {
			 throw new DaoException("Invalid in logging In");
		 }
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}

	public boolean editUser(User user) throws DaoException{
		String insertQuery = "UPDATE user SET firstname=?, lastname=?, phonenumber=?, location=? WHERE email=?";

		try (
				Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
				pst.setString(1, user.getFirstName());
				pst.setString(2, user.getLastName());
				pst.setString(3, user.getPhoneNumber());
				pst.setString(4, user.getLocation());
				pst.setString(5, user.getEmail());
				int count  = pst.executeUpdate();
				 if (count==1) {
					 return true;
				 } else {
					 throw new DaoException("Invalid in edit profile");
				 }
				} catch (SQLException e) {
					throw new DaoException(e);
				}
}
	
	
	public User getUserByEmail(String email) throws DaoException {
		User user = new User();
		String insertQuery = SQLINSERTQUERY;
		try (

				Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setLocation(rs.getString("location"));
				user.setPhoneNumber(rs.getString("phonenumber"));
			}
			return user;
		} catch (SQLException e) {
			throw new DaoException("User Doesn't Exists");

		}
	}
	
	
	
	public boolean checkColumnHasNullValues(String email) throws DaoException {
        String query = "SELECT firstname , lastname , location , phonenumber FROM user  WHERE email = ?";
        try (Connection connection = App.getConnection();
        		PreparedStatement pst = connection.prepareStatement(query)) {
        	
            pst.setString(1, email);
            try (ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    boolean hasNullValue = false;

                    for (int i = 1; i <= columnCount; i++) {
                        Object columnValue = resultSet.getObject(i);

                        if (columnValue == null) {
                            hasNullValue = true;
                            break; 
                        }
                    }

                    return !hasNullValue; // Return true if there are no null values
                } else {
                    return false; // Email not found in the table
                }
            }
        } catch (SQLException e) {
        	throw new DaoException("Email Doesn't Exists");
        }
    }
	
	
	public User readUserIdByEmail(String email) throws DaoException {
		String insertQuery = "SELECT id FROM  user where  email = ?";
		User user = new User();
		try (Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			throw new DaoException("Unable to View the user");
		}
		return user;
	}

}
