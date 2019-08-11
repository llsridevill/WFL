package com.example.demo.survey;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

@Entity
public class QuestionEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  qid;
	String question;
	String category;
	
	List<String> options;
	
	@ManyToMany(cascade =CascadeType.ALL)
	List<UserResponseEntity> userResponsesSet=new ArrayList<UserResponseEntity>();
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionEntity [qid=" + qid + ", question=" + question + ", category=" + category + ", options="
				+ options + ", userRsponsesSet=" + userResponsesSet + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<UserResponseEntity> getUserResponsesSet() {
		return userResponsesSet;
	}

	public void setUserResponsesSet(List<UserResponseEntity> userResponsesSet) {
		this.userResponsesSet = userResponsesSet;
	}

	

	
	
	
}