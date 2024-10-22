package org.example;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Scanner;
// maven 类似于前端中的package.json
//pom.xml 就是package.json
// npm i 其就是 maven install
// https://www.search.maven.org/ 里面放的有包，就类似于npm的仓库
// 这是我目前知道的关于java的包管理工具
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine();
        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(str.charAt(0));
        for (String s : pinyin){
            System.out.println(s);
        }
        System.out.println("Hello world!");
    }
}