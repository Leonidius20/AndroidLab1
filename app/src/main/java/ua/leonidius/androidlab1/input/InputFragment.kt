package ua.leonidius.androidlab1.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ua.leonidius.androidlab1.R
import ua.leonidius.androidlab1.databinding.InputFragmentBinding

class InputFragment: Fragment() {

    private var _binding: InputFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = InputFragmentBinding.inflate(inflater, container, false)

        binding.languagesList.let {
            it.adapter = ArrayAdapter.createFromResource(
                context!!,
                R.array.languages,
                android.R.layout.simple_spinner_item
            ).apply {
                // Specify the layout to use when the list of choices appears
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
        }

        binding.okButton.setOnClickListener {
            val selectedPosition = binding.languagesList.selectedItemPosition
            val language = resources.getStringArray(R.array.languages)[selectedPosition]
            val action = InputFragmentDirections.actionInputFragmentToOutputFragment(language)
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}