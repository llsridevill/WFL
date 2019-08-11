package com.example.demo.survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;





@SuppressWarnings("serial")
@Entity
public class UserResponseEntity  implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userResponseid;
	
	@ManyToMany(mappedBy="userResponsesSet")
	List<QuestionEntity> questionEntitySet=new ArrayList<QuestionEntity>();
	
	@ElementCollection
	@CollectionTable(name="QuestionEntity",joinColumns=@JoinColumn(name="userResponseid"))
	@MapKeyColumn(name="qid")
	@Column(name="values")
	Map<String,Integer> selectedOptions;
	
	@OneToOne(mappedBy ="ur")
	//@JoinColumn(name = "ue_id", referencedColumnName = "uid")
	UserEntity user;
	

	public Long getUserResponseid() {
		return userResponseid;
	}

	public void setUserResponseid(Long userResponseid) {
		this.userResponseid = userResponseid;
	}


	public List<QuestionEntity> getQuestionEntitySet() {
		return questionEntitySet;
	}

	public void setQuestionEntitySet(List<QuestionEntity> questionEntitySet) {
		this.questionEntitySet = questionEntitySet;
	}

	public Map<String, Integer> getSelectedOptions() {
		return selectedOptions;
	}

	public void setSelectedOptions(Map<String, Integer> selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "UserResponseEntity [userResponseid=" + userResponseid + ", questionEntitySet=" + questionEntitySet
				+ ", selectedOptions=" + selectedOptions + ", user=" + user + "]";
	}

	public void add(UserResponseEntity ure) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
