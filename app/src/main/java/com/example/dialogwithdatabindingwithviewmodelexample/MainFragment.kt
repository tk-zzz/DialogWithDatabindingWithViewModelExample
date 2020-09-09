package com.example.dialogwithdatabindingwithviewmodelexample

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.dialogwithdatabindingwithviewmodelexample.databinding.DialogMyBinding
import com.example.dialogwithdatabindingwithviewmodelexample.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentMainBinding>(view)?.apply {
            viewModel = this@MainFragment.mainViewModel
            lifecycleOwner = this@MainFragment
            showDialogButton.setOnClickListener{MyDialogFragment().show(parentFragmentManager, null)}
        }
    }

    class MyDialogFragment: DialogFragment(){

        private val mainViewModel : MainViewModel by activityViewModels()

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(requireContext())
            val binding = DataBindingUtil.inflate<DialogMyBinding>(
                LayoutInflater.from(requireContext()), R.layout.dialog_my, null, false)
                .apply {
                    viewModel = this@MyDialogFragment.mainViewModel
                }

            builder.setView(binding.root)
                .setNegativeButton("close") { _, _ -> dismiss()}

            return builder.create()
        }
    }

}