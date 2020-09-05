package tech.tokku_engineer.todoappsample_kotlin

import android.app.Application
import io.realm.Realm

class TodoAppSampleKotlinApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}