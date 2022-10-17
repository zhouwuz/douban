<template>
  <el-container style="min-height: 80vh">


    <el-container>

      <el-main>
        <div style="margin-bottom: 20px">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item>数据栏</el-breadcrumb-item>
            <el-breadcrumb-item>结果展示</el-breadcrumb-item>
            <el-breadcrumb-item>电影查找</el-breadcrumb-item>
          </el-breadcrumb>
        </div>

        <div style="margin: 10px 0">
          <template>
            <el-select style="width: 100px" v-model="value" placeholder="搜索类型">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
          <el-input style="width: 200px" v-model="input" placeholder="输入关键字"></el-input>
          <el-button class="ml-5" type="primary">搜索</el-button>
        </div>

        <div style="margin: 10px 0">
          <el-breadcrumb-item >查找结果</el-breadcrumb-item>
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
          <el-table-column prop="date" label="序号" width="60">
          </el-table-column>
          <el-table-column prop="name" label="电影名" width="150">
          </el-table-column>
          <el-table-column prop="actor" label="主演" width="180" align="center">
          </el-table-column>
          <el-table-column prop="type" label="类型" width="200" align="center">
          </el-table-column>
          <el-table-column prop="area" label="地区" width="150" align="center">
          </el-table-column>
          <el-table-column prop="fen" label="评分" width="100" align="center">
          </el-table-column>
          <el-table-column prop="shu" label="评论数" width="190" align="center">
          </el-table-column>
          <el-table-column prop="time" label="上映时间" align="center">
          </el-table-column>
        </el-table>
        <div style="padding: 10px 0">
          <el-pagination

              :page-sizes="[5, 10, 15, 20]"
              :page-size="10"
              layout="total, sizes, prev, pager, next, jumper"
              :total="400">
          </el-pagination>
        </div>
      </el-main>

    </el-container>
  </el-container>
</template>

<script>

export default {
  name: 'Home',
  data() {

    const item = {
      date: '1',
      name: 'xxxxxxxxxxxx',
      actor: 'xxxxxx',
      type: 'xx',
      area: 'xx',
      fen: 'xxx',
      shu: 'xxxxx',
      time: 'xxxx-xx-xx'
    };

    return {
      options: [{
        value: '选项1',
        label: '按名称'
      }, {
        value: '选项2',
        label: '按类型'
      }, {
        value: '选项3',
        label: '按地区'
      }, {
        value: '选项4',
        label: '按年份'
      }],
      value: '',
      tableData: Array(10).fill(item),
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true,
      headerBg: 'headerBg'
    }

  },

  methods: {
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

    collapse() {  // 点击收缩按钮触发
      this.isCollapse = !this.isCollapse
      if (this.isCollapse) {  // 收缩
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else {   // 展开
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    }
  }
}
</script>

<style>
.headerBg {
  background: #eee!important;
}
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>