<template>
  <div style="height: 100%">
      <el-container style="height: 100%; ">
          <el-aside :width="sideWidth + 'px' " style=" height :100%">

            <Aside/>
          </el-aside>
          <el-container>

              <el-header style="font-size: 12px; border-bottom: 1px solid #ccc;line-height: 60px;display: flex; justify-content: flex-end " >

                  <el-dropdown style="width: 100px;cursor: pointer">
                      <span>朴雄権</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                      <el-dropdown-menu slot="dropdown">
                          <el-dropdown-item>個人情報</el-dropdown-item>
                          <el-dropdown-item>ログアウト</el-dropdown-item>
                      </el-dropdown-menu>
                  </el-dropdown>

              </el-header>

              <el-main>

                  <el-breadcrumb separator-class="el-icon-arrow-right">
                      <el-breadcrumb-item :to="{ path: '/' }">TOP</el-breadcrumb-item>
                      <el-breadcrumb-item>社員管理</el-breadcrumb-item>
                  </el-breadcrumb>

                  <div class="pd-10">
                      <el-input style="width: 200px" suffix-icon="el-icon-collection-tag" placeholder="社員番号" class="ml-5"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="名前" v-model="name"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="年齢" v-model="age"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="性別" v-model="gender"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="生年月日" v-model="date"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="部署" v-model="department"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="趣味" v-model="hobby"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="最終履歴" v-model="academic"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="メールアドレス" v-model="mail"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="住所" v-model="address"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="電話番号" v-model="phone"></el-input>

                  </div>

                  <div style="margin: 10px 0">
                      <el-button type="primary" @click="handleAdd" icon="el-icon-plus">新規登録</el-button>
                      <el-button class="ml-5" type="primary" @click="load" icon="el-icon-search">検索</el-button>
                      <el-button class="ml-5" type="primary" @click="reset" icon="el-icon-refresh-left
">クリア</el-button>
                  </div>

                  <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
                      <el-table-column prop="id" label="社員番号" width="80" >
                      </el-table-column>
                      <el-table-column prop="name" label="名前" width="120">
                      </el-table-column>
                      <el-table-column prop="age" label="年齢" width="80">
                      </el-table-column>
                      <el-table-column prop="gender" label="性別">
                      </el-table-column>
                      <el-table-column prop="date" label="生年月日">
                      </el-table-column>
                      <el-table-column prop="department" label="部署">
                      </el-table-column>
                      <el-table-column prop="hobby" label="趣味">
                      </el-table-column>
                      <el-table-column prop="mail" label="メールアドレス">
                      </el-table-column>
                      <el-table-column prop="phone" label="電話番号">
                      </el-table-column>
                      <el-table-column prop="academic" label="最終履歴">
                      </el-table-column>
                      <el-table-column prop="address" label="住所">
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
                  <el-dialog title="新規登録" :visible.sync="dialogFormVisible" width="30%" size="small" >
                      <el-form label-width="150px" size="small" label-position="top">
                          <el-form-item label="名前"  >
                              <el-input  autocomplete="off" v-model="form.name"></el-input>

                          </el-form-item>
                          <el-form-item label="年齢" >
                              <el-input v-model= "form.age" oninput="value=value.replace(/[^0-9]/g,'')" />
                          </el-form-item>
                          <el-form-item label="性別" >
                              <el-select  placeholder="性別を選んでください"  v-model="form.gender">
                                  <el-option label="男性" value="男性"></el-option>
                                  <el-option label="女性" value="女性"></el-option>
                              </el-select>
                          </el-form-item>
                          <el-form-item label="生年月日"  >
                              <el-input  autocomplete="off" v-model="form.date"></el-input>
                          </el-form-item>
                          <el-form-item label="部署"  >
                              <el-input  autocomplete="off" v-model="form.department"></el-input>
                          </el-form-item>
                          <el-form-item label="趣味" >
                              <el-input  autocomplete="off" v-model="form.hobby"></el-input>
                          </el-form-item>
                          <el-form-item label="メールアドレス" >
                              <el-input  autocomplete="off" v-model="form.mail"></el-input>
                          </el-form-item>
                          <el-form-item label="電話番号"  >
                              <el-input  autocomplete="off" v-model="form.phone"></el-input>
                          </el-form-item>
                          <el-form-item label="最終学歴"  >
                              <el-input  autocomplete="off" v-model="form.academic"></el-input>
                          </el-form-item>
                          <el-form-item label="住所"  >
                              <el-input  autocomplete="off" v-model="form.address"></el-input>
                          </el-form-item>
                      </el-form>
                      <div slot="footer" class="dialog-footer">
                          <el-button @click="dialogFormVisible=false">キャンセル</el-button>
                          <el-button type="primary" @click="save">登録</el-button>
                      </div>
                  </el-dialog>
              </el-main>
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
          </el-container>
      </el-container>

  </div>
</template>

<script>

// @ is an alias to /src
import Aside from "../components/Aside.vue"
export default {
    data(){
        return {
            tableData: [],
            form:{},
            total:0,
            sideWidth:250,
            pageNum : 1,
            pageSize:10,
            name:"",
            department: "",
            age:"",
            gender: "",
            date :"",
            hobby:"",
            mail:"",
            phone:"",
            academic:"",
            address:"",
            collapseBtnClass : 'el-icon-s-fold',
            headerBg: 'headerBg',
            dialogFormVisible: false,
        }
    },
    components:{
      Aside
    },
    created() {
      //ページネーションデータ　抽出
        this.load()
    },
    methods : {
      handleAdd(){
          this.dialogFormVisible = true
          this.form = {}
      },
      save(){
        this.request.post("/employeedata",this.form).then(res=>{
            if(res){
                this.$message.success("yes")
            }else {
                this.$message.error("no")
            }
            this.load()
            this.dialogFormVisible = false
        })
      },
      handleEdit(row){
          this.form = row
          console.log(row)
          this.dialogFormVisible = true
      },
      handleDelete(id){
        this.request.delete("/employeedata/" + id).then(res=>{
            if(res){
                this.$message.success("yes")
            }else {
                this.$message.error("no")
            }
            this.load()
        })
      },
      collapse(){
        this.isCollapse = !this.isCollapse
          if(this.isCollapse){
              this.sideWidth = 64
              this.collapseBtnClass = 'el-icon-s-unfold'
              this.logoTextShow = !this.logoTextShow
          }
          else {
              this.sideWidth = 250
              this.collapseBtnClass = 'el-icon-s-fold'
              this.logoTextShow = !this.logoTextShow
          }
      },
      load(){
            this.request.get("/employeedata/page?",{
                params:{
                    pageNum: this.pageNum,
                    pageSize:this.pageSize,
                    name:this.name,
                    department: this.department,
                    age:this.age,
                    gender:this.gender,
                    date:this.date,
                    hobby:this.hobby,
                    mail:this.mail,
                    phone:this.phone,
                    academic:this.academic,
                    address:this.address,
                }
            } ).then(res => {
                console.log(res)
                this.tableData = res.records
                this.total = res.total
            }
            )
      },
        reset(){
                this.name = "",
                this.department = "",
                this.age = "",
                this.gender = "",
                this.dateOfBirth = "",
                this.hobby = "",
                this.mail= "",
                this.phone = "",
                this.academic = "",
                this.address = ""
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
}
</script>
<style>
.headerBg{
    background: #83c5be!important;
    text-align: center!important;
}
</style>