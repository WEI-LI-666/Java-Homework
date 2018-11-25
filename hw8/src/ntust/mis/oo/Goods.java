/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.oo;

/**
 *
 * @author User
 */
public class Goods {
    private String name;
    private double weight;
    private Type type;

    public Goods(String name, double weight, Type type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    
    @Override
    public String toString(){
        return this.name + "-" + this.weight + "-" + this.type.toString();
    }
}
