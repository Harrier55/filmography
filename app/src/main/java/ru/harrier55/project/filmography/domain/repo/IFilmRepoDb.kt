package ru.harrier55.project.filmography.domain.repo

import ru.harrier55.project.filmography.domain.entities.CardFilmEntity

interface IFilmRepoDb {
    fun createdCardFilm(cardFilm: CardFilmEntity)
    fun updateCardFilm()
    fun deleteCardFilm()
}