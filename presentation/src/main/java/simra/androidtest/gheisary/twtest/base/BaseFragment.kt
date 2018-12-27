package simra.androidtest.gheisary.twtest.base

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import ir.cobal.data.local.preference.PreferenceService
import simra.androidtest.gheisary.twtest.R
import simra.androidtest.gheisary.twtest.film.activity.FilmActivity

abstract class BaseFragment : DaggerFragment() {
    lateinit var mActivity: FragmentActivity
    lateinit var loadingDialog: Dialog

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        initLoading()
        mActivity = activity as FragmentActivity
    }

    private fun initLoading() {
        loadingDialog = Dialog(activity, R.style.AppThemeDialog)
        loadingDialog.setContentView(R.layout.loading_view)
        loadingDialog.setCancelable(false)
    }

    fun setLoading(isLoading: Boolean) {
        when(isLoading){
            true -> loadingDialog.show()
            false -> loadingDialog.dismiss()
        }
    }

}