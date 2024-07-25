package com.css101.pokedex.ui.pokedex

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.css101.pokedex.R
import com.css101.pokedex.databinding.FragmentPokedexBinding
import com.css101.pokedex.domain.models.PokemonDetails
import com.css101.pokedex.utils.calculateSpanCount
import com.css101.pokedex.utils.dpToPx
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.inject

class PokedexFragment : MvpAppCompatFragment(), PokedexView {

    private var _binding: FragmentPokedexBinding? = null
    private val binding get() = _binding!!

    private val presenterProvider: PokedexPresenter by inject()
    private val presenter by moxyPresenter { presenterProvider }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("aaa", "onviewcreated")
        presenter.showPokedex()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showPokedex(pokemons: List<PokemonDetails?>) {
        setAdapter(pokemons)
    }

    override fun setBackBtn(previous: String?) = with(binding) {
        if (previous != null) {
            btnBack.setBackgroundColor(resources.getColor(R.color.purple_500, null))
            btnBack.setOnClickListener {
                presenter.loadNewPage(previous)
            }
        } else {
            btnBack.setBackgroundColor(resources.getColor(R.color.grey, null))
            btnBack.setOnClickListener(null)
        }
    }

    override fun setForwardBtn(forward: String?) = with(binding) {
        if (forward != null) {
            btnForward.setBackgroundColor(resources.getColor(R.color.purple_500, null))
            btnForward.setOnClickListener {
                presenter.loadNewPage(forward)
            }
        } else {
            btnForward.setBackgroundColor(resources.getColor(R.color.grey, null))
            btnForward.setOnClickListener(null)
        }
    }

    override fun showLoading() = with(binding) {
        tvError.visibility = View.GONE
        rvPokedex.visibility = View.GONE
        tvLoading.visibility = View.VISIBLE
        llNavigation.visibility = View.GONE
        spacer.visibility = View.GONE
    }

    override fun showError() = with(binding) {
        tvLoading.visibility = View.GONE
        rvPokedex.visibility = View.GONE
        tvError.visibility = View.VISIBLE
        llNavigation.visibility = View.GONE
        spacer.visibility = View.GONE
    }

    private fun setAdapter(pokemons: List<PokemonDetails?>) = with(binding) {
        tvLoading.visibility = View.GONE
        tvError.visibility = View.GONE
        rvPokedex.visibility = View.VISIBLE
        llNavigation.visibility = View.VISIBLE
        spacer.visibility = View.VISIBLE
        val adapter = PokedexAdapter(pokemons) {}
        rvPokedex.apply {
            val screenWidth = requireContext().resources.displayMetrics.widthPixels
            val itemWidthPx = 96.dpToPx(requireContext())
            val span = calculateSpanCount(screenWidth, itemWidthPx)
            layoutManager = GridLayoutManager(requireContext(), span)
            this.adapter = adapter
        }
    }
}