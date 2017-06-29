package com.ekta.realm.realm;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.util.StringBuilderPrinter;

import com.ekta.realm.app.MyApplication;
import com.ekta.realm.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Ekta on 29-06-2017.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application){
        realm= Realm.getDefaultInstance();

    }

    public static RealmController with(Fragment fragment){
        if(instance==null){
            instance= new RealmController(fragment.getActivity().getApplication());
        }
            return instance;
    }

    public static RealmController with(Activity activity){
        if(instance==null){
            instance= new RealmController(activity.getApplication());
        }
        return instance;
    }
    public static RealmController with(Application application){
        if(instance==null){
            instance= new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance(){
        return instance;
    }

    public Realm getRealm(){
        return realm;
    }

    public void refresh(){
        realm.refresh();
    }

    public void clearAll(){

        realm.beginTransaction();
        realm.clear(Book.class);
        realm.commitTransaction();
    }

    public RealmResults<Book> getBooks() {

        return realm.where(Book.class).findAll();
    }

    public Book getBook(String id){

        return realm.where(Book.class).equalTo("id",id).findFirst();

    }

    public boolean hasBooks(){
        return !realm.allObjects(Book.class).isEmpty();
    }

    public RealmResults<Book> queredBooks(){

        return realm.where(Book.class)
                .contains("author","Author 0")
                .or()
                .contains("title","Realm")
                .findAll();
    }
}
