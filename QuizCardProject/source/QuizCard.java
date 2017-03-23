public class QuizCard {
	QuizCard(String q, String a){
		question=q;
		answer=a;
	}

	private String question;
	private String answer;

	public String getQuestion(){return question;}
	public void setQuestion(String qString){question = qString;}
	public String getAnswer(){return answer;}
	public void setAnswer(String aString){answer = aString;}	
}
