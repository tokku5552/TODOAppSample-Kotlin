package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.utils.Event
import tech.tokku_engineer.todoappsample_kotlin.views.TodoItemDetailFragment


/**
 * Fragmentの生成、遷移を管理する
 */
private const val TAG = "MainActivityViewModel"

class MainActivityViewModel : ViewModel() {

    val navigateToFragment: LiveData<Event<FragmentNavigationRequest>> get() = _navigateToFragment
    private val _navigateToFragment = MutableLiveData<Event<FragmentNavigationRequest>>()

    //FABが押された時
    //新規作成
    fun createTask() {
        Log.d(TAG, "createTask")
        showFragment(TodoItemDetailFragment.newInstance())
    }

    //FragmentからFragmentへの移動を伴うアクションについて、画面遷移のみ操作
    //一覧画面でアイテムがクリックされた時の画面遷移

    //詳細画面で保存が押された時の画面遷移
    fun showFragment(fragment: Fragment, backStack: Boolean = true, tag: String? = null) {
        _navigateToFragment.value = Event(FragmentNavigationRequest(fragment, backStack, tag))
    }

    fun todoItemClicked(todoItem: TodoItem) {
        //TODO アイテムがクリックされた時の処理を書く
        //playMedia(clickedItem, pauseAllowed = false)
        // showFragment(TodoListFragment.newInstance())
    }

}

data class FragmentNavigationRequest(
    val fragment: Fragment,
    val backStack: Boolean = false,
    val tag: String? = null
)