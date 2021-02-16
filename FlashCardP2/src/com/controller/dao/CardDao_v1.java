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
import com.controller.dao.deprecate.CardDao;
import com.model.main.Card;
import com.model.main.Vocabulary;

public class CardDao_v1 extends Dao<Card> {

	public CardDao_v1(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Card query(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from card where id=?";
		Card m = null;
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				m = new Card();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setV_id(rs.getInt("v_id"));
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
	public void add(Card t) throws SQLException, ClassNotFoundException {
		String sql = "insert into card (name,v_id,create_time)values(?,?,?)";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getName());
			st.setInt(2, t.getV_id());
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
	public List<Card> queryAll() throws SQLException, ClassNotFoundException {
		String sql = "select * from card";
		Card m = null;
		List<Card> list = new ArrayList<>();
		try (Connection conn = Conn.instance().getConn();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				m = new Card();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setV_id(rs.getInt("v_id"));
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
	public void update(Card t, int id) throws SQLException, ClassNotFoundException {
		String sql = "update card set name=?,v_id=?,update_time=? where id=?";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getName());
			st.setInt(2, t.getV_id());
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
		String sql = "delete from card where id=?";
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
