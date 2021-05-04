<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


<script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
        var href=$(this).attr("href");  //获取delete类中href属性的值
            $("#formDelete").attr("action",href).submit();//将href属性值给id=formDelete表单的action属性并提交
            return false;
        })
    })
</script>



<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>价格</td>
            <td>种类</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <!-- JPA分页           page.content ?start=1   ?start=page.number-1    ?start=page.number+1    ?start=page.totalPages-1      -->
        <!-- PageHelper插件分页 page.list    ?start=0   ?start=page.pageNum-1  ?start=page.pageNum+1   ?start=page.pages             -->
        <c:forEach items="${page.list}" var="p" varStatus="st">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.cid}</td>
                <td><a class="update" href="products/edit/${p.id}">编辑</a></td>
                <td><a class="delete" href="products/${p.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=0">[首  页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start= ${page.pages}">[末  页]</a>
        <!--                          -->
    </div>
    <br>


    <script type="text/javascript">
            function test1(){
                var a = $("#pid").val();
                var url="products/"+a;
                $("#getProduct").attr("action",url).submit();
            }
    </script>

    <div style="text-align: center" >
    <form action="products" method="post">
       <table align="center">
           <tr>
               <td>id: </td>
               <td><input name="id"></td>
           </tr>
           <tr>
               <td>name: </td>
               <td><input name="name"></td>
           </tr>
           <tr>
               <td>价格: </td>
               <td><input name="price"></td>
           </tr>
           <tr>
               <td>种类:</td>
               <td><input name="cid"></td>
           </tr>
       </table>
        <button type="submit">提交</button>
    </form>
    </div>
<br>
    <form id="formDelete" action="" method="POST" >
        <input type="hidden" name="_method" value="DELETE">
    </form>


    <form id="getProduct"action="" method="GET" >
        输入ID:<input id="pid" >
     <button class="get" type="submit" onclick="test1()" >获取</button>
    </form>
</div>