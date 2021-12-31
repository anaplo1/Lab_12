package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Задание 1.1
        Pattern p1 = Pattern.compile("\\d+\\s?");
        String[] words = p1.split("java5tiger 77 java6mustang");
        for (String word : words)
            System.out.println(word);
        //Задание 1.2
        Pattern p2 = Pattern.compile("[a-z]{22}[0-9]{5}");
        String a = "abcdefghijklmnopqrstuv18340";
        Matcher m2 = p2.matcher(a);
        boolean b = m2.matches();
        System.out.println(b);
        //Задание 2.1
        int count = 0;
        Pattern money = Pattern.compile("USD");
        String text = "44 EUR, 0.004 USD, 25.252 EZ";
        String[] s = text.split(" ");
        Matcher matcher;
        for (int i =0;i<s.length;i++){
            matcher = money.matcher(s[i]);
            if (matcher.find())
                System.out.println("Найдено совпадение " + s[i-1]);
        }
        money = Pattern.compile("RUB");
        for (int i =0;i<s.length;i++){
            matcher = money.matcher(s[i]);
            if (matcher.find())
                System.out.println("Найдено совпадение " + s[i-1]);
        }
        money = Pattern.compile("EU");
        for (int i =0;i<s.length;i++){
            matcher = money.matcher(s[i]);
            if (matcher.find())
                System.out.println("Найдено совпадение " + s[i-1]);
        }
        //Задание 2.2
        Pattern num = Pattern.compile("[0-9]+[ ]*[+]");
        text = "(1 + 8) – 9 / 4";
        matcher = num.matcher(text);
        if (matcher.find())
            System.out.println("Выражение верно!");
        else
            System.out.println("Выражение не содержит +");
        text = "6 / 5 – 2 * 9";
        matcher = num.matcher(text);
        if (matcher.find())
            System.out.println("Выражение верно!");
        else
            System.out.println("Выражение не содержит +");
        //Задание 2.3
        Pattern data = Pattern.compile("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)");
        text = "29/02/2000"; //29/02/2001
        matcher = data.matcher(text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start,end));
        }
        //Задание 2.4
        Pattern email = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        text = "user@loclahost"; //myhost@@@com.ru
        matcher = email.matcher(text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start,end));
        }
        //Задание 2.5
        Pattern password = Pattern.compile("(?=^.{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[_]).*$");
        text = "F032_Password"; //smart_pass
        matcher = password.matcher(text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start,end));
        }
    }
}
