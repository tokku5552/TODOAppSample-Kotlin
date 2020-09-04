package tech.tokku_engineer.todoappsample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Fragmentの生成、画面遷移のみ行う
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}