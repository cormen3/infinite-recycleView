package simra.androidtest.gheisary.twtest.film.list.model

import ir.cobal.data.local.preference.PreferenceService
import ir.cobal.data.network.model.SearchResult

class FilmListLocalData (private val preferenceService: PreferenceService): FilmListDataStore.Local{
    override fun saveFilmsInfo(searchResult: SearchResult) {}
}