package com.chow.autospangridlayoutinrecyclerview.flexbox

import android.content.res.Resources.getSystem
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.chow.autospangridlayoutinrecyclerview.R
import com.chow.autospangridlayoutinrecyclerview.RoundPerfectUtils
import com.chow.autospangridlayoutinrecyclerview.databinding.ActivityMainBinding
import kotlin.math.log

class FlexBoxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FlexBoxViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CHOTAOTEST", "onCreate: "+RoundPerfectUtils.max())
        viewModel = ViewModelProvider(this)[FlexBoxViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            rvContent.apply {
                adapter = ItemAdapter(emptyList())
                viewModel.tempList.observe(this@FlexBoxActivity) {
                    drawToCalWidth(it)
                }
                viewModel.list.observe(this@FlexBoxActivity) {
                    (adapter as ItemAdapter).updateList(it)
                    layoutManager = GridLayoutManager(this@FlexBoxActivity, viewModel.calculateSpanCount()).apply {
                        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                            override fun getSpanSize(position: Int): Int {
                                if (position < it.size) {
                                    Log.d("CHOTAOTEST", "spanCount: ${viewModel.calculateSpanCount()}")
                                    Log.d("CHOTAOTEST", "currentWidth: ${it[position].width}")
                                    Log.d("CHOTAOTEST", "minWidth: ${viewModel.getMinWidthItem()}")
                                    (it[position].width / viewModel.getMinWidthItem()).apply {
                                        Log.d("CHOTAOTEST", "int: ${toFloat()}")
                                        Log.d("CHOTAOTEST", "float: ${(it[position].width).toFloat() / viewModel.getMinWidthItem()}")
                                        return if (toFloat() != (it[position].width).toFloat() / viewModel.getMinWidthItem()) this + 1
                                        else this
                                    }
                                }
                                return 0
                            }
                        }
                    }
                    rlBg.visibility = View.INVISIBLE
                }
            }
        }
        viewModel.getData()
    }

    private fun drawToCalWidth(list: List<TextWidthModel>) {
        var count = 0
        binding.rlBg.run {
            list.map {
                    TextView(this@FlexBoxActivity).run {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        setPadding(20.dp, 20.dp, 20.dp, 20.dp)
                        background = getDrawable(R.color.teal_200)
                        text = it.content
                        addView(this)
                        visibility = View.INVISIBLE
                        post {
                            viewModel.updateListItem(count++, width)
                            removeView(this)
                        }
                    }
            }
        }
    }

    private val Int.dp: Int
        get() = (this * getSystem().displayMetrics.density + 0.5f).toInt()

//    fun scaleUp(view: View) {
//        val scaleUpX = ObjectAnimator.ofFloat(view, View.SCALE_X, 0f, 1f)
//        val scaleUpY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0f, 1f)
//        val fade = ObjectAnimator.ofFloat(view, View.ALPHA, 0f, 1f)
//        val animSet = AnimatorSet()
//        animSet.playTogether(fade, scaleUpX, scaleUpY)
//        animSet.duration = 200
//        animSet.start()
//    }

//    fun appear(view: View) {
//        val anim: Animation = ScaleAnimation(
//            1f, 0f,
//            1f, 1f,
//            Animation.RELATIVE_TO_SELF, 0f,
//            Animation.RELATIVE_TO_SELF, 0f
//        )
//        anim.duration = 200
//        view.startAnimation(anim)
//        anim.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation) {
//                Log.d("CHOTAOTEST", "onAnimationStart: ")
//                view.visibility = View.VISIBLE
//            }
//
//            override fun onAnimationEnd(animation: Animation) {
//                Log.d("CHOTAOTEST", "onAnimationEnd: ")
//                view.visibility = View.GONE
//            }
//
//            override fun onAnimationRepeat(animation: Animation) {}
//        })
//    }
}