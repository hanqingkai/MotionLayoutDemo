package com.example.motionlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.motionlayoutdemo.databinding.ActivityViewpagerBinding
import com.example.motionlayoutdemo.fragment.CodeControlFragment
import com.google.android.material.tabs.TabLayout

class ViewpagerActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewpagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewpager)

        val titles = arrayOf("111", "222", "333", "444", "555")
        val fragments = Array(titles.size) {
            CodeControlFragment.newInstance(titles[it], "")
        }
        val adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int =
                titles.size

            override fun getItem(position: Int): Fragment =
                fragments[position]

            override fun getPageTitle(position: Int): CharSequence? = titles[position]
        }
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                binding.motionLayout.root.progress =
                    (position + positionOffset) / (adapter.count - 1)
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
}