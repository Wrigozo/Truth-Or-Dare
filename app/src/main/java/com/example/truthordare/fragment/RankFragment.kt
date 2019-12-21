package com.example.truthordare.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.truthordare.R
import com.example.truthordare.databinding.RankFragmentBinding

class RankFragment : Fragment() {
    private lateinit var binding: RankFragmentBinding
    companion object {
        fun newInstance() = RankFragment()
    }

    private lateinit var viewModel: RankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.rank_fragment, container, false)
        binding.goToJson.setOnClickListener(){
            goJson()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RankViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun goJson(){
        val action=RankFragmentDirections.actionRankFragmentToJsonFragment()
        view!!.findNavController().navigate(action)
    }


}
