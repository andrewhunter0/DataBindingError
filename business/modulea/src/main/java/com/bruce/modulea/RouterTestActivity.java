package com.bruce.modulea;

import android.annotation.SuppressLint;
import android.os.Bundle;

//import com.andrew.architecture.services.modulea.ModuleAProvider;
import com.andrew.architecture.services.service.AnalyticsService2;
import com.andrew.architecture.services.service.AnalyticsService3;
import com.andrew.architecture.services.service.AnalyticsService3One;
import com.andrew.architecture.services.service.AnalyticsService;
import com.bruce.modulea.hilt.CommonClass;
import com.bruce.modulea.hilt.EntryPointHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import dagger.hilt.android.AndroidEntryPoint;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

// @AndroidEntryPoint base class must extend ComponentActivity, (support) Fragment, View, Service, or BroadcastReceiver
@AndroidEntryPoint
public class RouterTestActivity extends AppCompatActivity {
    @Inject
    // 如果直接是实现类，是可以直接通过@Inject注解，就能够初使化的，但如果是接口，就必须要写Module，告诉如何实例化接口实例
    public AnalyticsService analyticsService;

    @Inject
    // 如果直接是实现类，是可以直接通过@Inject注解，就能够初使化的，但如果是接口，就必须要写Module，告诉如何实例化接口实例
    public AnalyticsService2 analyticsService2;

    @AnalyticsService3One
    @Inject
    public AnalyticsService3 analyticsService3;

    @Inject
    @Singleton
    public CommonClass commonClass;

//    @Inject
//    @Singleton
//    public CommonClass2 commonClass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        testRouter();

        testInject();
    }

    void testInject() {
        System.out.println("test----in RouterTestActivity analyticsService not null:" + analyticsService);
        analyticsService.analytics();
        System.out.println("test------------------------------------------------------------------------\n");

        System.out.println("test----in 【modulea】.RouterTestActivity call 【moduleb】.analyticsService2:" + analyticsService2);
        analyticsService2.analytics();
        System.out.println("test------------------------------------------------------------------------\n");

        System.out.println("test----in 【modulea】.RouterTestActivity call 【moduleb】.analyticsService3:" + analyticsService3);
        System.out.println("test------------------------------------------------------------------------\n");

        System.out.println("test----in RouterTestActivity commonClass not null:" + commonClass);
        commonClass.testInit(" from RouterTestActivity ");
        System.out.println("test----########################################################################\n");

        System.out.println("test----in RouterTestActivity ModuleAEntryPoint:" +
                EntryPointHelper.INSTANCE.getEntryPoint(getApplicationContext()).getAnalyticsService());

//        new CommonClass().testInit("in new CommonClass()");

//        System.out.println("test------------------------\n");
//
//        if (commonClass2 == null) {
//            System.out.println("test----in RouterTestActivity commonClass22222 null!");
//        } else {
//            System.out.println("test----in RouterTestActivity commonClass22222 not null:" + commonClass2);
//            commonClass2.testInit("in if22222222");
//        }
    }

    void testRouter() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_router_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
