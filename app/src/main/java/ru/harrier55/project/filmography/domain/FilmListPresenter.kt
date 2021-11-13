package ru.harrier55.project.filmography.domain


import ru.harrier55.project.filmography.data.CardFilm

import ru.harrier55.project.filmography.data.MyApp


class FilmListPresenter:FilmListContract.Presenter {

    private var view: FilmListContract.View? = null

    private var myList:List<CardFilm>  = mutableListOf()



    override fun attach(view: FilmListContract.View) {
       this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun getDataForFilmList() {
     myList= MyApp.instance.getMyAppCardFilmRepoImpl().getCardFilmList()
        view?.setData(myList)
    }
}