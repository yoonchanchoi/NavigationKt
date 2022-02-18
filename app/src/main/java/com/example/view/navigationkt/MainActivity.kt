package com.example.view.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var layout_drawer: DrawerLayout
    private lateinit var naviView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_navi: Button
        btn_navi=findViewById(R.id.btn_navi)
        btn_navi.setOnClickListener{
            layout_drawer.openDrawer(GravityCompat.START)   //START: left, END: right 랑 같은 뜻
        }
        naviView.setNavigationItemSelectedListener(this)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {    //네비게이션 아이템 메뉴 클릭 시 수행

        when(item.itemId){
            R.id.access -> Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext,"메시지",Toast.LENGTH_SHORT).show()

        }

        layout_drawer = findViewById(R.id.layout_drawer)
        layout_drawer.closeDrawers()    //네비게이션 뷰 닫기기
       return false

    }

    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)){
            layout_drawer.closeDrawers()
        }

        super.onBackPressed()   //일반 백버튼 기능 실행

    }
}