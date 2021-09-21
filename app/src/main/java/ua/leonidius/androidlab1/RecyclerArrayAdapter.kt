package ua.leonidius.androidlab1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerArrayAdapter(context: Context, arrayId: Int,
                           private val onItemSelected: (View) -> Unit):
    RecyclerView.Adapter<RecyclerArrayAdapter.ViewHolder>() {

    private val array = context.resources.getStringArray(arrayId)
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = inflater.inflate(R.layout.list_item,
            parent, false) as TextView
        textView.setOnClickListener(onItemSelected)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textView.text = array[position]
    }

    override fun getItemCount() = array.size

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

}