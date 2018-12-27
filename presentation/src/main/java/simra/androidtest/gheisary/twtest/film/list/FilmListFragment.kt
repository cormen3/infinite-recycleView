package simra.androidtest.gheisary.twtest.film.list

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ir.cobal.data.network.model.SearchResult
import simra.androidtest.gheisary.twtest.base.BaseFragment
import ir.cobal.data.network.model.Outcome
import kotlinx.android.synthetic.main.fragment_film_list.*
import simra.androidtest.gheisary.twtest.R
import javax.inject.Inject
import android.support.v7.widget.RecyclerView
import simra.androidtest.gheisary.twtest.utility.EndlessRecyclerViewScrollListener
import simra.androidtest.gheisary.twtest.film.activity.FilmNavigator

class FilmListFragment: BaseFragment() {
    companion object {
        private const val ARG_FRAGMENT_INSTANCE = "ARG_FRAGMENT_INSTANCE"
        fun newInstance(someInt: String): FilmListFragment {
            val myFragment = FilmListFragment()
            val args = Bundle()
            args.putString(ARG_FRAGMENT_INSTANCE, someInt)
            myFragment.arguments = args
            return myFragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var filmListViewModel: FilmListViewModel
    private lateinit var filmListAdapter: FilmListAdapter
    var items = SearchResult(Search = ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(context, R.layout.fragment_film_list, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmListViewModel = ViewModelProviders.of(this, viewModelFactory).get(FilmListViewModel::class.java)

        initObservers()

        setupList()

        setupListeners()
    }

    private fun setupListeners() {
        filmListSearchIconImageView.setOnClickListener {
            items.Search.clear()
            filmListViewModel.searchFilms(filmListSearchEditText.text.toString(), 1)
        }
    }

    private fun setupList() {
        val linearLayoutManager =  LinearLayoutManager(activity)
        filmListRecyclerView.layoutManager = linearLayoutManager
        filmListAdapter = FilmListAdapter(mActivity)
        filmListAdapter.clickEvent.subscribe {FilmNavigator(mActivity as AppCompatActivity).navigateToFilmDetailFragment(it) }
        filmListRecyclerView.adapter = filmListAdapter

        val scrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                filmListViewModel.searchFilms(filmListSearchEditText.text.toString(), page + 1)
            }
        }
        filmListRecyclerView.addOnScrollListener(scrollListener)
    }

    private fun initObservers() {
        filmListViewModel.loginOutcome.observe(this, Observer<Outcome<SearchResult>> { outcome ->
            when (outcome) {
                is Outcome.Progress -> setLoading(outcome.loading)

                is Outcome.Success -> { updateList(outcome.data) }

                is Outcome.Failure -> { Toast.makeText(context,outcome.exception.message, Toast.LENGTH_LONG).show() }
            }
        })
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    private fun updateList(data : SearchResult) {
        items.Search.addAll(data.Search)
        filmListAdapter.setData(items)
        filmListAdapter.notifyDataSetChanged()

    }
}