package com.binish.mvvmdaggeruse.dagger

import com.binish.mvvmdaggeruse.MainActivity
import dagger.Component

@Component
interface AlexaComponent {
    fun inject(app: MainActivity)
}