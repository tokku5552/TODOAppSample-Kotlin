package tech.tokku_engineer.todoappsample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm

/**
 * Fragmentの生成、画面遷移のみ行う
 */
class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Realmのインスタンス取得
        realm = Realm.getDefaultInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Realmインスタンスの破棄
        realm.close()
    }
}