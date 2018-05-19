/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tinkerc
 */
public class QuestionScene implements Serializable {

    //Class instance variables
    private boolean correctAnswer;
    private String effect;
    private Question question;

    public QuestionScene() {
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.correctAnswer);
        hash = 73 * hash + Objects.hashCode(this.effect);
        hash = 73 * hash + Objects.hashCode(this.question);
        return hash;
    }

    @Override
    public String toString() {
        return "QuestionScene{" + "correctAnswer=" + correctAnswer + ", effect=" + effect + ", question=" + question + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionScene other = (QuestionScene) obj;
        if (!Objects.equals(this.correctAnswer, other.correctAnswer)) {
            return false;
        }
        if (!Objects.equals(this.effect, other.effect)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

}
