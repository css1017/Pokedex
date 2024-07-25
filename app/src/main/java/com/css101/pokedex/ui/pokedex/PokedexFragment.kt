package com.css101.pokedex.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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
        presenter.showPokedex()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showPokedex(pokemons: List<PokemonDetails?>) {
        if (pokemons.isNotEmpty()) {
            setAdapter(pokemons)
        } else {
            //show empty
        }

    }

    private fun setAdapter(pokemons: List<PokemonDetails?>) = with(binding) {
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