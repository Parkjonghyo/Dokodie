package com.cookandroid.dokodie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BookDatabaseManager {
    static final String DB_Book = "Book.db";   //DB이름
    static final String TABLE_Books = "Books"; //Table 이름
    static final int DB_VERSION = 1;			//DB 버전

    Context myContext = null;

    private static BookDatabaseManager myDBManager = null;
    private SQLiteDatabase mydatabase = null;

    //MovieDatabaseManager 싱글톤 패턴으로 구현
    public static BookDatabaseManager getInstance(Context context)
    {
        if(myDBManager == null)
        {
            myDBManager = new BookDatabaseManager(context);
        }
        return myDBManager;
    }

    private BookDatabaseManager(Context context)
    {
        myContext = context;

        //DB Open
        mydatabase = context.openOrCreateDatabase(DB_Book, context.MODE_PRIVATE,null);

        //Table 생성
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_Books +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "writer TEXT," +
                "publisher TEXT," +
                "date TEXT," +
                "price INTEGER," +
                "bookImgNumber INTEGER);");
    }

    // insert구문 TODO- 나만 못해
    public long insert(ContentValues addRowValue){
        return mydatabase.insert(TABLE_Books, null, addRowValue);
    }


    // update 구문 TODO - 살려줘
    public int update(ContentValues updateRowValue,
                      String whereClause,
                      String[] whereArgs)
    {
        return mydatabase.update(TABLE_Books,
                updateRowValue,
                whereClause,
                whereArgs);
    }


// Delete 구문
    public int delete(String whereClause,
                      String[] whereArgs)
    {
        return mydatabase.delete(TABLE_Books,
                whereClause,
                whereArgs);
    }

    // Select구문
    public Cursor query(String[] colums,
                        String selection,
                        String[] selectionArgs,
                        String groupBy,
                        String having,
                        String orderby)
    {

        return mydatabase.query(TABLE_Books,
                colums,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderby);
    }
}
