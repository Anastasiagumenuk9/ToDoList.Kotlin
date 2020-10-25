package com.example.toDoList

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.view.*


class StartFragment : Fragment() {

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: com.example.toDoList.databinding.FragmentStartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_start, container, false
        )
        binding.button.setOnClickListener { v: View ->
            v.findNavController().navigate(StartFragmentDirections.actionStartFragmentToToDoListFragment())
        }

        binding.button2.setOnClickListener { v: View ->
            onClickCounter()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun onClickCounter(){
        counter++
        textView6.text = counter.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent()  {
        val myIntent = Intent(Intent.ACTION_SEND)
        myIntent.type = "type/plain"
        val shareBody = "You are body"
        val shareSub = "You subject here"
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
        startActivity(Intent.createChooser(myIntent, "Share Your App"))
    }

    private fun shareSuccess() {
        getShareIntent()
    }
}