package ua.leonidius.androidlab1.ui.output

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ua.leonidius.androidlab1.R
import ua.leonidius.androidlab1.databinding.OutputFragmentBinding

class OutputFragment: Fragment() {

    private var _binding: OutputFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args: OutputFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OutputFragmentBinding.inflate(inflater, container, false)

        binding.languageEdittext.setText(args.language)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(OutputFragmentDirections.actionOutputFragmentToInputFragment())
        }

        val viewModel: OutputViewModel by viewModels()
        viewModel.saved.observe(viewLifecycleOwner) {
            if (it)
                Toast.makeText(context, R.string.saved_successfully, Toast.LENGTH_SHORT).show()
        }

        viewModel.saveRecord(args.language)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}