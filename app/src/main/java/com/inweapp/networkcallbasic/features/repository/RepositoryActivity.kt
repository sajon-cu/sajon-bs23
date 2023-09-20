package com.inweapp.networkcallbasic.features.repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.inweapp.networkcallbasic.core.extensions.replaceFragment
import com.inweapp.networkcallbasic.databinding.ActivityRepositoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRepositoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryBinding.inflate(layoutInflater)

        setupToolbar()

        if(savedInstanceState == null) {
            replaceFragment(binding.dummyPage, RepositoriesFragment::class.java, null, FRAGMENT_TAG)
        }

        setContentView(binding.root)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    fun <T : Fragment> navigateTo(fragmentClass: Class<T>, arguments: Bundle? = null) {
        supportFragmentManager.beginTransaction()
            // .setCustomAnimations(R.anim.right_in, R.anim.fade_out, R.anim.fade_in, R.anim.right_out)
            .replace(binding.dummyPage.id, fragmentClass, arguments)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        private const val FRAGMENT_TAG = "DummyHomeFragment"
    }
}