package com.khanintel.interview_prepare;

import com.khanintel.Utils.StringFormat;

import java.util.*;

/**
 * 这个，讲的就是一个 分拣思路
 *
 * HashMap，一对一 的数据存储
 *
 * 问：如何处理一对多的数据存储？
 *      答：分拣存储
 *          一对多的问题的处理（一个主Key，一堆的Value）
 *          把一对多的问题变成一对一的问题，之后，即可以运用HashMap来处理了，也避免了数据散落在各个地方
 *
 * 分拣存储、分类归类
 *      类似于快递的分拣，有几个关键，1）找包裹集合，2）没有集合，则新增集合并放入包裹，3）新包裹，找到包裹并放到集合里
 *
 *
 *
 *
 */

/**
 * 下面这道题
 * 解决的问题是：
 *      把一个字符串，统计出来每个单词出现的次数，并且打印出出现最多的字符串。
 *      如果次数一致，则返回最早出现的
 *
 * 这里面，有2个部分
 * 1. 用分拣思路，存进去
 *      把出现次数、第一次出现的序号，都放在同一个数据结构里了（同一个分拣袋，同一个bucket)
 * 2. 用排序的思路，找到目标
 *      有两种：
 *      a. 自己实现检索算法
 *      b. 自己在Word数据结构里面，把它变成 Comparable 的，即实现 compareTo 方法，然后调用Collections.sort()方法，简单，快速，可靠，啊哈哈
 *
 */
public class WordCounter {


    public static void main(String[] args) {
        String target =
                "Dear my friend, every day and night. Always be with you." +
                "DONALD J. TRUMP\n" +
                "Chairman and President, The Trump Organization\n" +
                "\n" +
                "Donald J. Trump is the very definition of the American success story, continually setting the standards of excellence while expanding his interests in real estate, sports, and entertainment. He is the archetypal businessman –\u0096 a deal maker without peer.\n" +
                "\n" +
                "Mr. Trump started his business career in an office he shared with his father in Sheepshead Bay, Brooklyn, New York. He worked with his father for five years, where they were busy making deals together. Mr. Trump has been quoted as saying, \u0093\"My father was my mentor, and I learned a tremendous amount about every aspect of the construction industry from him.\u0094\" Likewise, Fred C. Trump often stated that \u0093\"some of my best deals were made by my son, Donald...everything he touches seems to turn to gold.\u0094\" Mr. Trump then entered the very different world of Manhattan real estate.\n" +
                "\n" +
                "In New York City and around the world, the Trump signature is synonymous with the most prestigious of addresses.  Among them are the world-renowned Fifth Avenue skyscraper, Trump Tower, and the luxury residential buildings, Trump Parc, Trump Palace, Trump Plaza, 610 Park Avenue, The Trump World Tower (the tallest building on the East Side of Manhattan), and Trump Park Avenue.  Mr. Trump was also responsible for the designation and construction of the Jacob Javits Convention Center on land controlled by him, known as the West 34th Street Railroad Yards, and the total exterior restoration of the Grand Central Terminal as part of his conversion of the neighboring Commodore Hotel into the Grand Hyatt Hotel. The development is considered one of the most successful restorations in the City and earned Mr. Trump an award from Manhattan\u0092's Community Board Five for the \"\u0093tasteful and creative recycling of a distinguished hotel.\"\u0094 Over the years, Mr. Trump has owned and sold many great buildings in New York including the Plaza Hotel (which he renovated and brought back to its original grandeur, as heralded by the New York Times Magazine), the St. Moritz Hotel (three times and now called the Ritz Carlton on Central Park South) and until 2002, the land under the Empire State Building (which allowed the land and lease to be merged together for the first time in over 50 years).";

        target = "a b c a b ";

        /**
         * 获得HashMap
         * 获得Values
         * 因为values() 返回的是 View，不能操作
         * 因此放在ArrayList里面，然后再基于我们implements Comparable接口定义的排序算法进行升序排序
         * 搞定
         */
        String stringProcessed = StringFormat.stringFormat(target);
        HashMap<String, Word> processedWordHashMap = getHashMap(stringProcessed);
        Collection<Word> processedWordCollection = processedWordHashMap.values();
        ArrayList<Word> processedWordArrayList = new ArrayList<>(processedWordCollection);
        Collections.sort(processedWordArrayList);
        Word theResult = processedWordArrayList.get(processedWordArrayList.size()-1);
        System.out.println(theResult);


        /**
         * 用自己自定义的排序算法
         */
        theResult = myOwnSort(processedWordHashMap);
        System.out.println(theResult);
    }

    /**
     * 读取字符串，并且返回一个 hashMap
     * @param targetString
     * @return
     */
    public static HashMap<String, Word> getHashMap(String targetString) {

        HashMap<String, Word> hashMap = new HashMap<>();

        String[] targetArray = targetString.split(" ");
        for (int i=0; i<targetArray.length; i++) {
            Word word = hashMap.get(targetArray[i]);
            if (word == null) {
                word = new Word(targetArray[i], 0, i);
                hashMap.put(targetArray[i], word);
            }
            word.setRepeatTimes(word.getRepeatTimes()+1);
        }
        return hashMap;
    }


    /**
     * 用自己的排序算法，对 HashMap 进行处理并且返回 Word
     * @param hashMap
     * @return
     */
    public static Word myOwnSort(HashMap<String,Word> hashMap) {
        Collection<Word> wordCollection = hashMap.values();
        Iterator<Word> wordIterator = wordCollection.iterator();
        if (wordCollection.size() == 0) {
            return null;
        }

        Word word = wordIterator.next();
        int mostTimes = word.getRepeatTimes();
        ArrayList<Word> mostTimesAL = new ArrayList<>();
        mostTimesAL.add(word);

        while (wordIterator.hasNext()) {
            Word wordTemp = wordIterator.next();
            if (wordTemp.getRepeatTimes() > mostTimes) {
                mostTimesAL.clear();
                mostTimesAL.add(wordTemp);
                mostTimes = wordTemp.getRepeatTimes();
            } else if (wordTemp.getRepeatTimes() == mostTimes) {
                mostTimesAL.add(wordTemp);
            }
        }

        int firstTime = mostTimesAL.get(0).getFirstTime();
        Word theFirstMost = mostTimesAL.get(0);
        for (Word word1 : mostTimesAL) {
            if (word1.getFirstTime() < firstTime) {
                theFirstMost = word1;
            }
        }
       return theFirstMost;
    }

}




class Word implements Comparable<Word>{

    private String word;
    private int repeatTimes;
    private int firstTime;

    @Override
    public int compareTo(Word o) {
        int i = repeatTimes - o.repeatTimes;
        if (0==i) {
            i = -(firstTime -o.firstTime);
        }
        return i;
    }

    public Word(String word, int repeatTimes, int firstTime) {
        this.word = word;
        this.repeatTimes = repeatTimes;
        this.firstTime = firstTime;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public int getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(int firstTime) {
        this.firstTime = firstTime;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", repeatTimes=" + repeatTimes +
                ", firstTime=" + firstTime +
                '}';
    }
}


/**
 *

 * 老的思路
 * 其实不是很好用的
 * 上面的代码，用的是其他思路，实现的更好
 *
 * 1. 将字符串变成全小写，分割字符串，分割并存储到String[] 里面
        "String object".toLowercase();
        "String object".split(" ")
        事实上，我还把所以的标点、换行等，都干掉了
 * 2. 新建一个HashSet，Key 是某个字符串，Value 是 Integer 代表出现的次数
 * 2.5 新建一个HashSet，Key 是某个字符串，Value 是 Integer 代表第一次出现时的 string array脚标
 * 3. 遍历string array各个元素，并将其放在HashMap里面
        如果之前没有存储过，则存进去，同时把次数 Integer 设置为 1
        如果之前存储过，则把次数 Integer 加 1
 * 3.5 如果 contain key, 则不更新第一次出现时的Value
 * 4. 创建遍历器 Iterator，逐个遍历 HashSet 的 keySet，并且获取最多出现的次数，遍历的时候把当前最大数对应的String放在 ArrayList 里面
 * 5. 查看 ArrayList 里面的各个元素，如果是最小的脚标，则返回这个值
 *
 *
 * 还有一种思路
     就是
     创建一个对象，包含了这个String、它第一次出现的位置、它总共出现的次数
     然后操作这个对象
     这种思路
     就有点像分拣存储的感觉了，只不过还是没有记录过去每条记录的功能，我们可以用数据结构记录下
     但，的确有了准备袋子，装袋子的感觉


     --------------------
     一对多的问题的处理

     一个主Key，一堆的Value 的 问题

         主Key，班级编号
         一堆Value，存放班级的学生们

         主Key，一个单词
         一堆Value，一个是第一次出现的时间，一个是总共出现的次数

     把一对多的问题变成一对一的问题，之后，即可以运用HashMap来处理了，也避免了数据散落在各个地方

         把一堆学生，放在一个ArrayList里面
         把两个Value，放在一个特殊的数据结构里面

     如果处理ArrayList，每次访问班级总分数的时候，就需要再次遍历一遍，所以可以考虑直接把总分也包装在班级的类里面
     对于单词的出现次数、第一次出现的时间，如果都要数据的话，放在两个ArrayList里面的话，需要查询两次，放在一个数据结构里面的话，只需要查找一次。
     --------------------

     PS
     如果想记录每个数据的过去、历史记录都放进来的话（比如，就是一段话里一个单词出现的每个位置，都记录下来。一个Key，多个Value）

     则
     采用：底层是ArrayList，上层是HashMap的一个数据结构
     分拣存储，是存储的时候，把过去的历史也统一放进来了，累加到最后的结果中，没有体现过去的一条条状态
     如果还要记录过去的话，那还是需要底层是ArrayList或其他List
    --------------------


 *
 */
