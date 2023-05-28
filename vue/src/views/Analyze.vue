<template>
    <div>
        <el-row :gutter="21">
            <el-col :span="6">
                <div>
                    <el-statistic group-separator="," :precision="2" :value="allSales" title="売上"></el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic title="総社員数">
                        <template slot="formatter"> {{ address.allNum}} </template>
                    </el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic title="男女比">
                        <template slot="formatter"> {{ gender.man }}/{{gender.woman}} </template>
                    </el-statistic>
                </div>
            </el-col>
            <el-col :span="6">
                <div>
                    <el-statistic group-separator="," :precision="2" decimal-separator="." :value="600000" title="目標額">
                        <template slot="prefix">
                            <i class="el-icon-s-flag" style="color: red"></i>
                        </template>
                        <template slot="suffix">
                            <i class="el-icon-s-flag" style="color: blue"></i>
                        </template>
                    </el-statistic>
                </div>
            </el-col>
        </el-row>
        <el-row :gutter="21" style="margin-top: 50px">
            <el-col :span="6">
              <div id="chart_address">
              </div>
            </el-col>
            <el-col :span="6">
                <div id="chart_business">
                </div>
            </el-col>
        </el-row>
    </div>
</template>
<script>
import {defineComponent} from 'vue'
import * as echarts from 'echarts';
export default defineComponent({
    name: "analyze",
    created() {
        let that = this
        this.request.get("/employeedata/getAddress/all").then(res=> {
            that.address.allNum = res.data
        })
        this.request.get("/employeedata/getAddress/tokyo").then(res=>{
            that.address.tokyo = res.data
        })
        this.request.get("/employeedata/getAddress/saitama").then(res=>{
            that.address.saitama = res.data
        })
        this.request.get("/employeedata/getAddress/kanagawa").then(res=>{
            that.address.kanagawa = res.data
        })
        this.request.get("/employeedata/getAddress/tiba").then(res=>{
            that.address.tiba = res.data
        })
        this.request.get("/employeedata/gender/man").then(res=>{
            that.gender.man = res.data
        })
        this.request.get("/employeedata/gender/woman").then(res=>{
            that.gender.woman = res.data
        })
        this.request.get("/business").then(res=>{
            that.business = res.data
        })

    },
    mounted:function (){
      setTimeout(()=>{
          var chartDom = document.getElementById('chart_address');
          var myChart = echarts.init(chartDom);
          var option= {
              tooltip: {
                  trigger: 'item'
              },
              legend: {
                  top: '5%',
                  left: 'center'
              },
              series: [
                  {
                      name: '居住地',
                      type: 'pie',
                      radius: ['40%', '70%'],
                      avoidLabelOverlap: false,
                      itemStyle: {
                          borderRadius: 10,
                          borderColor: '#fff',
                          borderWidth: 2
                      },
                      label: {
                          show: false,
                          position: 'center'
                      },
                      emphasis: {
                          label: {
                              show: true,
                              fontSize: 20,
                              fontWeight: 'bold'
                          }
                      },
                      labelLine: {
                          show: false
                      },
                      data: [
                          { value: this.address.tokyo, name: '東京都' },
                          { value: this.address.saitama, name: '埼玉県' },
                          { value: this.address.kanagawa, name: '神奈川県' },
                          { value: this.address.tiba, name: '千葉県' },
                      ]
                  }
              ]
          };
          myChart.setOption(option);

          var chartDom2 = document.getElementById('chart_business');
          var myChart2 = echarts.init(chartDom2);
          var option2;

          option2 = {
              xAxis: {
                  type: 'category',
                  data: [this.business[0].date + '月', this.business[1].date + '月',
                      this.business[2].date + '月', this.business[3].date + '月',
                      this.business[4].date + '月', this.business[5].date + '月']
              },
              yAxis: {
                  type: 'value'
              },
              series: [
                  {
                      data: [
                          this.business[0].sales,
                          this.business[1].sales,
                          this.business[2].sales,
                          this.business[3].sales,
                          this.business[4].sales,
                          this.business[5].sales,
                      ],
                      type: 'bar'
                  }
              ]
          };
          myChart2.setOption(option2);
          this.getSales()
      },100)

    },
    data(){
        return{
            address: {
                allNum:0,
                tokyo:0,
                saitama:0,
                kanagawa:0,
                tiba:0
            },
            gender:{
                man:"",
                woman:""
            },
            business:{},
            allSales:0
        }
    },
    methods:{
        getSales(){
            var allSales =0;
             for (let i = 0;i<this.business.length;i++){
                 allSales += parseInt(this.business[i].sales)
            }
            console.log(allSales)
            this.allSales = allSales
        }
    }

})
</script>
<style scoped>
.el-col{

}
.el-col div{
    background: #FaFaFa;
    height: 80px;
    line-height: 40px;
}
#chart_address{
    width: 300px;
    height: 300px;
    border:1px solid #FaFaFa
}
#chart_business{
    width: 600px;
    height: 300px;
    border:1px solid #FaFaFa
}
</style>