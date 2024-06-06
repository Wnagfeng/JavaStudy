import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    // 我们希望在该类创建的时候只让它初始化一次牌源，我们可以使用静态代码块
    static ArrayList<String> cards = new ArrayList<String>();

    static {
        String[] Color = {"♦", "♣", "♥", "♠"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < Color.length; i++) {
            for (int j = 0; j < number.length; j++) {
                cards.add(Color[i] + number[j]);
            }
        }
        // 检查大小王是否已经存在于列表中，避免重复添加
        if (!cards.contains("小王")) {
            cards.add("小王");
        }
        if (!cards.contains("大王")) {
            cards.add("大王");
        }
    }

    // 洗牌并发牌
    public Demo() {
        // 洗牌
        Collections.shuffle(cards);
        // 发牌
        ArrayList<String> Back = new ArrayList<String>();
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        for (int i = 0; i < cards.size(); i++) {
            if (i < 3) {
                Back.add(cards.get(i));
            } else if (i % 3 == 0) {
                player1.add(cards.get(i));
            } else if (i % 3 == 1) {
                player2.add(cards.get(i));
            } else {
                player3.add(cards.get(i));
            }
        }
        lookPoker("底牌", Back);
        lookPoker("玩家1", player1);
        lookPoker("玩家2", player2);
        lookPoker("玩家3", player3);
    }

    // 看牌
    public void lookPoker(String name, ArrayList<String> cards) {
        System.out.println(name + "的牌:");
        for (String card : cards) {
            System.out.print(" " + card + " ");
        }
        System.out.println();
    }
}
