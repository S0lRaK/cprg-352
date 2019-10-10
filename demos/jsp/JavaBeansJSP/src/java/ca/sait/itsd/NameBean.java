/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class NameBean implements Serializable {
    String name;
    String nameOld;
    
public NameBean () {}

    public NameBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameOld() {
        return nameOld;
    }

    public void setName(String name) {
        setNameOld(this.name);
        this.name = name;
    }
    
    public void setNameOld(String name) {
        this.nameOld = name;
    }
}
