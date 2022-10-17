<template>

    <div class="wrapper1" >
        <div style="margin: 0px 0px;width: 200px;height: 20px;padding: 0; border-radius: 10px">
            <div class="demo-image__placeholder" style="margin: 0px 0px;width: 200px;height: 40px;padding: 0px; border-radius: 100px">
                <div class="block">
                </div>
            </div>
        </div>
        <div style="margin: 10px 300px;width: 500px;height: 40px;padding: 20px; border-radius: 10px">
            <div style="margin: 200px 100px">
                <el-carousel height="450px" :interval="1000">
                    <el-carousel-item v-for="item in imgs" :key="item">
                        <img :src="item" alt="" style="width: 100%">
                    </el-carousel-item>
                </el-carousel>
            </div>
        </div>
        <div style="margin: -55px 1070px; background-color: #fff; width: 300px;height: 600px; padding: 20px; border-radius: 20px">
            <div style="margin: 20px 0; text-align: center; font-size: 24px;left: 400px"><b>登 录</b></div>
            <el-form :model="user" :rules="rules" ref="userForm">
                <el-form-item prop="account">
                    <el-input placeholder="请输入账号" size="medium" style="margin: 30px 0" prefix-icon="el-icon-user" v-model="user.account"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input placeholder="请输入密码" size="medium" style="margin: 50px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
                </el-form-item>
                <el-form-item style="margin: 30px 0; text-align: center;left: 400px">
                    <el-button type="primary" size="small"  autocomplete="off" @click="login">登录</el-button>
                    <el-button type="warning" size="small"  autocomplete="off" @click="$router.push('/register')">注册</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>


    export default {
        name: "Login",
        data() {
            return {
               user: {},
                rules: {
                    account: [
                        {required: true, message: '请输入用户账号', trigger: 'blur'},
                        {min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
                    ],

                },


                files: []
            }
        },
        methods: {
            login() {
                this.$refs['userForm'].validate((valid) => {
                    if (valid) {  // 表单校验合法
                        this.request.post("/user/login", this.user).then(res => {
                            if(res.code === '200') {
                                localStorage.setItem("user", JSON.stringify(res.data))  // 存储用户信息到浏览器
                                this.$router.push("/")
                                this.$message.success("登录成功！")
                            } else {
                                this.$message.error(res.msg)
                                console.log(res.msg)
                            }
                        })
                    }
                });
            }
        }
    }
</script>

<style >
    .wrapper1 {
        height: 100vh;
        background:#fff url(../assets/bkg.jpg) top left/1500px 850px no-repeat;
        overflow: hidden;
    }
</style>
