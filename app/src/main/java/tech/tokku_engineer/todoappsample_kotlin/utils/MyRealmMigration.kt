package tech.tokku_engineer.todoappsample_kotlin.utils

import io.realm.DynamicRealm
import io.realm.RealmMigration

/**
 * Realmのスキーマ変更時に変更箇所を記載する。
 *
 */
class MyRealmMigration : RealmMigration {

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val realmSchema = realm.schema
        var oldVersion = oldVersion
        if (oldVersion == 0L) {
            realmSchema.get("TodoItem")!!
                .removeField("isDelete")
            oldVersion++
        }
    }

}