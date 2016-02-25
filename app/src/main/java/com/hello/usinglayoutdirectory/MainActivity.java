package com.hello.usinglayoutdirectory;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private People people;

    /**
     * layout-land  横屏布局文件夹
     * layout-port  竖屏布局文件夹
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate");

        //保存数据
        if (getLastCustomNonConfigurationInstance() != null){
            // 横竖屏切换

            //获取最后一次保存过的数据
            people = (People) getLastCustomNonConfigurationInstance();
            System.out.println("last save name :"+people.getName());
            System.out.println("last save age :"+people.getAge());


        }else{
            //初始启动
            initData();

        }
    }

    //模拟数据
    private void initData(){
        //获取单例
        people = People.getPeopleIntance();
        people.setName("万福");
        people.setAge(35);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    //检测横屏或竖屏的方法

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        //得到方向
        int mOrientation = getResources().getConfiguration().orientation;
        //如果是竖屏
        if(mOrientation == Configuration.ORIENTATION_PORTRAIT){
            System.out.println("竖屏");
        }else if(mOrientation == Configuration.ORIENTATION_LANDSCAPE){
            System.out.println("横屏");
        }

    }

    //保存数据方法
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        System.out.println("onRetainCustomNonConfigurationInstance");

        people = People.getPeopleIntance();

        return people;
    }
}
