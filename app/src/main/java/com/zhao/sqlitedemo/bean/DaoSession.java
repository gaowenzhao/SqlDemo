package com.zhao.sqlitedemo.bean;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zhao.sqlitedemo.bean.CreditCard;
import com.zhao.sqlitedemo.bean.Student;
import com.zhao.sqlitedemo.bean.StudentAndTeacherBean;
import com.zhao.sqlitedemo.bean.Teacher;

import com.zhao.sqlitedemo.bean.CreditCardDao;
import com.zhao.sqlitedemo.bean.StudentDao;
import com.zhao.sqlitedemo.bean.StudentAndTeacherBeanDao;
import com.zhao.sqlitedemo.bean.TeacherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig creditCardDaoConfig;
    private final DaoConfig studentDaoConfig;
    private final DaoConfig studentAndTeacherBeanDaoConfig;
    private final DaoConfig teacherDaoConfig;

    private final CreditCardDao creditCardDao;
    private final StudentDao studentDao;
    private final StudentAndTeacherBeanDao studentAndTeacherBeanDao;
    private final TeacherDao teacherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        creditCardDaoConfig = daoConfigMap.get(CreditCardDao.class).clone();
        creditCardDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        studentAndTeacherBeanDaoConfig = daoConfigMap.get(StudentAndTeacherBeanDao.class).clone();
        studentAndTeacherBeanDaoConfig.initIdentityScope(type);

        teacherDaoConfig = daoConfigMap.get(TeacherDao.class).clone();
        teacherDaoConfig.initIdentityScope(type);

        creditCardDao = new CreditCardDao(creditCardDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);
        studentAndTeacherBeanDao = new StudentAndTeacherBeanDao(studentAndTeacherBeanDaoConfig, this);
        teacherDao = new TeacherDao(teacherDaoConfig, this);

        registerDao(CreditCard.class, creditCardDao);
        registerDao(Student.class, studentDao);
        registerDao(StudentAndTeacherBean.class, studentAndTeacherBeanDao);
        registerDao(Teacher.class, teacherDao);
    }
    
    public void clear() {
        creditCardDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
        studentAndTeacherBeanDaoConfig.clearIdentityScope();
        teacherDaoConfig.clearIdentityScope();
    }

    public CreditCardDao getCreditCardDao() {
        return creditCardDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public StudentAndTeacherBeanDao getStudentAndTeacherBeanDao() {
        return studentAndTeacherBeanDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

}
