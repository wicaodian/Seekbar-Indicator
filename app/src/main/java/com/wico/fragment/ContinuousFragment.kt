package com.wico.fragment

import android.view.View
import android.widget.TextView
import com.wicaodian.widget.IndicatorSeekBar
import com.wicaodian.widget.OnSeekChangeListener
import com.wicaodian.widget.SeekParams
import com.wico.indicatorseekbar.R

class ContinuousFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.continuous

    override fun initView(root: View) {
        //custom indicator text
        val percent_indicator = root.findViewById<IndicatorSeekBar>(R.id.percent_indicator)
        percent_indicator.setIndicatorTextFormat("\${PROGRESS} %")

        //scale
        val scale = root.findViewById<IndicatorSeekBar>(R.id.scale)
        scale.setDecimalScale(4)
        val contentView = scale.indicator.contentView

        //thumb_drawable
        val thumb_drawable = root.findViewById<IndicatorSeekBar>(R.id.thumb_drawable)
        thumb_drawable.setThumbDrawable(resources.getDrawable(R.mipmap.ic_launcher))

        //set listener
        val listenerSeekBar = root.findViewById<IndicatorSeekBar>(R.id.listener)
        val states = root.findViewById<TextView>(R.id.states)
        states.text = "states: "
        val progress = root.findViewById<TextView>(R.id.progress)
        progress.text = "progress: " + listenerSeekBar.progress
        val progress_float = root.findViewById<TextView>(R.id.progress_float)
        progress_float.text = "progress_float: " + listenerSeekBar.progressFloat
        val from_user = root.findViewById<TextView>(R.id.from_user)
        from_user.text = "from_user: "
        listenerSeekBar.onSeekChangeListener = object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams) {
                states.text = "states: onSeeking"
                progress.text = "progress: " + seekParams.progress
                progress_float.text = "progress_float: " + seekParams.progressFloat
                from_user.text = "from_user: " + seekParams.fromUser
            }

            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar) {
                states.text = "states: onStart"
                progress.text = "progress: " + seekBar.progress
                progress_float.text = "progress_float: " + seekBar.progressFloat
                from_user.text = "from_user: true"
            }

            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar) {
                states.text = "states: onStop"
                progress.text = "progress: " + seekBar.progress
                progress_float.text = "progress_float: " + seekBar.progressFloat
                from_user.text = "from_user: false"
            }
        }
    }
}
