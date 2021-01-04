package com.model.main;

import java.sql.Date;

public class Exam extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 246473502594718243L;

	private Integer id;
	private String name;
	private Date exam_time;
	private String describe;
	private Integer score;
	private Integer num;
	private Integer b_id;
	private int ori_change;
	private Date create_time;
	private Date update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOri_change() {
		return ori_change;
	}

	public void setOri_change(int ori_change) {
		this.ori_change = ori_change;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExam_time() {
		return exam_time;
	}

	public void setExam_time(Date exam_time) {
		this.exam_time = exam_time;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

}
