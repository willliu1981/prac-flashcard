package com.model.main;

import java.sql.Date;


public class Vocabulary extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8459553598843948942L;
	private Integer id;
	private String en_word;
	private String ct_word;
	private String describe;
	private Integer exam_times;
	private Date exam_time;
	private Date create_time;
	private Date update_time;

	
	public void setValues(String en,String ct) {
		this.en_word=en;
		this.ct_word=ct;
	}
	

	public String getEn_word() {
		return en_word;
	}
	public void setEn_word(String en_word) {
		this.en_word = en_word;
	}
	public String getCt_word() {
		return ct_word;
	}
	public void setCt_word(String ct_word) {
		this.ct_word = ct_word;
	}
	public Integer getExam_times() {
		return exam_times;
	}
	public void setExam_times(Integer exam_times) {
		this.exam_times = exam_times;
	}
	public Date getExam_time() {
		return exam_time;
	}
	public void setExam_time(Date exam_time) {
		this.exam_time = exam_time;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescribe() {
		return describe;
	}


	public void setDescribe(String describe) {
		this.describe = describe;
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
