package model;

import java.sql.Date;

import com.google.gson.Gson;

public class Card extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187836156065508923L;
	private String name;
	private Integer v_id;
	private Integer exam_times;
	private Date exam_time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getV_id() {
		return v_id;
	}
	public void setV_id(Integer v_id) {
		this.v_id = v_id;
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
	
	public String toString() {
		return super.toString();
	}
	
	
}
