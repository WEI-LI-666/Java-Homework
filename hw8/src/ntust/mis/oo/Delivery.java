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
public class Delivery {

    private Person sender;
    private Person receiver;
    private Goods goods;
    public static final double MAX_WEIGHT = 100.0;
    public static double currentWeight = 0.0;

    public Delivery(Person sender, Person receiver, Goods goods) {
        this.sender = sender;
        this.receiver = receiver;
        this.goods = goods;
    }
    
    public double getAvaliableWeight(){
        return MAX_WEIGHT - currentWeight;
    }
    
    public void send(){
        if(goods.getWeight() + currentWeight > MAX_WEIGHT){
            System.out.println("Goods too heavy, will not add product");
            System.out.printf("Previous remaining weight = %.1f\n", this.getAvaliableWeight());
            System.out.printf("Remain weight left = %.1f\n", this.getAvaliableWeight());
            goods.setWeight(0.0);
            System.out.printf("\n%s\n", this.toString());
        } else if (goods.getWeight() + currentWeight == MAX_WEIGHT){
            System.out.printf("Previous remaining weight = %.1f\n", this.getAvaliableWeight());
            currentWeight += goods.getWeight();
            System.out.printf("Remain weight left = %.1f\n", this.getAvaliableWeight());
            System.out.printf("\n%s\n", this.toString());
            System.out.println("\nOut of available weight, thanks for your using\n");
        } else {
            System.out.println("Enter valid number");
            System.out.printf("Previous remaining weight = %.1f\n", this.getAvaliableWeight());
            currentWeight += goods.getWeight();
            System.out.printf("Remain weight left = %.1f\n", this.getAvaliableWeight());
            System.out.printf("\n%s\n", this.toString());
        }
    }
    
    
    @Override
    public String toString(){
        return "Sender:" + sender.toString() + '\n'
                + "Receiver:" + receiver.toString() + '\n'
                + "Goods:" + goods.toString();
    }
}
