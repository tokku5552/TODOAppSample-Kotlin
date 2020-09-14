package tech.tokku_engineer.todoappsample_kotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.realm.Realm
import io.realm.RealmConfiguration
import tech.tokku_engineer.todoappsample_kotlin.utils.MyRealmMigration
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.MainActivityViewModel
import tech.tokku_engineer.todoappsample_kotlin.views.TodoListFragment

/**
 * Fragmentの生成、画面遷移のみ行う
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

        val fragment = TodoListFragment.newInstance()
        viewModel.showFragment(fragment)
    }


}