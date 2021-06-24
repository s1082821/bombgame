package tw.edu.pu.s1082821.bombgame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_boom.*
import kotlinx.android.synthetic.main.activity_first_page.*
import kotlinx.android.synthetic.main.activity_main.*

class Boom : AppCompatActivity() {
    lateinit var mper: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boom)
        mper = MediaPlayer()
        mper = MediaPlayer.create(this, R.raw.explosion)
        mper.start()
        restart.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                intent = Intent(this@Boom, FirstPage::class.java)
                startActivity(intent)
            }
        })
    }
}