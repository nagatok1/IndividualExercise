package com.bae.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainerid;
	
	private String trainer;
	
	private Long classroomid;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "classroomid")
	private List<Trainee> classroom = new ArrayList<>();

	public Trainer(Long classroomid, String trainer) {
		this.classroomid = classroomid;
		this.trainer = trainer;
	}

	public Trainer() {

	}

	public Long getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(Long trainerid) {
		this.trainerid = trainerid;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
}