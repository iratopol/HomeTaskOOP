package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter human`s gender, name, surname, growth, weight: ");
        Scanner humanSc = new Scanner(System.in);
        boolean fHumanGender = humanSc.nextBoolean();
        String fHumanName = humanSc.next();
        String ffHumanSurname = humanSc.next();
        float fHumanHeight = humanSc.nextFloat();
        float fHumanWeight = humanSc.nextFloat();
        Human firstHuman = create(fHumanGender, fHumanName, ffHumanSurname, fHumanHeight, fHumanWeight);
        System.out.println(firstHuman);

        System.out.println("Enter human`s gender, name, surname, growth, weight: ");
        boolean sHumanGender = humanSc.nextBoolean();
        String sHumanName = humanSc.next();
        String sHumanSurname = humanSc.next();
        float sHumanHeight = humanSc.nextFloat();
        float sHumanWeight = humanSc.nextFloat();
        Human secondHuman = create(sHumanGender, sHumanName, sHumanSurname, sHumanHeight, sHumanWeight);
        System.out.println(secondHuman);

    }

    public static Human create(boolean gender, String name, String surname, float height, float weight) {
        if (gender) {
            return new Men(name, surname, height, weight);
        } else {
            return new Women(name, surname, height, weight);
        }
    }

  /*  Затем программа должна провести тест на совместимость и дать прогноз на результат отношений двух данных экземпляров. Алгоритм следующий:
            1. Метод “тест на совместимость” принимает два экземпляра людей и должен возвратить экземпляр человека или null.
            2. Вызвать метод “иметь отношения” первого экземпляра человека с аргументом - второй экземпляр.
            3. Полученный результат вернуть как результат работы метода “тест на совместимость”.*/

    public static Human compatibilityTest(Human firstHuman, Human secondHuman) {
        return firstHuman.haveRelationship(secondHuman);
    }

}

