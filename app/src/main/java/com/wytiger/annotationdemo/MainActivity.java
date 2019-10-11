package com.wytiger.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_test_annotation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testAnnotation();
            }
        });
    }

    private void testAnnotation() {
        try {
            Person person = new Person();
            Log.d("testAnnotation", "name = " + person.getName());
            Log.d("testAnnotation", "person = " + person);
            Log.d("testAnnotation", "----------------------------------------------");

            Class clazz = person.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //获取属性上面的注解
                if (field.isAnnotationPresent(MyAnnotation.class)) {
                    MyAnnotation myAnnotation = field.getAnnotation(MyAnnotation.class);
                    String value = myAnnotation.value();
                    Log.d("testAnnotation", "name = " + value);
                    field.setAccessible(true);
                    //设置值
                    field.set(person, value);
                }
            }
            Log.d("testAnnotation", "newPerson = " + person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
