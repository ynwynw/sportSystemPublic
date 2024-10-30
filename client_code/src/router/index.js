import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import newsList from '@/views/pages/news/list'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import saishixinwenList from '@/views/pages/saishixinwen/list'
import saishixinwenDetail from '@/views/pages/saishixinwen/formModel'
import saishixinwenAdd from '@/views/pages/saishixinwen/formAdd'
import storeupList from '@/views/pages/storeup/list'
import saishileibieList from '@/views/pages/saishileibie/list'
import saishileibieDetail from '@/views/pages/saishileibie/formModel'
import saishileibieAdd from '@/views/pages/saishileibie/formAdd'
import saishishipinList from '@/views/pages/saishishipin/list'
import saishishipinDetail from '@/views/pages/saishishipin/formModel'
import saishishipinAdd from '@/views/pages/saishishipin/formAdd'
import shangpinfenleiList from '@/views/pages/shangpinfenlei/list'
import shangpinfenleiDetail from '@/views/pages/shangpinfenlei/formModel'
import shangpinfenleiAdd from '@/views/pages/shangpinfenlei/formAdd'
import shangpinxinxiList from '@/views/pages/shangpinxinxi/list'
import shangpinxinxiDetail from '@/views/pages/shangpinxinxi/formModel'
import shangpinxinxiAdd from '@/views/pages/shangpinxinxi/formAdd'
import cartList from '@/views/pages/shop_order/cart'
import addressList from '@/views/pages/shop_address/list'
import guanggaoxinxiList from '@/views/pages/guanggaoxinxi/list'
import guanggaoxinxiDetail from '@/views/pages/guanggaoxinxi/formModel'
import guanggaoxinxiAdd from '@/views/pages/guanggaoxinxi/formAdd'
import menuList from '@/views/pages/menu/list'
import menuDetail from '@/views/pages/menu/formModel'
import menuAdd from '@/views/pages/menu/formAdd'
import discusssaishixinwenList from '@/views/pages/discusssaishixinwen/list'
import discusssaishixinwenDetail from '@/views/pages/discusssaishixinwen/formModel'
import discusssaishixinwenAdd from '@/views/pages/discusssaishixinwen/formAdd'
import discusssaishishipinList from '@/views/pages/discusssaishishipin/list'
import discusssaishishipinDetail from '@/views/pages/discusssaishishipin/formModel'
import discusssaishishipinAdd from '@/views/pages/discusssaishishipin/formAdd'
import discussshangpinxinxiList from '@/views/pages/discussshangpinxinxi/list'
import discussshangpinxinxiDetail from '@/views/pages/discussshangpinxinxi/formModel'
import discussshangpinxinxiAdd from '@/views/pages/discussshangpinxinxi/formAdd'
import order_confirm from '@/views/pages/shop_order/confirm'
import ordersList from '@/views/pages/shop_order/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'saishixinwenList',
			component: saishixinwenList
		}, {
			path: 'saishixinwenDetail',
			component: saishixinwenDetail
		}, {
			path: 'saishixinwenAdd',
			component: saishixinwenAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'saishileibieList',
			component: saishileibieList
		}, {
			path: 'saishileibieDetail',
			component: saishileibieDetail
		}, {
			path: 'saishileibieAdd',
			component: saishileibieAdd
		}
		, {
			path: 'saishishipinList',
			component: saishishipinList
		}, {
			path: 'saishishipinDetail',
			component: saishishipinDetail
		}, {
			path: 'saishishipinAdd',
			component: saishishipinAdd
		}
		, {
			path: 'shangpinfenleiList',
			component: shangpinfenleiList
		}, {
			path: 'shangpinfenleiDetail',
			component: shangpinfenleiDetail
		}, {
			path: 'shangpinfenleiAdd',
			component: shangpinfenleiAdd
		}
		, {
			path: 'shangpinxinxiList',
			component: shangpinxinxiList
		}, {
			path: 'shangpinxinxiDetail',
			component: shangpinxinxiDetail
		}, {
			path: 'shangpinxinxiAdd',
			component: shangpinxinxiAdd
		}
		, {
			path: 'cartList',
			component: cartList
		}
		, {
			path: 'addressList',
			component: addressList
		}
		, {
			path: 'guanggaoxinxiList',
			component: guanggaoxinxiList
		}, {
			path: 'guanggaoxinxiDetail',
			component: guanggaoxinxiDetail
		}, {
			path: 'guanggaoxinxiAdd',
			component: guanggaoxinxiAdd
		}
		, {
			path: 'menuList',
			component: menuList
		}, {
			path: 'menuDetail',
			component: menuDetail
		}, {
			path: 'menuAdd',
			component: menuAdd
		}
		, {
			path: 'discusssaishixinwenList',
			component: discusssaishixinwenList
		}, {
			path: 'discusssaishixinwenDetail',
			component: discusssaishixinwenDetail
		}, {
			path: 'discusssaishixinwenAdd',
			component: discusssaishixinwenAdd
		}
		, {
			path: 'discusssaishishipinList',
			component: discusssaishishipinList
		}, {
			path: 'discusssaishishipinDetail',
			component: discusssaishishipinDetail
		}, {
			path: 'discusssaishishipinAdd',
			component: discusssaishishipinAdd
		}
		, {
			path: 'discussshangpinxinxiList',
			component: discussshangpinxinxiList
		}, {
			path: 'discussshangpinxinxiDetail',
			component: discussshangpinxinxiDetail
		}, {
			path: 'discussshangpinxinxiAdd',
			component: discussshangpinxinxiAdd
		}
		, {
			path: 'order_confirm',
			component: order_confirm
		}
		, {
			path: 'ordersList',
			component: ordersList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
