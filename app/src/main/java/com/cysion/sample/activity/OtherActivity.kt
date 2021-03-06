package com.cysion.sample.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cysion.other.*
import com.cysion.sample.R
import com.cysion.sample.activity.other.EditExActivity
import com.cysion.sample.logd
import com.cysion.sample.logi
import com.cysion.targetfun._addOnAttachStateChangeListener
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        btnEditEx.setOnClickListener {
            _startActivityForResult<EditExActivity>(1000)
        }

        btnFilter._setOnClickListener {
            logd("clicked--" + System.currentTimeMillis().timeFormatm(""))
        }
//
//        //or
//        btnFilter._setOnClickListener(2000){
//            //click interval 2s
//        }
        btnFilter._addOnAttachStateChangeListener {
            _onAttached {
                logd("btnFilter attached")
            }
            _onDetached {
                logd("btnFilter detached")
            }
        }

        btnUnit.setOnClickListener {
            logd(dp2px(12).toString())
            logd(px2dp(60f).toString())
        }

        btnOther.setOnClickListener {
            btnOther.text = str(R.string.app_name)
            btnOther.background=drawable(R.mipmap.ic_launcher)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        logi("requestCode:$requestCode")
    }
}
