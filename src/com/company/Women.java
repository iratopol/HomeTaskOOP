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

    protected Human toGiveBirth(Human human) {
        String babyName;
        Scanner babySc = new Scanner(System.in);
        babyName = babySc.next();
        String babySurname=human.getSurName();
        float babyHeight;
        if (this.isGender()){
            babyHeight = (float) (this.getHeight() + 0.1 * (human.getHeight() - this.getHeight()));
        }else {
            babyHeight = (float) (human.getHeight() + 0.1 * (this.getHeight() - human.getHeight()));
        }
        float babyWeight;
        if (this.isGender()){
            babyWeight = (float) (this.getWeight() + 0.1 * (human.getWeight() - this.getWeight()));
        }else {
            babyWeight = (float) (human.getWeight() + 0.1 * (this.getWeight() - human.getWeight()));
        }
        if (Utils.random(0.5f)) {
            return new Women(babyName, babySurname, babyHeight, babyWeight);
        } else {
            return new Men(babyName, babySurname, babyHeight, babyWeight);
        }

    }

}
