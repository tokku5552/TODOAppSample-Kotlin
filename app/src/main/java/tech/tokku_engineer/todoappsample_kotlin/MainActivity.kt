package tech.tokku_engineer.todoappsample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.todo_list_fragment.*
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.MainActivityViewModel
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel
import tech.tokku_engineer.todoappsample_kotlin.views.TodoItemDetailFragment
import tech.tokku_engineer.todoappsample_kotlin.views.TodoListFragment

/**
 * Fragmentの生成、画面遷移のみ行う
 */
class MainActivity : AppCompatActivity() {

    //private val fragmentManager = supportFragmentManager
    // private val fragmentTransaction = fragmentManager.beginTransaction()
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fragment = TodoListFragment()
//        //引数で渡すidはmain_activity.xml内のidである必要がある
////        fragmentTransaction.add(R.id.fragmentContainer, fragment)
////        fragmentTransaction.commit()

        // fragment生成のObserver
        viewModel.navigateToFragment.observe(this, Observer {
            it?.getContentIfNotHandled()?.let { fragmentRequest ->
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.fragmentContainer, fragmentRequest.fragment, fragmentRequest.tag
                )
                if (fragmentRequest.backStack) transaction.addToBackStack(null)
                transaction.commit()
            }
        })
    }
}