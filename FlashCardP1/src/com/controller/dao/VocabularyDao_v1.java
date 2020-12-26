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
import com.model.main.Vocabulary;

public class VocabularyDao_v1 extends VocabularyDao {
	public VocabularyDao_v1(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		VocabularyDao_v1 dao = new VocabularyDao_v1("");
		/*
		 * try { List<Vocabulary> list = dao.queryall(); System.out.println(list); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 *///
		
		/*
		Vocabulary v = new Vocabulary();
		v.setEn_word("apple");
		v.setCt_word("蘋果");
		v.setCreate_time(new Date(new java.util.Date().getTime()));
		try {
			dao.add(v);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*///
	}

	@Override
	public Vocabulary query(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from vocabulary where id=?";
		Vocabulary m = null;
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				m = new Vocabulary();
				m.setId(rs.getInt("id"));
				m.setEn_word(rs.getString("en_word"));
				m.setCt_word(rs.getString("ct_word"));
				m.setExam_times(rs.getInt("exam_times"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setCreate_time(rs.getDate("create_time"));
				m.setUpdate_time(rs.getDate("update_time"));
				rs.close();
			}else {
				System.out.println("Query failed");
			}
		}
		return m;
	}

	@Override
	public void add(Vocabulary t) throws SQLException, ClassNotFoundException {
		String sql = "insert into vocabulary (en_word,ct_word,create_time)values(?,?,?)";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getEn_word());
			st.setString(2, t.getCt_word());
			st.setDate(3, t.getCreate_time());
			int count = st.executeUpdate();
			if (count == 0) {
				System.out.println("Add failed");
			} else {
				System.out.println("Add successfully");
			}
			
		}
	}

	@Override
	public List<Vocabulary> queryall() throws SQLException, ClassNotFoundException {
		String sql = "select * from vocabulary";
		Vocabulary m = null;
		List<Vocabulary> list = new ArrayList<>();
		try (Connection conn = Conn.instance().getConn();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				m = new Vocabulary();
				m.setId(rs.getInt("id"));
				m.setEn_word(rs.getString("en_word"));
				m.setCt_word(rs.getString("ct_word"));
				m.setExam_times(rs.getInt("exam_times"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setCreate_time(rs.getDate("create_time"));
				m.setUpdate_time(rs.getDate("update_time"));
				list.add(m);
			}
		}
		if(list.isEmpty()) {
			System.out.println("Query list is empty");
		}
		return list;
	}

	@Override
	public void update(Vocabulary t, int id) throws SQLException, ClassNotFoundException {
		String sql = "update vocabulary set en_word=?,ct_word=?,update_time=? where id=?";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, t.getEn_word());
			st.setString(2, t.getCt_word());
			st.setDate(3, t.getUpdate_time());
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
		String sql = "delete from vocabulary where id=?";
		try (Connection conn = Conn.instance().getConn(); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setInt(1, id);
			int count =st.executeUpdate();
			if (count == 0) {
				System.out.println("Not any data deleted");
			} else {
				System.out.println("Delete successfully");
			}
			
		}

	}

}
