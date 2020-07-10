package com.example.zeesh.virtualmallprototype

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BucketFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BucketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BucketFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        return inflater!!.inflate(R.layout.fragment_bucket, container, false)

        val arr = mutableListOf<Item>()
        arr.add(Item(BitmapFactory.decodeResource(resources, R.drawable.shoe), 4500, "Reebok"))
        arr.add(Item(BitmapFactory.decodeResource(resources, R.drawable.watch), 36000, "Rado"))
//        arr.add(Item(BitmapFactory.decodeResource(resources, R.drawable.shirt), 2000, "Levis"))
//        arr.add(Item(BitmapFactory.decodeResource(resources, R.drawable.glasses), 2000, "Armani"))
        val adptr = ItemRecyclerViewAdapter(arr, context)
//        cart_recyclerview.adapter = adptr
        // Inflate the layout for this fragment
        val v = inflater!!.inflate(R.layout.fragment_bucket, container, false)
        val rv = v.findViewById<RecyclerView>(R.id.bucket_recyclerview)
        rv.layoutManager = GridLayoutManager(context, 2)
        rv.adapter = adptr
        rv.addItemDecoration(GridSpacingItemDecoration(2, MySystem.dpToPx(10, resources), true))

//      if (MySystem.bmp1 != null)
//          adptr.addNewItem(Item(MySystem.bmp1, 3030, "testing"))
//        adptr.addNewItem(Item(BitmapFactory.decodeResource(resources, R.drawable.glasses), 3000, "Armani"))
//
//        Handler().postDelayed(Runnable {
//            adptr.addNewItem(Item(bmp, 390, "dldkfj"))
//            adptr.notifyDataSetChanged()
//        }, 1000)
//        adptr.notifyDataSetChanged()
//        v.findViewById<TextView>(R.id.cart_text_view).text = "called"
        return v
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BucketFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): BucketFragment {
            val fragment = BucketFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
