package binar.academy.myviewmodelpractice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import binar.academy.myviewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var mCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 3: Buat dua buah function untuk membandingkan penggunaan dengan dan tanpa viewModel
//        withoutViewModel()
        withViewModel()
    }

    // TODO 4: Lengkapi function tanpa viewModel
    private fun withoutViewModel() {
        binding.btnPlus.setOnClickListener {
            mIncrementCount()
        }
        binding.btnMinus.setOnClickListener {
            mDecrementCount()
        }
    }

    private fun mIncrementCount() {
        mCounter += 1
        updateUI()
    }

    private fun mDecrementCount() {
        mCounter.let {
            if (it > 0) mCounter -= 1
        }
        updateUI()
    }

    private fun updateUI() {
        binding.tvCount.text = mCounter.toString()
    }

    private fun withViewModel() {
        binding.btnPlus.setOnClickListener {
            wIncrementCount()
        }
        binding.btnMinus.setOnClickListener {
            wDecrementCount()
        }

        viewModel.vCounnter.observe(this, { result ->
            binding.tvCount.text = result.toString()
        })
    }

    private fun wIncrementCount() {
        viewModel.incrementCount()
    }

    private fun wDecrementCount() {
        viewModel.decrementCount()
    }
}