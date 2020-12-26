package com.model.main;

import java.sql.Date;


public class Vocabulary extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8459553598843948942L;
	private String en_word;
	private String ct_word;
	private Integer exam_times;
	private Date exam_time;

	
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


	public String toString() {
		/*
		return String .format("ID=%d , en=%s , ct=%s , ex-time=%s , times=%d , create-time=%s , update-time=%s",
				this.id,this.en_word,this.ct_word,this.exam_time,this.exam_times,this.create_time,this.update_time);
		*///
		return super.toString();
	}
}
