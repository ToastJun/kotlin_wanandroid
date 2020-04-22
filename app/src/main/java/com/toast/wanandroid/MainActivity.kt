package com.toast.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import com.toast.wanandroid.viewmodel.User
import com.toast.wanandroid.viewmodel.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    fun initData() {
        // 初始化ViewModel
        val viewModelProvider = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application))
        val userModel = viewModelProvider.get(UserModel::class.java)
        // 初始user
        val user = User()
        user.name = "Toast"
        user.age = 27
        userModel.addUser(user)

        // 观察user变化
        userModel.currentUser.observe(this, Observer<User> {
            tvContent.text = it.toString()
        })
        // 改变user数据
        btnChange.setOnClickListener {
            user.name = "Toast.Jun"
            user.age = 28
//            userModel.addUser(user)
            userModel.currentUser.value = user
        }

        val nameStr = Transformations.map(userModel.currentUser) {
            it.name + it.age
        }

        lifecycle.addObserver(object: LifecycleObserver {

        })
    }
}

