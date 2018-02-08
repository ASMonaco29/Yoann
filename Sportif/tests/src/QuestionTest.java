package src;

import cda.Question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
  
  Question q1;
  String maQuestion;
  
  /**
   * Fonction qui s'execute avant le test.
   * 
   * @throws Exception exception lancée
   */
  @Before
  public void avant() throws Exception {
  
    maQuestion = "Comment vous sentez-vous aujourd'hui ?";
    q1 = new Question(maQuestion);
  }

  
  /**
   * Fonction qui s'execute après le test.
   * 
   * @throws Exception exception lancée
   */
  @After
  public void apres() throws Exception {
  }

  
  @Test
  public void getQuestionTest() {
    
    String testQ1 = q1.getQuestion();
    assertEquals(maQuestion, testQ1);
  }

}
