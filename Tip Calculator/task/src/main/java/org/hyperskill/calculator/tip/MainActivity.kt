package org.hyperskill.calculator.tip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

        }
    }
}