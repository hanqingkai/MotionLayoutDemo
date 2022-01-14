package com.example.motionlayoutdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import com.example.motionlayoutdemo.databinding.ActivityDemoListBinding

class DemoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDemoListBinding>(
            this,
            R.layout.activity_demo_list
        ).apply {
            presenter = Presenter()
        }

    }


    class Presenter {

        fun codeControl(v: View) {
            startActivity(v.context, Intent(v.context, CodeControlActivity::class.java), null)
        }

        fun viewPager(v: View) {
            startActivity(v.context, Intent(v.context, ViewpagerActivity::class.java), null)
        }

        fun coordinatorLayout(v: View) {
            startActivity(v.context, Intent(v.context, CoordinatorlayoutActivity::class.java), null)
        }

        fun flow(v: View) {
            startActivity(v.context, Intent(v.context, ConstraintFlowActivity::class.java), null)
        }

        fun android11(v: View) {
            startActivity(v.context, Intent(v.context, EasterEggsActivity::class.java), null)
        }

        fun roundMenu(v: View) {
            startActivity(v.context, Intent(v.context, RoundMenuActivity::class.java), null)
        }

    }
}