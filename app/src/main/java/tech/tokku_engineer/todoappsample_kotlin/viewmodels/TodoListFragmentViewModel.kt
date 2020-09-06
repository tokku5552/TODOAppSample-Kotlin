package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem

/**
 * TodoListFragmentの表示、データの更新を行う
 *
 */
class TodoListFragmentViewModel : ViewModel() {
    lateinit var todoItem: MutableList<TodoItem>
    lateinit var title: MutableLiveData<String>
    fun todoItemClicked(todoItem: TodoItem) {
        //playMedia(clickedItem, pauseAllowed = false)
       // showFragment(TodoListFragment.newInstance())
    }

//    val navigateToFragment: LiveData<Event<FragmentNavigationRequest>> get() = _navigateToFragment
//    private val _navigateToFragment = MutableLiveData<Event<FragmentNavigationRequest>>()
//
//    /**
//     * Convenience method used to swap the fragment shown in the main activity
//     *
//     * @param fragment the fragment to show
//     * @param backStack if true, add this transaction to the back stack
//     * @param tag the name to use for this fragment in the stack
//     */
//    fun showFragment(fragment: Fragment, backStack: Boolean = true, tag: String? = null) {
//        _navigateToFragment.value = Event(FragmentNavigationRequest(fragment, backStack, tag))
//    }

    fun createTask() {

    }

    fun getTask() {

    }

    fun updateTask() {

    }

    fun deleteTask() {

    }

}

data class FragmentNavigationRequest(
    val fragment: Fragment,
    val backStack: Boolean = false,
    val tag: String? = null
)