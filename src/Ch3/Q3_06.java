package Ch3;
import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.LinkedListNode;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;

class Animal{
    String type;
    Date date;
    public Animal(String type){
        this.type=type;
    }

}
class AnimalShelter{
    LinkedList<Animal> dogs;
    LinkedList<Animal> cats;
    Animal oldest_dog;
    Animal oldest_cat;

    public AnimalShelter(){
        dogs=new LinkedList<>();
        cats=new LinkedList<>();
    }


    public void enqueue(Animal animal){
        Date date= new Date();
        animal.date=date;
        System.out.println("Adding animal type "+animal.type+" date "+ date);
        if (animal.type=="dog"){

            dogs.add(animal);
            if(oldest_dog==null){
                oldest_dog=animal;
            }
        }else {

            cats.add(animal);
            if(oldest_cat==null){
                oldest_cat=animal;
            }
        }
    }
    public Animal dequeueDog(){
        Animal adopted=dogs.removeLast();
        oldest_dog=dogs.getLast();
        return adopted;
    }
    public Animal dequeueCat(){
        Animal adopted=cats.removeLast();
        oldest_cat=cats.getLast();
        return adopted;

    }
    public Animal dequeueAny(){
        Animal adopted;
        if(oldest_dog.date.before(oldest_cat.date)){
            adopted=dogs.removeLast();
            oldest_dog=dogs.getLast();
        }else{
            adopted=cats.removeLast();
            oldest_cat=cats.getLast();
        }
        System.out.println("Removing any animal type "+adopted.type+" date "+ adopted.date);
        return adopted;
    }




}



public class Q3_06 {

    public static void main(String[] args) {
        Animal a1=new Animal("cat");
        Animal a2=new Animal("cat");
        Animal a3=new Animal("cat");
        Animal a4=new Animal("cat");
        Animal a5=new Animal("dog");
        Animal a6=new Animal("dog");
        Animal a7=new Animal("cat");
        AnimalShelter shelter=new AnimalShelter();

        shelter.enqueue(a1);
        shelter.enqueue(a2);
        shelter.enqueue(a3);
        shelter.enqueue(a4);
        shelter.enqueue(a5);
        shelter.enqueue(a6);
        shelter.enqueue(a7);





    }


}
