package tw.edu.pu.s1082821.bombgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_first_page.*
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        back.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                intent = Intent(this@Info, FirstPage::class.java)
                startActivity(intent)
            }
        })
    }
}