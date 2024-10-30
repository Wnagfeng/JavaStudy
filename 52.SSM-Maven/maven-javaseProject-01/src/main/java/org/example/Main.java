package org.example;

import net.sourceforge.pinyin4j.PinyinHelper;

public class Main {
    public static void main(String[] args) {
        String chineseWord = "汉字"; // 你想要转换的中文字符
        StringBuilder pinyin = new StringBuilder();

        for (char c : chineseWord.toCharArray()) {
            String[] pinyinArray = PinyinHelper.toMPS2PinyinStringArray(c);
            if (pinyinArray != null) {
                pinyin.append(pinyinArray[0]).append(" ");
            }
        }

        System.out.println("拼音: " + pinyin.toString().trim());
    }
}
