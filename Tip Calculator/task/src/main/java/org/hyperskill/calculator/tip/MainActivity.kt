package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            editText.doOnTextChanged { text, _, _, _ ->
                when {
                    text.isNullOrBlank() || text.toString().toBigDecimal() <= BigDecimal.ZERO -> {
                        billValueTv.text = ""
                        tipPercentTv.text = ""
                        tipAmountTv.text = ""
                    }

                    else -> {
                        billValueTv.text = getString(R.string.billValue, text.toString().toBigDecimal())
                        tipPercentTv.text = String.format("Tip: %s%%", seekBar.progress.toString())
                        tipAmountTv.text = getString(R.string.amount, BigDecimal(text.toString().toDouble() * seekBar.progress.toDouble() / 100 )  )
                    }
                }
            }

            seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(s: SeekBar?, progressValue: Int, p2: Boolean) {

                    tipPercentTv.text = if (binding.editText.text.isNullOrBlank()) "" else getString(R.string.percent, s?.progress)
                    tipAmountTv.text = if (binding.editText.text.isNullOrBlank()) "" else getString(R.string.amount, BigDecimal(editText.text.toString().toDouble() * seekBar.progress.toDouble() / 100 )  )
                }

                override fun onStartTrackingTouch(s: SeekBar?) {}

                override fun onStopTrackingTouch(s: SeekBar?) {}

            })

        }
    }

}