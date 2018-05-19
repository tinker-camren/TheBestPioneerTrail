/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tinkerc
 */
public class Answer implements Serializable {

    // Class instance variables
    private boolean answer;

    public Answer() {
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.answer ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Answer{" + "answer=" + answer + '}';
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
        final Answer other = (Answer) obj;
        if (this.answer != other.answer) {
            return false;
        }
        return true;
    }

}
