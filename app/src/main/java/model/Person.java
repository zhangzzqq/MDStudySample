package model;

/**
 * Created by steven on 2017/11/4 0004.
 */

public class Person {

    private String personName;
    private String personAddress;
    private String eat;

    public String getEat() {
        eat=null;
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public Person(String personName, String personAddress) {
        this.personName = personName;
        this.personAddress = personAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
