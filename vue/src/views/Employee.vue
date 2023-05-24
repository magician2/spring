<template>
<div>
    <div class="pd-10 ml-5" style="margin: 20px 0;">
        <div>
            <el-select  placeholder="検索範囲を選んでください"  v-model="selectValue" style="margin: 0 5px" @change="selected">
                <el-option label="名前" value="name"></el-option>
                <el-option label="部署" value="department"></el-option>
                <el-option label="性別" value="gender"></el-option>
                <el-option label="電話番号" value="phone"></el-option>
                <el-option label="最終履歴" value="academic"></el-option>
                <el-option label="メールアドレス" value="mail"></el-option>
                <el-option label="住所" value="address"></el-option>
            </el-select>
            <el-input style="width: 200px;margin: 0 5px"
                      suffix-icon="el-icon-caret-bottom"
                      v-model="name"></el-input>
            <el-button type="primary" @click="load" icon="el-icon-search">検索</el-button>
            <el-button class="ml-5" type="primary" @click="reset" icon="el-icon-refresh-left">クリア</el-button>
        </div>
        <el-collapse  accordion style="width: 400px">
            <el-collapse-item title="" name="1" title="条件絞り込み" style="">
                    <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="住所" v-model="address"></el-input>
            </el-collapse-item>
        </el-collapse>
<!--        <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="年齢" v-model="age"></el-input>-->
<!--        <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="生年月日" v-model="date"></el-input>-->
<!--        <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="趣味" v-model="hobby"></el-input>-->
<!--        <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="最終履歴" v-model="academic"></el-input>-->
<!--        <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="メールアドレス" v-model="mail"></el-input>-->
<!--        <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="電話番号" v-model="phone"></el-input>-->
    </div>
    <div style="margin: 10px 0">
        <el-button type="primary" @click="handleAdd" icon="el-icon-plus">新規登録</el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
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
    <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible" width="70%" size="small"
               @close="closeDialog"
               @open="openDialog"
               :close-on-click-modal="false">
        <el-form :model="form" :rules="rules" ref="form" class="demo-ruleForm" label-width="130px">
            <el-row :gutter="12">
                <el-col :span="6">
                    <el-upload
                        class="avatar-uploader"
                        action="http://localhost:9090/file/upload"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        style="width: 200px;text-align: center"
                    >
                        <img v-if="imgIf" :src="form.imgurl" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-col>
                <el-col :span="3" :offset="3">
                    <el-form-item label="名前"  prop="name">
                        <el-input  autocomplete="off" v-model="form.name"></el-input>
                    </el-form-item>
                    <p>{{form.name}}</p>
                    <el-form-item label="性別" prop="gender">
                        <el-select  placeholder="性別を選んでください"  v-model="form.gender">
                            <el-option label="男性" value="男性"></el-option>
                            <el-option label="女性" value="女性"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="部署"  prop="department">
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
                    <el-form-item label="生年月日"  prop="date">
                        <div class="block">
                            <el-date-picker
                                v-model="form.date"
                                type="date"
                                placeholder="生年月日選択">
                            </el-date-picker>
                        </div>
                    </el-form-item>
                    <el-form-item label="趣味" >
                        <el-input  autocomplete="off" v-model="form.hobby"></el-input>
                    </el-form-item>
                    <el-form-item label="電話番号"  prop="phone">
                        <el-input  autocomplete="off" v-model="form.phone" @blur="checkBlur($event)"></el-input>
                    </el-form-item>
                    <el-form-item label="最終学歴"  >
                        <el-input  autocomplete="off" v-model="form.academic"></el-input>
                    </el-form-item>
                    <el-form-item label="メールアドレス" prop="mail">
                        <el-input  autocomplete="off" v-model="form.mail"></el-input>
                    </el-form-item>
                    <el-form-item label="郵便番号" prop="zipcode">
                        <el-input v-model="form.zipcode"></el-input>
                        <el-button style="font-size: 12px" class="ml-5" @click="addCheck">郵便番号から住所を検索</el-button>
                    </el-form-item>
                    <el-form-item label="住所" >
                        <el-input  v-model="form.address" ></el-input>
                        <p>{{form.address}}</p>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
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
            activeName: '1',
            tableData: [],
            info :{},
            form:{address: ''},
            dialogTitle:"ddd",
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
            dialogFormVisible: false,
            headerBg: 'headerBg',
            imgIf: false,
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
    },
    mounted() {

    },
    methods:{
        selected(a){
            console.log(this.selectValue)
        },
        addCheck(){
            if(this.form.zipcode)
            axios.get('https://zipcloud.ibsnet.co.jp/api/search?', {
                params:{
                zipcode: this.form.zipcode
            }}).then(res=>{
                        this.info = res.data.results
                this.address1 = this.info[0].address1
                this.address2 = this.info[0].address2
                this.address3 = this.info[0].address3
                this.postaddress = this.address1 + this.address2 + this.address3
                // this.$nextTick(()=>{
                //     this.form.address = this.postaddress
                //     console.log("postaddress",this.postaddress)
                // }
                if(this.form.address === '') {
                    this.form.address = this.postaddress
                }
                    console.log(this.form)
                this.$forceUpdate();
        })
        },
        //電話番号にハイフン入力した際の警告
        checkBlur(e) {
                   if(e.target.value.indexOf("-") != -1){
                       this.$notify.info({
                           title: '',
                           message: 'ハイフンは不要です'
                       });
                   }
                    },
        save(form){
            this.$refs.form.validate((valid) => {
                if(valid){
                    this.request.post("/employeedata",this.form).then(res=>{
                        if(res){
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
        },
        handleEdit(row){
            this.form = row
            console.log(row)
            this.dialogFormVisible = true
            this.dialogTitle = "編集"
        },
        handleAdd(row){
            this.form = row
            this.form = {address: ''}
            console.log(this.form)
            this.dialogFormVisible = true

            this.dialogTitle= "新規登録"
        },
        handleDelete(id){
            this.request.delete("/employeedata/" + id).then(res=>{
                if(res){
                    this.$message.success("削除完成しました")
                }else {
                    this.$message.error("削除が完成していません")
                }
                this.load()
            })
        },
        handleAvatarSuccess(res){
            this.form.imgurl = res;
            if(this.form.imgurl){
                this.imgIf = true
            }
            else {
            }
        },
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
                }
            }).then(res => {
                    this.tableData = res.records
                    this.total = res.total
                }
            )
        },
        reset(){
            this.name = "",
                this.department = "",
                this.gender = "",
                this.hobby = "",
                this.mail= "",
                this.phone = "",
                this.academic = "",
                this.address = "",
            this.load()
        },
        handleCurrentChange(pageNum){
            console.log("Num",pageNum)
            this.pageNum = pageNum
            this.load()
        },
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
    border-top: 4px  solid #83c5be!important;
}
.el-form-item{
    width: 360px;
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    text-align: center;
}
.avatar-uploader .el-upload:hover {
    border-color: #409EFF;
}
.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 300px;
    height: 300px;
    line-height: 300px;
    text-align: center;
}
.avatar {
    height: 300px;
    display: block;
}
</style>