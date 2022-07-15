package com.example.mvvm_demo

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.mvvm_demo.Data.CaseOneData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class DataManager private constructor(): Observable() {
    companion object {
        val instance: DataManager = DataManager()
    }

    private var db: DataBase? = null

    fun initDataStore(context: Context) {
        db = Room.databaseBuilder(context, DataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun closeDatabase() {
        db?.close()
        db = null
    }

    fun setCase1Data(userID: Int, dataList: ArrayList<CaseOneData>) {
        GlobalScope.launch(Dispatchers.IO) {
            db?.getCase1Dao()?.insert(Case1(userID, dataList))
        }
    }

    fun getCase1Data(id: Int, result:(Case1?) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                db?.getCase1Dao()?.getByID(id)?.let {
                    result(it)
                } ?: result(null)
            } catch (e: Exception) {
                Log.e("getCase1Data error", "${e.message}")
            }
        }
    }
}