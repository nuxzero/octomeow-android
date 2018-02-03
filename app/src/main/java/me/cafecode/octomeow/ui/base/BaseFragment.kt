package me.cafecode.octomeow.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
