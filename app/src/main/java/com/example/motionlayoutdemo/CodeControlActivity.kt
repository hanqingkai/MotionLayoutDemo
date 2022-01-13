package com.example.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.Constraints
import androidx.databinding.DataBindingUtil
import com.example.motionlayoutdemo.databinding.ActivityCodeControlBinding

class CodeControlActivity : AppCompatActivity() {

    lateinit var binding: ActivityCodeControlBinding

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_code_control)

        binding.motionLayout.getConstraintSet(R.id.end)
        binding.motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH)

        binding.btnState1.setOnClickListener {
            val constraintSet = binding.motionLayout.getConstraintSet(R.id.end)
            constraintSet.getConstraint(R.id.box).apply {
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.bottomToBottom = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                transform.rotationY = 180f
                transform.rotationX = 0f
                transform.scaleX = 2f
                transform.scaleY = 2f
                propertySet.alpha = 0.1f
            }

        }
        binding.btnState2.setOnClickListener {
            val contraintSet = binding.motionLayout.getConstraintSet(R.id.end)
            contraintSet.getConstraint(R.id.box).apply {
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                //去除约束将View 放到右上角
                layout.bottomToBottom = Constraints.LayoutParams.UNSET
                transform.rotationY = 180f
                transform.rotationX = 0f
                transform.scaleX = 2f
                transform.scaleY = 2f
                propertySet.alpha = 0.1f

            }
        }
        /**
         * fix 动画在执行时，点击动画会重头开始问题
         * 1.去掉xml中的<OnClick/>
         * 2.自己编写对应的点击事件控制动画
         * motionLayout 中有currentState、startState、endState
         * startState 就是Transition的motion:constraintSetStart设置的id，endState同理
         * 上述结论 在motionLayout的setTransition(int beginId, int endId)方法中可以看出
         */
        binding.root.setOnClickListener {
            //运动中currentState的值是-1 不做处理
            if (binding.motionLayout.currentState == -1) {
                return@setOnClickListener
            }

            if (binding.motionLayout.currentState == binding.motionLayout.startState) {
                binding.motionLayout.transitionToEnd()
            } else if (binding.motionLayout.currentState == binding.motionLayout.endState) {
                binding.motionLayout.transitionToStart()
            }
        }
    }
}