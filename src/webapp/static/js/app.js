$(function () {
    var app_vue = new Vue({
        el:"#app",
        data:function () {
            var phoneValidate = function(rule, value, callback) {
                var reg = /^1[0-9]{10}$/;
                if (value === '') {
                    callback(new Error('请输入电话号码'));
                } else if (!reg.test(value)) {
                    callback(new Error('手机号码格式有误'));
                } else {
                    callback();
                }
            };
            return {
                relations:[
                    {value:'之妻', name:'之妻'},
                    {value:'之女', name:'之女'},
                    {value:'之子', name:'之子'}
                ],
                searchType:'',
                familyIntroContent:'',
                familyName:'',
                sublineName:'',
                news_contnet:'',
                news_title:'',
                news_time:'',
                news_familyName:'',
                // 表示图片为头像类型
                headImg:{
                    type:1
                },
                members_index:[],
                sublines_index:[],
                nations:[],
                sublines:[],
                geneas:[],
                activeNames: ['1'],
                members: [],
                // 我的页面显示
                memberHead:"/static/imgs/man.png",
                memberName:"",
                // 上传参数
                imageUrl:"",
                // 是否登录状态
                isLogin:true,
                formLabelWidth:'120px',
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                subIntroDialog:false,
                // 成员
                dialogFormVisible:false,
                dialogFamilyMemberVisible:false,
                dialogZbVisible:false,
                dialogAgeVisible:false,
                dialogWmVisible:false,
                dialogCodeVisible:false,

                newsDetailDialog:false,
                dialogSignOutVisible:false,
                dialogMemeberVisible:false,
                dialogAddMemeberVisible:false,
                dialogRelationVisible:false,
                dialogZbMessageVisible:false,
                // // 地区选择icon_change
                province:"",
                selectProvince:"",
                cities: [{
                    value: 'Beijing',
                    label: '北京'
                }, {
                    value: 'Shanghai',
                    label: '上海'
                }, {
                    value: 'Nanjing',
                    label: '南京'
                }, {
                    value: 'Chengdu',
                    label: '成都'
                }, {
                    value: 'Shenzhen',
                    label: '深圳'
                }, {
                    value: 'Guangzhou',
                    label: '广州'
                }],
                // 反馈内容
                textarea3:"",
                // 家族相册
                currentDate:new Date(),
                // 加载动画
                loading:false,
                // 个人资料form表单验证
                labelPosition:'left',
                memberPosition:'right',
                memberDetailPosition:'top',
                // 个人资料表单
                userInfoForm: {
                    isFather:'0',
                    memberID:'',
                    memberName: '',
                    memberNation: '',
                    memberIDNumber: '',
                    fatherIDNumber: '',
                    memberPhone: '',
                    memberBirthday: '',
                    memberAddress: '',
                    memberGenealogy: '',
                    memberHead: '',
                    memberSex: '男',
                    memberRelation: ''
                },
                // 添加成员表单
                addMemberForm: {
                    repwd:"",
                    memberName: '',
                    memberSex: '1',
                    memberHead: '',
                    memberBirthday: '',
                    memberIDNumber: '',
                    fatherIDNumber: '',
                    memberNation: '',
                    memberRelation: '',
                    memberGenealogy: '',
                    memberPass: '',
                    memberAddress: '',
                    isFather: '0'
                },
                memberInfoForm: {
                    name: '',
                    phone: '',
                    birthday: '',
                    sex: '男'
                },
                changePassForm: {
                    oldpass: '',
                    newpass: '',
                    repass: '',
                },
                rules: {
                    name: [
                        { required: true, message: '请输入真实姓名', trigger: 'blur' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    famous: [
                        { required: true, message: '请输入名族', trigger: 'blur' }
                    ],
                    usercard: [
                        { required: true, message: '请输入身份证号', trigger: 'blur' }
                    ],
                    generation: [
                        { required: true, message: '请输入身份证号', trigger: 'blur' }
                    ],
                    phone: [
                        { required: true, message: '请输入手机号', trigger: 'blur' },
                        { validator:phoneValidate, trigger: 'blur' }
                    ],
                    oldpass: [
                        { required: true, message: '请输入旧密码', trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ],
                    newpass: [
                        { required: true, message: '请输入新密码', trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ],
                    repass: [
                        { required: true, message: '请确认密码', trigger: 'blur' },
                        { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                    ]
                },
                /******************/
                mylinks:[
                    "家庭成员",
                    // "关系图谱",
                    "字辈谱信息",
                    "个人资料",
                    "修改密码",
                    "问题反馈"
                ],
                myloves:[
                    {imgUrl:"static/imgs/sublineIntro.jpg", id:1},
                ],
                familyCard:[
                    {img:"static/imgs/ml1.jpg", name:'龙洞湾向继耀支系'},
                    {img:"static/imgs/ml1.jpg", name:'龙洞湾向继耀支系'},
                    {img:"static/imgs/ml1.jpg", name:'龙洞湾向继耀支系'},
                    {img:"static/imgs/ml1.jpg", name:'龙洞湾向继耀支系阿德法撒旦法是打发斯蒂芬'}
                ],

                index_text_active:['grid-content', 'activeText'],
                graphic_text_active:['grid-content'],
                user_text_active:['grid-content'],
                group_text_active:['grid-content'],

                index_active:1,
                graphic_active:0,
                user_active:0,
                group_active:0,
                icon_index:[
                    "static/imgs/icon/icon_index.png",
                    "static/imgs/icon/icon_index_blue.png"
                ],
                graphic_index:[
                    "static/imgs/icon/icon_graphic.png",
                    "static/imgs/icon/icon_graphic_blue.png"
                ],
                group_index:[
                    "static/imgs/icon/icon_group.png",
                    "static/imgs/icon/icon_group_blue.png"
                ],
                user_index:[
                    "static/imgs/icon/icon_user.png",
                    "static/imgs/icon/icon_user_blue.png"
                ],
                // 帖子
                posts:[

                ],

                gridData: [],

                sublineData: []

            }
        },
        mounted:function() {
            var _this = this;
            $.ajax({
                type:"POST",
                url:"/subline/sub_list",
                data:{
                    sublineID:sessionStorage.sublineID || localStorage.sublineID,
                    subFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID
                },
                success:function (r) {
                    // console.log(r);
                    _this.geneas = [];
                    _this.form.memberGenealogy = '';
                    var arr = r.data[0].subGelogy.split('');
                    arr.forEach(function (value) {
                        var O = {};
                        O.subGelogy = value;
                        _this.geneas.push(O);
                    })
                },
                error:function () {
                    console.log('家族数据加载失败');
                }
            });

            // 获取轮播图数据
            // $.ajax({
            //     type:"POST",
            //     url:"/img/carousel",
            //     success:function (r) {
            //         // console.log(r);
            //         var imgData = [];
            //         r.forEach(function (v, i) {
            //             // console.log(v);
            //             imgData.push(v);
            //         });
            //         app_vue.myloves = imgData;
            //     },
            //     error:function () {
            //         console.log('轮播图加载失败');
            //     }
            // })

            // 获取民族数据
            $.ajax({
                type:"POST",
                url:"/nation/user_list",
                success:function (r) {
                    // console.log(r);
                    app_vue.nations = r.data;
                },
                error:function () {
                    console.log('民族数据加载失败');
                }
            });

            this.getSublineData();
            this.getMembers();

            // 加载帖子
            $.ajax({
                type:"POST",
                url:"/news/news_list",
                data:{
                    // 家族ID参数
                    newsFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID
                },
                success:function (r) {
                    // console.log(r);
                    app_vue.posts = r.data;
                },
                error:function () {
                    console.log('帖子数据加载失败');
                }
            });

            this.getPeopleByFamilyID(sessionStorage.sublineID || localStorage.sublineID, null);
        },
        methods: {
            // 姓氏介绍
            familyIntro:function () {
                var _this = this;
                this.subIntroDialog = true;
                $.ajax({
                    type:"POST",
                    url:"/family/fa_list",
                    data:{
                        familyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID
                    },
                    success:function (r) {
                        console.log(r);
                        _this.familyIntroContent = r.data[0].familyIntro;
                        _this.familyName = r.data[0].familyName;
                    },
                    error:function () {
                        console.log('家族数据加载失败');
                    }
                });
            },
            getMembers:function() {
                var _this = this;

                $.ajax({
                    type:"POST",
                    url:"/member/me_list",
                    data:{
                        memberFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID,
                        memberName:_this.sublineName
                    },
                    success:function (r) {
                        // console.log(r);
                        _this.members_index = r.data;
                        console.log(_this.members_index);
                    },
                    error:function () {
                        layer.msg('网络错误');
                    }
                });
            },
            // 获取支系数据
            getSublineData:function() {
                var _this = this;
                $.ajax({
                    type:"POST",
                    url:"/subline/sub_list",
                    data:{
                        subFamilyID:sessionStorage.memberFamilyID || localStorage.memberFamilyID,
                        subName:_this.sublineName
                    },
                    success:function (r) {
                        console.log(r);
                        app_vue.sublines_index = [];
                        r.data.forEach(function (v, i) {
                            // console.log(v);
                            _this.getPeopleByFamilyID(v.subID, i, v);
                        });
                        // app_vue.sublines_index = r.data;
                    },
                    error:function () {
                        console.log('支系数据加载失败');
                    }
                });
            },
            // 支系搜索
            searchSubline:function() {
                var _this = this;
                // console.log(_this.searchType);
                switch (_this.searchType) {
                    case '2':
                        _this.getMembers();
                        break;
                    default:
                        _this.getSublineData();
                        break;
                }
            },
            // 显示反馈数据
            showFb:function() {
                var _this = this;
                $.ajax({
                    type:"post",
                    url:"/feedback/fb_list",
                    data:{
                        fbmemberID:sessionStorage.memberID || localStorage.memberID
                    },
                    success:function (r) {
                        console.log(r);
                        _this.gridData = r.data;
                    },
                    error:function () {
                        _this.$message.error('网络错误');
                    }
                })
            },
            // 上传函数
            newMemberSuccess:function(res, file) {
                this.addMemberForm.memberHead = res.data;
            },
            newMemberUpload:function(file) {
                // var isJPG = file.type.contains() ;
                var isJPG = ['image/jpeg', 'image/png'].toString().indexOf(file.type) > -1;
                var isLt2M = file.size / 1024 / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('图片只能是JPG或PNG格式!');
                }
                if (!isLt2M) {
                    this.$message.error('图片大小不能超过200KB!');
                }
                return isJPG && isLt2M;
            },
            handleAvatarSuccessPersonData:function(res, file) {
                this.userInfoForm.memberHead = res.data;
            },
            beforeAvatarUploadPersonData:function(file) {
                // var isJPG = file.type.contains() ;
                var isJPG = ['image/jpeg', 'image/png'].toString().indexOf(file.type) > -1;
                var isLt2M = file.size / 1024 / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('图片只能是JPG或PNG格式!');
                }
                if (!isLt2M) {
                    this.$message.error('图片大小不能超过200KB!');
                }
                return isJPG && isLt2M;
            },
            // 添加成员
            addMemberFunc:function(formname) {
                var _this = this;
                if(_this.addMemberForm.repwd != _this.addMemberForm.memberPass) {
                    this.$message.error('两次输入的密码不相同');
                }
                this.$refs[formname].validate(function (valid) {
                  if(valid) {

                      if (_this.addMemberForm.memberHead == '' || _this.addMemberForm.memberHead == null){
                          if (_this.addMemberForm.memberSex == 1) {
                              _this.addMemberForm.memberHead = "/static/imgs/man.png";
                          }else{
                              _this.addMemberForm.memberHead = "/static/imgs/women.png"
                          }
                      }
                      $.ajax({
                          type:"POST",
                          url:"/member/me_i",
                          data: {
                              memberName: _this.addMemberForm.memberName,
                              memberSex: _this.addMemberForm.memberSex,
                              memberHead:_this.addMemberForm.memberHead,
                              memberPhone: _this.addMemberForm.memberPhone,
                              memberBirthday: _this.addMemberForm.memberBirthday,
                              memberIDNumber: _this.addMemberForm.memberIDNumber,
                              fatherIDNumber: _this.addMemberForm.fatherIDNumber,
                              memberNation: _this.addMemberForm.memberNation,
                              memberRelation: _this.addMemberForm.memberRelation,
                              memberGenealogy: _this.addMemberForm.memberGenealogy,
                              memberPass: _this.addMemberForm.memberPass,
                              memberAddress: _this.addMemberForm.memberAddress,
                              isFather: _this.addMemberForm.isFather,
                              memberFamilyID: sessionStorage.memberFamilyID || localStorage.memberFamilyID,
                              sublineID: sessionStorage.sublineID || localStorage.sublineID
                          },
                          success:function (res) {
                              if(res.code === 200) {
                                  _this.$message({
                                      type:'success',
                                      message:'添加成功'
                                  });
                              }
                          },
                          error:function () {
                              _this.$message.error('添加失败');
                          }
                      });
                  }
                });
            },
            // 底部Bar切换
            icon_change:function (_index) {
                var iconArray = [1, 0, 0, 0];
                var textArray = [this.index_text_active, this.group_text_active, this.graphic_text_active, this.user_text_active];
                for(var i = 0;i < iconArray.length;i++) {
                    iconArray[i] = 0;
                    // 去掉未激活的字体样式
                    if(textArray[i].toString().indexOf('activeText') != -1) {
                        textArray[i].pop('activeText');
                    }
                    // 给字体添加活动样式
                    if(_index == i) {
                        iconArray[i] = 1;
                        textArray[i].push('activeText');
                    }
                }
                this.index_active = iconArray[0];
                this.group_active = iconArray[1];
                this.graphic_active = iconArray[2];
                this.user_active = iconArray[3];

                this.index_text_active = textArray[0];
                this.group_text_active = textArray[1];
                this.graphic_text_active = textArray[2];
                this.user_text_active = textArray[3];

                // 显示对应盒子内容
                if(_index == 3) {
                    $("#xz_main").addClass("my-choose");
                } else {
                    $("#xz_main").removeClass("my-choose");
                }
                $(".content-box:eq(" + _index + ")").addClass("active-box").siblings().removeClass("active-box");

            },
            // 上传函数
            handleAvatarSuccess:function(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload:function(file) {
                // var isJPG = file.type.contains() ;
                var isJPG = ['image/jpeg', 'image/png'].toString().indexOf(file.type) > -1;
                var isLt2M = file.size / 1024 / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('图片只能是JPG或PNG格式!');
                }
                if (!isLt2M) {
                    this.$message.error('图片大小不能超过200KB!');
                }
                return isJPG && isLt2M;
            },
            // 询问是否关闭添加成员页面
            isCloseAddMemeber:function() {
                var _this = this;
                this.$confirm("确认关闭？这会丢失填写的信息！")
                    .then(function () {
                        // dialog确认关闭操作
                        _this.dialogAddMemeberVisible = false;
                        done();
                    }).catch(function () {
                    // dialog取消关闭操作
                });
            },
            // 添加成员
            addMemeber:function() {
                this.dialogAddMemeberVisible = true;
            },
            // 打开帖子详情
            newsDetailDialogFunc:function(item) {
                // 打开帖子详情框
                this.newsDetailDialog = true;
                // 帖子内容赋值
                this.news_contnet = item.newsContent;
                this.news_familyName = item.familyName;
                this.news_time = item.newsTime;
                this.news_title = item.newsTitle;
            },
            // 打开支系成员页面
            branchMember:function(subID) {
                this.dialogFormVisible = true;
                this.getPeopleByFamilyID(subID, null);
            },
            // 打开字辈歌信息页面
            zbMemeber:function(subFamilyID) {
                this.dialogZbVisible = true;
                var _this = this;
                $.ajax({
                    type:"POST",
                    url:"/count/c_index_data",
                    data:{
                        sublineID:subFamilyID,
                        type:4
                    },
                    success:function (r) {
                        console.log(r);
                        var d = r.data;
                        _this.sublineData = [];
                        d.forEach(function (v, i) {
                            var o= {};
                            o.nums = v.nums;
                            o.mgName = v.mgName;
                            _this.sublineData.push(o);
                        });
                    },
                    error:function () {
                        console.error('字辈分布数据获取失败');
                    }
                });
            },
            // 打开年龄分布页面
            ageMemeber:function() {
                this.dialogAgeVisible = true;
                console.log(1);
            },
            // 打开男女比例页面
            wmMemeber:function() {
                this.dialogWmVisible = true;
                console.log(1);
            },
            // 打开标识码页面
            codeMemeber:function() {
                this.dialogCodeVisible = true;
                console.log(1);
            },
            // 跳转登录页面
            goLogin:function () {
                location.href = "login.html";
            },
            // 用户退出
            generaterSignOut:function() {
                this.dialogSignOutVisible = false;
                this.isLogin = true;
                sessionStorage.clear();
                localStorage.clear();
                location.href = "login.html";
                console.log('退出登录操作');
            },
            handleChange:function(val) {
                // console.log(val);
            },
            // 获取家族成员
            getPeopleByFamilyID:function (subID, index, v) {
                var _this = this;
                $.ajax({
                    type:"POST",
                    url:"/member/me_list",
                    data:{
                        sublineID:subID
                    },
                    success:function (r) {
                         // console.log(r);
                        if(r.code == 200) {
                            // 设置每个支系的人数到数组中
                            if(index != null) {
                                v.sublineNumber = r.data.length;
                                app_vue.sublines_index.push(v);
                            }
                            //console.log(sublineNumber);
                            r.data.forEach(function (v, i) {
                                var idNumber = v.memberIDNumber.split(''), newIdNumber = '';
                                for(var i = 0;i < idNumber.length;i++) {
                                    if(i < 5) {
                                        newIdNumber += idNumber[i];
                                    } else {
                                        newIdNumber += '*';
                                    }
                                }
                                v.memberIDNumber = newIdNumber;
                            });
                            _this.members = r.data;
                        }
                        // layer.closeAll();
                    },
                    error:function () {
                        layer.msg('网络错误');
                    }
                });
            },
            // 我的页面点击链接
            myLinksDetail:function (mylink_id, event) {
                var _this = this;
                layui.use(['layer'], function () {
                    var layer = layui.layer;
                    if(!sessionStorage.memberName && !localStorage.memberName) {
                        layer.msg('请先登录');
                        return;
                    }
                    switch (mylink_id) {
                        // 家庭成员
                        case 0:
                            // _this.icon_change(4);
                            _this.dialogFamilyMemberVisible = true;
                            _this.getPeopleByFamilyID(sessionStorage.sublineID || localStorage.sublineID);
                            break;
                        // 关系图谱
                        // case 1:
                        //     _this.dialogRelationVisible = true;
                        //     break;
                        // 字辈歌信息
                        case 1:
                            _this.dialogZbMessageVisible = true;
                            $.ajax({
                                type:"POST",
                                url:"/member/me_my_order_sub",
                                data:{
                                    memberID:sessionStorage.memberFamilyID || localStorage.memberFamilyID
                                },
                                success:function (r) {
                                    console.log(r);
                                    if(r.code == 200) {
                                        _this.sublines = r.data;
                                    }
                                    layer.closeAll();
                                },
                                error:function () {
                                    layer.msg('网络错误');
                                }
                            })
                            break;
                        // 个人资料
                        case 2:
                            // console.log(_this.userInfoForm);
                            if(sessionStorage.memberName || localStorage.memberName) {
                                _this.userInfoForm.memberID = sessionStorage.memberID || localStorage.memberID;
                                _this.userInfoForm.memberName = sessionStorage.memberName || localStorage.memberName;
                                _this.userInfoForm.memberNation = sessionStorage.memberNation || localStorage.memberNation;
                                _this.userInfoForm.memberIDNumber = sessionStorage.memberIDNumber || localStorage.memberIDNumber;
                                _this.userInfoForm.memberPhone = sessionStorage.memberPhone || localStorage.memberPhone;
                                _this.userInfoForm.memberBirthday = sessionStorage.memberBirthday || localStorage.memberBirthday;
                                _this.userInfoForm.memberAddress = sessionStorage.memberAddress || localStorage.memberAddress;
                                _this.userInfoForm.memberGenealogy = sessionStorage.memberGenealogy || localStorage.memberGenealogy;
                                _this.userInfoForm.memberSex = sessionStorage.memberSex || localStorage.memberSex;
                                _this.userInfoForm.memberHead = sessionStorage.memberHead || localStorage.memberHead;
                            }
                            layer.open({
                                title:"个人资料",
                                shadeClose:true,
                                type:1,
                                area:'90%',
                                content:$('#personal_info')
                            });
                            break;
                        // 修改密码
                        case 3:
                            layer.open({
                                title:"修改密码",
                                shadeClose:true,
                                type:1,
                                area:'90%',
                                content:$('#changepass_info')
                            });
                            break;
                        // 问题反馈
                        case 4:
                            layer.open({
                                title:"问题反馈",
                                shadeClose:true,
                                type:1,
                                area:'90%',
                                content:$('#feedback_info')
                            });
                            break;
                    }
                });
            },
            // 保存个人资料
            saveUserInfo:function (form) {
                var l = this;
                this.loading = true;
                setTimeout(function () {
                    l.loading = false;
                }, 2000);
                // 重置用户信息表单branchMember
                // this.$refs['userInfoForm'].resetFields();
                if (l.userInfoForm.memberHead == '' || l.userInfoForm.memberHead == null){
                    if (l.userInfoForm.memberSex == 1) {
                        l.userInfoForm.memberHead = "/static/imgs/man.png";
                    }else{
                        l.userInfoForm.memberHead = "/static/imgs/women.png"
                    }
                }
                $.ajax({
                    type:"POST",
                    url:"/member/me_i",
                    data:{
                        memberID:l.userInfoForm.memberID,
                        isFather:l.userInfoForm.isFather,
                        memberName:l.userInfoForm.memberName,
                        memberNation:l.userInfoForm.memberNation,
                        memberIDNumber:l.userInfoForm.memberIDNumber,
                        fatherIDNumber:l.userInfoForm.fatherIDNumber,
                        memberPhone:l.userInfoForm.memberPhone,
                        memberBirthday:l.userInfoForm.memberBirthday,
                        memberAddress:l.userInfoForm.memberAddress,
                        memberHead:l.userInfoForm.memberHead,
                        memberSex:l.userInfoForm.memberSex,
                        memberRelation:l.userInfoForm.memberRelation,
                        memberGenealogy:l.userInfoForm.memberGenealogy
                    },
                    success:function (r) {
                        // console.log(r);
                        if(r.code == 200) {
                            l.$message({
                                type:'success',
                                message:'资料更新成功'
                            });

                            if(sessionStorage.memberName != null) {
                                sessionStorage.memberName = l.userInfoForm.memberName;
                            } else {
                                localStorage.memberName = l.userInfoForm.memberName;
                            }
                            if(sessionStorage.memberNation != null) {
                                sessionStorage.memberNation = l.userInfoForm.memberNation;
                            } else {
                                localStorage.memberNation = l.userInfoForm.memberNation;
                            }
                            if(sessionStorage.memberIDNumber != null) {
                                sessionStorage.memberIDNumber = l.userInfoForm.memberIDNumber;
                            } else {
                                localStorage.memberIDNumber = l.userInfoForm.memberIDNumber;
                            }
                            if(sessionStorage.memberPhone != null) {
                                sessionStorage.memberPhone = l.userInfoForm.memberPhone;
                            } else {
                                localStorage.memberPhone = l.userInfoForm.memberPhone;
                            }
                            if(sessionStorage.memberBirthday != null) {
                                sessionStorage.memberBirthday = l.userInfoForm.memberBirthday;
                            } else {
                                localStorage.memberBirthday = l.userInfoForm.memberBirthday;
                            }
                            if(sessionStorage.memberAddress != null) {
                                sessionStorage.memberAddress = l.userInfoForm.memberAddress;
                            } else {
                                localStorage.memberAddress = l.userInfoForm.memberAddress;
                            }
                            if(sessionStorage.memberHead != null) {
                                sessionStorage.memberHead = l.userInfoForm.memberHead;
                            } else {
                                localStorage.memberHead = l.userInfoForm.memberHead;
                            }
                            if(sessionStorage.memberGenealogy != null) {
                                sessionStorage.memberGenealogy = l.userInfoForm.memberGenealogy;
                            } else {
                                localStorage.memberGenealogy = l.userInfoForm.memberGenealogy;
                            }

                            if(sessionStorage.memberSex != null) {
                                sessionStorage.memberSex = l.userInfoForm.memberSex;
                            } else {
                                localStorage.memberSex = l.userInfoForm.memberSex;
                            }

                            // 更新我的页面中的头像
                            l.memberHead = l.userInfoForm.memberHead;
                        }
                    },
                    error:function () {
                        l.$message.error('资料更新失败');
                    }
                });
            },
            // 保存反馈信息
            saveFeedback:function() {
                console.log('保存反馈信息');
                layer.closeAll();
                var _this = this;
                $.ajax({
                    type:"post",
                    url:"/feedback/fb_i",
                    data:{
                        fbQuestion:_this.textarea3,
                        fbmemberID:sessionStorage.memberID || localStorage.memberID
                    },
                    success:function (r) {
                        _this.textarea3 = '';
                        if(r.code == 200) {
                            _this.$message({
                                type:"success",
                                message:"发送成功"
                            });
                        }
                    },
                    error:function () {
                        _this.$message.error('网络错误');
                    }
                })
            },
            // 修改密码
            changePassword:function() {
                console.log('修改密码');
                var l = this;
                if(this.changePassForm.newpass != this.changePassForm.repass) {
                    l.$message.error('密码不一致');
                }
                $.ajax({
                    type:"POST",
                    url:"/member/me_u_pwd",
                    data:{
                        memberID:sessionStorage.memberID || localStorage.memberID,
                        memberPhone:sessionStorage.memberPhone || localStorage.memberPhone,
                        memberPass:l.changePassForm.oldpass,
                        newPass:l.changePassForm.newpass
                    },
                    success:function (r) {
                        console.log(r);
                        if(r.code == 200) {
                            l.$message({
                                type:'success',
                                message:'密码修改成功'
                            });
                            layer.closeAll();
                        } else {
                            l.$message.error(r.message);
                        }
                    },
                    error:function () {
                        l.$message.error('密码修改失败');
                    }
                });
            },
            // 支系简介
            memberDetail:function () {
                // 获取家庭成员详情并显示
                // layui.use(['layer'], function () {
                //     var layer = layui.layer;
                //     layer.open({
                //         shadeClose:true,
                //         type:1,
                //         area:'90%',
                //         title:'详情',
                //         content:$('#member_info')
                //     });
                // });
                this.dialogMemeberVisible = true;
            }
        }
    });

    if(sessionStorage.memberName || localStorage.memberName) {
        app_vue.isLogin = false;
        app_vue.memberName = sessionStorage.memberName || localStorage.memberName;
        app_vue.memberHead = sessionStorage.memberHead || localStorage.memberHead || "/static/imgs/man.png";
    } else {
        app_vue.isLogin = true;
        // 未登录时跳转登录页
        location.href = 'login.html';
    }

    // 加载帖子
    // layui.use(['flow'], function () {
    //     var flow = layui.flow;
    //
    //
    //     flow.load({
    //         elem: '#app_index' //指定列表容器
    //         ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
    //             var lis = [];
    //             //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
    //             $.post('/news/news_list', {
    //                 page:page,
    //                 limit: 10
    //             }, function(res){
    //                 console.log(res);
    //                 app_vue.posts = res.data;
    //                 //假设你的列表返回在data集合中
    //                 layui.each(res.data, function(index, item){
    //                     lis.push('<li>'+ item.title +'</li>');
    //                 });
    //
    //                 //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
    //                 //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
    //                 next(lis.join(''), page < res.pages);
    //             });
    //         }
    //     });
    //
    //
    // });
});