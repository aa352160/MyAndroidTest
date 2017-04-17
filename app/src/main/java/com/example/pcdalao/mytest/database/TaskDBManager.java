package com.example.pcdalao.mytest.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.pcdalao.mytest.database.TaskDbHelper.TABLE_NAME;

/**
 * Created by pan jh on 2017/3/28.
 */

public class TaskDBManager {
    private TaskDbHelper helper;
    private SQLiteDatabase db;

    public TaskDBManager(Context mContext){
        helper=new TaskDbHelper(mContext);
        db=helper.getWritableDatabase();
    }

    public void addTask(int taskId,boolean isCheckIn,boolean isAnswer,boolean isCheckOut){
        db.beginTransaction();
        db.execSQL("INSERT INTO "+TABLE_NAME+" VALUES(?,?,?,?);",
                new Object[]{taskId,isCheckIn?1:0,isAnswer?1:0,isCheckOut?1:0});
        db.setTransactionSuccessful();
        closeDb();
    }

    public TaskBean queryTaskState(int taskId){
        db.beginTransaction();
        Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE taskId = "+taskId+";",null);
        TaskBean taskBean=new TaskBean();
        c.moveToNext();
        taskBean.setTaskId(c.getInt(c.getColumnIndex("taskId")));
        taskBean.setCheckIn(c.getInt(c.getColumnIndex("isCheckIn"))==1);
        taskBean.setAnswer(c.getInt(c.getColumnIndex("isAnswer"))==1);
        taskBean.setCheckOut(c.getInt(c.getColumnIndex("isCheckOut"))==1);
        c.close();
        closeDb();
        return taskBean;
    }

    /**
     * 修改任务状态
     */
    public void changeTaskState(int taskId,int type,boolean state){
        db.beginTransaction();
        String changeType="";
        if (type == 1){
            changeType="isCheckIn";
        }else if(type == 2){
            changeType="isAnswer";
        }else if (type == 3){
            changeType="isCheckOut";
        }
        int stateVal=state?1:0;
        //update table_name set isCheckIn = 1 where taskId = 100;
        db.execSQL("UPDATE "+TABLE_NAME+" SET "+changeType+" = "+stateVal+" WHERE taskId = "+taskId+";");
        db.setTransactionSuccessful();
        closeDb();
    }

    public void cleanTaskState(){
        db.beginTransaction();
//        db.delete(TABLE_NAME,"1=1",null);
        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE 1=1;");
        db.setTransactionSuccessful();
        closeDb();
    }

    public class TaskBean{
        private int taskId;
        private boolean isCheckIn;
        private boolean isAnswer;
        private boolean isCheckOut;

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public boolean isCheckIn() {
            return isCheckIn;
        }

        public void setCheckIn(boolean checkIn) {
            isCheckIn = checkIn;
        }

        public boolean isAnswer() {
            return isAnswer;
        }

        public void setAnswer(boolean answer) {
            isAnswer = answer;
        }

        public boolean isCheckOut() {
            return isCheckOut;
        }

        public void setCheckOut(boolean checkOut) {
            isCheckOut = checkOut;
        }
    }

    public void closeDb(){
        db.endTransaction();
        db.close();
    }
}
