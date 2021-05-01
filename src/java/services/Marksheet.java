/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author shelc
 */
public class Marksheet {

    int slno;
    String subcode;
    String subject;
    String tutor;
    int total;
    int scored;
    String result;
    int gpa;

    public Marksheet() {
    }

    public Marksheet(int slno, String subcode, String subject, String tutor, int total, int scored, String result, int gpa) {
        super();
        this.slno = slno;
        this.subcode = subcode;
        this.subject = subject;
        this.tutor = tutor;
        this.total = total;
        this.scored = scored;
        this.result = result;
        this.gpa = gpa;
    }

    public Marksheet(String subcode, String subject, String tutor, int total, int scored, String result, int gpa) {

        super();
        this.subcode = subcode;
        this.subject = subject;
        this.tutor = tutor;
        this.total = total;
        this.scored = scored;
        this.result = result;
        this.gpa = gpa;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

}
