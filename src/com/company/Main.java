package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("красивый",
                new String[]{"прекрасный", "симпатичный", "привлекательный", "милый", "обаятельный"});
        dictionary.put("человек",
                new String[]{"личность", "персона", "индивидум", "лицо"});
        dictionary.put("дом",
                new String[]{"хата", "здание", "жилье", "квартира"});
        dictionary.put("большой",
                new String[]{"огромный", "колосальный", "громадный", "габаритный"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();
        bigDictionary.putAll(dictionary);

        Set<String> set = dictionary.keySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {

            String k = iterator.next().toString();
            String[] z = dictionary.get(k);
            bigDictionary.put(k, z);

            for (String s : z) {

                ArrayList<String> arr = new ArrayList<>(z.length);
                arr.addAll(Arrays.asList(z));
                arr.remove(s);
                arr.add(k);
                String[] n = new String[arr.size()];
                n = arr.toArray(n);
                bigDictionary.put(s, n);
                System.out.println(s + " - " + Arrays.toString(n));
            }

        }

        while (true) {
            System.out.println("Введите слово из словаря: (Например: большой) \n");
            Scanner scanner = new Scanner(System.in);
            String sentences = scanner.nextLine();
            String[] words = sentences.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (bigDictionary.get(words[i]) == null) {
                    System.out.println("Не понял ваше слово ");
                } else {
                    String[] synonyms = bigDictionary.get(words[i]);
                    Random r = new Random();
                    int randomNumber = r.nextInt(synonyms.length);
                    System.out.print(synonyms[randomNumber] + " ");

                }
            }System.out.println();
        }
    }
}