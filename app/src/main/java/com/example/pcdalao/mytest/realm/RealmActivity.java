package com.example.pcdalao.mytest.realm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcdalao.mytest.R;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by pan jh on 2017/6/5.
 */

public class RealmActivity extends AppCompatActivity {
    private Button button1,button2;
    private TextView textView;
    private Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToRealm();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFromReal();
            }
        });

        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    /**
     * 添加数据
     */
    private void addToRealm() {
        Dog dog=new Dog();
        dog.setName("Rex");
        dog.setAge(1);

        realm.beginTransaction();
        final Dog managedDog = realm.copyFromRealm(dog);
        Person person = realm.createObject(Person.class);
        person.getDogs().add(managedDog);
        person.setName("Tom");
        realm.commitTransaction();

        textView.setText("add success");
    }

    /**
     * 查找数据
     */
    private void searchFromReal(){
        RealmQuery<Person> query = realm.where(Person.class);
        query.equalTo("name","Tom");

        RealmResults<Person> realmResults = query.findAll();

        textView.setText(realmResults.get(0).getDogs().get(0).getName());
    }

    private void bindChangeListener(){
        final RealmResults<Dog> puppies = realm.where(Dog.class).lessThan("age",2).findAll();
        textView.setText(puppies.size()+"");

        puppies.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> collection, OrderedCollectionChangeSet changeSet) {
                textView.setText("isChange:"+puppies.size());
            }
        });
    }
}
