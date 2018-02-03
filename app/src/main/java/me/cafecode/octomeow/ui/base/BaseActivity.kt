package me.cafecode.octomeow.ui.base

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity: AppCompatActivity() {

   lateinit var errorSnackbar: Snackbar

   fun showErrorAsSnackbar() {

   }
}
