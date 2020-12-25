/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsc;

/**
 *
 * @author Ahmed
 */
public class users {
    
    private String name;
    private String age;
    private String Addresse;

    public users(String name, String age, String Addresse) {
        this.name = name;
        this.age = age;
        this.Addresse = Addresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String Addresse) {
        this.Addresse = Addresse;
    }
    
    
   
}
