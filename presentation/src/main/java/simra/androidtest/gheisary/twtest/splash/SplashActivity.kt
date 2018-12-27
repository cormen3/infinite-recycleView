package simra.androidtest.gheisary.twtest.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import simra.androidtest.gheisary.twtest.film.activity.FilmActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, FilmActivity::class.java)
        startActivity(intent)
        finish()
    }
}