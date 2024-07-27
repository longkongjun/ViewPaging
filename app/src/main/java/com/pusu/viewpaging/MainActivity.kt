package com.pusu.viewpaging

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.pusu.viewpaging.adapter.fixedsize.FixedFlowerAdapter
import com.pusu.viewpaging.databinding.ActivityMainBinding
import com.pusu.viewpaging.viewmodel.FlowerViewModel

class MainActivity : AppCompatActivity() {

    private val flowerViewModel by viewModels<FlowerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            initView(it)
        }
    }

    private fun initView(binding: ActivityMainBinding) {
        val adapter = FixedFlowerAdapter()
        binding.vpContainer.adapter = adapter
        binding.vpContainer.isUserInputEnabled = false
        binding.vpContainer.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.btnPre.setOnClickListener {
                    binding.vpContainer.setCurrentItem((position - 1).coerceAtLeast(0), false)
                }
                binding.btnNext.setOnClickListener {
                    binding.vpContainer.setCurrentItem((position + 1).coerceAtMost(adapter.itemCount - 1), false)
                }
            }
        })

        binding.btnRefresh.setOnClickListener {
            flowerViewModel.queryFlowers()
        }

        flowerViewModel.flowers.observe(this) {
            adapter.submitList(it)
        }

    }

}