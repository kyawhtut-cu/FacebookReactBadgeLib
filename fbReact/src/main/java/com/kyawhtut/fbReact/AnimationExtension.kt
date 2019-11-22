package com.kyawhtut.lib

import android.view.animation.Animation

fun Animation.animationListener(
    open: Animation.() -> Unit = {},
    end: Animation.() -> Unit = {},
    repeat: Animation.() -> Unit = {}
) {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation) {
            animation.open()
        }

        override fun onAnimationEnd(animation: Animation) {
            animation.end()
        }

        override fun onAnimationStart(animation: Animation) {
            animation.repeat()
        }
    })
}