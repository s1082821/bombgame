package tw.edu.pu.s1082821.bombgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_first_page.*
import kotlinx.android.synthetic.main.activity_main.*


class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        start.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                intent = Intent(this@FirstPage, SecTFGame::class.java)
                startActivity(intent)
            }
        })
        info.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                intent = Intent(this@FirstPage, Info::class.java)
                startActivity(intent)
            }
        })

    }
}