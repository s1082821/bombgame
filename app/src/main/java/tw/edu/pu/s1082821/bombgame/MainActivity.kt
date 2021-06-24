package tw.edu.pu.s1082821.bombgame

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_first_page.*

class MainActivity : AppCompatActivity() {
    // Parameter
    var gameWin = true
    var max = 0
    var min = 0
    var Ran = 0
    var gameCount = 0
    var wrongCount = 0
    var Lose = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Create a random number in range min ~ max
    fun randomCreate(max: Int, min: Int): Int {
        val Ran = Random()
        return Ran.nextInt(max) + min
    }

    // Button_Click event
    @Throws(InterruptedException::class)
    fun buttonClick1(view: View?) {
        // Initialize setting
        if (gameWin == true) {
            max = 100 // Random range (Max)
            min = 1 // Random range (Min)
            Ran = randomCreate(max, min) // Get random number
            gameCount = 0 // Guess count
            wrongCount = 0
            Lose = 7
            gameWin = false // Game win flag
        }

        // IO setting
        val txtOutput = findViewById(R.id.textView1) as TextView
        val txtInput = findViewById(R.id.editText1) as EditText
        findViewById(R.id.button1) as Button

        // Alert dialog setting
        val endGame = AlertDialog.Builder(this)
        endGame.setTitle("恭喜，炸彈已解除\n")
        endGame.setMessage("炸彈密碼是 \"$Ran\"\n共解了: $gameCount 次")
        endGame.setPositiveButton(
            "Restart"
        ) { dialog, i -> // Re App
            intent = Intent(this@MainActivity, FirstPage::class.java)
            startActivity(intent)
        }
        endGame.setNegativeButton(
            "Close"
        ) { dialog, i -> // Close App
            intent = Intent(this@MainActivity, FirstPage::class.java)
            startActivity(intent)
        }
        if ("" == txtInput.text.toString().trim { it <= ' ' })
            txtOutput.text = "請輸入在範圍內的數字 \n範圍是 $min ~ $max" else {
            val keyinStr = txtInput.text.toString()
            val keyinInt = keyinStr.toInt()
            if (keyinInt >= min && keyinInt <= max) {
                gameCount += 1
                wrongCount += 1
                if(wrongCount > Lose){
                    intent = Intent(this@MainActivity, Boom::class.java)
                    startActivity(intent)
                }
                if (keyinInt == Ran) {
                    txtOutput.text = ""
                    gameWin = true
                    endGame.show()
                } else if (keyinInt < Ran) {
                    min = keyinInt
                    txtOutput.text = "範圍是 $min ~ $max , 已錯 $wrongCount 次."
                } else if (keyinInt > Ran) {
                    max = keyinInt
                    txtOutput.text = "範圍是 $min ~ $max , 已錯 $wrongCount 次."
                } else {
                    txtOutput.text = "請輸入在範圍內的數字"
                }
            } else txtOutput.text = "請輸入在範圍內的數字, \n     範圍是 $min ~ $max"
        }
        txtInput.setText(null)
    }
}