package com.wico.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wico.indicatorseekbar.R

abstract class BaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(layoutId, container, false)
        val textView = root.findViewById<TextView>(R.id.source_code)
        textView?.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/wicaodian/seekbar-indicator/")
                )
            )
        }
        initView(root)
        return root
    }

    protected abstract val layoutId: Int

    protected open fun initView(root: View) {
    }
}
