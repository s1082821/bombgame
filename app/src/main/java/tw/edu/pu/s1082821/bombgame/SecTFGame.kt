package tw.edu.pu.s1082821.bombgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import tw.edu.pu.s1082821.bombgame.Item
import tw.edu.pu.s1082821.bombgame.Questions
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_first_page.*


class SecTFGame : AppCompatActivity() {
    var tv_question: TextView? = null
    var b_true: Button? = null
    var b_false: Button? = null
    var mQuestions: Questions? = null
    var questionsLength = 0
    var questionsList: ArrayList<Item?>? = null
    var currentQuestion = 0
    var winner = false
    var loser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec_tfgame)
        Log.d(TAG, "onCreate(Bundle savedInstanceState)")

        //init stuff
        tv_question = findViewById(R.id.tv_question)
        b_true = findViewById(R.id.b_ture)
        b_false = findViewById(R.id.b_false)
        mQuestions = Questions()
        questionsLength = mQuestions!!.mQuestions.size
        Log.d(TAG, "questionsLength=$questionsLength")
        questionsList = ArrayList()

        //save all the questions in the list
        for (i in 0 until questionsLength) {
            questionsList!!.add(Item(mQuestions!!.getQuestion(i), mQuestions!!.getAnswer(i)))
            Log.d(TAG, "questionsList[" + i + ","
                    + mQuestions!!.getQuestion(i) + ","
                    + mQuestions!!.getAnswer(i) + "]")
        }

        //shuffle the questions
        Collections.shuffle(questionsList)

        //start the questions
        setQuestion(currentQuestion)
        b_true!!.setOnClickListener {
            if (checkQuestion(currentQuestion)) {
                //current - the game continues
                currentQuestion++
                if (currentQuestion < questionsLength) {
                    setQuestion(currentQuestion)
                }
                if(currentQuestion == 3){
                    winner = true
                    endGame()
                }
            } else {
                loser = true
                endGame()
            }
        }
        b_false!!.setOnClickListener {
            if (!checkQuestion(currentQuestion)) {
                //current - the game continues
                currentQuestion++
                if (currentQuestion < questionsLength) {
                    setQuestion(currentQuestion)
                }
                if(currentQuestion == 3){
                    winner = true
                    endGame()
                }
            } else {
                loser = true
                endGame()
            }
        }
    }
    //show question on the screen
    private fun setQuestion(number: Int) {
        Log.d(TAG, "setQuestion(int number)")
        tv_question?.setText(questionsList!![number]!!.question)
    }

    //check if the answer is right
    private fun checkQuestion(number: Int): Boolean {
        Log.d(TAG, "checkQuestion(int number)")
        val answer = questionsList!![number]!!.answer
        return answer == "true"
    }

    //game over
    private fun endGame() {
        Log.d(TAG, "endGame()")
        if (winner) {
            Toast.makeText(this, "厲害喔，你可以拆除炸彈了!", Toast.LENGTH_SHORT).show()
            intent = Intent(this@SecTFGame, MainActivity::class.java)
            startActivity(intent)
        } else if(loser){
            Toast.makeText(this, "答錯囉，炸彈已被引爆!", Toast.LENGTH_SHORT).show()
            intent = Intent(this@SecTFGame, Boom::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}