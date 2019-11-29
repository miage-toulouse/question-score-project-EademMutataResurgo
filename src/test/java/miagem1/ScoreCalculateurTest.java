package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple question;
    private ScoreCalculateur score;

    @Before
    public void setUp() throws Exception {
        this.question = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        this.score = new ScoreCalculateur();
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        //when : quand l'étudiant fournit l'indice de la mauvaise réponse
        ArrayList<Integer> liste=new ArrayList<>();
        liste.add(1);
        liste.add(4);
        //and : on demande le score de l'indice à la question
        float resScore=this.score.calculeScore(liste,this.question);
        //then : le score obtenu est 0
        assertEquals(0f, resScore,0.01f);
    }

    @Test
    public void testGetScoreForIndiceBonneReponsePartielle() {
        //when : quand l'étudiant fournit l'indice partiel de la bonne réponse
        ArrayList<Integer> liste=new ArrayList<>();
        liste.add(2);
        liste.add(3);
        //and : on demande le score de l'indice à la question
        float resScore=this.score.calculeScore(liste,this.question);
        //then : le score obtenu est 66,66
        assertEquals(2*100/3f, resScore,0.01f);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        //when : quand l'étudiant fournit l'indice de la bonne réponse
        ArrayList<Integer> liste=new ArrayList<>();
        liste.add(2);
        liste.add(3);
        liste.add(5);
        //and : on demande le score de l'indice à la question
        float resScore=this.score.calculeScore(liste,this.question);
        //then : le score obtenu est 100
        assertEquals(100, resScore,0.01f);
    }
}