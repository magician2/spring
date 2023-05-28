<template>
    <div class="wrapper">
        <div style="" class="loginBox">
            <div class="loginImg">
                <img src="../assets/23047578.png" style="width: 250px"/>
                <div style="display: inline-block;margin: 20px 5px;color: #ffff;font-family: 'PingFang SC';">社員管理</div>
                <div style="color: #ffff;font-family: 'PingFang SC';font-weight: bold;letter-spacing:5px;display: inline">system</div>
            </div>
            <el-form :model="user" :rules="rules" ref="userForm" class="inputBox">
                <el-form-item prop="username" class="loginText">
                    <el-input size="medium" prefix-icon="el-icon-user" v-model="user.username" @keyup.enter.native="login"></el-input>
                </el-form-item>
                <el-form-item prop="password" class="loginText">
                    <el-input size="medium" prefix-icon="el-icon-lock" show-password
                              v-model="user.password" @keyup.enter.native="login"></el-input>
                </el-form-item>
                <el-form-item style="margin: 10px 0; text-align: right">
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
                    {min: 3, max: 10, message: 'ユーザー名の長さが間違っております。', trigger: 'blur'}
                ],
                password: [
                    {required: true, message: 'パスワードを入力してください', trigger: 'blur'},
                    {min: 3, max: 20, message: '四桁のパスワードを入力してください。', trigger: 'blur'}
                ],
            }
        }
    },
    methods: {
        login() {
            this.$refs['userForm'].validate((valid) => {
                if (valid) {
                    this.request.post("/login", this.user).then(res => {
                        if (res.code === '200') {
                            localStorage.setItem("user",JSON.stringify(res.data))
                            this.$router.push("/employee")
                        } else {
                            this.$message.error(res.msg)
                        }
                    })
                }
                else {
                    return false
                }
            })
        }
    }
}
</script>

<style scoped>
.wrapper {
    height: 100vh;
    background: linear-gradient(0.25turn, #d9d9d9, #d9d9d9, #8c939d);
    background-size: cover;
    display:flex;
    justify-content:center;
}
.loginBox{
    margin: 0 auto;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 10;
}
.loginImg{
    width: 300px;
    text-align: center;
    font-size: 16px;
    position: relative;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    background: rgb(140, 197, 255)
}
.inputBox{
    width: 400px;
    height: 300px;
    background-color: rgba(255, 255, 255, 0.2);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
.loginText{
    width: 200px;
    margin: 20px 0;
}
}
</style>