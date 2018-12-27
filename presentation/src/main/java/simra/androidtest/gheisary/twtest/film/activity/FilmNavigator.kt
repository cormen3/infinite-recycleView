package simra.androidtest.gheisary.twtest.film.activity

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import simra.androidtest.gheisary.twtest.R
import simra.androidtest.gheisary.twtest.film.details.FilmDetailsFragment
import simra.androidtest.gheisary.twtest.film.list.FilmListFragment

class FilmNavigator (activity: AppCompatActivity) {
    private var fragmentManager: FragmentManager = activity.supportFragmentManager

    fun navigateToFilmListFragment(param: String) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,R.anim.slide_out_right)
                .replace(R.id.film_fragment_container, FilmListFragment.newInstance(param))
                .addToBackStack("FilmListFragment")
                .commit()
    }

    fun navigateToFilmDetailFragment(id: String) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,R.anim.slide_out_right)
            .add(R.id.film_fragment_container, FilmDetailsFragment.newInstance(id))
            .addToBackStack("FilmDetailsFragment")
            .commit()
    }


}