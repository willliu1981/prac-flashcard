package com.model.main;

import java.sql.Date;

public class Box extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8919870511407372383L;
	private Integer id;
	private String name;
	private String describe;
	private Integer exam_times;
	private Date exam_time;
	private Date create_time;
	private Date update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
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
