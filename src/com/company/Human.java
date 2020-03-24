package com.company;

/*Есть два рода людей: женщины и мужчины. Они обладают одинаковым набором свойств за небольшим исключением (у кого как) и методов.
        Пусть будет определен следующий набор свойств:
        - признак пола (boolean, true - мужчина, false - женщина)
        - имя (String)
        - фамилия (String)
        - рост (float)
        - вес (float)*/

//свойства
public abstract class Human {
    private boolean gender;
    private String name;
    private String surName;
    private float height;
    private float weight;

    //конструктор
    public Human(boolean gender, String name, String surName, float height, float weight) {
        this.gender = gender;
        this.name = name;
        this.surName = surName;
        this.height = height;
        this.weight = weight;
    }

    //переопределение метода
    @Override
    public String toString() {
        return "Human{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", growth=" + height +
                ", weight=" + weight +
                '}';
    }

    //геттер
    public boolean isGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

  /*  - "говорить" (возвращает boolean)
    Результат определяется по таблице , где первая колонка это пол собственного экземпляра, а вторая - пол аргумента:
    Ж            Ж            всегда true
    Ж            М            true
    М            Ж            true
    М            М            с вероятностью 0.5
*/

    boolean talk(Human human) {
        if (this.gender && human.isGender()) {
            return Utils.random(0.5f);
        } else {
            return true;
        }
    }

  /*  - "терпеть/выдерживать общество" (возвращает boolean)
    аналогично
    Ж            Ж            с вероятностью 0.05
    Ж            М            с вероятностью 0.7
    М            Ж            с вероятностью 0.7
    М            М            с вероятностью 0.056*/

    boolean tolerate(Human human) {
        if (!this.gender && !human.isGender()) {
            return Utils.random(0.05f);
        } else if (this.gender && human.isGender()) {
            return Utils.random(0.056f);
        } else {
            return Utils.random(0.7f);
        }
    }

   /* - проводить время вместе (возвращает boolean)
    если рост экземпляров отличается более чем на 10%, метод возвращает true с вероятностью 0.85
    если рост экземпляров отличается менее чем на 10%, метод возвращает true с вероятностью 0.95*/

    boolean spendTimeTogether(Human human) {
        float fHumanHeight = this.height;
        float sHumanGrowth = human.getHeight();
        float z = 0;
        if (fHumanHeight < sHumanGrowth) {
            z = sHumanGrowth / fHumanHeight;
        }
        else {
            z = fHumanHeight / sHumanGrowth;
        }
        if (z > 1.1) {
            return Utils.random(0.85f);
        } else {
            return Utils.random(0.95f);
        }
    }

/*
- иметь отношения (возвращает Человек)
    если “говорить” && “терпеть/выдерживать общество” && “проводить время вместе”
    равно true, то если свойство “пол” собственного экземпляра и пол аргумента одинаковые,
     то вернуть null, иначе создать экземпляр нового человека путем вызова метода “родить
      человека” у экземпляра с полом Ж.
*/


}
