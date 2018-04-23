package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.RequestDoesNotExistException;
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
	public boolean submitRequest(Request request) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO request VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setDouble(1, request.getRequestAmount());
			stmt.setInt(2, request.getRequesterId());
			stmt.setInt(3, request.getReviewerId());
			stmt.setInt(4, 0);
			stmt.setString(5, request.getPurpose());
			stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			stmt.setTimestamp(7, null);
			stmt.setString(8, request.getImageUrl());
			stmt.setBlob(9, request.getImage());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return false;
	}

	@Override
	public Request viewRequest(int id) throws RequestDoesNotExistException {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE request_id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Request request = new Request(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getTimestamp(7),
						rs.getTimestamp(8),
						rs.getString(9),
						rs.getBlob(10)
						);
				return request;
			} else {
				throw new RequestDoesNotExistException();
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
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
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = 0");
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
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = 1");
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
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public Request getSingleRequestForEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequestsForEmployee(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester_id=?");
			stmt.setInt(1, id);
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
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> getAllPendingRequestsForEmployee(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester_id=? AND status=?");
			stmt.setInt(1, id);
			stmt.setInt(2, 0);
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
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;	
	}

	@Override
	public List<Request> getAllResolvedRequestsForEmployee(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester_id=? AND status=?");
			stmt.setInt(1, id);
			stmt.setInt(2, 1);
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
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return null;	
	}

	@Override
	public String getRequestImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveRequest(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE request SET status=1 WHERE request_id=?");
			stmt.setInt(1, id);
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean denyRequest(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE request SET status=2 WHERE request_id=?");
			stmt.setInt(1, id);
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
		}
		return false;
	}

}
