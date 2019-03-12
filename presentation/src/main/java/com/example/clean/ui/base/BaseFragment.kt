package com.example.clean.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.example.clean.BR
import com.example.clean.R
import com.example.clean.util.DialogUtils

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var viewBinding: VB

    abstract val viewModel: VM

    var loadingDialog: AlertDialog? = null
    var messageDialog: AlertDialog? = null

    @LayoutRes
    abstract fun getLayoutResource(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            root.isClickable = true
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DialogUtils.createLoadingDialog(context, false)
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner, Observer {
                handleShowLoading(it == true)
            })
            errorMessage.observe(viewLifecycleOwner, Observer {
                hideLoading()
                if (it != null && it.isNotBlank()) {
                    handleShowErrorMessage(it)
                }
            })
        }
    }

    override fun onPause() {
        messageDialog?.dismiss()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.isLoading.removeObservers(this)
        viewModel.errorMessage.removeObservers(this)
        viewModel.onActivityDestroyed()
    }

    open fun handleShowLoading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    fun handleShowErrorMessage(message: String) {
        messageDialog = DialogUtils.showMessage(
            context,
            message = message,
            textPositive = getString(android.R.string.ok)
        )
    }

    fun showLoading() {
        hideLoading()
        loadingDialog?.show()
    }

    fun hideLoading() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog?.cancel()
        }
    }

    fun findFragment(tag: String) = activity?.supportFragmentManager?.findFragmentByTag(tag)

    fun findChildFragment(parentFragment: Fragment = this, tag: String) =
        parentFragment.childFragmentManager.findFragmentByTag(tag)

    fun addFragment(
        fragment: Fragment,
        tag: String?,
        addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.container, fragment, tag)
            ?.apply {
                commitTransaction(this, addToBackStack, tag, transit)
            }
    }

    fun replaceFragment(
        fragment: Fragment,
        tag: String?,
        addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, fragment, tag)
            ?.apply {
                commitTransaction(this, addToBackStack, tag, transit)
            }
    }

    fun addChildFragment(
        parentFragment: Fragment = this, containerViewId: Int,
        targetFragment: Fragment, tag: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().add(
            containerViewId, targetFragment, tag
        )
        commitTransaction(transaction, addToBackStack, tag, transit)
    }

    fun replaceChildFragment(
        parentFragment: Fragment = this, containerViewId: Int,
        targetFragment: Fragment, tag: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
            containerViewId, targetFragment, tag
        )
        commitTransaction(transaction, addToBackStack, tag, transit)
    }

    fun showDialogFragment(
        dialogFragment: DialogFragment,
        tag: String?,
        addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (addToBackStack) transaction?.addToBackStack(tag)
        if (transit != -1) transaction?.setTransition(transit)
        transaction?.apply {
            dialogFragment.show(this, tag)
        }
    }

    fun popChildFragment(parentFragment: Fragment = this) {
        parentFragment.childFragmentManager.popBackStack()
    }

    private fun commitTransaction(
        transaction: FragmentTransaction,
        addToBackStack: Boolean = false,
        tag: String? = null,
        transit: Int = -1
    ) {
        if (addToBackStack) transaction.addToBackStack(tag)
        if (transit != -1) transaction.setTransition(transit)
        transaction.commit()
    }
}