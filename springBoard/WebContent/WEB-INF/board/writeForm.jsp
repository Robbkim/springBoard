<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeForm.jsp -->>
<html>
<head>
  <title>�۾���</title>
</head>
<body>
  <div align="center">
    <form name="f" action="writePro_board.do" method="post">
      <table border="1" width="500">
        <tr bgcolor="yellow">
    	  <td align="center" colspan="2">
    	        �� �� ��
    	  </td>
    	</tr>
    	<tr>
    	  <td bgcolor="yellow" width="20%" align="center">�̸�</td>
    	  <td><input type="text" name="writer"></td>
    	</tr>
    	<tr>
    	  <td bgcolor="yellow" width="20%" align="center">�� ��</td>
    	  <td><input type="text" name="subject" size="50"></td>
    	</tr>
    	<tr>
    	  <td bgcolor="yellow" width="20%" align="center">Email</td>
    	  <td><input type="text" name="email" size="50"></td>
    	</tr>
    	<tr>
    	  <td bgcolor="yellow" width="20%" align="center">�� ��</td>
    	  <td><textarea name="content" row="11" cols="50"></textarea>
    	</tr>
    	<tr>
    	  <td bgcolor="yellow" width="20%" align="center">��й�ȣ</td>
    	  <td><input type="password" name="passwd"></td>  
    	 </tr>
    	 <tr>
    	   <td bgcolor="yellow" colspan="3" align="center">
    	     <input type="submit" value="�۾���">
    	     <input type="reset" value="�ٽ��ۼ�">
    	     <input type="button" value="��Ϻ���" onclick="window.location='list_board.do'">
    	  </td>  
    	</tr> 
      </table>
    </form>
  </div>
</body>
</html>