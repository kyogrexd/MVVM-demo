package com.example.mvvm_demo

import androidx.room.*
import com.example.mvvm_demo.Data.CaseOneData

const val DATABASE_NAME = "MyDatabase"
const val Table_Case1 = "Case1"
const val DB_Version = 2
@Database(entities = [Case1::class], version = DB_Version)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {
    abstract fun getCase1Dao(): Case1Dao
}

@Entity(tableName = Table_Case1, primaryKeys = arrayOf("userID"))
@TypeConverters(Case1Converters::class)
data class Case1(var userID: Int, var dataList: ArrayList<CaseOneData>)

@Dao
interface Case1Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Case1): Long

    @Query("SELECT * FROM [$Table_Case1] WHERE userID LIKE :userID")
    fun getByID(userID: Int): Case1?

    @Query("DELETE FROM [$Table_Case1] WHERE userID LIKE :userID")
    fun deleteByID(userID: Int): Int
}