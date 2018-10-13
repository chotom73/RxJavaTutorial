package com.bookofbrains.rxjava_tutorial.room

import android.arch.persistence.room.*
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert
    fun addUserToDatabase(user: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUser(): Single<List<UserEntity>>

    @Query("DELETE FROM user")
    fun deleteAll()

    @Delete
    fun deleteUser(userToDelete: UserEntity)

    @Update
    fun updateExistingUser(user: UserEntity)
}