package com.kyawhtut.fbReact

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.FrameLayout
import androidx.core.content.res.use
import com.kyawhtut.lib.animationListener
import com.kyawhtut.lib.invisible
import com.kyawhtut.lib.visible
import kotlinx.android.synthetic.main.react_layout.view.*
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class ReactBadge : FrameLayout {

    companion object {
        private val DEFAULT_TEXT_COLOR: Int = Color.parseColor("#3f51b5")
        private const val DEFAULT_TEXT_SIZE: Float = 16f
        private const val DEFAULT_REACT_COUNT: Int = 0
        private const val DEFAULT_ANIMATION_ENABLED = true
        private const val DEFAULT_ANIMATION_DURATION: Long = 500
        private const val DEFAULT_NUMBER_CONVERT_ENABLED = false
        private val DEFAULT_REACT_ICON: Emoji = Emoji.LIKE
    }

    private var update: Animation? = null
    private var show: Animation? = null
    private var hide: Animation? = null
    private var isBadgeShown: Boolean = true
    private val reactValue: String
        get() = if (isNumberConvertEnabled)
            convertToK(reactCount) else
            "$reactCount"

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        addView(LayoutInflater.from(context).inflate(R.layout.react_layout, this, false))
        val a = context.obtainStyledAttributes(attrs, R.styleable.ReactBadge, defStyleAttr, 0)
        a.use {
            with(it) {
                animationDuration =
                    getInt(
                        R.styleable.ReactBadge_animationDuration,
                        DEFAULT_ANIMATION_DURATION.toInt()
                    ).toLong()
                animationEnabled =
                    getBoolean(R.styleable.ReactBadge_animationEnabled, DEFAULT_ANIMATION_ENABLED)
                textColor = getColor(R.styleable.ReactBadge_textColor, DEFAULT_TEXT_COLOR)
                react = Emoji.getReactType(
                    context.resources.getStringArray(R.array.reaction)[getInt(
                        R.styleable.ReactBadge_srcReact,
                        0
                    )]
                )
                isNumberConvertEnabled = getBoolean(
                    R.styleable.ReactBadge_enableNumberConvert,
                    DEFAULT_NUMBER_CONVERT_ENABLED
                )
                textSize = getDimensionPixelSize(
                    R.styleable.ReactBadge_textSize, dp2Px(
                        DEFAULT_TEXT_SIZE
                    ).toInt()
                ).toFloat()
                reactCount = getInt(R.styleable.ReactBadge_reactCount, DEFAULT_REACT_COUNT)
            }
        }
    }

    @JvmField
    var animationDuration = DEFAULT_ANIMATION_DURATION
    var animationEnabled = DEFAULT_ANIMATION_ENABLED
        set(value) {
            field = value
            if (value && (update == null || show == null || hide == null)) {
                initUpdateAnimation()
            }
        }
    var react = DEFAULT_REACT_ICON
        set(value) {
            field = value
            iv_react.setImageResource(value.icon)
            if (isBadgeShown) react_container.startAnimation(update)
        }
    var textColor = DEFAULT_TEXT_COLOR
        set(value) {
            field = value
            tv_react_count.setTextColor(value)
        }
    var textSize = dp2Px(DEFAULT_TEXT_SIZE)
        set(value) {
            field = value
            tv_react_count.setTextSize(TypedValue.COMPLEX_UNIT_PX, value)
        }
    var reactCount = DEFAULT_REACT_COUNT
        set(value) {
            field = value
            tv_react_count.text = reactValue
            if (value == 0) clear() else processReactCount()
        }
    var isNumberConvertEnabled = DEFAULT_NUMBER_CONVERT_ENABLED
        set(value) {
            field = value
            tv_react_count.text = reactValue
        }

    private fun processReactCount() {
        if (isBadgeShown) {
            if (animationEnabled) {
                react_container.startAnimation(update)
            }
        } else {
            show()
        }
    }

    fun show() {
        if (!isBadgeShown) {
            react_container.apply {
                if (animationEnabled) startAnimation(show) else visible()
            }
            isBadgeShown = true
        }
    }

    fun clear() {
        if (isBadgeShown) {
            react_container.apply {
                if (animationEnabled) startAnimation(hide) else invisible()
            }
            isBadgeShown = false
        }
    }

    private fun initUpdateAnimation() {
        update = ScaleAnimation(
            1f,
            0.8f,
            1f,
            0.8f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        update?.apply {
            duration = animationDuration / 2
            repeatMode = Animation.REVERSE
            repeatCount = 1
            animationListener {
            }
        }

        show = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        show?.apply {
            duration = animationDuration / 2
            animationListener {
                react_container.visible()
            }
        }

        hide = ScaleAnimation(
            1f,
            0f,
            1f,
            0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        hide?.apply {
            duration = animationDuration / 2
            animationListener {
                react_container.invisible()
            }
        }
    }

    private fun convertToK(number: Int): String {
        val suffix = charArrayOf(' ', 'K', 'M', 'B', 'T', 'P', 'E')
        return with(floor(log10(number.toDouble())).toInt()) {
            val base: Int = this / 3
            if (this >= 3 && base < suffix.size) {
                DecimalFormat("#0.0").format(
                    number / 10.0.pow(base * 3)
                ) + suffix[base]
            } else DecimalFormat("#,##0").format(number)
        }
    }

    private fun dp2Px(value: Float): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics
    )
}