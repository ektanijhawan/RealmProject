package com.ekta.realm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.ekta.realm.model.Book;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Ekta on 29-06-2017.
 */

public  class RealmBooksAdapter extends RealmModelAdapter<Book>{
    public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
