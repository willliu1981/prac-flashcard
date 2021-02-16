package com.controller.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.conn.Conn;
import com.model.main.Box;
import com.model.main.Vocabulary;

public class BoxDao extends Dao<Box> {

	public BoxDao(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Box> queryAll() throws SQLException, ClassNotFoundException {
		String sql = "select * from box";
		Box m = null;
		List<Box> list = new ArrayList<>();
		try (Connection conn = Conn.instance().getConn();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				m = new Box();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setDescribe(rs.getString("describe"));
				m.setExam_times(rs.getInt("exam_times"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setCreate_time(rs.getDate("create_time"));
				m.setUpdate_time(rs.getDate("update_time"));
				list.add(m);
			}
		}
		if (list.isEmpty()) {
			System.out.println("Query list is empty");
		}
		return list;
	}

	@Override
	public Box query(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from box where id=?";
		Box m = null;
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				m = new Box();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("Name"));
				m.setDescribe(rs.getString("describe"));
				m.setExam_times(rs.getInt("exam_times"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setCreate_time(rs.getDate("create_time"));
				m.setUpdate_time(rs.getDate("update_time"));
				rs.close();
			} else {
				System.out.println("Query failed");
			}
		}
		return m;
	}

	@Override
	public void add(Box t) throws SQLException, ClassNotFoundException {
		String sql = "insert into box (name,describe,create_time)values(?,?,?)";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getName());
			st.setString(2, t.getDescribe());
			st.setDate(3, new Date(new java.util.Date().getTime()));
			int count = st.executeUpdate();
			if (count == 0) {
				System.out.println("Add failed");
			} else {
				System.out.println("Add successfully");
			}

		}

	}

	@Override
	public void update(Box t, int id) throws SQLException, ClassNotFoundException {
		String sql = "update box set name=?,describe=?,update_time=? where id=?";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getName());
			st.setString(2, t.getDescribe());
			st.setDate(3, new Date(new java.util.Date().getTime()));
			st.setInt(4, id);
			int count = st.executeUpdate();
			if (count == 0) {
				System.out.println("Not any data Updated");
			} else {
				System.out.println("Update successfully");
			}
		}

	}

	@Override
	public void delete(int id) throws SQLException, ClassNotFoundException {
		String sql = "delete from box where id=?";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setInt(1, id);
			int count = st.executeUpdate();
			if (count == 0) {
				System.out.println("Not any data deleted");
			} else {
				System.out.println("Delete successfully");
			}

		}

	}

}
