demo学习地址 一级标题
=================

[学习地址]( https://blog.csdn.net/weixin_44819566/article/details/122191259?spm=1001.2014.3001.5501)
[学习地址2](https://blog.csdn.net/knight1996/article/details/108015536?spm=1001.2101.3001.6650.6&depth_1-utm_relevant_index=9)
[MotionLayout/ConstraintLayout 官方示例 (GitHub)](https://github.com/android/views-widgets-samples/tree/master/ConstraintLayoutExamples)
[属性介绍比较详细](https://juejin.cn/post/6854573206653812743)
  
  
    <Transition
    app:constraintSetStart="@+id/start"
    app:constraintSetEnd="@+id/end"
    app:duration="1000">
        <!-- 拖动 -->
    <OnSwipe />

	<!-- 点击 -->
    <OnClick />
    <KeyFrameSet >
    
	        <KeyAttribute>
	            	<CustomAttribute/>
	        </KeyAttribute>
	        
	        <KeyPostion/>
	        
	        <KeyCycle/>
	        
	        <KeyTimeCycle/>
    </KeyFrameSet>
    
	    <!--用于过渡动画的起始点状态参数配置-->
	   <Constraint android:id="@id/viewId">
			    <!-- 运动模型: 弧线路路径，时间模型等 -->
			    <Motion/>
			    <!--
			    布局相关
			    注意: width 、 height 和 margin 的命名空间是 android: (beta1 开始)
			         而约束相关的命名空间是 app (或 motion )
			    -->
			    <Layout/>
			    <!-- 动画变换:做旋转，位移，缩放，海海拔等属性 -->
			    <Transform/>
			    <!--
			    自定义属性
			        attributeName 会加上 set/get 反射找到真正的函数名，
			        ⽐如 backgroundColor 就会调用 setBackgroundColor() 函数
			        custom(xxx)Value 对应属性的数据类型
			    -->
			    <CustomAttribute/>
			    <!--
			    特定的属性
			        visibility 、alpha 等属性
			    -->
			    <PropertySet/>
	</Constraint>
    
    <!--用于过渡动画的结束点状态参数配置-->
    <ConstraintSet android:id="@+id/end"../>
    </Transition>
 