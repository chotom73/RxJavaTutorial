package com.bookofbrains.rxjava_tutorial.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

//@Database(entities = arrayOf(UserEntity::class.java), version = 1)
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}