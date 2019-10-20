package io.github.aungkothet.padc.assignment10.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.aungkothet.padc.assignment10.R
import android.content.Intent
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
       val moveAnimation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.move_image)
        imgSplash.startAnimation(moveAnimation)
        val textAnimation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.move_text)
        tvAppName.startAnimation(textAnimation)
       val handler = Handler()

        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
