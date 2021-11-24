package com.acronymmeaning.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acronymmeaning.example.adapters.AcronymAdapter
import com.acronymmeaning.example.databinding.FragmentUserInputBinding
import com.acronymmeaning.example.model.Lf
import com.acronymmeaning.example.viewmodels.UserInputViewModel

class UserInputFragment : Fragment() {
    lateinit var fragmentUserInputBinding: FragmentUserInputBinding
    private lateinit var userInputViewModel: UserInputViewModel
    private var lFList: List<Lf> = ArrayList()
    private var userInputText: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userInputViewModel = ViewModelProvider(this).get(UserInputViewModel::class.java)
        fragmentUserInputBinding =
            FragmentUserInputBinding.inflate(layoutInflater, container, false)
        fragmentUserInputBinding.lifecycleOwner = activity
        setupButtonClickListener()
        //TODO Config Change needs to be fixed
//        restoreDataIfAvailable(savedInstanceState)
        return fragmentUserInputBinding.root
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putParcelableArrayList(LF_LIST, lFList as ArrayList<Lf>)
//        outState.putString(USER_TEXT, userInputText)
//        Log.i(TAG, "onSaveInstanceState: $lFList")
//    }
//
//    private fun restoreDataIfAvailable(savedInstanceState: Bundle?) {
//        if (savedInstanceState != null) {
//            lFList = savedInstanceState.getParcelableArrayList(LF_LIST)!!
//            userInputText = savedInstanceState.getString(USER_TEXT).toString()
//            Log.i(TAG, "restoreDataIfAvailable: $lFList")
//            Log.i(TAG, "restoreDataIfAvailable userInputText: $userInputText")
//            fragmentUserInputBinding.userInput = userInputText
//            displayRecyclerView()
//        }
//    }

    private fun setupButtonClickListener() {
        fragmentUserInputBinding.btCheckMeaning.setOnClickListener {
            userInputText = fragmentUserInputBinding.etAcronym.text.toString()
            context?.let { context ->
                userInputViewModel.getAcronymDetailsLiveDataFromNetwork(context, userInputText)
                userInputViewModel.acronymDetailsLiveData.observe(viewLifecycleOwner, {
                    lFList = it[0].lfs
                    displayRecyclerView()
                })
            }

        }
    }

    private fun displayRecyclerView() {
        val acronymAdapter = AcronymAdapter(lFList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        fragmentUserInputBinding.rlAcronymList.layoutManager = layoutManager
        fragmentUserInputBinding.rlAcronymList.visibility = View.VISIBLE
        fragmentUserInputBinding.adapter = acronymAdapter
    }

    companion object {
        private const val TAG = "UserInputFragment"
        const val LF_LIST = "lfList"
        const val USER_TEXT = "user_text"
    }
}
