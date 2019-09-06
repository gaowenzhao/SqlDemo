package com.zhao.sqlitedemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zhao.sqlitedemo.utils.DaoTool
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Observable.fromCallable {
            Log.i("test",Thread.currentThread().name)
            DaoTool.instance.insertStudent()
        }.subscribeOn(Schedulers.computation())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe{
            Toast.makeText(MainActivity@this,"加载完成${Thread.currentThread().name}",Toast.LENGTH_LONG).show()
        }
        fab.setOnClickListener {
            val students = DaoTool.instance.queryList()
            val creditCardsList = students[0].creditCardsList
            Log.i("tag", "students")
        }
    }
}
