package com.mm.question.operations;

public class Questions implements Status {
private String question;
private int status=UNREAD;
private boolean flag=true;
private int score;
private String answer[];
private String rans;
private String urans;
public int getScore() {
	return score;
}
public void setScore() {
	if(urans==null)
		this.score=0;
	else if(urans.equals(rans))
	this.score = 5;
	else
		this.score=0;
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}

public String[] getAnswer() {
	return answer;
}
public Questions(String ques,String answer[],String rans) {
	this.question=ques;
	this.answer=answer;
	this.rans=rans;
}
public void setAnswer(String[] answer) {
	this.answer = answer;
}

public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getRans() {
	return rans;
}
public void setRans(String rans) {
	this.rans = rans;
}
public String getUrans() {
	return urans;
}
public void setUrans(String urans) {
	this.urans = urans;
}
@Override
public boolean equals(Object obj) {
	if(obj instanceof Questions) {
		Questions q=(Questions)obj;
		if(this.getQuestion()==q.getQuestion())
			return true;
		
	}
	return false;
}
}
