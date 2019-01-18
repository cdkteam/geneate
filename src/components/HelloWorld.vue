<template>
    <el-container>
      <el-header></el-header>
      <el-main class="card-main">
        <el-card class="box-card" v-for="item in familyCard" :key="item.id">
          <div slot="header" class="clearfix family-img-box">
            <img :src="item.img" alt="" class="family-img">
          </div>
          <div class="family-name-box">
            <div class="family-name">
              <span>{{item.name}}</span>
            </div>
          </div>
        </el-card>
      </el-main>
      <el-footer></el-footer>
    </el-container>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data:function() {
    return {
      familyCard:[
        {img:require('../assets/logo.png'), name:'龙洞湾向继耀支系'},
        {img:require('../assets/logo.png'), name:'龙洞湾向继耀支系'},
        {img:require('../assets/logo.png'), name:'龙洞湾向继耀支系'},
        {img:require('../assets/logo.png'), name:'龙洞湾向继耀支系阿德法撒旦法是打发斯蒂芬'}
      ]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.family-name {
  display:inline-block;
  width:100%;
  font-size:.8rem;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
p {
  margin:0;
}
.family-name > p:nth-child(2) {
  font-size:.8rem;
  color:#ccc;
}
.grid-content {
  text-align:center;
}
.grid-content p {
  margin-top:5px;
  font-size:.8rem;
  color:#409EFF;
}
.box-card {
  float:left;
  width:150px;
  height:200px;
  margin-bottom:15px;
}
.card-main {
  padding:0;
  display:flex;
  justify-content: space-around;
  flex-wrap:wrap;
}
.family-img-box {
  text-align:center;
}
.family-img {
  width:100px;
  height:100px;
}
</style>
