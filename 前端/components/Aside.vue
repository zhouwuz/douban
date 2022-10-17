<!--导航栏-->
<template>
  <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
             background-color="rgb(199, 62, 58)"
             text-color="#fff"
             active-text-color="#E99D42"
             :collapse-transition="false"
             :collapse="isCollapse"
             router
    >
        <div style="height: 60px; line-height: 60px; text-align: center">
          <img src="../assets/logo1.png" alt="" style="width: 20px; position: relative; top: 5px; right: 5px">
            <b style="color: white" v-show="logoTextShow">豆瓣电影|压力怪</b>
        </div>

        <el-menu-item index="/">
            <template slot="title">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
            </template>
        </el-menu-item>
    <el-menu-item index="/User">
      <template slot="title">
        <i class="el-icon-user"></i>
        <span slot="title">用户管理</span>
      </template>
    </el-menu-item>

      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-message"></i>
          <span slot="title">数据栏</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/sc">数据生成</el-menu-item>
          <el-menu-item index="/lishi">历史记录</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-3">
          <template slot="title">结果展示</template>
          <el-menu-item  class="el-icon-tickets"index="zonglan">电影总览</el-menu-item>
          <el-menu-item  class="el-icon-medal-1"index="1">主演人数前十</el-menu-item>
            <el-menu-item  class="el-icon-medal-1"index="2">类型与其数量</el-menu-item>
            <el-menu-item  class="el-icon-medal-1"index="3">评分对应数量</el-menu-item>
            <el-menu-item  class="el-icon-medal-1"index="4">评论排行前十</el-menu-item>
            <el-menu-item  class="el-icon-medal-1"index="6">年份与平均分</el-menu-item>
            <el-menu-item  class="el-icon-medal-1"index="7">评分排行前十</el-menu-item>
          <el-menu-item class="el-icon-pie-chart" index="/Sector">地区电影饼图</el-menu-item>
          <el-menu-item class="el-icon-s-marketing" index="/Line">年代数量柱状图</el-menu-item>
        </el-submenu>
      </el-submenu>


    </el-menu>
</template>

<script>
    export default {
        name: "Aside",
        props: {
            isCollapse: Boolean,
            logoTextShow: Boolean
        }
    }
</script>

<style scoped>

</style>
