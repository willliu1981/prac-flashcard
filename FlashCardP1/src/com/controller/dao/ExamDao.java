package com.controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.controller.conn.Conn;
import com.model.main.Exam;

public class ExamDao extends Dao<Exam> {

	public ExamDao(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Exam t) throws ClassNotFoundException, SQLException {
		Connection conn = Conn.instance().getConn();

	}

	@Override
	public List<Exam> queryAll() throws ClassNotFoundException, SQLException {

		String sql = "select * from exam";
		List<Exam> list = new ArrayList<>();
		Exam m = null;
		try (Connection conn = Conn.instance().getConn();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				m = new Exam();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setExam_time(rs.getDate("exam_time"));
				m.setDescribe(rs.getString("describe"));
				m.setScore(rs.getInt("score"));
				m.setNum(rs.getInt("num"));
				m.setB_id(rs.getInt("b_id"));
				m.setOri_change(rs.getInt("ori_change"));
				m.setCreate_time(rs.getDate("create_time"));
				m.setUpdate_time(rs.getDate("update_time"));
				list.add(m);
			}
		}

		return list;
	}

	@Override
	public void update(Exam t, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Exam query(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}
