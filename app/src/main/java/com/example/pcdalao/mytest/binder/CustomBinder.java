package com.example.pcdalao.mytest.binder;

import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan jh on 2017/5/15.
 */

public class CustomBinder {
    private List<Book> mBookList=new ArrayList<>();

    private final IBookManager.Stub mBinder = new IBookManager.Stub(){
        @Override
        public List<Book> getBookList() throws RemoteException {
            synchronized (mBookList){
                return mBookList;
            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };
}
