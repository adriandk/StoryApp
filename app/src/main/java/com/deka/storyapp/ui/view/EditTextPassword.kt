package com.deka.storyapp.ui.view

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.deka.storyapp.R

class EditTextPassword : AppCompatEditText {

    constructor(context: Context) : super(context) {
        init()
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setHint(R.string.password)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }
    private fun init() {

        addTextChangedListener(object  : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                error = if (s.length < 6) {
                    context.getString(R.string.invalid_password)
                } else {
                    null
                }
            }

            override fun afterTextChanged(s: Editable) {}

        })
    }
}