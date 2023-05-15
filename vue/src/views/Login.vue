<template>
    <div class="wrapper">
        <div
                style="margin: 100px auto; background-color: #fff; width: 350px;  padding: 20px; border-radius: 10px">

            <div style="margin: 20px 0; text-align: center; font-size: 24px">
                <img src="../assets/23649043.png" width="150"/>
            </div>
            <el-form :model="user" :rules="rules" ref="userForm">
                <el-form-item prop="username">
                    <el-input size="medium" prefix-icon="el-icon-user" v-model="user.username"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input size="medium" prefix-icon="el-icon-lock" show-password
                              v-model="user.password"></el-input>
                </el-form-item>
                <el-form-item style="margin: 10px 0; text-align: right">
                    <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">Sign in</el-button>
                    <el-button type="primary" size="small" autocomplete="off" @click="login">Login</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
import {setRoutes} from "@/router";

export default {
    name: "Login",
    data() {
        return {
            user: {},
            rules: {
                username: [
                    {required: true, message: 'ユーザー名を入力してください', trigger: 'blur'},
                    {min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: 'パスワードを入力してください', trigger: 'blur'},
                    {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
                ],
            }
        }
    },
    methods: {
        login() {
            this.$refs['userForm'].validate((valid) => {
                if (valid) {  // 表单校验合法
                    this.request.post("/user/login", this.user).then(res => {
                        if (res.code === '200') {
                            localStorage.setItem("user", JSON.stringify(res.data))  // 存储用户信息到浏览器
                            localStorage.setItem("menus", JSON.stringify(res.data.menus))  // 存储用户信息到浏览器
                            // 动态设置当前用户的路由
                            setRoutes()
                            this.$message.success("登录成功")

                            if (res.data.role === 'ROLE_STUDENT') {
                                this.$router.push("/front/home")
                            } else {
                                this.$router.push("/")
                            }
                        } else {
                            this.$message.error(res.msg)
                        }
                    })
                }
            });
        }
    }
}
</script>

<style scoped>
.wrapper {
    height: 100vh;
    background: linear-gradient(0.25turn, #3f87a6, #ebf8e1, #f69d3c);
    overflow: hidden;
}
</style>