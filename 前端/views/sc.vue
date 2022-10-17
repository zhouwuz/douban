<template>
  <el-container style="min-height: 80vh">
    <el-container>

      <el-main>
        <div style="margin-bottom: 20px">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>数据栏</el-breadcrumb-item>
            <el-breadcrumb-item>数据生成</el-breadcrumb-item>
          </el-breadcrumb>

        </div>


        <div style="margin-top:60px;margin-left:10px;width:1200px;height: 350px">
          <div style="box-shadow: rgba(238,169, 169) 0px 2px 12px 0px;float: left;width:270px;height: 350px">

            <el-switch style="margin-left: 20px;margin-top: 30px"
                active-text="评分"
                v-model="value1">
            </el-switch>
            <div class="demo-input-suffix" style="height: 50px;margin-top: 30px;margin-left: 20px">
              9分以上：
              <el-input style="width: 150px"
                  placeholder="请输入占比（百分比）"
                  v-model="input1">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              8分-9分：
              <el-input style="width: 150px"
                  placeholder="请输入占比（百分比）"
                  v-model="input2">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              7分-8分：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input3">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              7分以下：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input4">
              </el-input>
            </div>

          </div>
          <div style="box-shadow: rgba(238,169, 169) 0px 2px 12px 0px;float: left;margin-left:10px;width:300px;height: 350px" >
            <el-switch style="margin-left: 20px;margin-top: 30px"
                active-text="上映年份"
                v-model="value2">
            </el-switch>
            <div class="demo-input-suffix" style="height: 50px;margin-top: 30px;margin-left: 20px">
              2022年：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input5">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              2021年：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input6">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              2020年：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input7">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              2020前：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input8">
              </el-input>
            </div>
          </div>
          <div style="box-shadow: rgba(238,169, 169) 0px 2px 12px 0px;float: left;margin-left:10px;width:300px;height: 350px">
            <el-switch style="margin-left: 20px;margin-top: 30px"
                active-text="拍摄国家"
                v-model="value3">
            </el-switch>
            <div class="demo-input-suffix" style="height: 50px;margin-top: 30px;margin-left: 20px">
              中国：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input9">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              美国：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input10">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              欧洲：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input11">
              </el-input>
            </div>
            <div class="demo-input-suffix" style="height: 50px;margin-left: 20px">
              其他：
              <el-input style="width: 150px"
                        placeholder="请输入占比（百分比）"
                        v-model="input12">
              </el-input>
            </div>
          </div>
          <div style="box-shadow: rgba(238,169, 169) 0px 2px 12px 0px;float: left;margin-left:10px;width:300px;height: 350px" >
            <el-switch style="margin-left: 20px;margin-top: 30px"
                active-text="评论数"
                v-model="value4">
            </el-switch>
            <div class="demo-input-suffix" style="height: 50px;margin-top: 30px;margin-left: 20px">
              <el-input style="width: 200px"
                        placeholder="请输入10至于10000的区间"
                        v-model="input13">
              </el-input>
            </div>

          </div >
          <div style="margin: 20px 0">

              <el-button round @click="$router.push('/mock')"style="margin-top: 20px;margin-left: 1100px;width: 100px;height: 60px" type="primary">确认查询</el-button>

          </div>
        </div>

      </el-main>

    </el-container>
  </el-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Home',
  data() {
    const item = {
      date: '1',
      name: 'xxx',
      address: 'xxxx',
      time: 'xxxx-xx-xx',
      rules: 'xx，xx',
      state: 'xx'
    };
    return {
      tableData: Array(10).fill(item),
      msg: "hello 青哥哥",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true,
      headerBg: 'headerBg',
      value:'true',
      value1: false,
      value2: false,
      value3: false,
      value4: false,
      input1: '',
      input2: '',
      input3: '',
      input4: '',
      input5: '',
      input6: '',
      input7: '',
      input8: '',
      input9: '',
      input10: '',
      input11: '',
      input12: '',
      input13: ''

    };

  },

  methods: {
    getData() {
      axios.get('/getUserList').then((res) => {
        console.log(res)
        this.userList = res.data.data.rows;
      })
    },

    open() {
      this.$alert('xxxxxxxx', '规则详情', {
        confirmButtonText: '确定',
        callback: action => {
        }
      });
    },
    delate() {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

  }
}
</script>

<style>
.headerBg {
  background: #eee!important;
}
</style>