package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;
    private List<Integer> l;

    @Before
    public void setUp() throws Exception {
        //given: une instance de question à choix multiple
        this.l=new ArrayList<>();
        l.add(1);
        l.add(2);
        this.question=new QuestionAChoixMultiple("un énoncé",l,3);
    }

    @Test
    public void testGetEnonce() {
        //when: on demande son enoncé à la question
        String resEnonce = question.getEnonce();
        //then: l'énoncé retourné est l'énnoncé fourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        //when : quand l'étudiant fournit l'indice de la bonne réponse
        ArrayList<Integer> le=new ArrayList();
        le.add(1);
        le.add(2);
        //and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(le.get(0));
        resScore+=question.getScoreForIndice(le.get(1));
        //then : le score obtenu est 100
        assertEquals(100f, resScore,0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : un étudiant fourni l'indice correspondant à la mauvaise réponse
        int indiceEtudiant = 3;
        // and : on calcul le score
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // then : le score obtenu est 0
        assertEquals(-100f, resScore,0.01f);
    }
}