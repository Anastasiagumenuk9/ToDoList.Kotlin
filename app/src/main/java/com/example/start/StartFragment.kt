package com.example.start

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.task.TaskVMFactory
import com.example.database.ToDoListDatabase
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {

    private lateinit var viewModel: StartViewModel
    private lateinit var viewModelFactory: StartViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelFactory = StartViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StartViewModel::class.java)

        val binding: com.example.start.databinding.FragmentStartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_start, container, false
        )
        binding.button.setOnClickListener { v: View ->
            v.findNavController().navigate(StartFragmentDirections.actionStartFragmentToToDoListFragment())
        }


        var application = requireNotNull(this.activity).application
        var dataSource = ToDoListDatabase.getInstance(application).toDoListDatabaseDao
        val viewModelFactory = TaskVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(StartViewModel::class.java)

        setHasOptionsMenu(true)
        return binding.root
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