package com.andrew.architecture

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.andrew.architecture.core.base.BaseActivity
import com.andrew.architecture.services.service.AnalyticsService3
import com.andrew.architecture.services.service.AnalyticsService3One
import com.andrew.architecture.services.service.AnalyticsService3Two
import com.bruce.modulea.RouterTestActivity
import com.bruce.moduleb.hilt.AnalyticsServiceImpl_b
import com.bruce.moduleb.hilt.AnalyticsServiceImpl_b3
import com.bruce.moduleb.hilt.CommonClass_b
import com.bruce.moduleb.hilt.EntryPointHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @Description：App首界面
 *
 * @author Andrew Liu
 * @since 2020/8/2
 */
@AndroidEntryPoint
class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var listAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 传统的设置布局方法，被DataBindingUtil替换
//        setContentView(R.layout.activity_main)

        viewModel = initViewModel(MainViewModel().javaClass)
        listAdapter = MainListAdapter(this)
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        try {
            val field = Toolbar::class.java.getDeclaredField("mNavButtonStyle")
            field.isAccessible = true
            field[findViewById(R.id.action_bar)] = R.style.navButtonStyle
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        // 如果无法识别BR.XXX，你需要Build->Rebuild Project一下
        binding.setVariable(BR.viewClick, this)
        binding.setVariable(BR.mainListAdapter, listAdapter)
        binding.setVariable(BR.mainViewModel, viewModel)

        /**
         * TODO
         * 因为这个事，苦恼了好久，更新了Adapter的数据后，界面不会自动刷新，
         * 很明显notifyDataSetChanged不是想要的，原来是因为没有设置这玩意
         * https://developer.android.com/topic/libraries/data-binding/architecture
         * 看官网的例子，是需要添加binding.setLifecycleOwner(this)的
         */
        binding.lifecycleOwner = this

        // 监听数据变化
        viewModel.dataList2.observe(this, Observer { list ->
            println("test-------observe list:${list.size}")
        })

        // 自定义类，相应的绑定使用方法
//        binding.setVariable(BR.viewClick, ClickProxy())

        // 提前初使化，能够明显加快Flutter页面加载
//        FlutterMainActivity.initEngine(applicationContext)
    }

    /**
     * 自定义类，然后绑定到View中
     */
//    class ClickProxy {
//        fun onClick() {
//            println("test---------")
//        }
//    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnRefresh) {
            viewModel.updateDataList()
            // 给bind设置binding.lifecycleOwner = this后，不需要这个主动notify
            // listAdapter.notifyDataSetChanged()
        } else if (view?.id == R.id.btnGoFlutter) {
//            startActivity(FlutterMainActivity.getIntent(this))
            // 打开热点设置界面
//            val intent = Intent()
//            intent.addCategory(Intent.CATEGORY_DEFAULT)
//            intent.action = "android.intent.action.MAIN"
//            val cn = ComponentName(
//                "com.android.settings",
//                "com.android.settings.Settings\$TetherSettingsActivity"
//            )
//            intent.component = cn
//            startActivity(intent)
        }

        // 无法调用静态方法createDefaultIntent
//        startActivity(FlutterMainActivity.createDefaultIntent(this))
//        println("test---------onClick!")

//        ServiceRegistry.registerService(ServiceReference("modulea", "test"), ModuleAProviderFetcher())
        testHilt()

        startActivity(Intent(this, RouterTestActivity::class.java))
    }

    private fun testHilt() {
        if (analyticsServiceImp_b == null) {
            println("test----in MainActivity AnalyticsServiceImpl_b null!")
        } else {
            System.out.println("test----in MainActivity AnalyticsServiceImpl_b not null:$analyticsServiceImp_b")
            analyticsServiceImp_b?.analytics()
        }

        println("test----########################################################################\n")

        if (analyticsServiceImp_b2 == null) {
            println("test----in MainActivity analyticsServiceImp_b2 null!")
        } else {
            println("test----in MainActivity analyticsServiceImp_b2 AnalyticsService3 not null:$analyticsServiceImp_b2")
            println("test----in MainActivity analyticsServiceImp_b22 AnalyticsService3 not null:$analyticsServiceImp_b22")
            println("test----in MainActivity analyticsServiceImp_b3 class not null:$analyticsServiceImp_b3")
            analyticsServiceImp_b2?.analytics()
        }

        println("test----########################################################################\n")

        CommonClass_b().testInit(" from MainActivity ", applicationContext)

        println("test----########################################################################\n")
//        println("test----in MainActivity analyticsService4:$analyticsService4")
        println("test----in MainActivity EntryPoint analyticsService:${EntryPointHelper.getEntryPoint(applicationContext).analyticsService}")
        println("test----in MainActivity EntryPoint analyticsService3:${EntryPointHelper.getEntryPoint(applicationContext).analyticsService3}")
        println("test----in MainActivity EntryPoint analyticsService3_2:${EntryPointHelper.getEntryPoint(applicationContext).analyticsService3_2}")
//        println("test----in MainActivity analyticsService4:${EntryPointHelper.getEntryPoint(applicationContext).getAnalyticsServiceTest()}")
    }

    @Inject
    // 如果直接是实现类，是可以直接通过@Inject注解，就能够初使化的，但如果是接口，就必须要写Module，告诉如何实例化接口实例
    lateinit var analyticsServiceImp_b: AnalyticsServiceImpl_b

    /**
     * 测试一个接口的两个实例
     */
    @AnalyticsService3One
    @Inject
    // 如果直接是实现类，是可以直接通过@Inject注解，就能够初使化的，但如果是接口，就必须要写Module，告诉如何实例化接口实例
    lateinit var analyticsServiceImp_b2: AnalyticsService3
    @AnalyticsService3Two
    @Inject
    // 测试通过@Provides提供的单例
    lateinit var analyticsServiceImp_b22: AnalyticsService3

    @Inject
    // 没有接口，直接使用实体类的情况，是可以直接使用构造函数进行注入，不需要写@Binds或@Provider的
    lateinit var analyticsServiceImp_b3: AnalyticsServiceImpl_b3
//    @Inject
    // 测试不定义实现的接口，编译时直接报错，未提供provides
//    lateinit var analyticsService4: AnalyticsService4

    // TODO 可以不给Activity添加@AndroidEntryPoint注解，可以直接使用EntryPointHelper.getEntryPoint这种来调用
}