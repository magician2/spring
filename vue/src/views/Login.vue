<template>
    <div class="wrapper">
        <div
                style="margin: 100px auto; background-color: #fff; width: 350px;  padding: 20px; border-radius: 10px">

            <div style="margin: 20px 0 40px 0; text-align: center; font-size: 16px">
                <h1>社員管理システム</h1>
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
    background: linear-gradient(0.25turn, #3f87a6, #ebf8e1, #f69d3c);
    overflow: hidden;
}
</style>