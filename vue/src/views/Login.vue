<template>
    <div class="wrapper">
        <div style="" class="loginBox">
            <div style=" text-align: center; font-size: 16px;position: relative">
                <div style="position: absolute;left: 100px">社員管理システム</div>
                <img src="../assets/23047578.png" style="height: 250px"/>
            </div>
            <el-form :model="user" :rules="rules" ref="userForm" style="width: 200px;margin: 0 auto">
                <el-form-item prop="username">
                    <el-input size="medium" prefix-icon="el-icon-user" v-model="user.username"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input size="medium" prefix-icon="el-icon-lock" show-password
                              v-model="user.password"></el-input>
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
                    {min: 3, max: 20, message: '四桁のパスワードを入力してください。。', trigger: 'blur'}
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
    display: flex;
    background: linear-gradient(0.25turn, #d9d9d9, #d9d9d9, #8c939d);
    background-size: cover;
    justify-content: center;
    align-items: center;
}
.loginBox{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 700px;
    height: 300px;
    background-color: rgba(255, 255, 255, 0.2);
    overflow: hidden;
    z-index: 10;

}
</style>