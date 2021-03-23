package com.bruce.modulea;

import androidx.fragment.app.Fragment;

/**
 * @Description: 在项目中，发现有类似基类BaseFragment，在进行Transform扫描的时候，没有扫描到这个类，这里实现一下
 * 看来还是因项目代码有差异，项目中有问题，这里直接这样写BaseFragment，然后继承，是没有问题的
 * // TODO 待追查原因
 * @Date: 2021/3/3 11:44
 */
class BaseFragment extends Fragment {
}
