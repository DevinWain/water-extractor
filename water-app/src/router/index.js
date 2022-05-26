import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView'
import MyContainer from '@/views/MyContainer'
import UploadView from '@/views/UploadView'
import DownsampleView from '@/views/DownsampleView'
import Otsu1dView from '@/views/Otsu1dView'

Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/*',
  //   redirect: '/404'
  // },
  // {
  //   path: '/404',
  //   component: () => import('@/views/error/404')
  // },
  {
    path: '/',
    component: MyContainer,
    children: [
      {
        path: '/',
        name: 'home',
        component: HomeView
      },
      {
        path: '/upload',
        name: 'upload',
        component: UploadView
      },
      {
        path: '/downsample',
        name: 'downsample',
        component: DownsampleView
      },
      {
        path: '/otsu-1d',
        name: 'otsu-1d',
        component: Otsu1dView
      },
      // {
      //   path: '/setting',
      //   name: 'setting',
      //   meta: {
      //     requireAuth: true
      //   },
      //   component: () => import('@/views/setting/Setting')
      // }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
