package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.utils.Event
import tech.tokku_engineer.todoappsample_kotlin.views.TodoItemDetailFragment
import java.text.FieldPosition


/**
 * Fragmentの生成、遷移を管理する
 */
private const val TAG = "MainActivityViewModel"

class MainActivityViewModel : ViewModel() {

    var selectedItem: TodoItem? = null
    val navigateToFragment: LiveData<Event<FragmentNavigationRequest>> get() = _navigateToFragment
    private val _navigateToFragment = MutableLiveData<Event<FragmentNavigationRequest>>()

    //FABが押された時
    //新規作成
    fun createTask() {
        Log.d(TAG, "createTask")
        selectedItem = null
        showFragment(TodoItemDetailFragment.newInstance())
    }

    //FragmentからFragmentへの移動を伴うアクションについて、画面遷移のみ操作
    //一覧画面でアイテムがクリックされた時の画面遷移

    //詳細画面で保存が押された時の画面遷移
    fun showFragment(fragment: Fragment, backStack: Boolean = true, tag: String? = null) {
        _navigateToFragment.value = Event(FragmentNavigationRequest(fragment, backStack, tag))
    }

    //LiveDataに選択されたTodoItemを保存してから詳細画面へ遷移
    fun todoItemClicked(todoItem: TodoItem) {
        Log.d(TAG, "called todoItemClicked")
        selectedItem = todoItem
        showFragment(TodoItemDetailFragment.newInstance())
    }

}

data class FragmentNavigationRequest(
    val fragment: Fragment,
    val backStack: Boolean = false,
    val tag: String? = null
)