<template>
    <div>
        <div class="pd-10 ml-5" style="margin: 20px 0;">
            <div>
                <el-input style="width: 200px;margin: 0 5px"
                          v-model="search" @keyup.enter.native="load" clearable></el-input>
                <el-button type="primary" @click="load" icon="el-icon-search">検索</el-button>
                <el-button class="ml-5" type="primary" @click="reset" icon="el-icon-refresh-left">クリア</el-button>
            </div>
        </div>
        <div style="margin: 10px 10px">
            <el-button type="primary" @click="handleAdd" icon="el-icon-plus">新規登録</el-button>
            <el-button type="primary" @click="downLoad" icon="el-icon-download">CSVダウンロード</el-button>
        </div>
        <div style="text-align: right">
            <el-button @click="cloumnChange" :icon="cardChange ? 'el-icon-menu': 'el-icon-tickets'" style=""></el-button>
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" v-if="cardChange">
            <el-table-column prop="id" label="社員番号" width="100" sortable >
            </el-table-column >
            <el-table-column prop="name" label="名前" width="200" sortable>
            </el-table-column>
            <el-table-column prop="gender" label="性別" sortable width="100" sortable>
            </el-table-column>
            <el-table-column prop="department" label="部署" width="120" sortable>
            </el-table-column>
            <el-table-column prop="mail" label="メールアドレス" sortable>
            </el-table-column>
            <el-table-column prop="phone" label="電話番号" width="120" sortable>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template  slot-scope="scope">
                    <el-button type="success" @click="handleEdit(scope.row)" icon="el-icon-edit">編集</el-button>
                    <el-popconfirm
                        class="ml-5"
                        confirm-button-text='はい'
                        cancel-button-text='いいえ'
                        icon="el-icon-info"
                        icon-color="red"
                        title="この情報は削除でよろしいでしょうか？"
                        @confirm="handleDelete(scope.row.id)"
                    >
                        <el-button type="danger"  slot="reference" icon="el-icon-delete">削除</el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <el-row :gutter="20" v-if="!cardChange">
            <el-col :span="7" v-for="item in tableData" :key="item.id"
                    style="margin: 20px 15px;text-align: center" v-on:mouseover.native="cardOver(item)" v-on:mouseleave.native="cardLeave(item)">
                <el-card :body-style="{ padding: '10px',background: 'rgb(239, 242, 245)' }" shadow="hover" >
                    <img :src="item.imgurl" class="image" style="width: 70% ;height: 60%">
                    <div style="padding: 10px;display: flex;flex-direction: column">
                        <small >NO.{{item.id}}</small>
                        <span class="mt-5">{{item.department}}</span>
                        <span class="mt-5">{{item.name}}</span>
                        <div class="mt-5">
                            <el-button type="success" @click="handleEdit(item)" icon="el-icon-edit">編集</el-button>
                            <el-popconfirm
                                confirm-button-text='はい'
                                cancel-button-text='いいえ'
                                icon="el-icon-info"
                                icon-color="red"
                                title="この情報は削除でよろしいでしょうか？"
                                @confirm="handleDelete(item)"
                            >
                                <el-button type="danger"  slot="reference" icon="el-icon-delete">削除</el-button>
                            </el-popconfirm>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>


        <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible" width="70%" size="small"
                   @close="closeDialog"
                   @open="openDialog"
                   :close-on-click-modal="false">
            <el-tabs v-model="dialogActiveName" @tab-click="">
                    <el-form :model="form" :rules="rules" ref="form" class="demo-ruleForm" label-width="130px" label-position="top">
                        <el-tabs v-model="activeName">
                            <el-tab-pane label="基本情報" name="first">
                            <div style="" class="dialogBox">
                                <h1>基本情報</h1>
                                <el-upload
                                    class="avatar-uploader"
                                    action="http://localhost:9090/file/upload"
                                    :show-file-list="false"
                                    :on-success="handleAvatarSuccess"
                                    style="width: 200px;margin: 0 auto;"
                                >
                                    <img v-if="imgIf" :src="form.imgurl" class="avatar">
                                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                </el-upload>
                                <el-form-item label="名前"  prop="name" class="input_box">
                                    <el-input  autocomplete="off" v-model="form.name"></el-input>
                                </el-form-item>
                                <el-form-item label="性別" prop="gender" class="input_box">
                                    <el-radio-group v-model="form.gender">
                                        <el-radio-button label="男性"></el-radio-button>
                                        <el-radio-button label="女性"></el-radio-button>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item label="生年月日"  prop="date" class="input_box">
                                    <div class="block">
                                        <el-date-picker
                                            v-model="form.date"
                                            type="date"
                                            placeholder="生年月日選択">
                                        </el-date-picker>
                                    </div>
                                </el-form-item>
                                <el-form-item label="部署"  prop="department" class="input_box">
                                    <el-select  placeholder="部署を選んでください"  v-model="form.department">
                                        <el-option label="SS事業部" value="SS事業部"></el-option>
                                        <el-option label="営業部" value="営業部"></el-option>
                                        <el-option label="製品開発事業部" value="製品開発事業部"></el-option>
                                        <el-option label="管理部" value="管理部"></el-option>
                                        <el-option label="品質管理部" value="品質管理部"></el-option>
                                        <el-option label="インバウンド事業部" value="インバウンド事業部"></el-option>
                                        <el-option label="情報システム管理部" value="情報システム管理部"></el-option>
                                    </el-select>
                                </el-form-item>
                            </div>
                            </el-tab-pane>
                            <el-tab-pane label="連絡先" name="second">
                            <div class="dialogBox">
                                <h1>連絡先</h1>
                                <el-form-item label="メールアドレス" prop="mail" class="input_box">
                                    <el-input  autocomplete="off" v-model="form.mail"></el-input>
                                </el-form-item>
                                <el-form-item label="電話番号(ハイフン - なし)"  prop="phone" class="input_box">
                                    <el-input  autocomplete="off" v-model="form.phone" @blur="checkBlur($event)"></el-input>
                                </el-form-item>
                            </div>
                            </el-tab-pane>
                            <el-tab-pane label="住所" name="third">
                                <div class="dialogBox">
                                    <h1>住所</h1>
                                    <el-form-item label="郵便番号(ハイフン - なし)" prop="zipcode" class="input_box">
                                        <el-input v-model="form.zipcode"></el-input>
                                        <el-button style="font-size: 12px" class="ml-5" @click="addCheck">郵便番号から住所を検索</el-button>
                                    </el-form-item>
                                    <el-form-item label="住所" class="input_box">
                                        <el-input  v-model="form.address" clearable></el-input>
                                    </el-form-item>
                                </div>
                            </el-tab-pane>
                                <el-tab-pane label="その他" name="fourth">
                                    <div class="dialogBox">
                                    <h1>その他</h1>
                                    <el-form-item label="趣味" class="input_box">
                                        <el-input  autocomplete="off" v-model="form.hobby"></el-input>
                                    </el-form-item>
                                    <el-form-item label="最終学歴"  class="input_box">
                                        <el-input  autocomplete="off" v-model="form.academic"></el-input>
                                    </el-form-item>
                                    </div>
                                </el-tab-pane>
                        </el-tabs>
                    </el-form>
            </el-tabs>

            <div slot="footer" class="dialog-footer">
                <el-button @click="closeDialog">キャンセル</el-button>
                <el-button type="primary" @click="save('form')">登録</el-button>
            </div>
        </el-dialog>
        <div style="padding: 10px">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[4, 6, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
                style="width: 200px;margin: 0 auto"
            >
            </el-pagination>
        </div>
    </div>
</template>
<script>
import {defineComponent} from 'vue'
import axios from "axios";
export default defineComponent({
    name: "Employee",
    data(){
        return{
            selectValue:"",
            activeName: 'first',
            tableData: [],
            info :{},
            form:{address: ''},
            dialogTitle:"",
            total:0,
            pageNum : 1,
            pageSize:10,
            name:"",
            department: "",
            gender: "",
            date :"",
            hobby:"",
            mail:"",
            phone:"",
            academic:"",
            address:"",
            imgurl:"",
            zipcode:"",
            address1:"",
            address2:"",
            address3:"",
            address4:"",
            postaddress:"",
            search:"",
            dialogActiveName: 'second',
            dialogFormVisible: false,
            headerBg: 'headerBg',
            imgIf: false,
            cardChange:false,
            cloumnIcon:"el-icon-menu",
            cardOverAction:false,
            //必須項目のルール
            rules: {
                name: [
                    { required: true, message: '名前を入力してください', trigger: 'blur' },
                ],
                date: [
                    { required: true, message: '生年月日を選択してください', trigger: 'blur' },
                ],
                zipcode: [
                    { required: true, message: '郵便番号を入力してください', trigger: 'blur' },
                    { pattern:/^[0-9]{7}$/, message: '正しい郵便番号を入力してください', trigger: 'blur' }
                ],
                phone:[
                    { required: true, message: '電話番号を入力してください', trigger: 'blur' },
                    { pattern:/^0[789]0[0-9]{4}[0-9]{4}$/, message: '正しい電話番号を入力してください', trigger: 'blur' }
                    ///^1[0-9]{10}$/
                ],
                department: [
                    { required: true, message: '部署を選んでください', trigger: 'blur' },
                ],
                gender: [
                    { required: true, message: '性別を選んでください', trigger: 'blur' },
                ],
                mail:[
                    { required: true, message: 'メールアドレスを入力してください', trigger: 'blur' },
                    { pattern:/^[a-zA-Z0-9_+-]+(.[a-zA-Z0-9_+-]+)*@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\.)+[a-zA-Z]{2,}$/, message: '正しいメールアドレスを入力してください', trigger: 'blur' }
                    ///^1[0-9]{10}$/
                ],
            }
        }
    },
    created() {
        this.load()
        this.attendanceLoad()
    },
    mounted() {
    },

    methods:{
        cloumnChange(){
            this.cardChange = !this.cardChange
        },
        cardOver(item){
            this.cardOverAction = true
        },
        cardLeave(){
            this.cardOverAction = false;
        },
        downLoad(){
            window.open("http://localhost:9090/employeedata/export")

        },
        //郵便番号APIの処理
        addCheck(){
            //入力欄の中がnullなのか判断
            if(this.form.zipcode)
                axios.get('https://zipcloud.ibsnet.co.jp/api/search?', {
                    params:{
                        //入力した郵便番号をapiに参照しデータを取る
                        zipcode: this.form.zipcode
                    }}).then(res=>{
                    this.info = res.data.results
                    //配列の中身は 例：address1　:"埼玉県":address2:"ふじみ野市"address3:"上福岡"　の形式
                    console.log(this.info)
                    this.address1 = this.info[0].address1
                    this.address2 = this.info[0].address2
                    this.address3 = this.info[0].address3
                    this.postaddress = this.address1 + this.address2 + this.address3
                    //住所のフォームが空である場合中に郵便番号から得た住所を入れる
                    if(this.form.address === '') {
                        this.form.address = this.postaddress
                    }else {
                        this.form.address = ''
                        this.form.address = this.postaddress
                    }
                    //强制渲染
                    this.$forceUpdate();
                })
        },

        //form更新の処理
        save(form){
            this.$refs.form.validate((valid) => {
                if(valid){
                    this.request.post("/employeedata",this.form).then(res=>{
                        if(res.data){
                            this.$message.success("登録完了")
                        }
                        this.load()
                        this.dialogFormVisible = false
                    })
                }else{
                    this.$message.error("まだ入力してない情報があります")
                }
            })
        },
        openDialog(){
            if(this.form.imgurl){
                this.imgIf = true
            }else {
                this.imgIf = false
            }
        },
        closeDialog(){
            this.dialogFormVisible = false
            this.load()
            this.activeName = 'first'
        },
        //編集処理
        handleEdit(row){
            this.form = row
            this.dialogFormVisible = true
            this.dialogTitle = "編集"
        },
        //新規登録処理
        handleAdd(row){
            this.form = row
            this.form = {address: ''}
            this.dialogFormVisible = true
            this.dialogTitle= "新規登録"
        },
        //削除処理
        handleDelete(id){
            this.request.delete("/employeedata/" + id).then(res=>{
                if(res.data){
                    this.$message.success("削除完成しました")
                }else {
                    this.$message.error("削除が完成していません")
                }
                this.load()
            })
        },
        //画像アップロード処理
        handleAvatarSuccess(res){
            this.form.imgurl = res;
            if(this.form.imgurl){
                this.imgIf = true
                this.$forceUpdate();
            }
            else {
            }
        },
        //createdでブラウザが起動前に中のデータを引っ張ってくる
        load(){
            this.request.get("/employeedata/page?",{
                params:{
                    pageNum: this.pageNum,
                    pageSize:this.pageSize,
                    name:this.name,
                    department: this.department,
                    gender:this.gender,
                    date:this.date,
                    hobby:this.hobby,
                    mail:this.mail,
                    phone:this.phone,
                    academic:this.academic,
                    //バックエンドから曖昧検索を処理する
                    search:this.search
                }
            }).then(res => {
                    this.tableData = res.data.records
                    this.total = res.data.total
                }
            )
        },
        attendanceLoad(){
            this.request.get("/attendance/page?",{
                params:{
                    pageNum:1,
                    pageSize:10000
                }
            }).then(res => {
                    // this.tableData = res.data.records
                    // this.total = res.data.total
                    console.log(res)
                }
            )
        },
        //検索欄リセット
        reset(){
            this.name = ""
            this.department = ""
            this.gender = ""
            this.hobby = ""
            this.mail= ""
            this.phone = ""
            this.academic = ""
            this.address = ""
            this.search = ""
            this.load()
        },
        //ページネーション
        handleCurrentChange(pageNum){
            console.log("Num",pageNum)
            this.pageNum = pageNum
            this.load()
        },
        //ページネーション
        handleSizeChange(pageSize){
            this.pageSize = pageSize
            console.log(pageSize)
            this.load()
        },

    }
})
</script>
<style>
.headerBg{
//background: #83c5be!important;
    text-align: center!important;

}
.el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}
.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}
.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 200px;
    height: 200px;
    line-height: 200px;
    text-align: center;
}
.avatar {
    max-width: 100%;
    max-height: 100%;
    display: block;
}
.input_box{

}
.el-form-item__label{
    padding: 0px!important;
}
.el-input__inner{
    border: none;
    border-radius: 0px;
    border-bottom: 0.5px solid #8c939d;
}
.dialogBox{
    border: 2px solid #d9d9d9;
    margin: 15px 0;
    border-radius: 10px;
    box-sizing: border-box;
    padding: 30px 40px;
}
.dialogBox h1{
    margin-bottom: 5px;
}
</style>