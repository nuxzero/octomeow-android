package me.cafecode.octomeow.ui.base

import android.content.Context
import android.support.v4.app.Fragment
import me.cafecode.octomeow.OctomeowApplication


abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity?.application as? OctomeowApplication)?.component?.inject(this)
    }
}
