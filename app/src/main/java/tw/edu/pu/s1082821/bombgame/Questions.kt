package tw.edu.pu.s1082821.bombgame

class Questions {
    var mQuestions = arrayOf(
        "     上課報告時要大聲一點，老師才聽的清楚",
        "     上學只是為了學習，不用認識新朋友",
        "     2+?+3=7，?=2",
        "     6+X+42=52 X=4",
        "     彩虹有7種顏色",
        "     水果草莓長在樹上",
        "     獅子不屬於貓科動物",
        "     鴨嘴獸不屬於哺乳類動物",
        "     歷史八國聯軍裡含有西班牙",
        "     台灣擁有福爾摩沙的美名是葡萄牙人所取",
        "     詩仙是指李白，詩佛是指杜甫",
        "     在台灣過了1分鐘，美國就過了60秒",
        "     子青老師帥氣逼人",
        "     北極熊的毛是黑色的",
        "     法國香水盛行是因為黑死病",
        "     蚊子可以傳播愛滋病",
        "     屏東火車站比高雄火車站還要北邊",
        "     自己的手前臂和腳底板一樣長",
        "     開車不喝酒，喝酒不開車",
        "     抽菸對身體無害，可以大口抽"
    )
    var mAnswers = arrayOf(
        "true",
        "false",
        "true",
        "true",
        "true",
        "false",
        "false",
        "false",
        "false",
        "true",
        "false",
        "true",
        "true",
        "false",
        "true",
        "false",
        "true",
        "true",
        "true",
        "false"
    )

    fun getQuestion(number: Int): String {
        return mQuestions[number]
    }

    fun getAnswer(number: Int): String {
        return mAnswers[number]
    }
}