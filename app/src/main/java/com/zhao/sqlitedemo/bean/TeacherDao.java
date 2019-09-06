package com.zhao.sqlitedemo.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEACHER".
*/
public class TeacherDao extends AbstractDao<Teacher, Long> {

    public static final String TABLENAME = "TEACHER";

    /**
     * Properties of entity Teacher.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Age = new Property(1, int.class, "age", false, "AGE");
        public final static Property TelPhone = new Property(2, String.class, "telPhone", false, "TEL_PHONE");
        public final static Property Sex = new Property(3, String.class, "sex", false, "SEX");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
        public final static Property Address = new Property(5, String.class, "address", false, "ADDRESS");
        public final static Property SchoolName = new Property(6, String.class, "schoolName", false, "SCHOOL_NAME");
        public final static Property Grade = new Property(7, String.class, "grade", false, "GRADE");
        public final static Property Test = new Property(8, String.class, "test", false, "TEST");
    }


    public TeacherDao(DaoConfig config) {
        super(config);
    }
    
    public TeacherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEACHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"AGE\" INTEGER NOT NULL ," + // 1: age
                "\"TEL_PHONE\" TEXT," + // 2: telPhone
                "\"SEX\" TEXT," + // 3: sex
                "\"NAME\" TEXT," + // 4: name
                "\"ADDRESS\" TEXT," + // 5: address
                "\"SCHOOL_NAME\" TEXT," + // 6: schoolName
                "\"GRADE\" TEXT," + // 7: grade
                "\"TEST\" TEXT);"); // 8: test
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEACHER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getAge());
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(3, telPhone);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(7, schoolName);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(8, grade);
        }
 
        String test = entity.getTest();
        if (test != null) {
            stmt.bindString(9, test);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Teacher entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getAge());
 
        String telPhone = entity.getTelPhone();
        if (telPhone != null) {
            stmt.bindString(3, telPhone);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(4, sex);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
 
        String schoolName = entity.getSchoolName();
        if (schoolName != null) {
            stmt.bindString(7, schoolName);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(8, grade);
        }
 
        String test = entity.getTest();
        if (test != null) {
            stmt.bindString(9, test);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Teacher readEntity(Cursor cursor, int offset) {
        Teacher entity = new Teacher( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // age
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // telPhone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sex
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // address
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // schoolName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // grade
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // test
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Teacher entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAge(cursor.getInt(offset + 1));
        entity.setTelPhone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAddress(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSchoolName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setGrade(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTest(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Teacher entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Teacher entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Teacher entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
