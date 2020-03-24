package com.company;

public class Women extends Human {
    public Women(String name, String surName, float height, float weight) {
        super(false, name, surName, height, weight);
    }

   /* У женщин есть дополнительный метод - "родить человека" (возвращает экземпляр человека)
    Он имеет следующую реализацию:
    Создать новый экземпляр женщины или мужчины с вероятностью 0.5 со следующими свойствами:
- имя (String) - ввести с консоли
- фамилия (String) - берется у экземпляра с мужским полом
- рост (float) - копируется у соответствующего экземпляра с таким же полом + 0.1*(рост экземпляра противоположного
рода минус рост однородного экземпляра)
            - вес (float) - аналогично росту*/

   Human toGiveBirth (Human human1, Human human2 ) {
       return null;
   }

}
