<template>
    <el-container style="min-height: 80vh">


        <el-container>

            <el-main>
                <div style="margin-bottom: 20px">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item>数据栏</el-breadcrumb-item>
                        <el-breadcrumb-item>结果展示</el-breadcrumb-item>
                        <el-breadcrumb-item>类型与其数量</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>


                <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
                    <el-table-column prop="userid" label="ID" width="60">
                    </el-table-column>
                    <el-table-column prop="areaname" label="类型" width="200">
                    </el-table-column>
                    <el-table-column prop="price" label="数量" width="200" align="center">
                    </el-table-column>
                    <el-table-column prop="time" label="查询时间" width="200" align="center">
                    </el-table-column>
                </el-table>
                <div style="padding: 10px 0">
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="pageNum"
                            :page-sizes="[15, 10, 3]"
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
                this.request.get("/2/page", {
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

