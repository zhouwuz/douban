<template>
  <div class="tirSection">
    <span style="text-align: center;display:block;">21-22赛季球员三分命中率排行
    </span>
    <el-table
        :data="tableData" border stripe :header-cell-class-name="headerBg"
        style="width: 100%">
      <el-table-column prop="id" label="排名" ></el-table-column>
      <el-table-column prop="name" label="球员" ></el-table-column>
      <el-table-column prop="threehitrate" label="三分命中率" ></el-table-column>
      <el-table-column prop="session" label="场次"></el-table-column>
      <el-table-column prop="gametime" label="场均时间" ></el-table-column>
    </el-table>
    <el-pagination
        :page-size="20"
        :pager-count="11"
        layout="prev, pager, next"
        :total="1000">
    </el-pagination>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "tirSection",
    data() {
      return {
        tableData:[{"id":10049,"name":"雅各布-珀尔特尔","threehitrate":1.0,
          "backboard":9.3,"score":0.62,"shoting":null,"steal":null,
          "session":0,"blocks":1.73,"assist":2.8,"gametime":28.9,"salary":810}],
        error: "获取数据失败,请稍后再试",
        headerBg: 'headerBg'
      }
    },
    created() {
      const that = this;
      axios.get('http://localhost:8880/selectthree').then(function (resp) {
        that.tableData=resp.data;
        console.log(that.tableData)
      })
    }


  }








  const that = this;
  axios.get('http://localhost:9091/echarts').then(function (resp) {
      that.num=resp.data.num;
      that.opinionData=resp.data.name;
      console.log(that.num)
      console.log(that.opinionData)
  })

</script>

<style scoped>

</style>
