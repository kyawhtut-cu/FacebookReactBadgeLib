package com.kyawhtut.fbReact

import androidx.annotation.DrawableRes

data class Emoji private constructor(@JvmField @DrawableRes val icon: Int, @JvmField private val type: String) {

    override fun toString(): String {
        return type
    }

    companion object {
        @JvmField
        val LIKE: Emoji = Emoji(R.drawable.ic_facebook_like_react, "Like React")
        @JvmField
        val LOVE: Emoji = Emoji(R.drawable.ic_facebook_love_react, "Love React")
        @JvmField
        val HAHA: Emoji = Emoji(R.drawable.ic_facebook_haha_react, "Haha React")
        @JvmField
        val WOW: Emoji = Emoji(R.drawable.ic_facebook_wow_react, "Wow React")
        @JvmField
        val SAD: Emoji = Emoji(R.drawable.ic_facebook_sad_react, "Sad React")
        @JvmField
        val ANGRY: Emoji = Emoji(R.drawable.ic_facebook_angry_react, "Angry React")

        @JvmStatic
        fun getReactType(type: String): Emoji = when (type.toLowerCase()) {
            "like" -> LIKE
            "love" -> LOVE
            "haha" -> HAHA
            "wow" -> WOW
            "sad" -> SAD
            "angry" -> ANGRY
            else -> throw IllegalArgumentException("$type is not member of like, love, haha, wow, sad, angry")
        }
    }
}
