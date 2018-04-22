package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {
	
	private static RequestDaoImpl instance;
	
	private RequestDaoImpl() {}
	
	public static RequestDaoImpl getInstance() {
		if (instance == null) {
			instance = new RequestDaoImpl();
		}
		return instance;
	}

	@Override
	public boolean submitRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Request viewRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(
						rs.getInt(1), // id
						rs.getDouble(2), // requestAmount
						rs.getInt(3), // requesterId
						rs.getInt(4), // reviewerId
						rs.getInt(5), // status int
						rs.getString(6), 
						rs.getTimestamp(7),
						rs.getTimestamp(8),
						rs.getString(9),
						rs.getBlob(10)
						));
			}
			return requests;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request getSingleRequestForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequestsForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllPendingRequestsForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequestsForEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
