const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '商品信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'商品信息',
							url:'/index/shangpinxinxiList'
						},
					]
				},
				{
					name: '赛事新闻管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'赛事新闻',
							url:'/index/saishixinwenList'
						},
					]
				},
				{
					name: '广告信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'广告信息',
							url:'/index/guanggaoxinxiList'
						},
					]
				},
				{
					name: '赛事视频管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'赛事视频',
							url:'/index/saishishipinList'
						},
					]
				},
				{
					name: '购物车管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'购物车',
							url:'/index/cartList'
						},
					]
				},
				{
					name: '新闻资讯管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'公告信息',
							url:'/index/newsList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "体育平台网站"
        } 
    }
}
export default config
