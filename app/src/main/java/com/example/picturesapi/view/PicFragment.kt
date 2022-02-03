package com.example.picturesapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.picturesapi.databinding.FragmentPicBinding
import com.example.picturesapi.models.repository.PicRepository
import com.example.picturesapi.viewmodel.PicViewModel
import com.example.picturesapi.models.network.APIManager

class PicFragment : Fragment() {

    private var _binding: FragmentPicBinding? = null
    private val binding: FragmentPicBinding get() = _binding!!

    private val viewModel: PicViewModel by activityViewModels {
        PicViewModel.Factory(PicRepository(APIManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            viewModel.pics.observe(viewLifecycleOwner) {imgs->
                imageRv.apply {
                    adapter = imgs?.let { PicAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}