<template>
  <el-container style="min-height: 80vh">
    <el-container>

      <el-main>
        <div style="margin-bottom: 20px">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>数据栏</el-breadcrumb-item>
            <el-breadcrumb-item>历史记录</el-breadcrumb-item>
          </el-breadcrumb>
        </div>

          <div style="margin: 10px 0">
              <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="account"></el-input>
              <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
          </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
          <el-table-column prop="id" label="序号" width="60">
          </el-table-column>
          <el-table-column prop="account" label="账号" width="150">
          </el-table-column>
          <el-table-column prop="num" label="查询数据量" width="180" align="center">
          </el-table-column>
          <el-table-column prop="time" label="生成时间" width="200" align="center">
          </el-table-column>
          <el-table-column prop="a" label="生成规则" width="200" align="center">
          </el-table-column>
          <el-table-column label="操作"  align="center">
            <template slot-scope="scope">
              <el-button type="success" @click="$router.push('/zonglan')">查看结果 <i class="el-icon-s-promotion"></i></el-button>

                <el-popconfirm
                        class="ml-5"
                        confirm-button-text='确定'
                        cancel-button-text='我再想想'
                        icon="el-icon-info"
                        icon-color="red"
                        title="您确定删除吗？"
                        @confirm="del(scope.row.id)"
                >
                    <el-button type="danger" slot="reference">删除记录 <i class="el-icon-remove-outline"></i></el-button>
                </el-popconfirm>
            </template>
          </el-table-column>
        </el-table>
          <div style="padding: 10px 0">
              <el-pagination
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      :current-page="pageNum"
                      :page-sizes="[2, 4, 6]"
                      :page-size="pageSize"
                      layout="total, sizes, prev, pager, next, jumper"
                      :total="total">
              </el-pagination>
          </div>
      </el-main>

    </el-container>
  </el-container>
</template>

<script>

export default {
    name: 'lishi',
    data() {
        return {
            tableData: [],
            total: 0,
            pageNum: 1,
            pageSize: 2,
            account: "",
            headerBg:"headerBg"
        }
    },
    created() {
        this.load()
    },
    methods: {
        load() {
            this.request.get("/lishi/page", {
                params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    name: this.name,
                }
            }).then(res => {
                console.log(res)

                this.tableData = res.records
                this.total = res.total

            })
        },
        del(id) {
            this.request.delete("/lishi/" + id).then(res => {
                if (res) {
                    this.$message.success("删除成功")
                    this.load()
                } else {
                    this.$message.error("删除失败")
                }
            })
        },




        handleSizeChange(pageSize) {
            console.log(pageSize)
            this.pageSize = pageSize
            this.load()
        },
        handleCurrentChange(pageNum) {
            console.log(pageNum)
            this.pageNum = pageNum
            this.load()
        }
    }

}
</script>

<style>
.headerBg {
  background: #eee!important;
}
</style>
