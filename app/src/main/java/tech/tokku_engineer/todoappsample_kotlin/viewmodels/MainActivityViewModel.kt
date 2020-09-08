package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.tokku_engineer.todoappsample_kotlin.utils.Event


/**
 * Fragmentの生成、遷移を管理する
 */


class MainActivityViewModel : ViewModel() {

    val navigateToFragment: LiveData<Event<FragmentNavigationRequest>> get() = _navigateToFragment
    private val _navigateToFragment = MutableLiveData<Event<FragmentNavigationRequest>>()


    //FABが押された時

    //FragmentからFragmentへの移動を伴うアクションについて、画面遷移のみ操作
    //一覧画面でアイテムがクリックされた時の画面遷移

    //詳細画面で保存が押された時の画面遷移

}

data class FragmentNavigationRequest(
    val fragment: Fragment,
    val backStack: Boolean = false,
    val tag: String? = null
)