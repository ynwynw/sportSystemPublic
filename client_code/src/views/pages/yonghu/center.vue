<template>
	<div class="app-contain" :style='{"width":"64%","padding":"0","margin":"0 auto 30px","position":"relative","borderRadius":"20px","background":"#fff"}'>
		<div class="section_title">
			{{formName}}
		</div>
		<div class="usersView">
			<div class="usersTabView">
				<div class="usersTab usersTabActive" @click="tabClick({tableName:'center'})">个人中心</div>
				<div v-for="(item,index) in menuList" :key="index" class="usersTab" @mouseenter="usersTabHover(index)"
					@mouseleave="usersTabLeave">
					{{item.menu}}
					<el-collapse-transition>
						<div class="usersTabHoverView" v-if="usersTabIndex==index">
							<div class="usersTabHoverTab" v-for="(items,indexs) in item.child" @click="tabClick(items)">
								{{items.menu}}</div>
						</div>
					</el-collapse-transition>
				</div>
			</div>
			<div class="usersBox">
				<el-form class="usersForm" ref="userFormRef" :model="userForm" label-width="120px" :rules="rules">
					<el-row>
						<el-col :span="12">
							<el-form-item prop="yonghuzhanghao" label="用户账号">
								<el-input class="list_inp" v-model="userForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="yonghumima" label="用户密码">
								<el-input class="list_inp" v-model="userForm.yonghumima" placeholder="用户密码" type="password"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="yonghuxingming" label="用户姓名">
								<el-input class="list_inp" v-model="userForm.yonghuxingming" placeholder="用户姓名" ></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="touxiang" label="头像">
								<uploads
									action="file/upload" 
									tip="请上传头像" 
									:limit="1" 
									style="width: 100%;text-align: left;"
									:fileUrls="userForm.touxiang?userForm.touxiang:''" 
									@change="touxiangUploadSuccess">
								</uploads>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="性别" prop="xingbie">
								<el-select
									class="list_sel"
									v-model="userForm.xingbie" 
									placeholder="请选择性别"
									style="width:100%;"
									>
									<el-option v-for="(item,index) in xingbieLists" :label="item" :value="item">
									</el-option>
								</el-select>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="shoujihaoma" label="手机号码">
								<el-input class="list_inp" v-model="userForm.shoujihaoma" placeholder="手机号码" ></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="jf" label="积分">
								<el-input class="list_inp" v-model="userForm.jf" placeholder="积分" readonly></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item prop="money" label="余额">
								<div class="vip_item">
									<el-input class="vip_inp" v-model="userForm.money" placeholder="余额" readonly></el-input>
									<el-button class="vip_btn" @click="rechargeClick">点我充值</el-button>
								</div>
							</el-form-item>
						</el-col>
					</el-row>
					<div class="formModel_btn_box">
						<el-button class="formModel_confirm" @click="updateSession">更新信息</el-button>
						<el-button class="formModel_cancel" @click="loginout" type="danger">退出登录</el-button>
					</div>
				</el-form>
			</div>
		</div>
		<el-dialog v-model="rechargeVisible" :title="'用户充值'" width="50%" destroy-on-close class="rechargeDialog">
			<div class="centerPayInpView">
				<el-input class="pay_inp" v-model.number="rechargeForm.money" placeholder="充值金额" :min="1"></el-input>
			</div>
			<div class="centerPayList">
				<div class="centerPayView">
					<el-radio v-model="payType" label="1"><img src="@/assets/pay/weixin.png" alt>微信支付</el-radio>
				</div>
				<div class="centerPayView">
					<el-radio v-model="payType" label="2"><img src="@/assets/pay/zhifubao.png" alt>支付宝支付</el-radio>
				</div>
				<div class="centerPayView">
					<el-radio v-model="payType" label="3"><img src="@/assets/pay/yinhangka.png" alt>银行卡支付<el-icon :class="payType==3?'active':''"><ArrowDown /></el-icon></el-radio>
				</div>
				<el-collapse-transition>
					<div class="yinhang_view" v-show="payType==3">
						<div class="centerPayView">
							<el-radio v-model="payType1" label="1"><img src="@/assets/pay/zhonghang.png" alt>中国银行</el-radio>
						</div>
						<div class="centerPayView">
							<el-radio v-model="payType1" label="2"><img src="@/assets/pay/nongye.png" alt>中国农业银行</el-radio>
						</div>
						<div class="centerPayView">
							<el-radio v-model="payType1" label="3"><img src="@/assets/pay/jianshe.png" alt>中国建设银行</el-radio>
						</div>
						<div class="centerPayView">
							<el-radio v-model="payType1" label="4"><img src="@/assets/pay/gonghang.png" alt>中国工商银行</el-radio>
						</div>
						<div class="centerPayView">
							<el-radio v-model="payType1" label="5"><img src="@/assets/pay/jiaotong.png" alt>交通银行</el-radio>
						</div>
					</div>
				</el-collapse-transition>
				<div class="centerPayView">
					<el-radio v-model="payType" label="4"><img src="@/assets/pay/yunshanfu.png" alt>云闪付</el-radio>
				</div>
			</div>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="rechargeVisible=false">取消</el-button>
					<el-button type="primary" @click="rechargeSave">
						充值
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	import menu from '@/utils/menu'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'yonghu'
	const formName = '个人中心'
	//基础信息
	//个人信息
	const userFormRef = ref(null)
	const userForm = ref({})
	//验证规则
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		yonghuzhanghao: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yonghumima: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		yonghuxingming: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		touxiang: [
		],
		xingbie: [
		],
		shoujihaoma: [
			{ validator: validateMobile, trigger: 'blur' },
		],
		jf: [
			{ validator: validateNumber, trigger: 'blur' },
		],
		money: [
			{ validator: validateNumber, trigger: 'blur' },
		],
	})
	const getSession = () =>{
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method:'get'
		}).then(res=>{
			context?.$toolUtil.storageSet('userid',res.data.data.id)
			context?.$toolUtil.storageSet("frontName", res.data.data.yonghuzhanghao)
			context?.$toolUtil.storageSet('headportrait',res.data.data.touxiang)
			userForm.value = res.data.data
		})
	}
	//菜单跳转
	const tabClick = (item) => {
		if (item.tableName == 'center') {
			return false
		}
		if(item.tableName=='examrecord'&&item.menuJump=='22'){
			router.push(`/index/examfailrecord?centerType=1`)
			return false
		}
		if(item.tableName=='forum'&&item.menuJump=='14'){
			router.push(`/index/forumList?centerType=1&&myType=1`)
			return false
		}
		switch (item.menu) {
			case '我的收藏':
				router.push(`/index/storeupList?centerType=1&&type=1`)
				break;
			default:
				router.push(`/index/${item.tableName}List?centerType=1`)
		}
	}
	//菜单
	const menuList = ref([])
	const role = ref('')
	//头像上传回调
	const touxiangUploadSuccess=(e)=>{
		userForm.value.touxiang = e
	}
	//性别列表
	const xingbieLists = ref([])
	//初始化
	const init = () => {
		const menus = menu.list()
		let arr = []
		let brr = []
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('frontRole')
		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				arr = menuList.value[i].backMenu
				break;
			}
		}
		for(let x in arr){
			if(arr[x].child){
				if(arr[x].child[0].tableName == 'orders'){
					brr = JSON.parse(JSON.stringify(arr[x].child[0]))
					arr[x].child = [brr]
				}
			}
		}
		menuList.value = arr
		xingbieLists.value = "男,女".split(',')
		getSession()
	}
	//菜单悬浮的显示与隐藏
	const usersTabIndex = ref(-1)
	const usersTabHover = (index) => {
		usersTabIndex.value = index
	}
	const usersTabLeave = () => {
		usersTabIndex.value = -1
	}
	//付款方式
	const payType = ref('')
	const payType1 = ref('')
	//充值
	const rechargeVisible = ref(false)
	const rechargeForm = ref({
		money:''
	})
	const rechargeClick = () => {
		payType.value = ''
		payType1.value = ''
		rechargeForm.value = {
			money:''
		}
		rechargeVisible.value = true
	}
	//充值保存
	const rechargeSave = () => {
		if(rechargeForm.value.money==''){
			context?.$toolUtil.message('请输入充值金额','error')
			return false
		}
		if(rechargeForm.value.money<=0){
			context?.$toolUtil.message('请输入正确充值金额','error')
			return false
		}
		if(typeof rechargeForm.value.money !== 'number'){
			context?.$toolUtil.message('请输入正确充值金额','error')
			return false
		}
		if(payType.value==''){
			context?.$toolUtil.message('请选择充值方式','error')
			return false
		}
		if(payType.value==3&&payType1.value==''){
			context?.$toolUtil.message('请选择充值银行','error')
			return false
		}
		let params = JSON.parse(JSON.stringify(userForm.value))
		params.money = parseInt(params.money) + parseInt(rechargeForm.value.money)
		context?.$http({
			url: `${tableName}/update`,
			method: 'post',
			data: params
		}).then(res=>{
			context?.$toolUtil.message('充值成功','success',()=>{
				rechargeVisible.value = false
				getSession()
			})
		})
	}
	//富文本
	const editorChange = (e,name) =>{
		userForm.value[name] = e
	}
	//保存
	const updateSession = () => {
		userFormRef.value.validate((valid)=>{
			if(valid){
				if(userForm.value.touxiang!=null){
					userForm.value.touxiang = userForm.value.touxiang.replace(new RegExp(context?.$config.url,"g"),"");
				}
				context?.$http({
					url: `${tableName}/update`,
					method: 'post',
					data: userForm.value
				}).then(res=>{
					context?.$toolUtil.message('更新成功','success',()=>{
						getSession()
					})
				})
			}
		})
	}
	//退出登录
	const loginout = () => {
		context?.$toolUtil.message('退出成功', 'success')
		context?.$toolUtil.storageClear()
		router.replace('/index/home')
	}
	init()
</script>

<style lang="scss" scoped>
	.usersView {
		padding: 20px;
		margin: 0px 0;
		display: block;
		border-color: #27bacc30;
		flex-wrap: wrap;
		border-radius: 0 0 20px 20px;
		overflow: hidden;
		background: linear-gradient(180deg, rgba(255,255,255,1) 0%, rgba(242,254,255,1) 100%);
		width: 100%;
		justify-content: space-between;
		border-width: 0px 1px 1px;
		align-items: flex-start;
		border-style: solid;

		.usersTabView {
			border: 0px solid #ddd;
			padding: 20px 20px 0;
			margin: 0 0px 0 0;
			background: none;
			display: block;
			width: 250px;
			box-sizing: border-box;
			float: left;
			flex-wrap: wrap;

			.usersTab {
				cursor: pointer;
				padding: 16px 10px;
				margin: 0 10px 0px 0;
				color: #666;
				display: inline-block;
				font-size: 16px;
				border-color: #27bacc30;
				transition: all 0.3s;
				border-radius: 0px;
				background: none;
				width: 100%;
				border-width: 0 0 2px;
				position: relative;
				border-style: solid;
				text-align: center;

				.usersTabHoverView {
					border: 1px solid #f6f6f6;
					padding: 10px 10px 0;
					z-index: 999;
					right: -100%;
					box-sizing: border-box;
					transition: all 0s;
					border-radius: 0px;
					box-shadow: 0 0px 0px rgba(0, 0, 0, .1);
					top: 0px;
					background: #fff;
					width: auto;
					position: absolute;
					min-width: 100%;
					.usersTabHoverTab {
						border: 0px solid #eee;
						border-radius: 4px;
						padding: 0px 0;
						margin: 0 0 10px;
						color: #666;
						background: #fff;
						font-size: 14px;
						line-height: 36px;
						text-align: center;
					}
					.usersTabHoverTab:hover {
						border-radius: 0;
						color: #fff;
						background: #27bacc;
					}
				}
			}
			.usersTab:hover {
				color: #fff;
				background: #27bacc;
				font-size: 16px;
				border-color: #27bacc;
				border-width: 0 0 2px;
				border-style: solid;
			}
			.usersTabActive {
				border-radius: 10px 10px 0 0;
				padding: 16px 10px;
				margin: 0 10px 0px 0;
				color: #fff;
				background: #27bacc;
				display: inline-block;
				width: 100%;
				font-size: 16px;
				border-color: #27bacc;
				border-width: 0 0 2px;
				border-style: solid;
				text-align: center;
			}
		}

		.usersBox {
			border: 0px solid #ddd;
			border-radius: 0px;
			padding: 40px 7%;
			margin: 0px;
			background: none;
			flex: 1;
			width: calc(100% - 250px);
			box-sizing: border-box;
			float: right;
			.usersForm {
				border: 0px solid #eee;
				border-radius: 0px;
				padding: 0;
				background: none;
				// form item
				:deep(.el-form-item) {
					border: 0px solid #eee;
					border-radius: 4px;
					padding: 6px 0;
					margin: 0 2% 20px 0;
					background: none;
					display: flex;
					width: 100%;
					flex-wrap: wrap;
					//label
					.el-form-item__label {
						background: none;
						display: block;
						width: auto;
						min-width: 150px;
						text-align: right;
					}
					// 内容盒子
					.el-form-item__content {
						display: flex;
						width: calc(100% - 150px);
						justify-content: flex-start;
						align-items: center;
						flex-wrap: wrap;
						// 输入框
						.list_inp {
							padding: 0 10px;
							background: none;
							width: auto;
							border-color: #ddd;
							border-width: 0 0 1px;
							line-height: 36px;
							box-sizing: border-box;
							border-style: solid;
							min-width: 100%;
							height: 36px;
							//去掉默认样式
							.el-input__wrapper{
								border: none;
								box-shadow: none;
								background: none;
								border-radius: 0;
								height: 100%;
								padding: 0;
							}
							.is-focus {
								box-shadow: none !important;
							}
						}
						// 下拉框
						.list_sel {
							border-radius: 0;
							padding: 0 10px;
							background: none;
							width: auto;
							border-color: #ddd;
							border-width: 0 0 1px;
							line-height: 36px;
							box-sizing: border-box;
							border-style: solid;
							min-width: 100%;
							//去掉默认样式
							.select-trigger{
								height: 100%;
								.el-input{
									height: 100%;
									.el-input__wrapper{
										border: none;
										box-shadow: none;
										background: none;
										border-radius: 0;
										height: 100%;
										padding: 0;
									}
									.is-focus {
										box-shadow: none !important;
									}
								}
							}
						}
						//图片上传样式
						.el-upload-list  {
							//提示语
							.el-upload__tip {
								margin: 7px 0 0;
								color: #999;
								display: flex;
								font-size: 14px;
								justify-content: flex-start;
								align-items: center;
							}
							//外部盒子
							.el-upload--picture-card {
								border: 1px solid #ddd;
								cursor: pointer;
								border-radius: 0px;
								background: none;
								display: flex;
								width: 150px;
								line-height: 90px;
								justify-content: center;
								align-items: center;
								text-align: center;
								height: 80px;
								//图标
								.el-icon{
									color: #999;
									font-size: 24px;
								}
							}
							.el-upload-list__item {
								border: 1px solid #ddd;
								cursor: pointer;
								border-radius: 0px;
								background: none;
								display: flex;
								width: 150px;
								line-height: 90px;
								justify-content: center;
								align-items: center;
								text-align: center;
								height: 80px;
							}
						}
						.vip_item {
							display: flex;
							align-items: center;
							.vip_inp {
								padding: 0 10px;
								background: none;
								width: auto;
								border-color: #ddd;
								border-width: 0 0 1px;
								line-height: 36px;
								box-sizing: border-box;
								border-style: solid;
								height: 36px;
								//去掉默认样式
								.el-input__wrapper{
									border: none;
									box-shadow: none;
									background: none;
									border-radius: 0;
									height: 100%;
									padding: 0;
								}
								.is-focus {
									box-shadow: none !important;
								}
							}
							.vip_btn {
								border: 0;
								border-radius: 20px;
								padding: 0 20px;
								margin: 0 0 0 6px;
								color: #fff;
								background: #27bacc;
								width: auto;
								line-height: auto;
								height: 34px;
							}
							.vip_btn:hover {
								opacity: 0.8;
							}
						}
					}
				}
			}
		}
		// 按钮盒子
		.formModel_btn_box {
				padding: 0 150px;
				display: flex;
				width: 100%;
				justify-content: flex-start;
				align-items: center;
			.formModel_cancel {
				border: 1px solid #27bacc;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 30px;
				margin: 0 10px 0 0;
				outline: none;
				color: #27bacc;
				background: none;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			.formModel_cancel:hover {
			}
		
			.formModel_confirm {
				border: 0;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 30px;
				margin: 0 20px 0 0;
				outline: none;
				color: #fff;
				background: #27bacc;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
			.formModel_confirm:hover {
				opacity: 0.8;
			}
		}
	}
	:deep(.rechargeDialog) {
		border-radius: 30px;
		.el-dialog__header {
			padding: 0;
		}
		.el-dialog__title {
			padding: 0 46px;
			height: 60px;
			line-height: 60px;
			border-radius: 30px 30px 30px 0;
			display: inline-block;
			color: #fff;
			width: auto;
			background: linear-gradient(120deg, #2891FF 0%, #2B53F0 100%);
		}	
	}
	.centerPayInpView {
		border: 1px solid #d8d8d8;
		border-radius: 10px;
		width: calc(100% - 80px);
		display: flex;
		align-items: center;
		height: 100px;
		justify-content: center;
		margin: 0 40px;
		
		:deep(.pay_inp) {
			width: 60%;
			height: 50px;
			font-size: 30px;
			color: #f00;
			text-align: center;
			border-bottom: 1px solid #d8d8d8;
			.el-input__wrapper {
				border: none;
				box-shadow: none;
				height: 100%;
				color: inherit;
				text-align: center;
			}
			.el-input__inner {
				height: 100%;
				color: inherit;
				text-align: center;
			}
		}
	}
	.centerPayList {
		padding: 40px;
		width: 100%;
		.yinhang_view {
			margin: 0 0 0 60px;
			width: calc(100% - 60px);
			:deep(.is-checked){
				.el-radio__inner {
					background: #f00;
					border-color: #f00;
				}
				.el-radio__label {
					color: #f00;
				}
			}
		}
		.centerPayView {
			width: 100%;
			padding: 20px 0;
			display: flex;
			justify-content: flex-start;
			align-items: center;
			border-bottom: 1px solid #d8d8d8;
			font-size: 18px;
			:deep(.el-radio){
				.el-radio__label{
					display: flex;
					align-items: center;
					img{
						width: 30px;
						margin-right: 6px;
					}
					.el-icon{
						margin-left: 10px;
						transition: all 0.3s;
					}
					.active {
						transform: rotate(180deg);
					}
				}
			}
			
		}
	}
</style>