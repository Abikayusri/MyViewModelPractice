package binar.academy.myviewmodelpractice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import binar.academy.myviewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mCounter: Int = 0 // TODO 1: Buat sebuah variable untuk menampung angka
    private val viewModel: MainViewModel by viewModels() // TODO 1: Tambahkan variable untuk memanggil viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 2: Buat dua buah function untuk membandingkan penggunaan dengan dan tanpa viewModel
        withoutViewModel()
        withViewModel() // TODO 3: Buat function baru untuk implement viewModel
    }

    // TODO 3: Lengkapi function withoutViewModel
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

    // TODO 2: Lengkapi function withViewModel seperti sebelumnya
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