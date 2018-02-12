package src;

import cda.Question;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    q1 = new Question(maQuestion, true);
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
    
    String testQ1q = q1.getQuestion();
    assertEquals(maQuestion, testQ1q);
    
    q1.setQuestion("Avez-vous couru plus de 30 minutes aujourd'hui ?");
    assertFalse("Question fausse", testQ1q.equals(q1.getQuestion()) == true);
    
    boolean testQ1b = q1.getChoixDeflt();
    assertEquals(testQ1b, q1.getChoixDeflt());
    
    q1.setChoixDeflt(false);
    assertFalse("Choix incorrect", testQ1b == q1.getChoixDeflt());
  }

}
