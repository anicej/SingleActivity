package com.nicej.singleactivity.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nicej.singleactivity.R
import com.nicej.singleactivity.model.Applications
import com.nicej.singleactivity.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appOne = Applications(title = "Adam McKay", description = "", id = 0)
        val appTwo = Applications(title = "Denis Villeneuve", description = "", id = 1)
        val appThree = Applications(title = "Morten Tyldum", description = "", id = 2)
        val appFour = Applications(title = "The Big Short", description = "", id = 3)
        val appFive = Applications(title = "Arrival", description = "", id = 4)
        val appSix = Applications(title = "Blade Runner 2049", description = "", id = 5)
        var list = arrayOf<Applications>(appOne, appTwo, appThree, appFour, appFive, appSix)
        btn.setOnClickListener {

            viewModel.insert(list)
        }
        viewModel.getPhoto(3).observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.e("TAG", "onViewCreated: ")
                imageweb.loadUrl(it.thumbnailUrl)
            }
        })

    }
}