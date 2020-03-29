package com.company;

import java.util.Scanner;

public class Women extends Human {
    public Women(String name, String surName, float height, float weight) {
        super(false, name, surName, height, weight);
    }

    @Override
    public String toString() {
        return "Women " + super.toString();
    }


   /* У женщин есть дополнительный метод - "родить человека" (возвращает экземпляр человека)
    Он имеет следующую реализацию:
    Создать новый экземпляр женщины или мужчины с вероятностью 0.5 со следующими свойствами:
- имя (String) - ввести с консоли
- фамилия (String) - берется у экземпляра с мужским полом
- рост (float) - копируется у соответствующего экземпляра с таким же полом + 0.1*(рост экземпляра противоположного
рода минус рост однородного экземпляра)
            - вес (float) - аналогично росту*/

    /*В результате работы программы надо выдать на экран все свойства нового экземпляра человека или написать “ничего не вышло... разбежались”.
    Желательно вызовы методов экземпляров классов женщин и мужчин сопровождать выводом на экран комментариев к процессу.*/

    public Human toGiveBirth(Men man) {
        String babyName;
        System.out.println("Enter baby name: ");
        Scanner babySc = new Scanner(System.in);
        babyName = babySc.next();
        String babySurname = man.getSurName();
        float babyHeightBoy = (float) (man.getHeight() + 0.1 * (this.getHeight() - man.getHeight()));
        float babyHeightGirl = (float) (this.getHeight() + 0.1 * (man.getHeight() - this.getHeight()));
        float babyWeightBoy = (float) (man.getWeight() + 0.1 * (this.getWeight() - man.getWeight()));
        float babyWeightGirl = (float) (this.getWeight() + 0.1 * (man.getWeight() - this.getWeight()));
        if (Utils.random(0.5f)) {
            return new Women(babyName, babySurname, babyHeightGirl, babyWeightGirl);
        } else {
            return new Men(babyName, babySurname, babyHeightBoy, babyWeightBoy);
        }

    }
}
