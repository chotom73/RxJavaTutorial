package com.bookofbrains.rxjava_tutorial.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(@PrimaryKey @ColumnInfo(name="idColumn") val id: Int,
                 @ColumnInfo(name = "nameColumn") val name: String,
                 @ColumnInfo(name = "emailColumn") val email: String)