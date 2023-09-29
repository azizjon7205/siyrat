package uz.bismillah.siyrat.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import uz.bismillah.siyrat.MainActivity
import uz.bismillah.siyrat.utils.fragment_toolbar.ToolbarManager

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseMainFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        onViewCreate()

        ToolbarManager(
            getToolbar(),
            navController,
            (activity as MainActivity).appBarConfiguration
        )
    }

    abstract fun onViewCreate()

    protected abstract fun getToolbar(): Toolbar?

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}