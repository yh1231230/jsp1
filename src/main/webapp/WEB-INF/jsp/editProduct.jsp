<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>


<!--form 下增加 filed, 虽然这个form的method是post, 但是springmvc看到这个_method的值是put后，会把其修改为put-->
<div style="margin:0px auto; width:500px">
    <form action="${p.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
       <table>
           <tr>
               <td>name:</td>
               <td><input name="name" value="${p.name}"></td>
           </tr>
           <tr>
               <td>price:</td>
               <td><input name="price" value="${p.price}"></td>
           </tr>
           <tr>
               <td>cid:</td>
               <td><input name="cid" value="${p.cid}"></td>
           </tr>
       </table>
        <button type="submit">提交</button>
    </form>
</div>

