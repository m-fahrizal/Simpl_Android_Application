package com.example.finalproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        val welcomeScreenDisplay = 3000 // 3000 = 3 detik

        val welcomeThread: Thread = object : Thread() {
            var wait = 0
            override fun run() {
                try {
                    super.run()
                    while (wait < welcomeScreenDisplay) {
                        sleep(100)
                        wait += 100
                    }
                } catch (e: Exception) {
                    println("EXc=$e")
                } finally {
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }
            }
        }
        welcomeThread.start()
    }
}