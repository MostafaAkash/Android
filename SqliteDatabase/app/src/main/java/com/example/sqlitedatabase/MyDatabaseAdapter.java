package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseAdapter {
    MyDatabaseHelper helper;
    public MyDatabaseAdapter(Context context)
    {
        helper = new MyDatabaseHelper(context);
        helper.getWritableDatabase();
    }


    public long insertData(String name,int age,String gender)
    {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.STUDENT_COLUMN_NAME,name);
        contentValues.put(MyDatabaseHelper.STUDENT_COLUMN_AGE,age);
        contentValues.put(MyDatabaseHelper.STUDENT_COLUMN_GENDER,gender);
        long rowId = sqLiteDatabase.insert(MyDatabaseHelper.TABLE_NAME,null,contentValues);
        return rowId;
    }
    public String retrieveData()
    {

        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor =  database.rawQuery(MyDatabaseHelper.SELECT_ALL_ITEM,null);
        return cursorHelper(cursor);

    }

    public String cursorHelper(Cursor cursor)
    {
        StringBuffer buffer = new StringBuffer();
        if(cursor.getCount()==0)
        {
            buffer.append("No data Available");
            return buffer.toString();
        }
        int indexOne = cursor.getColumnIndex(MyDatabaseHelper.STUDENT_COLUMN_NAME);
        int indexTwo = cursor.getColumnIndex(MyDatabaseHelper.STUDENT_COLUMN_AGE);
        int indexThree = cursor.getColumnIndex(MyDatabaseHelper.STUDENT_COLUMN_GENDER);


        while (cursor.moveToNext())
        {
            buffer.append("Id: "+cursor.getString(0)+"\n");
            buffer.append("Name: "+cursor.getString(indexOne)+"\n");
            buffer.append("Age: "+cursor.getString(indexTwo)+"\n");
            buffer.append("Gender: "+cursor.getString(indexThree)+"\n"+"\n");

        }
        return buffer.toString();
    }


    public String getDatabasedOnId(String id)
    {
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] columns = {MyDatabaseHelper.STUDENT_COLUMN_NAME,MyDatabaseHelper.STUDENT_COLUMN_AGE,MyDatabaseHelper.STUDENT_COLUMN_GENDER};
        Cursor cursor = database.query(MyDatabaseHelper.TABLE_NAME,columns,MyDatabaseHelper.STUDENT_COLUMN_ID+" = "+id,null,null,null,null);

        return cursorHelper(cursor);

    }

    public String getDataBetweenAge(String startAge,String endAge)
    {
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] columns = {MyDatabaseHelper.STUDENT_COLUMN_ID,MyDatabaseHelper.STUDENT_COLUMN_NAME,MyDatabaseHelper.STUDENT_COLUMN_AGE,MyDatabaseHelper.STUDENT_COLUMN_GENDER};
        String[] selectionArguments = {startAge,endAge};
        Cursor cursor = database.query(MyDatabaseHelper.TABLE_NAME,columns,MyDatabaseHelper.STUDENT_COLUMN_AGE + " >= ? AND "+ MyDatabaseHelper.STUDENT_COLUMN_AGE+" <= ?",selectionArguments,null,null,MyDatabaseHelper.STUDENT_COLUMN_ID+" DESC");

        return cursorHelper(cursor);

    }

    public int deleteRowDataBasedOnName(String name)
    {
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] whereArgs = {name};
        int count = database.delete(MyDatabaseHelper.TABLE_NAME,MyDatabaseHelper.STUDENT_COLUMN_NAME+" =?",whereArgs);
        return count;

    }

    public void updateName(String oldName,String newName)
    {
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] whereArgs = {oldName};
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.STUDENT_COLUMN_NAME,newName);
        database.update(MyDatabaseHelper.TABLE_NAME,contentValues,MyDatabaseHelper.STUDENT_COLUMN_NAME+" =?",whereArgs);
    }








    static class MyDatabaseHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "Student.db";
        private static final String TABLE_NAME = "Student_Details";
        private static final int VERSION_NUMBER = 6;
        private static final String STUDENT_COLUMN_ID = "id";
        private static final String STUDENT_COLUMN_NAME = "name";
        private static final String STUDENT_COLUMN_AGE= "age";
        private static final String STUDENT_COLUMN_GENDER= "gender";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+
                STUDENT_COLUMN_ID  +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                STUDENT_COLUMN_NAME+" VARCHAR(30),"+
                STUDENT_COLUMN_AGE +" INTEGER,"+
                STUDENT_COLUMN_GENDER+" VARCHAR(20)"+
                ");";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
        private static final String SELECT_ALL_ITEM = "SELECT * FROM "+TABLE_NAME;

        //private static final String[] columsName={"ID","AGE","NAME"};
        private Context context;

        public MyDatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, VERSION_NUMBER);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
                //Toast.makeText(context, "OnCreate is Executed ", Toast.LENGTH_SHORT).show();
                Message.message(context,"OnCreate is Executed ");


            }
            catch (Exception e)
            {
                Toast.makeText(context, "Exception "+e, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context, "onUpgrade is called ", Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);

            }
            catch (Exception e)
            {
                Toast.makeText(context, "Exception "+e, Toast.LENGTH_SHORT).show();

            }

        }
    }

}
