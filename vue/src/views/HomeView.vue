<template>
  <div style="height: 100%">
      <el-container style="height: 100%; ">
          <el-aside :width="sideWidth + 'px' " style="background-color: rgb(238, 241, 246); height :100%">
              <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
                background-color="rgb(0,109,119)"
                text-color="#fff"
                active-text-color="#ffd04b"
                :collapse-transition="false"
                class="el-menu-vertical-demo"
                       :collapse="isCollapse"
              >
                  <div style="height: 60px;line-height: 60px;text-align: center">
                    <b style="color: white" v-show="logoTextShow">社員管理システム</b>
                  </div>

              </el-menu>
          </el-aside>

          <el-container>
              <el-header style="font-size: 12px; border-bottom: 1px solid #ccc;line-height: 60px;display: flex  " >
                  <div style="flex: 1;font-size: 18px">
                    <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
                  </div>

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
                      <el-input style="width: 200px" suffix-icon="el-icon-collection-tag
" placeholder="社員番号"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-s-custom" class="ml-5" placeholder="名前"></el-input>
                      <el-input style="width: 200px" suffix-icon="el-icon-house" class="ml-5" placeholder="所属"></el-input>
                      <el-button class="ml-5" type="primary">検索</el-button>
                  </div>

                  <div style="margin: 10px 0">
                      <el-button type="primary">増加<i class="el-icon-circle-plus-outline"></i></el-button>
                  </div>

                  <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
                      <el-table-column prop="age" label="社員番号" width="140" >
                      </el-table-column>
                      <el-table-column prop="name" label="名前" width="120">
                      </el-table-column>
                      <el-table-column prop="department" label="所属">
                      </el-table-column>
                      <el-table-column label="操作">
                          <template  slot-scope="scope">
                              <el-button type="">編集<i class="el-icon-edit-outline"></i></el-button>
                              <el-button type="">削除<i class="el-icon-remove-outline"></i></el-button>
                          </template>
                      </el-table-column>
                  </el-table>
              </el-main>
              <div style="padding: 10px">
                  <el-pagination

                      :page-sizes="[5, 10, 15, 20]"
                      :page-size="10"
                      layout="total, sizes, prev, pager, next, jumper"
                      :total="total">
                  </el-pagination>
              </div>
          </el-container>
      </el-container>

  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'HomeView',
  components: {
  },
    data(){
        return {
            tableData: [],
            msg: "hello,11",
            total:0,
            collapseBtnClass : 'el-icon-s-fold',
            isCollapse: false,
            sideWidth : 250,
            logoTextShow:true,
            headerBg: 'headerBg'
        }
    },
    created() {
      //ページネーションデータ　抽出
        fetch("http://localhost:9090/employeePage/page?pageNum=1&pageSize=2").then(res => res.json()).then(res=>{
            console.log(res)
            this.tableData = res.data
            this.total = res.total
        })

    },
    methods : {
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
      }
    }
}
</script>
<style>
.headerBg{
    background: #83c5be!important;
}
</style>