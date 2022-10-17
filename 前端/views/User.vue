<template>
  <div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>
      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
    </div>



      <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
          <el-table-column prop="id" label="序号" width="200">
          </el-table-column>
          <el-table-column prop="username" label="名称" width="250">
          </el-table-column>
          <el-table-column prop="account" label="账号" width="200">
          </el-table-column>
          <el-table-column prop="email" label="邮箱" width="245">
          </el-table-column>
          <el-table-column prop="phone" label="电话" width="200">
          </el-table-column>
          <el-table-column label="操作"  width="200" align="center">
              <template slot-scope="scope">
            <el-popconfirm
                      class="ml-5"
                      confirm-button-text='确定'
                      cancel-button-text='我再想想'
                      icon="el-icon-info"
                      icon-color="red"
                      title="您确定注销吗？"
                      @confirm="del(scope.row.id)"
              >
                  <el-button type="danger" slot="reference">注销用户 <i class="el-icon-remove-outline"></i></el-button>
              </el-popconfirm>
              </template>
          </el-table-column>
      </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  name: "User",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      username: "",
        headerBg:"headerBg"
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.request.get("/user/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
        }
      }).then(res => {
          console.log(res)

        this.tableData = res.records
        this.total = res.total

      })
    },

    del(id) {
      this.request.delete("/user/" + id).then(res => {
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



