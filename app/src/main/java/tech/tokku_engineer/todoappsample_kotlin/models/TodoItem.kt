/*
 * Copyright (c) 2020 tokku5552
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/mit-license.php
 *
 */

package tech.tokku_engineer.todoappsample_kotlin.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class TodoItem : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var title: String = ""
    var detail: String = ""
    var createDate: Date = Date()
    var updateDate: Date = Date()
    var isDone: Boolean = false
}