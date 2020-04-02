package com.company;

/*Есть два рода людей: женщины и мужчины. Они обладают одинаковым набором свойств за небольшим исключением (у кого как) и методов.
        Пусть будет определен следующий набор свойств:
        - признак пола (boolean, true - мужчина, false - женщина)
        - имя (String)
        - фамилия (String)
        - рост (float)
        - вес (float)*/

public abstract class Human {
    private boolean gender;
    private String name;
    private String surName;
    private float height;
    private float weight;

    public Human(boolean gender, String name, String surName, float height, float weight) {
        this.gender = gender;
        this.name = name;
        this.surName = surName;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public boolean getGender() {
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

    public boolean isMan() {
        return this.gender;
    }

    public boolean isWoman() {
        return !this.gender;
    }

      /*  - "говорить" (возвращает boolean)
    Результат определяется по таблице , где первая колонка это пол собственного экземпляра, а вторая - пол аргумента:
    Ж            Ж            всегда true
    Ж            М            true
    М            Ж            true
    М            М            с вероятностью 0.5
*/

    protected boolean talk(Human human) {
        if (this.isMan() && human.isMan()) {
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

    protected boolean tolerate(Human human) {
        if (this.isWoman() && human.isWoman()) {
            return Utils.random(0.05f);
        } else if (this.isMan() && human.isMan()) {
            return Utils.random(0.056f);
        } else {
            return Utils.random(0.7f);
        }
    }

   /* - проводить время вместе (возвращает boolean)
    если рост экземпляров отличается более чем на 10%, метод возвращает true с вероятностью 0.85
    если рост экземпляров отличается менее чем на 10%, метод возвращает true с вероятностью 0.95*/

    protected boolean spendTimeTogether(Human human) {
        float fHumanHeight = this.height;
        float sHumanHeight = human.getHeight();
        float z;
        if (fHumanHeight < sHumanHeight) {
            z = sHumanHeight / fHumanHeight;
        } else {
            z = fHumanHeight / sHumanHeight;
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

    public Human haveRelationship(Human secondHuman) {
        if (talk(secondHuman) && tolerate(secondHuman) && spendTimeTogether(secondHuman) &&
                this.gender != secondHuman.getGender()) {
            if (this.isWoman()) {
                return ((Women) this).toGiveBirth((Men) secondHuman);
            }
            if (secondHuman.isWoman()) {
                return ((Women) secondHuman).toGiveBirth((Men) this);
            }
        }
        return null;
    }
}
