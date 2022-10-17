<template>
  <div>
    <el-button type="primary" round @click="$router.push('/sc')">
      <i style="font-weight:bold;font-size: 15px">返回</i>
    </el-button>
    <h1 align="center">生成展示</h1>
    <!-- <el-button @click="chaxun">查询信息</el-button> -->
    <el-table ref="table" :data="tableData" stripe max-height="1000" border>
      <el-table-column label="序号" prop="shopId" align="center" width="50px"/>
      <el-table-column label="电影名" prop="name" align="center" />
      <el-table-column label="主演人数" prop="number" align="center" />
      <el-table-column label="主演" prop="actor" align="center" />
      <el-table-column label="评分" prop="age" align="center" />
      <el-table-column label="上映时间" prop="time" align="center" />
      <el-table-column label="类型" prop="type" align="center" />
      <el-table-column label="评论数" prop="observe" align="center" />
      <el-table-column label="拍摄国家" prop="city" align="center" />
    </el-table>
  </div>
</template>
<script>
import axios from "axios";
// import reqMock from "../mock/reqMock";
export default {
  name: "Table",
  data() {
    return {
      tableData: [],
    };
  },
  mounted() {
    //console.log(1111);
    axios.get("/shop/shopList").then((res) => {
      //console.log("2222", res);
      this.tableData = res.data.data; //第二个data是我写的mock数据data
    });
  },
};
</script>