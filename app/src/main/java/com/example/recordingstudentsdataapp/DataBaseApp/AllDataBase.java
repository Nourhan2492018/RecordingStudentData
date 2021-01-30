package com.example.recordingstudentsdataapp.DataBaseApp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recordingstudentsdataapp.DataBaseApp.Dao.StudentDao;
import com.example.recordingstudentsdataapp.Model.StudentModel;

@Database(entities = {StudentModel.class},version = 1, exportSchema = false)
public abstract class AllDataBase extends RoomDatabase {
    private  static volatile AllDataBase INSTANCE;
    public abstract StudentDao studentDao();
    public static AllDataBase getDataBase(final Context context)
     {
         //Double Check
         if(INSTANCE ==null)
         {
             synchronized (AllDataBase.class)
             {
                 if(INSTANCE ==null)
                 {
                     INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                             AllDataBase.class,"database_app").allowMainThreadQueries()
                             .fallbackToDestructiveMigration()
                             .build();
                 }
             }

         }
         return INSTANCE ;
     }


}
