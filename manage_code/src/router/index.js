	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import discusssaishixinwen from '@/views/discusssaishixinwen/list'
	import news from '@/views/news/list'
	import saishileibie from '@/views/saishileibie/list'
	import address from '@/views/address/list'
	import saishixinwen from '@/views/saishixinwen/list'
	import shangpinxinxi from '@/views/shangpinxinxi/list'
	import storeup from '@/views/storeup/list'
	import users from '@/views/users/list'
	import shangpinfenlei from '@/views/shangpinfenlei/list'
	import yonghu from '@/views/yonghu/list'
	import guanggaoxinxi from '@/views/guanggaoxinxi/list'
	import discussshangpinxinxi from '@/views/discussshangpinxinxi/list'
	import discusssaishishipin from '@/views/discusssaishishipin/list'
	import saishishipin from '@/views/saishishipin/list'
	import orders from '@/views/orders/list'
	import config from '@/views/config/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/discusssaishixinwen',
			name: '赛事新闻评论',
			component: discusssaishixinwen
		}
		,{
			path: '/news',
			name: '公告信息',
			component: news
		}
		,{
			path: '/saishileibie',
			name: '赛事类别',
			component: saishileibie
		}
		,{
			path: '/address',
			name: '地址',
			component: address
		}
		,{
			path: '/saishixinwen',
			name: '赛事新闻',
			component: saishixinwen
		}
		,{
			path: '/shangpinxinxi',
			name: '商品信息',
			component: shangpinxinxi
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/shangpinfenlei',
			name: '商品分类',
			component: shangpinfenlei
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/guanggaoxinxi',
			name: '广告信息',
			component: guanggaoxinxi
		}
		,{
			path: '/discussshangpinxinxi',
			name: '商品信息评论',
			component: discussshangpinxinxi
		}
		,{
			path: '/discusssaishishipin',
			name: '赛事视频评论',
			component: discusssaishishipin
		}
		,{
			path: '/saishishipin',
			name: '赛事视频',
			component: saishishipin
		}
		,{
			path: '/orders',
			name: '订单管理',
			component: orders
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
