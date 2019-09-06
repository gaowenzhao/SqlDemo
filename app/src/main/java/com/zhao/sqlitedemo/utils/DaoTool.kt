package com.zhao.sqlitedemo.utils

import com.zhao.sqlitedemo.App
import com.zhao.sqlitedemo.bean.DaoMaster
import com.zhao.sqlitedemo.bean.DaoSession
import com.zhao.sqlitedemo.bean.Student
import com.zhao.sqlitedemo.bean.StudentDao
import com.zhao.sqlitedemo.bean.CreditCard
import java.util.*


//双重校验锁式（Double Check)
class DaoTool {
    private var daoSession: DaoSession? = null

    private constructor() {
        initGreenDao()
    }

    companion object {
        val instance: DaoTool by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DaoTool()
        }
    }

    /**
     * 可以切换数据库
     */
    fun initGreenDao(dbName: String = "greendao") {
        daoSession?.let {
            it.database.close()
        }
        val helper = DaoMaster.DevOpenHelper(App.instance, dbName)
        val db = helper.writableDatabase
        val daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
    }

    fun insertStudent() {
        for (i in 0..99) {
            val student = Student()
            student.studentNo = i
            val age = 10
            student.age = age
            student.telPhone = "15800$i"
            val chineseName = "zhao$i"
            student.name = chineseName
            if (i % 2 == 0) {
                student.sex = "男"
            } else {
                student.sex = "女"
            }
            student.address = "杨一村"
            student.grade = (age % 10).toString() + "年纪"
            student.schoolName = "杨一小学"
            daoSession?.insert(student)
            //插入对应的CreditCard数据
            addOtherData(Random(), chineseName,student.id)
        }

    }

    private fun addOtherData(random: Random, userName: String, id: Long?) {
        var max = 5
        if(id==6.toLong()){
            max = 1000
        }
        for (j in 0 until max) {
            val creditCard = CreditCard()
            creditCard.userId = id
            creditCard.userName = userName
            creditCard.cardNum = (random.nextInt(899999999) + 100000000).toString() + (random.nextInt(899999999) + 100000000).toString()
            creditCard.whichBank = "招商$id"
            creditCard.cardType = random.nextInt(10)
            daoSession?.insert(creditCard)
        }
    }

    fun queryList(): List<Student> {
        val qb = daoSession?.queryBuilder(Student::class.java)!!
        return qb.where(
            qb.and(
                StudentDao.Properties.Id.gt(5),
                StudentDao.Properties.Id.le(50)/*,StudentDao.Properties.Name.like("zhao")*/
            )
        ).list()
    }
}