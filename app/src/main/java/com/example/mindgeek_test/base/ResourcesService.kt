package com.example.mindgeek_test.base

import android.content.Context
import android.content.res.Resources
import com.example.mindgeek_test.base.contract.ResourcesServiceInterface
import javax.inject.Inject

class ResourcesService @Inject constructor(
    private val context: Context
): ResourcesServiceInterface {

    override fun getResources(): Resources {
        return context.resources
    }
}