package io.github.aungkothet.padc.assignment10.mvp.presenters

import androidx.lifecycle.ViewModel
import io.github.aungkothet.padc.assignment10.mvp.views.BaseView

abstract class BasePresenter<T: BaseView>: ViewModel(){
    protected lateinit var mView: T

    open fun initPresenter(view: T) {
        mView = view
    }
}