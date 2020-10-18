package algorithm;
import java.io.InputStream;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
public class RS_IBE {
private static final String UNICODE_FORMAT = "UTF8";
public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
private KeySpec ks;
private SecretKeyFactory skf;
private Cipher cipher;
byte[] arrayBytes;
private String myEncryptionKey;
private String myEncryptionScheme;
SecretKey key;
public RS_IBE() throws Exception {
myEncryptionKey = "ThisIsSpartaThisIsSparta";
myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
ks = new DESedeKeySpec(arrayBytes);
skf = SecretKeyFactory.getInstance(myEncryptionScheme);
cipher = Cipher.getInstance(myEncryptionScheme);
key = skf.generateSecret(ks);
}
public String encrypt(String unencryptedString) {
String encryptedString = null;
try {
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
byte[] encryptedText = cipher.doFinal(plainText);
encryptedString = new String(Base64.encodeBase64(encryptedText));
} catch (Exception e) {
e.printStackTrace();
}
return encryptedString;
}



public String decrypt(String encryptedString) {
String decryptedText=null;
try {
cipher.init(Cipher.DECRYPT_MODE, key);
byte[] encryptedText1 = encryptedString.getBytes(UNICODE_FORMAT);
byte[] encryptedText = Base64.decodeBase64(encryptedText1);
byte[] plainText = cipher.doFinal(encryptedText);
decryptedText= new String(plainText);
} catch (Exception e) {
 e.printStackTrace();
}
 return decryptedText;
}
}

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Data Provider Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
</head>
 <%
 if (request.getParameter("msg") != null) {
 %>
 <script>alert('Login Successfully');</script>
 <%
 }
 %>
<body>
<div class="main">
 <div class="header">
 <div class="header_resize">
 <div class="logo">
 <h1>Secure Data Sharing in Cloud Computing Using Revocable-Storage Identity-Based
Encryption
</h1>
 </div>
 <div class="searchform">
 <form id="formsearch" name="formsearch" method="post" action="#">
 <span>
 <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80"
value="Search our ste:" type="text" />
 </span>
 <input name="button_search" src="images/search.gif" class="button_search" type="image" />
 </form>
 </div>
 <div class="clr"></div>
 <div class="menu_nav">
 <ul>
 <li class="active"><a href="uhome.jsp"><span>User Home</span></a></li>
 <li><a href="file_req.jsp"><span>Send Request</span></a></li>
 <li><a href="down.jsp"><span>File Download </span></a></li>
 <li><a href="index.jsp"><span>Logout</span></a></li>
 </ul>
 </div>
 <div class="clr"></div>
 <div class="slider">
 <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="960" height="335"
alt="" /> </a> <a href="#"><img src="images/slide2.jpg" width="960" height="335" alt="" /> </a> <a
href="#"><img src="images/slide3.jpg" width="960" height="335" alt="" /> </a> </div>
 <div class="clr"></div>
 </div>
 <div class="clr"></div>
 </div>
 </div>
 <div class="content">
 <div class="content_resize">
 <div class="mainbar">
 <div class="article">
 <br><h2>User Home</h2><br>
 <div class="clr"></div>
 <!---Start Body --->
 <img src="images/user1.jpg" width="360" height="200" alt="" />
 <!---End Body --->
 <br><br><br><br></div>
 </div>
 <div class="sidebar">
 <div class="gadget">
 <h2 class="star"><span>User</span> Menu</h2>
 <div class="clr"></div>
 <ul class="sb_menu">
 <li><a href="uhome.jsp">User Home</a></li>
 <li><a href="file_req.jsp">Send Request</a></li>
 <li><a href="down.jsp">File Download</a></li>
 <li><a href="index.jsp">Logout</a></li>
 </ul>
 </div>

 </div>
 <div class="clr"></div>
 </div>
 </div>
 <div class="footer">
 <div class="footer_resize">


 <div style="clear:both;"></div>
 </div>
 </div>
</div>
</body>
</html>