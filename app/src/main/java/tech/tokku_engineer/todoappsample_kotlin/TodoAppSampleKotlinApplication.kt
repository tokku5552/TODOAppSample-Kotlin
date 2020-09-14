/*
 * Copyright (c) 2020 tokku5552
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/mit-license.php
 *
 */

package tech.tokku_engineer.todoappsample_kotlin

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import tech.tokku_engineer.todoappsample_kotlin.utils.MyRealmMigration

private const val TAG = "TodoAppSampleKotlinApplication"

class TodoAppSampleKotlinApplication : Application() {

    @SuppressLint("LongLogTag")
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "called onCreate")
        realmMigration()
    }

    //スキーマ変更時のマイグレーション処理
    private fun realmMigration() {
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .schemaVersion(1L)
            .migration(MyRealmMigration())
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}