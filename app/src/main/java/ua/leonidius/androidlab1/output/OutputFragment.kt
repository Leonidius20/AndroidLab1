package ua.leonidius.androidlab1.output

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ua.leonidius.androidlab1.databinding.OutputFragmentBinding

class OutputFragment: Fragment() {

    private var _binding: OutputFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val args: OutputFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = OutputFragmentBinding.inflate(inflater, container, false)

        binding.languageEdittext.setText(args.language)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(OutputFragmentDirections.actionOutputFragmentToInputFragment())
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}