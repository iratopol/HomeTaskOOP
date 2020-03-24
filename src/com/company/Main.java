package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* Men men = new Men(false,"Ihor","Topol", 1.80f,80.0f);
        System.out.println(men.toString());
        System.out.println(men.getName());
        System.out.println(men.isGender());

        Women women = new Women(false, "Ira", "Topol", 1.63f, 52.0f);
        System.out.println(women.toString());
        System.out.println(women.getName());*/

        System.out.println("Enter human`s growth, weight, gender, name, surname: ");
        Scanner humanSc = new Scanner(System.in);
        float fHumanHeight = humanSc.nextFloat();
        float fHumanWeight = humanSc.nextFloat();
        boolean fHumanGender = humanSc.nextBoolean();
        String fHumanName = humanSc.next();
        String ffHumanSurname = humanSc.next();
        Human human1=create(fHumanGender,)


        System.out.println("Enter human`s growth, weight, gender, name, surname: ");
        float sHumanHeight = humanSc.nextFloat();
        float sHumanWeight = humanSc.nextFloat();
        boolean sHumanGender = humanSc.nextBoolean();
        String sHumanName = humanSc.nextLine();
        String sHumanSurname = humanSc.nextLine();



    }

    public  static Human create (boolean gender, String name, String surname, float height, float weight) {
        if (gender){
            return new Men();
        }else {
            return new Women();
        }
    }
}
