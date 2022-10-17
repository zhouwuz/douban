/* eslint-disable prettier/prettier */
import Mock from "mockjs"
let data = Mock.mock({
    //生成10条数据，数组形式
    "data|1000": [
        {
            "shopId|+1": 1, //生成id，自增1
            'number|10-30': 20,
            actor:'@name',
            'name|1':['楚门的世界','钢琴家','摩登时代','飞屋环游记','飞越疯人院','让子弹飞','我不是药神','绿皮书','蝴蝶效应','低俗小说','7号房的礼物','玛丽和马克思','看不见的客人','忠犬八公的故事','触不可及','泰坦尼克号','怦然心动','我们都是坏孩子','功夫联盟','教父'],
            time: '@date',
            'observe|10000-1000000':500000,
            'type|1':['剧情','科幻','动画','动作','犯罪','喜剧','爱情'],
            'city|1':['中国','美国','欧洲','其他'],
            'age|6-9': 8
        },
    ],
});
//导出mock数据文件，指定此数据文件的接口url后缀为：/shop/shopList
// eslint-disable-next-line no-unused-vars
export default Mock.mock('/shop/shopList', (req, res) => {
    return data
})