package yongchao.com.wineapp.ui.login.util

import android.os.CountDownTimer
import android.widget.Button

class CodeTime {

    private val startTime: Long = 1000
    private val endTimer = startTime * 60
    private var countDownTimer: CountDownTimer? = null


    fun codeCountTimer(codeView: Button) {
        countDownTimer = object : CountDownTimer(endTimer, startTime) {
            override fun onFinish() {
                codeView.isEnabled = true
                codeView.text = "重新获取"
            }

            override fun onTick(millisUntilFinished: Long) {
                codeView.isEnabled = false
                codeView.text = "重新获取（"+(millisUntilFinished / 1000).toString()+"s）"
            }
        }.start()
    }

    fun onDestroy() {
        countDownTimer?.cancel()
    }
}