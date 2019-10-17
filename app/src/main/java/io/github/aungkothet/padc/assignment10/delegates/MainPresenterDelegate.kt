package io.github.aungkothet.padc.assignment10.delegates

import io.github.aungkothet.padc.assignment10.mvp.presenters.MainPresenter

interface MainPresenterDelegate {

    fun getPresenter(): MainPresenter

}