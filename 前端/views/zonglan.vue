<template>
  <el-container style="min-height: 80vh">


    <el-container>

      <el-main>
        <div style="margin-bottom: 20px">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>数据栏</el-breadcrumb-item>
            <el-breadcrumb-item>结果展示</el-breadcrumb-item>
            <el-breadcrumb-item>电影总览</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
          <div style="margin: 10px 0">
              <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="name"></el-input>
              <el-button class="ml-5" type="primary" @click="getall">搜索</el-button>
          </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
          <el-table-column prop="id" label="ID" width="60">
          </el-table-column>
          <el-table-column prop="name" label="电影名" width="150">
          </el-table-column>
          <el-table-column prop="nub" label="主演人数" width="180" align="center">
          </el-table-column>
          <el-table-column prop="sorce" label="评分" width="150" align="center">
          </el-table-column>
          <el-table-column prop="time" label="时间" width="100" align="center">
          </el-table-column>
          <el-table-column prop="type" label="类型" width="190" align="center">
          </el-table-column>
          <el-table-column prop="sum" label="评论数" align="center">
          </el-table-column>
            <el-table-column prop="cou" label="国家" align="center">
            </el-table-column>
        </el-table>
          <div style="padding: 10px 0">
              <el-pagination
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      :current-page="pageNum"
                      :page-sizes="[20, 10, 3]"
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
  name: 'paihang',
    data() {
        return {
            tableData: [],
            total: 0,
            pageNum: 1,
            pageSize: 14,
            name: "",
            headerBg:"headerBg"
        }
    },
    created() {
        this.getall()
    },
    methods: {
        getall() {
            this.request.get("/paihang/page", {
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




        handleSizeChange(pageSize) {
            console.log(pageSize)
            this.pageSize = pageSize
            this.getall()
        },
        handleCurrentChange(pageNum) {
            console.log(pageNum)
            this.pageNum = pageNum
            this.getall()
        }
    }

}
</script>

