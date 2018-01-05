package com.mm.question.operations;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import com.mm.question.view.QuestionView;

public class QuestionOperations {
private HashSet<Questions> quesSet=new HashSet<>();
private static QuestionOperations quesOpr;
private BufferedImage rimg;
private BufferedImage gimg;
private BufferedImage yimg;

private QuestionOperations() {
	
		try {
			rimg=ImageIO.read(QuestionView.class.getResource("red.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gimg=ImageIO.read(QuestionView.class.getResource("green.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			yimg=ImageIO.read(QuestionView.class.getResource("yellow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static QuestionOperations getInstance() {
	if(quesOpr==null) {
		quesOpr= new QuestionOperations();
	}
	return quesOpr;
}

//public boolean checkedAllQues() {
//		if(!(ques.get(0).isFlag()||ques.get(1).isFlag()||ques.get(2).isFlag())) {
//			System.out.println("true");
//						//if gets all false
//		return true;
//	}
//	return false;
//}
//Random random=new Random();
//public int getQuesIndex() {
//	if(!checkedAllQues()) {
//	int i=random.nextInt(3);
//	System.out.println("Random"+i);
//	Questions question=ques.get(i);
//	if(question.isFlag()) {
//		System.out.println(i);
//		return i;//ques to be displayed
//	}
//	System.out.println(-1);
//	return -1;}//this ques displayed
//	else
//		System.out.println(-2);
//		return -2;//All ques displayed
//}

public HashSet<Questions> getList() {
	return quesSet;
}

public void drawRed(Graphics g,int x,int y) {
	g.drawImage(rimg,x,y,null);
}

public void drawGreen(Graphics g,int x,int y) {
	g.drawImage(gimg,x,y,null);
}
public void drawYellow(Graphics g,int x,int y) {
	g.drawImage(yimg, x, y, null);
}
int currentIndex;
Questions ques;
public Questions getQuestion(int qcount) {
	currentIndex=-1;
Iterator<Questions> itr=quesSet.iterator();
ques=null;
while(itr.hasNext()) {
	currentIndex++;
	ques=itr.next();
	if(qcount==currentIndex) {
		return ques;
		}
}
return null;
}

}